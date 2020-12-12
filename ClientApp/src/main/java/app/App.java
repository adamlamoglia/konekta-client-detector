package app;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import Communication.Communication;
import windows.MainWindow;

public class App {
	
	public static final int PORT = 5435;
	public static AccountModel myAccount;
	
    public static void main( String[] args ) throws UnknownHostException, IOException{    	
    	Socket  clientSocket = new Socket("127.0.0.1", PORT);
    	Communication communication = new Communication(clientSocket, myAccount);
    	MainWindow window = new MainWindow(communication);
    }
}
