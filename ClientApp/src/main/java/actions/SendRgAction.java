package actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Communication.Communication;
import windows.MainMenu;

public class SendRgAction implements ActionListener {

	public boolean existRG;
	public Communication communication;
	private  JTextField textField;
	public JFrame frame;

	public SendRgAction(Communication communication, JTextField textField, JFrame frame) {
		this.communication = communication;
		this.textField = textField;
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			this.existRG = this.communication.sendRG(this.textField.getText());
			if(existRG) {
				frame.dispose();
				MainMenu main = new MainMenu(communication);
			}
			else {
				this.textField.setText("");
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
