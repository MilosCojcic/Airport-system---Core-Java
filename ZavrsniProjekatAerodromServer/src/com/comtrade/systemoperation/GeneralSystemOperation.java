package com.comtrade.systemoperation;



import com.comtrade.connection.Connections;
import com.comtrade.domen.MyException;

public abstract class GeneralSystemOperation {
	
	public void executeSystemOperation(Object obj) {
		try {
		startTransaction();
		ExecuteConcreteSystemOperation(obj);
		confirmTransaction();
		}catch(Exception e){
		reverseTransaction();
		}finally {
		closeConnections();
		}
	}
	private void closeConnections() {
		Connections.getObject().closeConection();
	}
	private void reverseTransaction() {
		Connections.getObject().reverseTransaciton();
	}
	private void confirmTransaction() {
		Connections.getObject().confirmTransaction();
	}
	protected void startTransaction() {
		Connections.getObject().startTransaction();
	}
	protected abstract void ExecuteConcreteSystemOperation(Object obj) throws MyException;
	
	
}
