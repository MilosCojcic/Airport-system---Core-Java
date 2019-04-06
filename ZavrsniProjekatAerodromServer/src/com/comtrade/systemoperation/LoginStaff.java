package com.comtrade.systemoperation;

import java.util.HashMap;

import com.comtrade.broker.Broker;
import com.comtrade.broker.IBroker;
import com.comtrade.domen.MyException;
import com.comtrade.domen.Staff;


public class LoginStaff extends GeneralSystemOperation{

	@Override
	protected void ExecuteConcreteSystemOperation(Object obj) throws MyException {
		HashMap<String, Object>hm=(HashMap<String, Object>) obj;
		Staff s= (Staff) hm.get("staff");
		IBroker ib = new Broker();
		Staff value=ib.returnValue(s);
		hm.put("value", value);
		
	}
		
	}


