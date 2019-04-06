package com.comtrade.systemoperation;

import com.comtrade.broker.Broker;
import com.comtrade.broker.IBroker;
import com.comtrade.domen.MyException;
import com.comtrade.domen.User;

public class InputUser extends GeneralSystemOperation {

	@Override
	protected void ExecuteConcreteSystemOperation(Object obj) throws MyException {
		try {
			User user = (User) obj;
			IBroker ib = new Broker();
			ib.save(user);

		} catch (Exception e) {
			throw new MyException("something went wrong, try again please");
		}
	}
}
