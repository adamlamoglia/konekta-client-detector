package windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Communication.Communication;
import actions.TransferAction;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.ImageIcon;

public class TransferWindow extends JFrame {

	private JPanel contentPane;
	public Communication communication;
	private JTextField valor;
	private JTextField rgDestino;
	
	public TransferWindow(Communication communication, String nome, String saldo) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TransferWindow.class.getResource("/images/banco-do-brasil-01-logo.png")));
		setResizable(false);
		setTitle("Transferencia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 545, 401);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(33, 82, 151));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomeIago = new JLabel("Nome: " + nome);
		lblNomeIago.setForeground(new Color(255, 255, 255));
		lblNomeIago.setBounds(10, 11, 302, 30);
		contentPane.add(lblNomeIago);
		
		JLabel lblSaldoR = new JLabel("Saldo: R$"+ saldo);
		lblSaldoR.setForeground(new Color(255, 255, 255));
		lblSaldoR.setBounds(408, 11, 129, 14);
		contentPane.add(lblSaldoR);
		
		valor = new JTextField();
		valor.setBackground(new Color(248, 209, 23));
		valor.setBounds(103, 242, 157, 20);
		contentPane.add(valor);
		valor.setColumns(10);
		
		rgDestino = new JTextField();
		rgDestino.setBackground(new Color(248, 209, 23));
		rgDestino.setBounds(308, 242, 157, 20);
		contentPane.add(rgDestino);
		rgDestino.setColumns(10);
		
		JLabel lblRg = new JLabel("Rg destino:");
		lblRg.setForeground(new Color(255, 255, 255));
		lblRg.setBounds(308, 211, 86, 19);
		contentPane.add(lblRg);
		
		JLabel lblValor = new JLabel("Valor:");
		lblValor.setForeground(new Color(255, 255, 255));
		lblValor.setBounds(103, 214, 77, 16);
		contentPane.add(lblValor);
		
		GenericRoundedButton  btnNewButton = new GenericRoundedButton ("Transferir");
		btnNewButton.setForeground(new Color(33, 82, 151));
		btnNewButton.setBackground(new Color(248, 209, 23));
		btnNewButton.addActionListener(new TransferAction(communication,valor,rgDestino,this));
		btnNewButton.setBounds(103, 285, 362, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TransferWindow.class.getResource("/images/traferenciaIcon (1).png")));
		lblNewLabel.setBounds(221, 99, 117, 82);
		contentPane.add(lblNewLabel);
		
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
	}

}
