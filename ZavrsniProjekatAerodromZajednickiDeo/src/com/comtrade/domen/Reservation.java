package com.comtrade.domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

public class Reservation implements CommonDomen, Serializable{
	private int idReservation;
	private int bought_tickets;
	private String date;
	private int idUser;
	private int idStaff;
	private int id_flight;
	public Reservation(int bought_tickets, String date, int idUser, int idStaff,int id_flight) {
		super();
		this.bought_tickets = bought_tickets;
		this.date = date;
		this.idUser = idUser;
		this.idStaff = idStaff;
		this.id_flight=id_flight;
	}
	public int getIdReservation() {
		return idReservation;
	}
	public void setIdReservation(int idReservation) {
		this.idReservation = idReservation;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public int getIdStaff() {
		return idStaff;
	}
	public void setIdStaff(int idStaff) {
		this.idStaff = idStaff;
	}
	
	public int getBought_tickets() {
		return bought_tickets;
	}
	public void setBought_tickets(int bought_tickets) {
		this.bought_tickets = bought_tickets;
	}
	public int getId_flight() {
		return id_flight;
	}
	public void setId_flight(int id_flight) {
		this.id_flight = id_flight;
	}
	@Override
	public String returnNameForTable() {
		// TODO Auto-generated method stub
		return "reservation";
	}
	@Override
	public String returnNameForInsert() {
		
		return "values ('"+getBought_tickets()+"','"+getDate()+"','"+getIdUser()+"','"+getIdStaff()+"','"+getId_flight()+"')";
	}
	@Override
	public String returnNameForUpdate(CommonDomen cd) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String returnNameForSelect() {
		
		return null;
	}
	@Override
	public List<CommonDomen> manageSelect(ResultSet rs) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String returnNameForColumn() {
		// TODO Auto-generated method stub
		return "(bought_tickets,date,id_User,id_Staff,id_flights)";
	}
	
}
