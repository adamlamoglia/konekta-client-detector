package actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JTextField;

import Communication.Communication;

public class TransferAction implements ActionListener {
	public boolean existRG;
	public Communication communication;
	private  JTextField valor;
	private JTextField rgDestino;
	public JFrame frame;
	
	public TransferAction(Communication communication, JTextField valor, JTextField rgDestino ,JFrame frame) {
		this.communication = communication;
		this.valor = valor;
		this.rgDestino = rgDestino;
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			this.communication.transferMoney(valor.getText(), rgDestino.getText());
			this.frame.dispose();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	
	
}
