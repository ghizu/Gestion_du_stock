package com.master.DAO;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.master.entities.ProduitApprovisionnement;
import com.master.foreignClasses.Commandes;
import com.master.utils.HibernateUtil;
import com.master.utils.HibernateUtil2;

public class CommandDAO {

	public void add(Commandes command) {
		Session session = HibernateUtil2.getSessionfactory().getCurrentSession();
		session.beginTransaction();
		session.saveOrUpdate(command);
		session.getTransaction().commit();
	}

	public void delete(int id) {
		Session session = HibernateUtil2.getSessionfactory().getCurrentSession();
		session.beginTransaction();
		Commandes command = (Commandes) session.get(Commandes.class, id);
		if (null != command) {
			session.delete(command);
		}
		session.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List<Commandes> list() {

		Session session = HibernateUtil2.getSessionfactory().getCurrentSession();
		session.beginTransaction();
		List<Commandes> commands = null;
		try {
			commands = (List<Commandes>) session.createQuery("from Commandes").list();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return commands;
	}

	public Commandes getById(int id) {
		Commandes commands = null;
		Session session = HibernateUtil2.getSessionfactory().getCurrentSession();
		session.beginTransaction();
		commands = (Commandes) session.get(Commandes.class, id);
		session.getTransaction().commit();
		return commands;
	}

	@SuppressWarnings("unchecked")
	public List<Commandes> get_commands_by_date(Date dateProduitStock, Date dateCurrent) {

		Session session = HibernateUtil2.getSessionfactory().getCurrentSession();
		session.beginTransaction();
		List<Commandes> commands = null;
		try {

			Query query = session.createQuery("from Commandes a where a.dateCmd >= :x and a.dateCmd <= :y ");
			query.setParameter("x", dateProduitStock);
			query.setParameter("y", dateCurrent);
			commands = (List<Commandes>) query.list();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return commands;
	}

}
