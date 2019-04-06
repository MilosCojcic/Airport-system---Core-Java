package com.comtrade.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.comtrade.enumi.IPAdressAndPort;
import com.comtrade.thread.ClientThread;

public class Server extends Thread{
	
	public void run() {
		StartServer();
	}

	private void StartServer() {
		try {
			ServerSocket ss= new ServerSocket(IPAdressAndPort.PORT.getPort());
			while(true) {
				Socket s=ss.accept();
				ClientThread ct=new ClientThread();
				ct.setSocket(s);
				ct.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
