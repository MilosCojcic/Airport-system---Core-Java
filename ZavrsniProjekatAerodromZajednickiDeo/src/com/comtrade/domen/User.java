package com.comtrade.domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

public class User implements CommonDomen, Serializable {
	private int id_user;
	private String name;
	private String surname;
	private String title;
	private String date_of_birth;
	private String gender;
	private String email;
	private String username;
	private String password;
	

	public User(String name, String surname, String title, String date_of_birth, String gender, String email,
			String userName, String password) {
		super();
		
		this.name = name;
		this.surname = surname;
		this.title = title;
		this.date_of_birth = date_of_birth;
		this.gender = gender;
		this.email = email;
		this.username = userName;
		this.password = password;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String userName) {
		this.username = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String returnNameForTable() {
		// TODO Auto-generated method stub
		return "user";
	}

	@Override
	public String returnNameForInsert() {
		// TODO Auto-generated method stub
		return " values('"+getName()+"','"+getSurname()+"','"+getTitle()+"','"+getDate_of_birth()+"','"+getGender()+"','"+getEmail()+"','"+getUserName()+"','"+getPassword()+"')";
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
		return " (name,surname,title,date_of_birth,gender,email,username,password) ";
	}

}
