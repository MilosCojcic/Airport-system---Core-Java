package com.comtrade.systemoperation;

import java.util.HashMap;
import java.util.List;

import com.comtrade.broker.Broker;
import com.comtrade.broker.IBroker;
import com.comtrade.domen.CommonDomen;
import com.comtrade.domen.Flight;
import com.comtrade.domen.MyException;

public class ListFlights extends GeneralSystemOperation{
	
	@Override
	protected void ExecuteConcreteSystemOperation(Object obj) throws MyException {
		HashMap<String, Object>hm=(HashMap<String, Object>) obj;
		Flight f = (Flight) hm.get("date");
		String value = (String) hm.get("value");
		IBroker ib = new Broker();
		List<CommonDomen>listF =null;
		if(value.equals("return")) {
			listF = (ib).returnFlight(f);
		}else if(value.equals("check")) {
			listF= (ib).checkDate(f);	
		}
		hm.put("list",listF);
	}

}
