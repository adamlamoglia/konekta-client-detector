package windows;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Communication.Communication;
import actions.ExitAction;
import actions.GlobalStateAction;
import actions.WithdrawAction;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class MainMenu extends JFrame {

	private JPanel contentPane;
	public Communication communication;
	public WithdrawWindow withdrawWindow;
	public DepositWindow depositWindow;
	public TransferWindow transferWindow;
	
	public MainMenu(Communication communication) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainMenu.class.getResource("/images/banco-do-brasil-01-logo.png")));
		setResizable(false);
		setTitle("Menu");
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JButton btnNewButton = new JButton("Deposito");
		btnNewButton.setIcon(new ImageIcon(MainMenu.class.getResource("/images/deposit (1).png")));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(33, 82, 151) );
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					communication.updateBalance();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				 depositWindow =  new DepositWindow(communication,communication.myAccount.getNome(),Double.toString(communication.myAccount.saldo));;
				 depositWindow.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 14));
		btnNewButton.setBounds(0, 63, 300, 224);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Saque");
		btnNewButton_1.setIcon(new ImageIcon(MainMenu.class.getResource("/images/saque (1).png")));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(248, 209, 23));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					communication.updateBalance();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				withdrawWindow = new WithdrawWindow(communication,communication.myAccount.getNome(),Double.toString(communication.myAccount.saldo));
				withdrawWindow.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Dialog", Font.BOLD, 14));
		btnNewButton_1.setBounds(300, 63, 292, 224);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Transferencia");
		btnNewButton_2.setIcon(new ImageIcon(MainMenu.class.getResource("/images/traferenciaIcon (1).png")));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(248, 209, 23) );
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					communication.updateBalance();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				transferWindow = new TransferWindow(communication,communication.myAccount.getNome(),Double.toString(communication.myAccount.saldo));
				transferWindow.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Dialog", Font.BOLD, 14));
		btnNewButton_2.setBounds(0, 287, 300, 280);
		contentPane.add(btnNewButton_2);
		
		JButton btnExit = new JButton("Sair");
		btnExit.setIcon(new ImageIcon(MainMenu.class.getResource("/images/exit (1).png")));
		btnExit.setForeground(new Color(255, 255, 255));
		btnExit.setBackground(new Color(33, 82, 151));
		btnExit.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		btnExit.addActionListener(new ExitAction(communication,this));
		btnExit.setBounds(300, 287, 292, 280);
		contentPane.add(btnExit);
		
		JButton btnNewButton_3 = new JButton("Estado Global");
		btnNewButton_3.setBounds(0, 0, 592, 66);
		btnNewButton_3.setBackground(new Color(255, 238, 0));
		btnNewButton_3.setForeground(new Color(33, 82, 151));
		btnNewButton_3.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		btnNewButton_3.addActionListener(new GlobalStateAction(communication));
		contentPane.add(btnNewButton_3);
		
		this.communication = communication;
		
		this.setVisible(true);
		
		//fechar tela (@fix)
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
	}
}
