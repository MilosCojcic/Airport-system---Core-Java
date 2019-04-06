package com.comtrade.systemoperation;

import java.util.HashMap;

import com.comtrade.broker.Broker;
import com.comtrade.broker.IBroker;
import com.comtrade.domen.MyException;
import com.comtrade.domen.User;

public class LoginUser extends GeneralSystemOperation {

	@Override
	protected void ExecuteConcreteSystemOperation(Object obj) throws MyException {
		HashMap<String, Object>hm=(HashMap<String, Object>) obj;
		User u = (User) hm.get("user");
		IBroker ib = new Broker();
		Integer value=ib.returnValue(u);
		hm.put("value", value);
		
	}

	
}
