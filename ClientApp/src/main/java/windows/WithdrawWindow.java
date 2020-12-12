package windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Communication.Communication;
import actions.WithdrawAction;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class WithdrawWindow extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	public Communication communication;
	

	public WithdrawWindow(Communication communication, String nome, String saldo) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(WithdrawWindow.class.getResource("/images/banco-do-brasil-01-logo.png")));
		setTitle("Saque");
		this.communication = communication;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 427);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(33, 82, 151));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		GenericRoundedButton btnNewButton = new GenericRoundedButton("Sacar");
		btnNewButton.setForeground(new Color(33, 82, 151));
		btnNewButton.setBackground(new Color(248, 209, 23) );
		
		btnNewButton.setBounds(182, 258, 181, 32);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBackground(new Color(248, 209, 23) );
		textField.setBounds(134, 219, 267, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblValor = new JLabel("Informe o valor:");
		lblValor.setForeground(new Color(255, 255, 255));
		lblValor.setBounds(201, 186, 181, 21);
		contentPane.add(lblValor);
		
		JLabel lblNome = new JLabel("Nome: " + nome);
		lblNome.setForeground(new Color(255, 255, 255));
		lblNome.setBounds(10, 11, 300, 32);
		contentPane.add(lblNome);
		
		JLabel  lblNewLabel = new JLabel("Saldo: R$" + saldo);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(381, 14, 135, 14);
		contentPane.add(lblNewLabel);
		btnNewButton.addActionListener(new WithdrawAction(communication,textField,this));
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(WithdrawWindow.class.getResource("/images/saque (1).png")));
		label.setBounds(212, 67, 98, 82);
		contentPane.add(label);
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
	}
}
