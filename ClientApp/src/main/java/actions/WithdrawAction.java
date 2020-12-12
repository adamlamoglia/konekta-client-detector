package actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Communication.Communication;
import windows.MainMenu;

public class WithdrawAction implements ActionListener {

	public Communication communication;
	private  JTextField textField;
	public JFrame frame;
	
	public WithdrawAction(Communication communication, JTextField textField, JFrame frame) {
		this.communication = communication;
		this.textField = textField;
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			this.communication.withdrawMoney(textField.getText());
			this.frame.dispose();
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
