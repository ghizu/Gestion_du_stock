package com.master.DAO;


import org.hibernate.Query;
import org.hibernate.Session;

import com.master.entities.Users;
import com.master.utils.HibernateUtil;

public class UserDao {

	public Users check(String login, String pass) {
		
		Users user = null ;
		try {
			Session session = HibernateUtil.getSessionfactory().getCurrentSession();
			session.beginTransaction();
			Query query = session.createQuery("from Users u where u.login =:n  and u.pass =:p");
			query.setParameter("n", login);
			query.setParameter("p", pass);
			user = (Users) query.uniqueResult();
			session.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
			user = null;
		}
		
		return user;
	}
	public Users add(Users user) {
		Session session = HibernateUtil.getSessionfactory().getCurrentSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		return user;
	}
}
