package com.comtrade.communication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import com.comtrade.enumi.IPAdressAndPort;
import com.comtrade.transfer.TransferClass;

public class Communication {
	
	private static Communication instanca;
	private Socket socket;
	private Communication () {
		try {
			socket=new Socket(IPAdressAndPort.ADRESS.getAdress(),IPAdressAndPort.PORT.getPort());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Communication getInstanca() {
		if(instanca==null) {
			instanca=new Communication();
		}
		return instanca;
	}
	public void send(TransferClass tf) {
		ObjectOutputStream outSocket;
		try {
			outSocket = new ObjectOutputStream(socket.getOutputStream());
			outSocket.writeObject(tf);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public TransferClass read() throws ClassNotFoundException, IOException {
		ObjectInputStream inSocket = null;
			try {
				inSocket = new ObjectInputStream(socket.getInputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return (TransferClass) inSocket.readObject();
		
	}
}
