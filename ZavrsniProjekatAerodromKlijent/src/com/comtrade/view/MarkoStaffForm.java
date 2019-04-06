package com.comtrade.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.comtrade.controlerUI.Controler;
import com.comtrade.domen.Airline;
import com.comtrade.domen.CommonDomen;
import com.comtrade.transfer.TransferClass;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class MarkoStaffForm extends JFrame {

	private JPanel contentPane;
	private JTextField tfAirline;
	private JComboBox cbAirport;
	private String airport;

	public MarkoStaffForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 786, 531);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 770, 492);
		contentPane.add(panel);
		
		cbAirport = new JComboBox();
		cbAirport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!cbAirport.getSelectedItem().toString().equals("---Choose airport---")) {
					airport = (String) cbAirport.getSelectedItem();
					//System.out.println(airport); 
				} else {
					//JOptionPane.showMessageDialog(null, "there is no airport by that name ");
				}
			}
		});
		cbAirport.setBounds(403, 226, 152, 20);

		;

		cbAirport.addItem("---Choose airport---");
		cbAirport.addItem("Nikola Tesla");
		cbAirport.addItem("Konstantin Veliki");
		cbAirport.addItem("Airport Podgorica");
		cbAirport.addItem("Airport Tivat");
		
		panel.add(cbAirport);
		
		

		JLabel lblInsertAirLine = new JLabel("Insert a new Airline Boss");
		lblInsertAirLine.setBounds(187, 5, 300, 34);
		lblInsertAirLine.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 21));
		panel.add(lblInsertAirLine);

		tfAirline = new JTextField();
		tfAirline.setBounds(233, 50, 200, 20);
		panel.add(tfAirline);
		tfAirline.setColumns(10);
		
		JButton btnSave = new JButton("Save Airline");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CommonDomen cd= new Airline(tfAirline.getText(),cbAirport.getSelectedItem().toString());
				try {
					TransferClass tc = Controler.getInstanca().sendValueAirline(cd);
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
		btnSave.setBackground(Color.WHITE);
		btnSave.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		panel.add(btnSave);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StaffForm sf = new StaffForm();
				sf.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		btnBack.setForeground(Color.BLACK);
		btnBack.setBackground(Color.WHITE);
		btnBack.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		panel.add(btnBack);
		JLabel picLabel = new JLabel(new ImageIcon("mozdajedobra.jpg"));
		picLabel.setBounds(583, 22, -1, -1);
		
				panel.add(picLabel);
	}
}
