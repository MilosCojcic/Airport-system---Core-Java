package com.comtrade.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;

import com.comtrade.controler.Controler;
import com.comtrade.domen.CommonDomen;
import com.comtrade.domen.Flight;
import com.comtrade.domen.Ticket;
import com.comtrade.transfer.TransferClass;

import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class TicketForm extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel dtm = new DefaultTableModel();
	private TransferClass tc;
	private List<Ticket> listT = new ArrayList<>();
	private JButton btnShowReservation;
	private int idUsera;
	private String a;
	private ImageIcon iconA;
	
	public TicketForm(Integer idUsera, String a) {
		this.idUsera=idUsera;
		this.a=a;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 679, 208);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 680, 169);
		contentPane.add(panel);
		panel.setLayout(null);
		table = new JTable(dtm);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 670, 58);
		panel.add(scrollPane);
		scrollPane.setViewportView(table);
		
		iconA = new ImageIcon("tojetobukvalno.png");
		btnShowReservation = new JButton("Show Reservation",iconA);
		btnShowReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Ticket t= new Ticket();
					t.setDate(a);
					t.setIdUsera(idUsera);
					tc= com.comtrade.controlerUI.Controler.getInstanca().returnTicket(t);
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				FillTable();
			}
		});
		btnShowReservation.setIcon(new ImageIcon("tojetobukvalno.png.jpg"));
		btnShowReservation.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		btnShowReservation.setBounds(187, 109, 268, 35);
		panel.add(btnShowReservation);
		Object[] columns = { "Id Flight", "From", "To", "Departure Time", "Arrival time", "Date", "Bought tickets" };
		dtm.addColumn(columns[0]);
		dtm.addColumn(columns[1]);
		dtm.addColumn(columns[2]);
		dtm.addColumn(columns[3]);
		dtm.addColumn(columns[4]);
		dtm.addColumn(columns[5]);
		dtm.addColumn(columns[6]);
		

	}

	private void FillTable() {
		dtm.setRowCount(0);
		//tc = com.comtrade.controlerUI.Controler.getInstanca().returnTicket(t)
		listT = (List<Ticket>) tc.getServerObject_responce();
		Object[] row = new Object[7];
		for (Ticket t : listT) {
			row[0] = t.getId_flight();
			row[1] = t.getStarting_point();
			row[2] = t.getDestination();
			row[3] = t.getArrival_time();
			row[4] = t.getDeparture_time();
			row[5] = t.getDate();
			row[6] = t.getTickets();

			dtm.addRow(row);
		}	
	}
}
