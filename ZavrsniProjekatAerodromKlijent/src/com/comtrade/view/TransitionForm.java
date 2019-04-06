package com.comtrade.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import com.comtrade.controlerUI.Controler;
import com.comtrade.domen.CommonDomen;
import com.comtrade.domen.User;
import com.comtrade.transfer.TransferClass;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;
import java.io.File;
import java.io.IOException;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class TransitionForm extends JFrame {

	private JPanel contentPane;
	private JTextField tfUser;
	private JButton btnHome;
	private JPasswordField pfPass;

	/**
	 * Launch the application.
	 * 
	 * @throws IOException
	 */

	public TransitionForm() throws IOException {
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

		JLabel lblAlready = new JLabel("Already have an Account?");
		lblAlready.setBounds(107, 143, 332, 52);
		lblAlready.setForeground(Color.RED);
		lblAlready.setFont(new Font("Microsoft YaHei Light", Font.BOLD | Font.ITALIC, 24));
		panel.add(lblAlready);

		ImageIO.read(new File("pozadinica4.jpg"));

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(Color.RED);
		lblUsername.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblUsername.setBounds(107, 206, 113, 28);
		panel.add(lblUsername);

		tfUser = new JTextField();
		tfUser.setBounds(242, 212, 86, 20);
		panel.add(tfUser);
		tfUser.setColumns(10);

		JLabel lblPass = new JLabel("Password");
		lblPass.setForeground(Color.RED);
		lblPass.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblPass.setBounds(107, 261, 75, 14);
		panel.add(lblPass);

		btnHome = new JButton("Homepage");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GreatingForm gf = null;
				try {
					gf = new GreatingForm();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				gf.setVisible(true);
				setVisible(false);
				dispose();

			}

		});
		btnHome.setBackground(Color.GRAY);
		btnHome.setForeground(Color.WHITE);
		btnHome.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		btnHome.setBounds(23, 419, 113, 38);
		panel.add(btnHome);

		JButton btnNewButton = new JButton("Create an Account");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CreationForm cf = null;
				try {
					cf = new CreationForm();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				cf.setVisible(true);
				setVisible(false);
				dispose();
				
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setFont(new Font("Palatino Linotype", Font.ITALIC, 16));
		btnNewButton.setBounds(480, 373, 203, 28);
		panel.add(btnNewButton);
		
		pfPass = new JPasswordField();
		pfPass.setBounds(242, 261, 86, 19);
		panel.add(pfPass);
		
		JLabel lblJust = new JLabel("Just Browsing?");
		lblJust.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		lblJust.setForeground(Color.RED);
		lblJust.setBounds(359, 28, 158, 28);
		panel.add(lblJust);
		
		JButton btnCheck = new JButton("Check all our flights here!");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckOurFlightsForm coff= new CheckOurFlightsForm();
				coff.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		btnCheck.setBackground(Color.WHITE);
		btnCheck.setForeground(Color.RED);
		btnCheck.setBounds(329, 54, 188, 23);
		panel.add(btnCheck);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String user=tfUser.getText();
				char[] pass = pfPass.getPassword();
				String password = String.valueOf(pass);
				User user1 = new User();
				user1.setUserName(user);
				user1.setPassword(password);
				try {
					TransferClass tf = Controler.getInstanca().sendValueLogin(user1);
					Integer value = (Integer) tf.getServerObject_responce();
					if (value!=0) {
						DejanStaffForm ds = new DejanStaffForm(value);
						ds.setVisible(true);
					}else  {
						JOptionPane.showMessageDialog(null, "user doesn't exists in base");
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				
			}
		});
		btnLogin.setForeground(Color.RED);
		btnLogin.setFont(new Font("Palatino Linotype", Font.ITALIC, 16));
		btnLogin.setBackground(Color.WHITE);
		btnLogin.setBounds(107, 304, 121, 28);
		panel.add(btnLogin);
		JLabel picLabel = new JLabel(new ImageIcon("pozadinica4.jpg"));
		picLabel.setLocation(0, 0);
		picLabel.setSize(770, 492);
		panel.add(picLabel);

	}
}
