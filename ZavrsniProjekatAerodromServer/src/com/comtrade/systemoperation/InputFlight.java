package com.comtrade.systemoperation;



import com.comtrade.broker.Broker;
import com.comtrade.broker.IBroker;
import com.comtrade.domen.Flight;
import com.comtrade.domen.MyException;

public class InputFlight extends GeneralSystemOperation {

	@Override
	protected void ExecuteConcreteSystemOperation(Object obj) throws MyException {
		Flight f = (Flight) obj;
		IBroker ib = new Broker();
		ib.save(f);

	}

}
