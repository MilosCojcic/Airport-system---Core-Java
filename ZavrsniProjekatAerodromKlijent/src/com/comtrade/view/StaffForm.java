package com.comtrade.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.comtrade.controlerUI.Controler;
import com.comtrade.domen.Staff;
import com.comtrade.domen.User;
import com.comtrade.transfer.TransferClass;


import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;


public class StaffForm extends JFrame {

	private JPanel contentPane;
	private JTextField tfUser;
	private JPasswordField pfPass;
	private JButton btnLogin; 
	private JButton btnHomePage;
	private JFrame frame;
	
	

	public StaffForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 760, 482);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblUser = new JLabel("Username");
		lblUser.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblUser.setForeground(Color.BLACK);
		lblUser.setBounds(216, 166, 81, 14);
		panel.add(lblUser);
		
		JLabel lblPass = new JLabel("Password");
		lblPass.setForeground(Color.BLACK);
		lblPass.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblPass.setBounds(216, 212, 81, 14);
		panel.add(lblPass);
		
		tfUser = new JTextField();
		tfUser.setBounds(325, 165, 86, 20);
		panel.add(tfUser);
		tfUser.setColumns(10);
		
		pfPass = new JPasswordField();
		pfPass.setBounds(325, 211, 86, 20);
		panel.add(pfPass);
		
		
		ImageIcon iconDugme = new ImageIcon("loginButton.png");
		JButton btnLogin_1;
		btnLogin_1 = new JButton(iconDugme);
		btnLogin_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String staff=tfUser.getText();
				char[] pass = pfPass.getPassword();
				String password = String.valueOf(pass);
				Staff staff1= new Staff();
				staff1.setUsername(staff);
				staff1.setPassword(password);
				try {
					TransferClass tf = Controler.getInstanca().sendValueLoginStaff(staff1);
					Staff sta = (Staff) tf.getServerObject_responce();
					if(sta.getStatus()==1) {
						MarkoStaffForm msf= new MarkoStaffForm();
						msf.setVisible(true);
						setVisible(false);
						dispose();
					}
					else if(sta.getStatus()==2) {
							CojcicStaffForm csf= new CojcicStaffForm();
							csf.setVisible(true);
							setVisible(false);
							dispose();
						}
					else if (sta.getStatus()==3) {
								DejanStaffForm dsf= new DejanStaffForm(sta.getId_staff());
								dsf.setVisible(true);
								setVisible(false);
								dispose();
							
						
					}else  {
						JOptionPane.showMessageDialog(null, "Staff doesn't exist in base");
					}
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnLogin_1.setBackground(new Color(240, 240, 240));
		btnLogin_1.setFont(new Font("Yu Gothic UI", Font.ITALIC, 16));
		btnLogin_1.setBounds(309, 259, 120, 43);
		panel.add(btnLogin_1);
		
		btnHomePage = new JButton("Homepage");
		btnHomePage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					GreatingForm gf= new GreatingForm();
					gf.setVisible(true);
					setVisible(false);
					dispose();
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnHomePage.setForeground(Color.WHITE);
		btnHomePage.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		btnHomePage.setBackground(Color.GRAY);
		btnHomePage.setBounds(476, 343, 113, 38);
		panel.add(btnHomePage);
		
		JLabel picLabel = new JLabel(new ImageIcon("stjuardescica3.jpg"));
		picLabel.setLocation(0, 0);
		picLabel.setSize(600, 394);
		panel.add(picLabel);
	}
}
