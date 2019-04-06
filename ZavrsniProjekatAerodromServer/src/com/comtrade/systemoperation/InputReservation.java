package com.comtrade.systemoperation;

import com.comtrade.broker.Broker;
import com.comtrade.broker.IBroker;
import com.comtrade.domen.MyException;
import com.comtrade.domen.Reservation;


public class InputReservation extends GeneralSystemOperation {

	@Override
	protected void ExecuteConcreteSystemOperation(Object obj) throws MyException {
		try {
			Reservation reservation = (Reservation) obj;
			IBroker ib = new Broker();
			ib.save(reservation);

		} catch (Exception e) {
			throw new MyException("something went wrong, try again please");
		}
	}
		
	}


