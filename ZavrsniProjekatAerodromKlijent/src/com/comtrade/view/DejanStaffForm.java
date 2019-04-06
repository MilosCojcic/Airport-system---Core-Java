package com.comtrade.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.comtrade.controlerUI.Controler;
import com.comtrade.domen.Airline;
import com.comtrade.domen.Datum;
import com.comtrade.domen.CommonDomen;
import com.comtrade.domen.Flight;
import com.comtrade.domen.Reservation;
import com.comtrade.transfer.TransferClass;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;



import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class DejanStaffForm extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel dtm = new DefaultTableModel();
	private TransferClass tc;
	private List<Flight>listF=new ArrayList<>();
	private CommonDomen cd;
	private JDateChooser dateChooser;
	private Flight f;
	private String a="";
	private int reserveRow;
	private Integer idUsera;
	private JTextField tfTicets;
	private String idFlight;
	private String date;
	
	public DejanStaffForm(Integer idUsera) throws ClassNotFoundException, IOException {
		this.idUsera = idUsera;
		setIconImage(Toolkit.getDefaultToolkit().getImage("reservationic2.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 786, 531);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(-129, 0, 899, 492);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		
		
		
		
		JLabel lblPleaseSelectA = new JLabel("Please Select a Date");
		lblPleaseSelectA.setBounds(367, 35, 150, 22);
		lblPleaseSelectA.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		panel.add(lblPleaseSelectA);
		
		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyyy-MM-dd");
		dateChooser.setBounds(527, 37, 95, 20);
		
		panel.add(dateChooser);
		table = new JTable(dtm);
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				reserveRow=table.getSelectedRow();
				
			}
		});
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(129, 316, 770, 176);
		panel.add(scrollPane);
		scrollPane.setViewportView(table);
		Object[]columns= {"id_flight ","starting_point","destination","arrival_time","departure_time","date","tickets"};
		dtm.addColumn(columns[0]);
		//dtm.addColumn(columns[1]);
		//.addColumn(columns[2]);
		dtm.addColumn(columns[1]);
		dtm.addColumn(columns[2]);
		dtm.addColumn(columns[3]);
		dtm.addColumn(columns[4]);
		dtm.addColumn(columns[5]);
		dtm.addColumn(columns[6]);
		
		JButton brnRefreshTable = new JButton("Refresh Flights");
		brnRefreshTable.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		brnRefreshTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					TransferClass tc = Controler.getInstanca().returnFlight();
					//SELECT (flights.tickets-sum(reservation.bought_tickets))as preostale FROM `flights` inner join reservation on flights.id_flights=reservation.id_flights group by reservation.id_flights
					
					setTable(tc);
					//fullfilYourDestiny();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		brnRefreshTable.setBounds(201, 37, 156, 23);
		panel.add(brnRefreshTable);
		
		JButton btnFilter = new JButton("Filter");
		btnFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				a = sdf.format(dateChooser.getDate());
				//System.out.println(a);
				CommonDomen cd = new Flight(a);
				try {
					 TransferClass tc = Controler.getInstanca().checkDate(cd);
					
				setTable(tc);
				
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
						
			}
			
		});
		btnFilter.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		btnFilter.setBounds(646, 37, 89, 23);
		panel.add(btnFilter);
		
		JButton btnReserve = new JButton("Reserve ");
		btnReserve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int column = 0;
				
				 idFlight = table.getModel().getValueAt(reserveRow, column).toString();
				 int tickets_left = Integer.parseInt(table.getModel().getValueAt(reserveRow, 6).toString());
				 int id = Integer.parseInt(idFlight);
				 String numberOfTickets = "";
				 numberOfTickets = tfTicets.getText().toString();
				 date = table.getModel().getValueAt(reserveRow, 5).toString();
				 if(numberOfTickets.equals("") || (a == "")) {
					 JOptionPane.showMessageDialog(null, "Please either insert a correct date or choose a number of tickets ");
				 }else {
				  int flightYear =Integer.parseInt(a.substring(0, 4));
			      int flightMonth = Integer.parseInt(a.substring(5, 7));
			      int flightDay = Integer.parseInt(a.substring(8, 10));
				
				 
					  int number = Integer.parseInt(numberOfTickets);
					  int year =Integer.parseInt(a.substring(0, 4));
				      int month = Integer.parseInt(a.substring(5, 7));
				      int day = Integer.parseInt(a.substring(8, 10));
				      Datum flightDate= new Datum(flightDay, flightYear, flightMonth);
				      Datum reservationDate = new Datum(day, year, month);
			      
				  if(number <= tickets_left && datumRezervacije(flightDate, reservationDate) ) {
					  CommonDomen cd = new Reservation(number, a, idUsera, idUsera, Integer.parseInt(idFlight));
					  try {
						Controler.getInstanca().sendReservation(cd);
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					  JOptionPane.showMessageDialog(null, "You have sucessfully reserved your tickets"); 
				  }else {
					  JOptionPane.showMessageDialog(null, "Unfortunatelly there are not enough seats available for this flight, "
					  		+ "please try fewer tickets or reserve a different flight");
				  }
				  
				 }
				
			}
			
		});
		btnReserve.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		btnReserve.setBounds(584, 263, 105, 23);
		panel.add(btnReserve);
		
		tfTicets = new JTextField();
		tfTicets.setBounds(488, 266, 86, 20);
		panel.add(tfTicets);
		tfTicets.setColumns(10);
		
		JButton btnNewButton = new JButton("Print Ticket");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TicketForm tf= new TicketForm(idUsera,a);
				tf.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		btnNewButton.setBounds(730, 263, 130, 25);
		panel.add(btnNewButton);
		
		JLabel picLabel = new JLabel(new ImageIcon("reservationic2.jpg"));
		picLabel.setBounds(129, -11, 770, 492);
		panel.add(picLabel);
		
	}

/*	private void fullfilYourDestiny() throws ClassNotFoundException, IOException {
		
		dtm.setRowCount(0);
		
		listF=(List<Flight>) tc.getServerObject_responce();
		Object[]row=new Object[9];
		for(Flight f:listF) {
			row[0]=f.getId_flight();
			row[1]=f.getId_airline();
			row[2]=f.getStatus();
			row[3]=f.getStarting_point();
			row[4]=f.getDestination();
			row[5]=f.getArrival_time();
			row[6]=f.getDeparture_time();
			row[7]=f.getDate();
			row[8]=f.getTickets();
																
			dtm.addRow(row);
			
		}
		setTable(tc);
	
	}*/
	
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
	
	public boolean datumRezervacije(Datum datumForma, Datum datumRezervacije) {
		int godina = datumForma.getGodina() - datumRezervacije.getGodina();
		if(godina > 0) {
			return true;
		}else if(godina < 0 ) {
			return false;
		}	
		else if(datumForma.getMesec() < datumRezervacije.getMesec()) {
			 return false;
		}else if(datumForma.getMesec() > datumRezervacije.getMesec()) {
			return true;
		}else if(datumForma.getDan() < datumRezervacije.getDan()) {
			return false;
		}else {
			return true;
		}
		
	}
}
