package com.comtrade.controlerUI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.comtrade.communication.Communication;
import com.comtrade.domen.Airline;
import com.comtrade.domen.CommonDomen;
import com.comtrade.domen.Const;
import com.comtrade.domen.Staff;
import com.comtrade.domen.Ticket;
import com.comtrade.domen.User;
import com.comtrade.transfer.TransferClass;

public class Controler {
	public static Controler instanca;
	private List<Airline>listA=new ArrayList<>();

	private Controler() {

	}

	public static Controler getInstanca() {
		if (instanca == null) {
			instanca = new Controler();
		}
		return instanca;
	}

	public TransferClass sendData(CommonDomen cd) throws ClassNotFoundException, IOException {
		TransferClass tc = new TransferClass();
		tc.setOperation(Const.SAVE_USER);
		tc.setClient_object(cd);
		Communication.getInstanca().send(tc);
		TransferClass responce = Communication.getInstanca().read();
		return responce;

	}

	public TransferClass sendValueLogin(CommonDomen cd) throws ClassNotFoundException, IOException {
		TransferClass tc = new TransferClass();
		tc.setOperation(Const.RETURN_LOGIN);
		tc.setClient_object(cd);
		Communication.getInstanca().send(tc);
		TransferClass responce = Communication.getInstanca().read();
		return responce;
	}

	public TransferClass sendValueLoginStaff(CommonDomen cd) throws ClassNotFoundException, IOException {
		TransferClass tc = new TransferClass();
		tc.setOperation(Const.RETURN_LOGINSTAFF);
		tc.setClient_object(cd);
		Communication.getInstanca().send(tc);
		TransferClass responce = Communication.getInstanca().read();
		return responce;
	}

	public TransferClass sendValueAirline(CommonDomen cd) throws ClassNotFoundException, IOException {
		TransferClass tc = new TransferClass();
		tc.setOperation(Const.SAVE_AIRLINE);
		tc.setClient_object(cd);
		Communication.getInstanca().send(tc);
		TransferClass responce = Communication.getInstanca().read();
		return responce;

	}
	public TransferClass returnComboAirline() throws ClassNotFoundException, IOException {
		TransferClass tc = new TransferClass();
		tc.setOperation(Const.RETURN_AIRLINE);
	
		Communication.getInstanca().send(tc);
		TransferClass responce = Communication.getInstanca().read();
		return responce;
	}
	public TransferClass sendFlight(CommonDomen cd) throws ClassNotFoundException, IOException {
		TransferClass tc = new TransferClass();
		tc.setOperation(Const.SAVE_FLIGHT);
		tc.setClient_object(cd);
		Communication.getInstanca().send(tc);
		TransferClass responce = Communication.getInstanca().read();
		return responce;
		
	}
	public TransferClass returnFlight() throws ClassNotFoundException, IOException {
		TransferClass tc = new TransferClass();
		tc.setOperation(Const.RETURN_FLIGHT);
	
		Communication.getInstanca().send(tc);
		TransferClass responce = Communication.getInstanca().read();
		return responce;
	}
	public TransferClass checkDate(CommonDomen cd) throws ClassNotFoundException, IOException {
		TransferClass tc = new TransferClass();
		tc.setOperation(Const.CHECK_DATE);
		tc.setClient_object(cd);
		Communication.getInstanca().send(tc);
		TransferClass responce = Communication.getInstanca().read();
		return responce;
	}	
	public TransferClass sendReservation(CommonDomen cd) throws ClassNotFoundException, IOException {
		TransferClass tc = new TransferClass();
		tc.setOperation(Const.SAVE_RESERVATION);
		tc.setClient_object(cd);
		Communication.getInstanca().send(tc);
		TransferClass responce = Communication.getInstanca().read();
		return responce;
		
	}
	public TransferClass returnTicket(Ticket t) throws ClassNotFoundException, IOException {
		TransferClass tc = new TransferClass();
		tc.setOperation(Const.RETURN_TICKET);
		tc.setClient_object(t);
	
		Communication.getInstanca().send(tc);
		TransferClass responce = Communication.getInstanca().read();
		return responce;
	}
	
		
	
		
}
