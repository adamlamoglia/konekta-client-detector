package actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import Communication.Communication;

public class GlobalStateAction   implements ActionListener {
	
	public Communication communication;
	
	public GlobalStateAction (Communication communication) {
		this.communication = communication;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
			this.communication.globalState();
		
	}

}
