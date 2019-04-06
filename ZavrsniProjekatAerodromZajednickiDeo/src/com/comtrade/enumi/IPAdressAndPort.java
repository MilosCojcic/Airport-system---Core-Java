package com.comtrade.enumi;

public enum IPAdressAndPort {
ADRESS ("127.0.0.1"), PORT (9000);
	private String adress;
	private int port;
	private IPAdressAndPort(String adress) {
		this.adress = adress;
	}
	private IPAdressAndPort(int port) {
		this.port = port;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	
}
