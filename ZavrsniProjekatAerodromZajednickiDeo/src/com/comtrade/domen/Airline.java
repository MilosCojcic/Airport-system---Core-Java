package com.comtrade.domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;

public class Airline implements CommonDomen, Serializable {
	private int id_airline;
	private String company_name;
	private String airport_name;

	public Airline(String company_name, String airport_name) {
		super();
		
		this.company_name = company_name;
		this.airport_name = airport_name;
		
	}
	public Airline() {
		
	}

	public String getAirport_name() {
		return airport_name;
	}

	public void setAirport_name(String airport_name) {
		this.airport_name = airport_name;
	}

	public int getId_airline() {
		return id_airline;
	}

	public void setId_airline(int id_airline) {
		this.id_airline = id_airline;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}


	
	@Override
	public String returnNameForTable() {
		// TODO Auto-generated method stub
		return "airline";
	}

	@Override
	public String returnNameForInsert() {
		
		return "values ('"+getCompany_name()+"','"+getAirport_name()+"')";
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
		List<CommonDomen>listA=new ArrayList<>();
		try {
			while(rs.next()) {
				rs.getInt("id_airline");
				rs.getString("company_name");
				rs.getString("airport_name");
				Airline a=new Airline();
				a.setId_airline(getId_airline());
				a.setCompany_name(getCompany_name());
				a.setAirport_name(getAirport_name());
			listA.add(a);
			}} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		
		return listA;
		
	}

	@Override
	public String returnNameForColumn() {
		// TODO Auto-generated method stub
		return "(company_name,airport_name)";
	}

}
