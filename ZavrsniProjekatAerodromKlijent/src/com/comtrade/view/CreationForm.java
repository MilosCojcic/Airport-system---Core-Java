package com.comtrade.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.comtrade.controlerUI.Controler;
import com.comtrade.domen.CommonDomen;
import com.comtrade.domen.User;
import com.comtrade.transfer.TransferClass;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import com.toedter.calendar.JDateChooser;

public class CreationForm extends JFrame {

	private JPanel contentPane;
	private JTextField tfName;
	private JTextField tfSurname;
	private JTextField tfEmail;
	private JTextField tfUser;
	private JButton btnMake;
	private JPasswordField pfPass;
	private JComboBox cbTitle;
	private JDateChooser dateChooser;
	private JRadioButton rbMale;
	private JRadioButton rbFemale;
	private String title;
	private String gender;

	public CreationForm() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 786, 531);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblRegister = new JLabel("Register for Free!");
		lblRegister.setBounds(240, 46, 224, 44);
		lblRegister.setForeground(Color.WHITE);
		lblRegister.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel.add(lblRegister);

		JLabel lblTekstic = new JLabel(
				"Create an Account to be able to check in online, and achieve many more possibilities available only to registered members!!!!");
		lblTekstic.setBounds(54, 90, 706, 14);
		lblTekstic.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblTekstic.setForeground(Color.WHITE);
		panel.add(lblTekstic);
		ImageIO.read(new File("pozadinica5.jpg"));

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(54, 158, 66, 17);
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel.add(lblName);

		tfName = new JTextField();
		tfName.setBounds(181, 157, 86, 20);
		tfName.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel.add(tfName);
		tfName.setColumns(10);

		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setBounds(54, 200, 66, 17);
		lblSurname.setForeground(Color.WHITE);
		lblSurname.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel.add(lblSurname);

		tfSurname = new JTextField();
		tfSurname.setBounds(181, 199, 86, 20);
		tfSurname.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tfSurname.setColumns(10);
		panel.add(tfSurname);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(54, 277, 66, 17);
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel.add(lblEmail);

		tfEmail = new JTextField();
		tfEmail.setBounds(181, 276, 86, 20);
		tfEmail.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tfEmail.setColumns(10);
		panel.add(tfEmail);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(54, 242, 66, 17);
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel.add(lblUsername);

		tfUser = new JTextField();
		tfUser.setBounds(181, 241, 86, 20);
		tfUser.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tfUser.setColumns(10);
		panel.add(tfUser);

		JButton button = new JButton("Homepage");
		button.setBounds(10, 433, 113, 38);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GreatingForm gf = null;
				try {
					gf = new GreatingForm();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				gf.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		button.setBackground(Color.GRAY);
		panel.add(button);

		JLabel lblPass = new JLabel("Password");
		lblPass.setBounds(54, 324, 95, 17);
		lblPass.setForeground(Color.WHITE);
		lblPass.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel.add(lblPass);

		ImageIcon iconAvio = new ImageIcon("avioncic3.png");

		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(328, 158, 66, 17);
		lblGender.setForeground(Color.WHITE);
		lblGender.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel.add(lblGender);

		rbMale = new JRadioButton("Male");
		rbMale.setBounds(326, 182, 109, 23);
		rbMale.setSelected(true);
		panel.add(rbMale);
		
		rbFemale = new JRadioButton("Female");
		rbFemale.setBounds(462, 182, 109, 23);
		panel.add(rbFemale);
		ButtonGroup group = new ButtonGroup();
		group.add(rbMale);
		group.add(rbFemale);
		if(rbMale.isSelected()) 
	        gender="Male";
	else if(rbFemale.isSelected()) 
	        gender="Female";

		ImageIcon iconAero = new ImageIcon("avioncic3.png");

		btnMake = new JButton("Make an Account", iconAero);
		btnMake.setBounds(311, 367, 229, 30);
		btnMake.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String a = sdf.format(dateChooser.getDate());
				char[] pass = pfPass.getPassword();
				String password = String.valueOf(pass);
				CommonDomen cd = new User(tfName.getText(), tfSurname.getText(), cbTitle.getSelectedItem().toString(),
						a, gender, tfEmail.getText(), tfUser.getText(),
						password);
				try {
					TransferClass tc = Controler.getInstanca().sendData(cd);
					JOptionPane.showMessageDialog(null, tc.getServerMessage_responce());
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnMake.setForeground(Color.BLACK);
		btnMake.setFont(new Font("Microsoft YaHei", Font.ITALIC, 17));
		panel.add(btnMake);

		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(326, 227, 66, 17);
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel.add(lblTitle);

		cbTitle = new JComboBox();
		cbTitle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!cbTitle.getSelectedItem().toString().equals("---Choose your title---")) {
					title = (String) cbTitle.getSelectedItem();
					System.out.println(title);
				} else {
					//JOptionPane.showMessageDialog(null, "ko zna zasto ovo ne radi :D ");
				}
			}
		});
		cbTitle.setBounds(403, 226, 152, 20);
		cbTitle.addItem("---Choose your title---");
		cbTitle.addItem("Mr");
		cbTitle.addItem("Mrs");
		cbTitle.addItem("Ms");
		cbTitle.addItem("Miss");
		cbTitle.addItem("Mstr");
		panel.add(cbTitle);

		pfPass = new JPasswordField();
		pfPass.setBounds(181, 324, 86, 19);
		panel.add(pfPass);

		JButton btnBack = new JButton("Back to Login");
		btnBack.setBounds(566, 366, 184, 32);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TransitionForm tf= new TransitionForm();
					tf.setVisible(true);
					setVisible(false);
					dispose();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
				}
				
			}
		});
		btnBack.setFont(new Font("Microsoft JhengHei", Font.ITALIC, 17));
		panel.add(btnBack);

		dateChooser = new JDateChooser();
		dateChooser.setBounds(403, 298, 113, 20);
		dateChooser.setDateFormatString("yyyy-MM-dd");
		panel.add(dateChooser);

		JLabel lblDateofbirth = new JLabel("DateOfBirth");
		lblDateofbirth.setBounds(311, 298, 83, 14);
		lblDateofbirth.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblDateofbirth.setForeground(Color.WHITE);
		panel.add(lblDateofbirth);

		JLabel picLabel = new JLabel(new ImageIcon("pozadinica4.jpg"));
		picLabel.setBounds(10, 0, 760, 487);
		panel.add(picLabel);
	}
}
