package Communication;

import java.net.Socket;
import java.net.SocketException;
import java.nio.channels.SocketChannel;
import java.util.List;

public class LamportChandy extends Thread {
	
	public int numberMarker;
	public static  List<String> sendBuffer;
	public static long idClient;
	public boolean stateOne;
	public Socket clientSocket;
	private static  List<String> historic;

	public  LamportChandy( List<String> sendBuffer,Socket clientSocket, List<String> historic ) {
		this.clientSocket = clientSocket;
		this.numberMarker = 0;
		this.sendBuffer = sendBuffer;
		this.historic = historic;
		this.stateOne = true;
	}
	
	public void restart() {
		this.stateOne = true;
		this.numberMarker = 0;
	}
	
	public void printLog() {
		System.out.println("Cliente com id: "+ idClient);
		System.out.println("Socket do cliente ativo? " + this.clientSocket.isConnected());
		System.out.println("Porta local utilizada: "+this.clientSocket.getLocalPort());
		System.out.println("Porta remota de conexão: " + this.clientSocket.getPort());
		System.out.println("IP do cliente: "+this.clientSocket.getInetAddress());
		
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				if (this.numberMarker == 0 ) {
					Thread.sleep(5000);
				}
				 if (this.numberMarker == 1 && this.stateOne) {
					//imprimir aqui o log
					this.printLog();
					sendBuffer.add(CommandList.MARKER + Long.toString(this.idClient));
					//bolean que permite a entrada no estado 1 somente uma vez
					this.stateOne = false;
					Thread.sleep(40000);
					continue;
				}
				 if (this.numberMarker == 2 ) {
					 System.out.println("Operações trocadas durante execução do algoritmo:");
					for(String op : this.historic)
						System.out.println(op);
				}
				 //Voltando ao estado inicial
				 this.restart();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
