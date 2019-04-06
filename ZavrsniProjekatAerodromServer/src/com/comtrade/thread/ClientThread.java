package com.comtrade.thread;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

import com.comtrade.controler.Controler;
import com.comtrade.domen.Airline;
import com.comtrade.domen.CommonDomen;
import com.comtrade.domen.Const;
import com.comtrade.domen.Flight;
import com.comtrade.domen.Reservation;
import com.comtrade.domen.Staff;
import com.comtrade.domen.Ticket;
import com.comtrade.domen.User;
import com.comtrade.transfer.TransferClass;

public class ClientThread extends Thread {

	private Socket socket;

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		while (true) {
			try {
				ObjectInputStream inSocket = new ObjectInputStream(socket.getInputStream());
				TransferClass tc = (TransferClass) inSocket.readObject();
				processingClient(tc);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void processingClient(TransferClass tc) {
		switch (tc.getOperation()) {
		case Const.SAVE_USER:
			User user = (User) tc.getClient_object();
			TransferClass tc1 = new TransferClass();
			
			try {
				Controler.getInstanca().saveData(user);
				tc1.setServerMessage_responce("User sucessesfully saved");
			} catch (Exception e) {
				tc1.setServerMessage_responce("system can not save User");
			}
			send(tc1);
			break;
		case Const.RETURN_LOGIN:
			User user1 = (User) tc.getClient_object();
			TransferClass tc2 = new TransferClass();
			try {
				Integer value = Controler.getInstanca().returnLogin(user1);
				tc2.setServerObject_responce(value);
				send(tc2);
			} catch (Exception e) {
				tc2.setServerMessage_responce("system can not find User");
			}
			break;
		case Const.RETURN_LOGINSTAFF:
			Staff staff1 = (Staff) tc.getClient_object();
			TransferClass tc3 = new TransferClass();
			try {
				Staff status = Controler.getInstanca().returnLoginStaff(staff1);
				tc3.setServerObject_responce(status);
				send(tc3);
			} catch (Exception e) {
				tc3.setServerMessage_responce("system can not find Staff");

			}
			break;
			case Const.SAVE_AIRLINE:
			Airline airline = (Airline) tc.getClient_object();
			TransferClass tc4 = new TransferClass();
			
			try {
				Controler.getInstanca().saveValueAirline(airline);
				tc4.setServerMessage_responce("Airline sucessesfully saved");
				
			} catch (Exception e) {
				tc4.setServerMessage_responce("system can not save Airline");
			}
			send(tc4);
			break;
			case Const.RETURN_AIRLINE:
				
				TransferClass tc5 = new TransferClass();

				List<Airline>listA = Controler.getInstanca().returnAirline();
				tc5.setServerObject_responce(listA);
					
				send(tc5);
				break;
			case Const.SAVE_FLIGHT:
				Flight f=(Flight) tc.getClient_object();
				TransferClass tc6 = new TransferClass();
				try {
				Controler.getInstanca().sendFlight(f);
				tc6.setServerMessage_responce("Flight sucessesfully saved");
				}catch(Exception e){
					tc6.setServerMessage_responce("system can not save Flight");
				}
				send(tc6);
				break;
				
			case Const.RETURN_FLIGHT:
				Flight flight = (Flight) tc.getClient_object();
				TransferClass tc7 = new TransferClass();

				List<Flight>listF = Controler.getInstanca().returnFlight();
				tc7.setServerObject_responce(listF);
					
				send(tc7);
				break;
			case Const.CHECK_DATE:
				Flight flight1 = (Flight) tc.getClient_object();
				TransferClass tc8 = new TransferClass();

				List<Flight>listF1 = Controler.getInstanca().checkDate(flight1);
				tc8.setServerObject_responce(listF1);
					
				send(tc8);
				break;
			case Const.SAVE_RESERVATION:
				Reservation reservation = (Reservation) tc.getClient_object();
				TransferClass tc9 = new TransferClass();
				
				try {
					Controler.getInstanca().saveReservation(reservation);
					tc9.setServerMessage_responce("Reservation sucessesfully made");
					
				} catch (Exception e) {
					tc9.setServerMessage_responce("system can not make a Reservation");
				}
				send(tc9);
				break;
			case Const.RETURN_TICKET:
				Ticket ticket = (Ticket) tc.getClient_object();
				TransferClass tc10 = new TransferClass();

				List<Ticket>listT = Controler.getInstanca().returnTicket(ticket);
				tc10.setServerObject_responce(listT);
					
				send(tc10);
				break;
				
				
	}};

	private void send(TransferClass tc1) {
		ObjectOutputStream outSocket;
		try {
			outSocket = new ObjectOutputStream(socket.getOutputStream());
			outSocket.writeObject(tc1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
