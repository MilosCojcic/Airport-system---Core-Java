package com.comtrade.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.comtrade.controlerUI.Controler;
import com.comtrade.domen.Flight;
import com.comtrade.transfer.TransferClass;
import com.toedter.calendar.JDateChooser;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class CheckOurFlightsForm extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel dtm= new DefaultTableModel();
	private List<Flight>listF=new ArrayList<>();
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public CheckOurFlightsForm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Milos\\Desktop\\poslednja1.jpg"));
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
		
		
		JButton btnNewButton = new JButton("Check Flights");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TransferClass tc = Controler.getInstanca().returnFlight();
					setTable(tc);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			public void setTable (TransferClass tc) {
				dtm.setRowCount(0);
				listF=(List<Flight>) tc.getServerObject_responce();
				Object[]row=new Object[9];
				for(Flight f:listF) {
					row[0]=f.getId_flight();
					row[1]=f.getStarting_point();
					row[2]=f.getDestination();
					row[3]=f.getArrival_time();
					row[4]=f.getDeparture_time();
					row[5]=f.getDate();
					row[6]=f.getTickets();
																		
					dtm.addRow(row);
				}
			}
		});
		btnNewButton.setBounds(105, 127, 126, 23);
		panel.add(btnNewButton);
		
		JLabel lblNotSureWhen = new JLabel("Not sure when you want to fly? ");
		lblNotSureWhen.setForeground(Color.WHITE);
		lblNotSureWhen.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		lblNotSureWhen.setBounds(74, 29, 250, 23);
		panel.add(lblNotSureWhen);
		
		JLabel lblNotSureWhich = new JLabel("Not sure which flight works best for you?");
		lblNotSureWhich.setForeground(Color.WHITE);
		lblNotSureWhich.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		lblNotSureWhich.setBounds(386, 31, 355, 19);
		panel.add(lblNotSureWhich);
		
		JLabel lblCheckAllOur = new JLabel("Check all our available flights here by clicking the button below.");
		lblCheckAllOur.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		lblCheckAllOur.setForeground(Color.WHITE);
		lblCheckAllOur.setBounds(74, 96, 555, 23);
		panel.add(lblCheckAllOur);
		table = new JTable(dtm);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(20, 346, 750, 146);
		panel.add(scrollPane);
		Object[]columns= {"id_flight ","starting_point","destination","arrival_time","departure_time","date","tickets"};
		dtm.addColumn(columns[0]);
		dtm.addColumn(columns[1]);
		dtm.addColumn(columns[2]);
		dtm.addColumn(columns[3]);
		dtm.addColumn(columns[4]);
		dtm.addColumn(columns[5]);
		dtm.addColumn(columns[6]);
		
		scrollPane.setViewportView(table);
		
		JButton btnBack = new JButton("");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TransitionForm tf = null;
				
				try {
					tf = new TransitionForm();
					tf.setVisible(true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				setVisible(false);
				dispose();
			}
		});
		btnBack.setIcon(new ImageIcon("back.png"));
		btnBack.setBounds(628, 98, 89, 23);
		panel.add(btnBack);
		JLabel picLabel = new JLabel(new ImageIcon("C:\\Users\\Milos\\Desktop\\poslednja1.jpg"));
		picLabel.setBounds(-70, -32, 926, 561);
		panel.add(picLabel);
	}
}
