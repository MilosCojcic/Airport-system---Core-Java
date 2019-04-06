package com.comtrade.broker;


import java.util.List;

import com.comtrade.domen.Airline;
import com.comtrade.domen.CommonDomen;
import com.comtrade.domen.Flight;
import com.comtrade.domen.Staff;
import com.comtrade.domen.Ticket;
import com.comtrade.domen.User;

public interface IBroker {
	
	public void save(CommonDomen cd);
	public int returnValue(User user);
	public Staff returnValue(Staff staff);
	public List<Airline> returnAirline (Airline a);
	public List<CommonDomen> returnFlight(Flight f);
	public List<CommonDomen> checkDate(Flight f);
	public List<CommonDomen> returnTicket(Ticket t);
	
	
	
	
	
}
