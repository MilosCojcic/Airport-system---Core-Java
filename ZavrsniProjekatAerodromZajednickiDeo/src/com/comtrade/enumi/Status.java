package com.comtrade.enumi;

public class Status {
	public static final String ON_TIME = "on-time";
	public static final String DELAYED = "delayed";
	public static final String LATE = "late";
	public static final String CANCELED = "canceled";
	public static String getOnTime() {
		return ON_TIME;
	}
	public static String getDelayed() {
		return DELAYED;
	}
	public static String getLate() {
		return LATE;
	}
	public static String getCanceled() {
		return CANCELED;
	}
	
}
