package com.comtrade.transfer;

import java.io.Serializable;

public class TransferClass implements Serializable{
	
	private int operation;
	private Object client_object;
	private Object serverObject_responce;
	private String serverMessage_responce;
	

	public int getOperation() {
		return operation;
	}

	public void setOperation(int operation) {
		this.operation = operation;
	}

	public Object getClient_object() {
		return client_object;
	}

	public void setClient_object(Object client_object) {
		this.client_object = client_object;
	}

	public Object getServerObject_responce() {
		return serverObject_responce;
	}

	public void setServerObject_responce(Object serverObject_responce) {
		this.serverObject_responce = serverObject_responce;
	}

	public String getServerMessage_responce() {
		return serverMessage_responce;
	}

	public void setServerMessage_responce(String serverMessage_responce) {
		this.serverMessage_responce = serverMessage_responce;
	}

	
	
}
