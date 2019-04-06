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

public class ContactUsForm extends JFrame {

	private JPanel contentPane;

	 
	public ContactUsForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 786, 531);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 770, 492);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblDesk = new JLabel("Check-in Desk   +38166 22 33 44");
		lblDesk.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblDesk.setForeground(new Color(0, 0, 0));
		lblDesk.setBounds(76, 31, 213, 35);
		panel.add(lblDesk);
		
		JLabel lblLostBaggage = new JLabel("Lost Baggage      +38166 22 33 45");
		lblLostBaggage.setForeground(Color.BLACK);
		lblLostBaggage.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblLostBaggage.setBounds(76, 94, 228, 35);
		panel.add(lblLostBaggage);
		
		JLabel lblDisruptionTeam = new JLabel("Disruption Team     +38166 22 33 47");
		lblDisruptionTeam.setForeground(Color.BLACK);
		lblDisruptionTeam.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblDisruptionTeam.setBounds(431, 94, 246, 35);
		panel.add(lblDisruptionTeam);
		
		JLabel lblManagementTeam = new JLabel("Management Team +38166 22 33 46");
		lblManagementTeam.setForeground(Color.BLACK);
		lblManagementTeam.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblManagementTeam.setBounds(431, 31, 246, 35);
		panel.add(lblManagementTeam);
		
		JLabel lblEmailCheckinteambg = new JLabel("email checkin.team.bg");
		lblEmailCheckinteambg.setForeground(Color.BLACK);
		lblEmailCheckinteambg.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblEmailCheckinteambg.setBounds(76, 61, 213, 35);
		panel.add(lblEmailCheckinteambg);
		
		JLabel lblEmailLostbgteambg = new JLabel("email lostbg.team.bg");
		lblEmailLostbgteambg.setForeground(Color.BLACK);
		lblEmailLostbgteambg.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblEmailLostbgteambg.setBounds(76, 117, 213, 35);
		panel.add(lblEmailLostbgteambg);
		
		JLabel lblEmailDisruptteambg = new JLabel("email disrupt.team.bg");
		lblEmailDisruptteambg.setForeground(Color.BLACK);
		lblEmailDisruptteambg.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblEmailDisruptteambg.setBounds(431, 117, 213, 35);
		panel.add(lblEmailDisruptteambg);
		
		JLabel lblEmailManagementteambg = new JLabel("email management.team.bg");
		lblEmailManagementteambg.setForeground(Color.BLACK);
		lblEmailManagementteambg.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblEmailManagementteambg.setBounds(431, 61, 213, 35);
		panel.add(lblEmailManagementteambg);
		
		JButton btnBack = new JButton();
		btnBack.setFont(new Font("Tahoma", Font.ITALIC, 15));
		btnBack.setIcon(new ImageIcon("back.png"));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AboutUsForm auf= new AboutUsForm();
				auf.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		btnBack.setBounds(394, 401, 93, 30);
		panel.add(btnBack);
		
		JLabel picLabel = new JLabel(new ImageIcon("contactusic2.jpg"));
		picLabel.setLocation(10, 0);
		picLabel.setSize(760, 487);
		panel.add(picLabel);
	}

}
