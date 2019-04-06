package com.comtrade.systemoperation;

import java.util.HashMap;
import java.util.List;

import com.comtrade.broker.Broker;
import com.comtrade.broker.IBroker;
import com.comtrade.domen.CommonDomen;
import com.comtrade.domen.MyException;
import com.comtrade.domen.Ticket;

public class ListTicket extends GeneralSystemOperation {

	@Override
	protected void ExecuteConcreteSystemOperation(Object obj) throws MyException {
		HashMap<String, Object>hm=(HashMap<String, Object>) obj;
		Ticket ti = (Ticket) hm.get("ticket");
		IBroker ib = new Broker();
		List<CommonDomen>listT= ib.returnTicket(ti);
		hm.put("list", listT);
		
	}

}
