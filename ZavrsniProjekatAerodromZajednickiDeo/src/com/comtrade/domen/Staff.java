package com.comtrade.domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

public class Staff implements CommonDomen, Serializable {
	private int id_staff;
	private String username;
	private String password;
	private int status;
	public Staff(String username, String password, int status) {
		super();
		
		this.username = username;
		this.password = password;
		this.status = status;
	}
	
	public Staff() {
		
	}

	public int getId_staff() {
		return id_staff;
	}

	public void setId_staff(int id_staff) {
		this.id_staff = id_staff;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String returnNameForTable() {
		// TODO Auto-generated method stub
		return "staff";
	}

	@Override
	public String returnNameForInsert() {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String returnNameForColumn() {
		// TODO Auto-generated method stub
		return "(username,password)";
	}
	
}
