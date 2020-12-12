package Communication;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import app.AccountModel;


public class Receiver extends Thread {
	
	public Socket clientSocket;
	private DataInputStream inFromServer;
	public String responseFromServ;
	public static AccountModel myAccount;
	private static LamportChandy lamportChandy;
	private static Sender sender;
	public long idClient;
	
	public Receiver(Socket clientSocket, AccountModel myAccount, LamportChandy lamportChandy, Sender sender  ) throws IOException {
		this.clientSocket = clientSocket;
		this.inFromServer = new DataInputStream(new BufferedInputStream(this.clientSocket.getInputStream()));
		this.lamportChandy  = lamportChandy;
		this.myAccount = myAccount;
		this.sender = sender;
	}

	@Override
	public void run() {
		while(true) {
			try {
				this.responseFromServ = inFromServer.readUTF();
				if (responseFromServ.indexOf(CommandList.UPDATE_BALANCE) == -1) {
					
					if(responseFromServ.indexOf(CommandList.MARKER) != -1) {
						this.lamportChandy.numberMarker++;
						continue;
					}
					if(responseFromServ.indexOf(CommandList.SEND_ID) != -1) {
						String value = responseFromServ.replaceAll(CommandList.SEND_ID, "");
						idClient = Long.parseLong(value);
						this.lamportChandy.idClient = this.idClient;
						continue;
					}
					
					else if (responseFromServ.equals(CommandList.OP_FAILED)) {
						JOptionPane.showMessageDialog(new JFrame(), "Transação não realizada, operação inválida");
					} else {
						this.myAccount.setSaldo(Double.parseDouble(responseFromServ));
						JOptionPane.showMessageDialog(new JFrame(), "Transação realizada com sucesso");
						
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
