package actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Communication.Communication;
import windows.MainMenu;

public class ExitAction implements ActionListener {

	public Communication communication;
	public JFrame frame;
	
	public ExitAction(Communication communication, JFrame frame) {
		this.communication = communication;
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			this.communication.exitSystem();
			this.frame.dispose();
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
