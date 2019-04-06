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

public class TopKnochForm extends JFrame {

	private JPanel contentPane;

	
	public TopKnochForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 786, 582);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(182, 136, 1, 1);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblVip = new JLabel("Vip Lounge");
		lblVip.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblVip.setForeground(Color.BLACK);
		lblVip.setBounds(37, 11, 146, 19);
		contentPane.add(lblVip);
		
		JLabel lblWorkingHours = new JLabel("Open everyday 7:00 - 20:00, Sundays 10:00 - 19:00");
		lblWorkingHours.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblWorkingHours.setBounds(37, 41, 335, 14);
		contentPane.add(lblWorkingHours);
		
		JLabel lblRestaurant = new JLabel("Restaurants");
		lblRestaurant.setForeground(Color.WHITE);
		lblRestaurant.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblRestaurant.setBounds(410, 38, 186, 19);
		contentPane.add(lblRestaurant);
		
		JLabel lblOpenEveryday = new JLabel("Open everyday 12:00 - 22:00, Sundays 12:00 - 20:00");
		lblOpenEveryday.setForeground(Color.WHITE);
		lblOpenEveryday.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblOpenEveryday.setBounds(410, 227, 335, 14);
		contentPane.add(lblOpenEveryday);
		
		JLabel lblShops = new JLabel("Shops");
		lblShops.setForeground(Color.WHITE);
		lblShops.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblShops.setBounds(47, 466, 186, 19);
		contentPane.add(lblShops);
		
		JLabel lblOpenEveryday_1 = new JLabel("Open everyday 08:00 - 22:00, Sundays 08:00 - 20:00");
		lblOpenEveryday_1.setForeground(Color.WHITE);
		lblOpenEveryday_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblOpenEveryday_1.setBounds(10, 280, 335, 14);
		contentPane.add(lblOpenEveryday_1);
		
		JLabel lblCoffee = new JLabel("Coffee Shops");
		lblCoffee.setForeground(Color.WHITE);
		lblCoffee.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblCoffee.setBounds(428, 388, 186, 19);
		contentPane.add(lblCoffee);
		
		JLabel lblOpenEveryday_2 = new JLabel("Open everyday 08:00 - 22:00");
		lblOpenEveryday_2.setForeground(Color.WHITE);
		lblOpenEveryday_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblOpenEveryday_2.setBounds(390, 453, 335, 14);
		contentPane.add(lblOpenEveryday_2);
		
		JButton btnBack = new JButton();
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AboutUsForm auf= new AboutUsForm();
				auf.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		btnBack.setIcon(new ImageIcon("back.png"));
		btnBack.setFont(new Font("Tahoma", Font.ITALIC, 15));
		btnBack.setBounds(347, 502, 93, 30);
		contentPane.add(btnBack);
		JLabel picLabel3= new JLabel(new ImageIcon("kafic1.jpg"));
		picLabel3.setBounds(390, 280, 380, 263);
		contentPane.add(picLabel3);
		
		JLabel picLabel = new JLabel(new ImageIcon("vipic1.jpg"));
		picLabel.setBounds(0, 0, 400, 253);
		contentPane.add(picLabel);
		JLabel picLabel2= new JLabel(new ImageIcon("restorancici1.jpg"));
		picLabel2.setBounds(395, 0, 450, 282);
		contentPane.add(picLabel2);
		JLabel picLabel1 = new JLabel(new ImageIcon("sopic1.jpg"));
		picLabel1.setBounds(-11, 247, 419, 296);
		contentPane.add(picLabel1);
	}
}
