package com.comtrade.domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class Flight implements CommonDomen,Serializable {
	private int id_flight;
	private int id_airline;
	private String status;
	private String starting_point;
	private String destination;
	private String arrival_time;
	private String departure_time;
	private String date;
	private int tickets;
	
	public Flight(int id_airline,String status, String starting_point, String destination, String arrival_time, String departure_time,
			String date, int tickets) {
		super();
		
		this.id_airline = id_airline;
		this.status = status;
		this.starting_point = starting_point;
		this.destination = destination;
		this.arrival_time = arrival_time;
		this.departure_time = departure_time;
		this.date = date;
		this.tickets = tickets;
		
	}
	public Flight() {
		
	}
	
	public Flight(String date) {
		super();
		this.date = date;
	}

	
	public int getId_flight() {
		return id_flight;
	}
	public void setId_flight(int id_flight) {
		this.id_flight = id_flight;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStarting_point() {
		return starting_point;
	}
	public void setStarting_point(String starting_point) {
		this.starting_point = starting_point;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getArrival_time() {
		return arrival_time;
	}
	public void setArrival_time(String arrival_time) {
		this.arrival_time = arrival_time;
	}
	public String getDeparture_time() {
		return departure_time;
	}
	public void setDeparture_time(String departure_time) {
		this.departure_time = departure_time;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public int getTickets() {
		return tickets;
	}
	public void setTickets(int tickets) {
		this.tickets = tickets;
	}
	
	public int getId_airline() {
		return id_airline;
	}
	public void setId_airline(int id_airline) {
		this.id_airline = id_airline;
	}
	@Override
	public String returnNameForTable() {
		// TODO Auto-generated method stub
		return "flights";
	}
	@Override
	public String returnNameForInsert() {
		// TODO Auto-generated method stub
		return " values('"+getId_airline()+"','"+getStatus()+"','"+getStarting_point()+"','"+getDestination()+"','"+getArrival_time()+"','"+getDeparture_time()+"','"+getDate()+"','"+getTickets()+"')";
	}
	@Override
	public String returnNameForUpdate(CommonDomen cd) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String returnNameForSelect() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<CommonDomen> manageSelect(ResultSet rs) {
		List<CommonDomen>listF=new ArrayList<>();
		try {
			while(rs.next()) {
				Flight f2 = new Flight();
				f2.setId_flight(rs.getInt("id_flights"));
				
				f2.setStarting_point(rs.getString("starting_point"));
				f2.setDestination(rs.getString("destination"));
				f2.setArrival_time(rs.getString("arrival_time"));
				f2.setDeparture_time(rs.getString("departure_time"));
				f2.setDate(rs.getString("date"));
				f2.setTickets(rs.getInt("tickets_left"));
				
				listF.add(f2);
			}} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		
		return listF;
	
	}
	@Override
	public String returnNameForColumn() {
		// TODO Auto-generated method stub
		return "(id_airline, status, starting_point, destination, arrival_time, departure_time, date, tickets )";
	}
	
}
