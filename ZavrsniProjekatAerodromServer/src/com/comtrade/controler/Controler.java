package com.comtrade.controler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.comtrade.broker.Broker;
import com.comtrade.domen.Airline;
import com.comtrade.domen.CommonDomen;
import com.comtrade.domen.Flight;
import com.comtrade.domen.Staff;
import com.comtrade.domen.Ticket;
import com.comtrade.systemoperation.GeneralSystemOperation;
import com.comtrade.systemoperation.InputAirline;
import com.comtrade.systemoperation.InputFlight;
import com.comtrade.systemoperation.InputReservation;
import com.comtrade.systemoperation.InputUser;
import com.comtrade.systemoperation.ListAirline;
import com.comtrade.systemoperation.ListFlights;
import com.comtrade.systemoperation.ListTicket;
import com.comtrade.systemoperation.LoginStaff;
import com.comtrade.systemoperation.LoginUser;


public class Controler {

	private static volatile Controler instanca;
	private static Object mutex = new Object();
	private List<Airline>listA=new ArrayList<>();
	private List<Ticket>ListT= new ArrayList<>();

	public static Controler getInstanca() {
		Controler result = instanca;
		if (result == null) {
			synchronized (mutex) {
				result = instanca;
				if (result == null) {
					instanca = result = new Controler();
				}
			}
		}
		return result;
	}

	public void saveData(CommonDomen cd) {
		GeneralSystemOperation gso = new InputUser();
		gso.executeSystemOperation(cd);
	}

	public int returnLogin(CommonDomen cd) {
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("user", cd);
		GeneralSystemOperation gso = new LoginUser();
		gso.executeSystemOperation(hm);
		Integer value = (Integer) hm.get("value");
		return value;

	}

	public Staff returnLoginStaff(CommonDomen cd) {
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("staff", cd);
		GeneralSystemOperation gso = new LoginStaff();
		gso.executeSystemOperation(hm);
		Staff value = (Staff) hm.get("value");
		return value;

	}

	public void saveValueAirline(Airline a) {
		GeneralSystemOperation gso = new InputAirline();
		gso.executeSystemOperation(a);

	}
	public List<Airline> returnAirline(){
		HashMap<String, Object> hm = new HashMap<>();
		GeneralSystemOperation gso = new ListAirline();
		gso.executeSystemOperation(hm);
		List<Airline>listA=(List<Airline>) hm.get("list");
		return listA;
	}
	public void sendFlight(CommonDomen cd) {
		GeneralSystemOperation gso = new InputFlight();
		gso.executeSystemOperation(cd);
	}
	public List<Flight> returnFlight(){
		HashMap<String, Object> hm = new HashMap<>();
		GeneralSystemOperation gso = new ListFlights();
		hm.put("value", "return");
		gso.executeSystemOperation(hm);
		List<Flight>listF=(List<Flight>) hm.get("list");
		return listF;
	}
	public List<Flight> checkDate(CommonDomen cd){
		HashMap<String, Object> hm = new HashMap<>();
		GeneralSystemOperation gso = new ListFlights();
		hm.put("date", cd);
		hm.put("value", "check");
		
		gso.executeSystemOperation(hm);
		List<Flight>listF=(List<Flight>) hm.get("list");
		return listF;
	}
	public void saveReservation(CommonDomen cd) {
		GeneralSystemOperation gso = new InputReservation();
		gso.executeSystemOperation(cd);
	}
	public List<Ticket> returnTicket(Ticket ticket){
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("ticket", ticket);
		GeneralSystemOperation gso = new ListTicket();
		gso.executeSystemOperation(hm);
		List<Ticket>listT=(List<Ticket>) hm.get("list");
		return listT;
	
	
	}
}
