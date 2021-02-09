package com.master.DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.master.entities.ProduitStock;
import com.master.foreignClasses.ProduitPrix;
import com.master.utils.HibernateUtil;

public class ProduitStockDAO {

	public void add(ProduitStock produitStock) {
		Session session = HibernateUtil.getSessionfactory().getCurrentSession();
		session.beginTransaction();
		session.saveOrUpdate(produitStock);
		session.getTransaction().commit();
	}

	public void delete(int id) {
		Session session = HibernateUtil.getSessionfactory().getCurrentSession();
		session.beginTransaction();
		ProduitStock produitStock = (ProduitStock) session.get(ProduitStock.class, id);
		if (null != produitStock) {
			session.delete(produitStock);
		}
		session.getTransaction().commit();
	}

	public List<ProduitStock> list() {

		Session session = HibernateUtil.getSessionfactory().getCurrentSession();
		session.beginTransaction();
		List<ProduitStock> contacts = null;
		try {
			contacts = (List<ProduitStock>) session.createQuery("from ProduitStock").list();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return contacts;
	}

	public ProduitStock getById(int id) {
		ProduitStock ProdStock = null;
		Session session = HibernateUtil.getSessionfactory().getCurrentSession();
		session.beginTransaction();
		ProdStock = (ProduitStock) session.get(ProduitStock.class, id);
		session.getTransaction().commit();
		return ProdStock;
	}

	public List<Date> get_distinct_dates() {

		Session session = HibernateUtil.getSessionfactory().getCurrentSession();
		session.beginTransaction();
		List<Date> distinct_dates = null;
		try {
			distinct_dates = (List<Date>) session.createQuery("select distinct i.dateProduitStock from ProduitStock i order by dateProduitStock").list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return distinct_dates;
	}

	public List<ProduitStock> get_produitsStock_of_date(Date date) {
		Session session = HibernateUtil.getSessionfactory().getCurrentSession();
		session.beginTransaction();
		List<ProduitStock> produitsStock_of_date = null;
		try {
			Query query = session.createQuery("from ProduitStock i where i.dateProduitStock =:x");
			query.setParameter("x", date);
			produitsStock_of_date = (List<ProduitStock>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return produitsStock_of_date;

	}

	public void delete_by_date(Date date) {
		Session session = HibernateUtil.getSessionfactory().getCurrentSession();
		session.beginTransaction();
		try {
			Query query = session.createQuery("DELETE from ProduitStock i where i.dateProduitStock= :x");
			query.setParameter("x", date);
			System.out.println(date);
			query.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
	}

	public List<ProduitStock> get_produitStock_with_name(List<ProduitStock> produitStock) {
		ProduitPrixDAO daoProduitPrix  = new ProduitPrixDAO() ;
		Session session = HibernateUtil.getSessionfactory().getCurrentSession();
		session.beginTransaction();
		List<ProduitPrix> Produits = new ArrayList<ProduitPrix>();
		try {

			for (int i = 0; i < produitStock.size(); i++) {
				Produits.add(daoProduitPrix.getById(produitStock.get(i).getCodePdt()));
			}
			for (int i = 0; i < produitStock.size(); i++) {
				produitStock.get(i).setNomPdt(Produits.get(i).getNomPdt());
			}
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();

		return produitStock;
	}
}
