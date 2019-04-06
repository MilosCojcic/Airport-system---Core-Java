package com.comtrade.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TransportForm extends JFrame {

	private JPanel contentPane;

	public TransportForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 786, 531);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 760, 487);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel piclabel = new JLabel(new ImageIcon("mapica1.jpg"));
		piclabel.setBounds(24, 138, 713, 349);
		panel.add(piclabel);
		JLabel piclabel1 = new JLabel(new ImageIcon("busic.png"));
		piclabel1.setBounds(280, 48, 80, 79);
		panel.add(piclabel1);
		JLabel piclabel2 = new JLabel(new ImageIcon("taksic1.png"));
		piclabel2.setBounds(24, 47, 80, 80);
		panel.add(piclabel2);
		JLabel piclabel3 = new JLabel(new ImageIcon("vozic1.jpg"));
		piclabel3.setBounds(436, 47, 80, 80);
		panel.add(piclabel3);
		
		JLabel lblPinkTaxi = new JLabel("Pink Taxi ");
		lblPinkTaxi.setFont(new Font("Times New Roman", Font.ITALIC, 13));
		lblPinkTaxi.setForeground(new Color(0, 0, 0));
		lblPinkTaxi.setBounds(114, 34, 86, 14);
		panel.add(lblPinkTaxi);
		
		JLabel label = new JLabel("+3810112499987");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Times New Roman", Font.ITALIC, 13));
		label.setBounds(114, 48, 134, 14);
		panel.add(label);
		
		JLabel lblNaxiTaxi = new JLabel("Beogradski Taxi");
		lblNaxiTaxi.setForeground(Color.BLACK);
		lblNaxiTaxi.setFont(new Font("Times New Roman", Font.ITALIC, 13));
		lblNaxiTaxi.setBounds(114, 73, 114, 14);
		panel.add(lblNaxiTaxi);
		
		JLabel label_1 = new JLabel("+3810112574444");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Times New Roman", Font.ITALIC, 13));
		label_1.setBounds(114, 87, 134, 14);
		panel.add(label_1);
		
		JLabel lblAloTaxi = new JLabel("Alo Taxi ");
		lblAloTaxi.setForeground(Color.BLACK);
		lblAloTaxi.setFont(new Font("Times New Roman", Font.ITALIC, 13));
		lblAloTaxi.setBounds(114, 112, 86, 14);
		panel.add(lblAloTaxi);
		
		JLabel label_2 = new JLabel("+3810114789999");
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Times New Roman", Font.ITALIC, 13));
		label_2.setBounds(114, 126, 134, 14);
		panel.add(label_2);
		
		JLabel lblLineA = new JLabel("Line A1");
		lblLineA.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblLineA.setBounds(370, 48, 46, 14);
		panel.add(lblLineA);
		
		JLabel lblLineA_1 = new JLabel("Line A2");
		lblLineA_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblLineA_1.setBounds(370, 73, 46, 14);
		panel.add(lblLineA_1);
		
		JLabel lblLineA_2 = new JLabel("Line A3");
		lblLineA_2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblLineA_2.setForeground(Color.BLACK);
		lblLineA_2.setBounds(370, 98, 46, 14);
		panel.add(lblLineA_2);
		
		JLabel lblNewLabel = new JLabel("In progress");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setBounds(528, 79, 80, 28);
		panel.add(lblNewLabel);
		
		JButton btnBack = new JButton();
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AboutUsForm auf = new AboutUsForm();
				auf.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		btnBack.setIcon(new ImageIcon("back.png"));
		btnBack.setFont(new Font("Tahoma", Font.ITALIC, 15));
		btnBack.setBounds(644, 71, 93, 30);
		panel.add(btnBack);
	}

}
