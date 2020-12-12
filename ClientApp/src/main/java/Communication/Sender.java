package Communication;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

public class Sender extends Thread {

	public Socket clientSocket;
	private DataOutputStream outToServer;
	private static  List<String> sendBuffer;
	private static LamportChandy lamportChandy;
	
	public Sender (Socket clientSocket, List<String> sendBuffer, LamportChandy lamportChandy) throws IOException {
		this.clientSocket = clientSocket;
		this.outToServer = new DataOutputStream(this.clientSocket.getOutputStream());
		outToServer.flush();
		this.sendBuffer = sendBuffer;
		this.lamportChandy  = lamportChandy;
	}
	@Override
	public void run() {
		
		while(true) {
			try {
				Thread.sleep(300);
				if ( !sendBuffer.isEmpty() ) {
					if(sendBuffer.get(0).indexOf(CommandList.EXIT) != -1 ) {
						outToServer.writeUTF(this.sendBuffer.get(0));
						outToServer.flush();
						this.sendBuffer.remove(0);
						break;
					}
					else if (sendBuffer.get(0).indexOf(CommandList.MARKER) != -1) {
						//inicia o algoritmo
						outToServer.writeUTF(this.sendBuffer.get(0));
						outToServer.flush();
						this.sendBuffer.remove(0);
						
					}
					else {
						outToServer.writeUTF(this.sendBuffer.get(0));
						outToServer.flush();
						this.sendBuffer.remove(0);
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
