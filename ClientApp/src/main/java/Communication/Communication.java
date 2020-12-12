package Communication;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.sound.midi.Synthesizer;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.google.gson.Gson;

import app.AccountModel;

public class Communication {

	public String command;
	public String responseFromServ;
	public Socket clientSocket;
	private DataInputStream inFromServer;
	private boolean exit;
	public static AccountModel myAccount;
	private static  List<String> sendBuffer;
	private static Sender sender;
	private static Receiver receiver;
	private static LamportChandy lamportChandy ;
	private static  List<String> historic;

	//Construtor
	public Communication(Socket clientSocket, AccountModel myAccount) throws IOException {
		this.historic = new ArrayList<String>();
		this.clientSocket = clientSocket;
		this.inFromServer = new DataInputStream(new BufferedInputStream(this.clientSocket.getInputStream()));
		this.exit = false;
		this.myAccount = myAccount;
		this.sendBuffer = new ArrayList<String>();
		this.lamportChandy = new LamportChandy(this.sendBuffer, this.clientSocket, this.historic);
		lamportChandy.start();
		this.sender = new Sender(this.clientSocket, this.sendBuffer, this.lamportChandy);
		this.sender.start();
	}
	
	
	
	
	public boolean sendRG(String rg) throws IOException {
		// Recebe o rg e envia para o servidor
		this.command = rg;
		this.historic.add(CommandList.SEND_RG);
		this.sendBuffer.add(CommandList.SEND_RG + this.command);
		
		String AccountFromServ = inFromServer.readUTF();
		if(AccountFromServ.equals(CommandList.OP_FAILED)) {
			JOptionPane.showMessageDialog(new JFrame(), "Transação não realizada, RG invalido");
			return false;
		}
		else {
			Gson gson = new Gson();
			this.myAccount = gson.fromJson(AccountFromServ, AccountModel.class);
			this.receiver = new Receiver(clientSocket, myAccount, this.lamportChandy, this.sender);
			receiver.start();
			return true;
		}
	}

	public void depositMoney(String value ) throws IOException {
		this.command = value;
		this.historic.add(CommandList.DEPOSIT);
		this.sendBuffer.add(CommandList.DEPOSIT + this.command);
	}
	
	public void withdrawMoney(String value) throws IOException {
		this.command = value;
		this.historic.add(CommandList.WITHDRAW);
		this.sendBuffer.add(CommandList.WITHDRAW + this.command);
	}
	
	public void transferMoney(String value, String rgDestino) throws IOException {
		String valor = value;
		this.command = valor+","+rgDestino;
		this.historic.add(CommandList.TRANSFER);
		this.sendBuffer.add(CommandList.TRANSFER + this.command);
		
	}
	
	public void exitSystem() throws IOException {
		this.historic.add(CommandList.EXIT);
		this.sendBuffer.add(CommandList.EXIT + this.command);
		this.receiver.stop();
		this.exit = true;
	}
	
	public void updateBalance() throws IOException {
		this.historic.add(CommandList.UPDATE_BALANCE);
		this.sendBuffer.add(CommandList.UPDATE_BALANCE);
	}
	
	public void globalState() {
		this.historic.clear();
		this.lamportChandy.numberMarker = 1;
	}
	
	
}
