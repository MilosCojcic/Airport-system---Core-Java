package com.comtrade.view;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.awt.event.ActionEvent;

import com.comtrade.controlerUI.Controler;
import com.comtrade.domen.Airline;
import com.comtrade.domen.CommonDomen;
import com.comtrade.domen.Flight;
import com.comtrade.enumi.Status;
import com.comtrade.transfer.TransferClass;
import com.toedter.calendar.JDateChooser;

import com.comtrade.controler.*;
public class CojcicStaffForm extends JFrame {
	
	private JPanel contentPane;
	private JTextField tfStart;
	private JTextField tfDestination;
	private JTextField tfDepartureTime;
	private JTextField tfArrivalTime;
	private JDateChooser dateChooser;
	private JComboBox<String> cbAirLine;
	private TransferClass tc = Controler.getInstanca().returnComboAirline();
	private List<Airline>listA=(List<Airline>) tc.getServerObject_responce();
	JComboBox cbStatus;
	private String status;
	private int id_airline;
	private CommonDomen cd;
	private JTextField tfTickets;
	

	public CojcicStaffForm() throws ClassNotFoundException, IOException {
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

		tfStart = new JTextField();
		tfStart.setBounds(491, 65, 118, 20);
		panel.add(tfStart);
		tfStart.setColumns(10);

		tfDestination = new JTextField();
		tfDestination.setBounds(260, 65, 118, 20);
		tfDestination.setColumns(10);
		panel.add(tfDestination);

		tfDepartureTime = new JTextField();
		tfDepartureTime.setBounds(27, 309, 118, 20);
		tfDepartureTime.setColumns(10);
		panel.add(tfDepartureTime);

		tfArrivalTime = new JTextField();
		tfArrivalTime.setBounds(27, 234, 118, 20);
		tfArrivalTime.setColumns(10);
		panel.add(tfArrivalTime);

		cbAirLine = new JComboBox();
		cbAirLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String AirlineName = cbAirLine.getSelectedItem().toString();
				for(Airline a:listA) {
					if(AirlineName.equals(a.getCompany_name())){
						id_airline=a.getId_airline();
					}
				}
			}
		});
		cbAirLine.setBounds(27, 65, 118, 20);
		
		panel.add(cbAirLine);
		
		JLabel lblAirline = new JLabel("Select Airline");
		lblAirline.setForeground(Color.WHITE);
		lblAirline.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		lblAirline.setBackground(Color.WHITE);
		lblAirline.setBounds(27, 24, 209, 30);
		panel.add(lblAirline);

		JLabel lblInsertStart = new JLabel("Insert Starting Point");
		lblInsertStart.setForeground(Color.WHITE);
		lblInsertStart.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		lblInsertStart.setBackground(Color.WHITE);
		lblInsertStart.setBounds(260, 24, 209, 30);
		panel.add(lblInsertStart);

		JLabel lblInsertDestination = new JLabel("Insert Destination");
		lblInsertDestination.setForeground(Color.WHITE);
		lblInsertDestination.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		lblInsertDestination.setBackground(Color.WHITE);
		lblInsertDestination.setBounds(491, 24, 209, 30);
		panel.add(lblInsertDestination);

		JLabel lblInsertDepartureTime = new JLabel("Insert Departure Time");
		lblInsertDepartureTime.setForeground(Color.WHITE);
		lblInsertDepartureTime.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		lblInsertDepartureTime.setBackground(Color.WHITE);
		lblInsertDepartureTime.setBounds(27, 193, 209, 30);
		panel.add(lblInsertDepartureTime);

		JLabel lblInsertArrivaltime = new JLabel("Insert ArrivalTime");
		lblInsertArrivaltime.setForeground(Color.WHITE);
		lblInsertArrivaltime.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		lblInsertArrivaltime.setBackground(Color.WHITE);
		lblInsertArrivaltime.setBounds(27, 268, 209, 30);
		panel.add(lblInsertArrivaltime);

		JLabel lblInsertDate = new JLabel("Insert Date");
		lblInsertDate.setForeground(Color.WHITE);
		lblInsertDate.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		lblInsertDate.setBackground(Color.WHITE);
		lblInsertDate.setBounds(517, 174, 209, 30);
		panel.add(lblInsertDate);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StaffForm sf = new StaffForm();
				sf.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		btnBack.setBounds(28, 421, 89, 23);
		panel.add(btnBack);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(517, 234, 95, 20);
		dateChooser.setDateFormatString("yyyy-MM-dd");
		panel.add(dateChooser);
		
		JButton btnMakeAFlight = new JButton("Make a Flight");
		btnMakeAFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String a = sdf.format(dateChooser.getDate());
				int i= Integer.parseInt(tfTickets.getText());
				
				
				CommonDomen cd=new Flight(id_airline,cbStatus.getSelectedItem().toString(), tfStart.getText(), tfDestination.getText(), tfArrivalTime.getText(), tfDepartureTime.getText(), a, i);
				try {
					TransferClass tc = Controler.getInstanca().sendFlight(cd);
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
		btnMakeAFlight.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		btnMakeAFlight.setBounds(517, 421, 128, 23);
		panel.add(btnMakeAFlight);
		
		JLabel lblTickets = new JLabel("Tickets");
		lblTickets.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		lblTickets.setForeground(Color.WHITE);
		lblTickets.setBounds(517, 296, 92, 30);
		panel.add(lblTickets);
		
		tfTickets = new JTextField();
		tfTickets.setBounds(517, 337, 86, 20);
		panel.add(tfTickets);
		tfTickets.setColumns(10);
				
		cbStatus = new JComboBox();
		cbStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!cbStatus.getSelectedItem().toString().equals("---Choose your title---")) {
					status = (String) cbStatus.getSelectedItem();
					System.out.println(status);
				} else {
					//JOptionPane.showMessageDialog(null, "not possible ");
				}
				
					}
				});
				cbStatus.setBounds(27, 123, 118, 20);
				cbStatus.addItem("---Choose status---");
				cbStatus.addItem(Status.getOnTime());
				cbStatus.addItem(Status.getDelayed());
				cbStatus.addItem(Status.getLate());
				cbStatus.addItem(Status.getCanceled());
				panel.add(cbStatus);
				
				JLabel lblStatus = new JLabel("Status");
				lblStatus.setFont(new Font("Times New Roman", Font.ITALIC, 18));
				lblStatus.setForeground(Color.WHITE);
				lblStatus.setBounds(27, 96, 118, 16);
				panel.add(lblStatus);
				
				JLabel picLabel = new JLabel(new ImageIcon("dark.jpeg"));
				picLabel.setFont(new Font("Times New Roman", Font.ITALIC, 16));
				picLabel.setBounds(0, 0, 770, 492);
				panel.add(picLabel);
				display();
		
	}


	private void display() throws ClassNotFoundException, IOException {
		
		for(Airline a: listA) {
			cbAirLine.addItem(a.getCompany_name());
			id_airline=a.getId_airline();
	}
}
}
