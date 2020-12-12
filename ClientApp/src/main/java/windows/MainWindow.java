package windows;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Communication.Communication;
import actions.SendRgAction;

import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;


public class MainWindow extends JFrame  {
	
	public Communication communication;

	private JPanel contentPane;
	private  JTextField textField;
	private JLabel lblNewLabel;
	
	public MainWindow(Communication communication) {
		setResizable(false);
		setBackground(new Color(255, 255, 255));
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/images/banco-do-brasil-01-logo.png")));
		setTitle("Banco Distribuido");
		this.communication = communication;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 561, 432);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(33, 82, 151));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblInsiraSeuRg = new JLabel("Informe seu RG:");
		lblInsiraSeuRg.setForeground(new Color(246,246,246));
		lblInsiraSeuRg.setFont(new Font("Dialog", Font.BOLD, 13));
		lblInsiraSeuRg.setBounds(215, 194, 138, 51);
		contentPane.add(lblInsiraSeuRg);
		
		textField = new JTextField();
		textField.setBackground(new Color(248, 209, 23));
		textField.setBounds(163, 249, 222, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		

		GenericRoundedButton  btnSend = new GenericRoundedButton ("Entrar");
		btnSend.setForeground(new Color(33, 82, 151));
		btnSend.setBackground(new Color(248, 209, 23));
		btnSend.addActionListener( new SendRgAction(communication,textField,this));
		btnSend.setBounds(184, 284, 183, 34);
		contentPane.add(btnSend);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/user (1).png")));
		lblNewLabel.setBounds(217, 56, 121, 110);
		contentPane.add(lblNewLabel);
		this.setVisible(true);	
	}
	
	

	
}
