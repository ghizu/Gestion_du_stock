package com.master.actions;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.master.DAO.UserDao;
import com.master.entities.Users;
import com.mysql.cj.Session;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport  implements SessionAware{

	Users user;
	UserDao dao;

	private SessionMap<String ,Object> sessionMap ;
	
	public UserAction() {
		dao = new UserDao();
	}

	
	public void setSession(Map<String, Object> map) {
		sessionMap = (SessionMap) map ;
	}
	@Override
	public String execute() throws Exception {
		if (dao.check(getUser().getLogin(), getUser().getPass()) != null) {
			sessionMap.put("login", "true");
			sessionMap.put("name",getUser().getLogin() );
			return SUCCESS;
		}

		else
			
		return INPUT;
	}

	public Users getUser() {

		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

}
