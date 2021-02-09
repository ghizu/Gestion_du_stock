package com.master.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Users")

public class Users {

	private int codeUser ;
	private String login ; 
	private String pass ;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	public int getCodeUser() {
		return codeUser;
	}
	public void setCodeUser(int codeUser) {
		this.codeUser = codeUser;
	}
	@Column
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	@Column
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	
	
}
