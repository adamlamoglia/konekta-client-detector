package windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Communication.Communication;
import actions.DepositAction;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class DepositWindow extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	public Communication communication;
	
	public DepositWindow(Communication communication, String nome, String saldo) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(DepositWindow.class.getResource("/images/banco-do-brasil-01-logo.png")));
		setForeground(new Color(33, 82, 151));
		setTitle("Deposito");
		this.communication = communication;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 531, 412);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(33, 82, 151));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setForeground(new Color(33, 82, 151));
		textField.setToolTipText("");
		textField.setBackground(new Color(248, 209, 23));
		textField.setBounds(135, 216, 237, 37);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome: " + nome);
		lblNewLabel.setForeground(new Color(246,246,246));
		lblNewLabel.setBounds(10, 12, 320, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Saldo: R$" + saldo);
		lblNewLabel_1.setForeground(new Color(246,246,246));
		lblNewLabel_1.setBounds(370, 15, 130, 22);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblValor = new JLabel("Informe o valor:");
		lblValor.setForeground(new Color(246,246,246));
		lblValor.setBounds(192, 182, 214, 22);
		contentPane.add(lblValor);
		
		GenericRoundedButton btnNewButton = new GenericRoundedButton("Depositar");
		btnNewButton.setForeground(new Color(33, 82, 151));
		btnNewButton.setBackground(new Color(248, 209, 23));
		btnNewButton.addActionListener(new DepositAction(communication,textField,this));
		btnNewButton.setBounds(173, 265, 157, 36);
		
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setIcon(new ImageIcon(DepositWindow.class.getResource("/images/deposit (1).png")));
		lblNewLabel_2.setBounds(203, 59, 92, 99);
		contentPane.add(lblNewLabel_2);
		
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
	}

}
