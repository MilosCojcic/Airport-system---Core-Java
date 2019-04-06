package com.comtrade.systemoperation;

import com.comtrade.broker.Broker;
import com.comtrade.broker.IBroker;
import com.comtrade.domen.Airline;
import com.comtrade.domen.MyException;

public class InputAirline extends GeneralSystemOperation {

	@Override
	protected void ExecuteConcreteSystemOperation(Object obj) throws MyException {
		try {
			Airline airline = (Airline) obj;
			IBroker ib = new Broker();
			ib.save(airline);

		} catch (Exception e) {
			throw new MyException("something went wrong, try again please");
		}
	}

}
