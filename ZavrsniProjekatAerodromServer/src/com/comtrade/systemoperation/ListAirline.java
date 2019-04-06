package com.comtrade.systemoperation;

import java.util.HashMap;
import java.util.List;

import com.comtrade.broker.Broker;
import com.comtrade.broker.IBroker;
import com.comtrade.domen.Airline;
import com.comtrade.domen.MyException;

public class ListAirline extends GeneralSystemOperation {

	@Override
	protected void ExecuteConcreteSystemOperation(Object obj) throws MyException {
		HashMap<String, Object>hm=(HashMap<String, Object>) obj;
		IBroker ib = new Broker();
		List<Airline>listA= ib.returnAirline(new Airline());
		hm.put("list", listA);
		

	}

}
