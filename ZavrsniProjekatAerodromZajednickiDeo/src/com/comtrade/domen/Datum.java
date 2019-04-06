package com.comtrade.domen;

public class Datum {

	private int dan;
	private int godina;
	private int mesec;
	public Datum(int dan, int godina, int mesec) {
		super();
		this.dan = dan;
		this.godina = godina;
		this.mesec = mesec;
	}
	public int getDan() {
		return dan;
	}
	public void setDan(int dan) {
		this.dan = dan;
	}
	public int getGodina() {
		return godina;
	}
	public void setGodina(int godina) {
		this.godina = godina;
	}
	public int getMesec() {
		return mesec;
	}
	public void setMesec(int mesec) {
		this.mesec = mesec;
	}
	
}
