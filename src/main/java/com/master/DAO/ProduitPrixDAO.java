package com.master.DAO;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.master.entities.ProduitApprovisionnement;
import com.master.entities.ProduitStock;
import com.master.foreignClasses.ProduitPrix;
import com.master.utils.HibernateUtil;
import com.master.utils.HibernateUtil2;

public class ProduitPrixDAO {

	public void add(ProduitPrix Produit) {
		Session session = HibernateUtil2.getSessionfactory().getCurrentSession();
		session.beginTransaction();
		session.saveOrUpdate(Produit);
		session.getTransaction().commit();
	}

	public void delete(int id) {
		Session session = HibernateUtil2.getSessionfactory().getCurrentSession();
		session.beginTransaction();
		ProduitPrix Produit = (ProduitPrix) session.get(ProduitPrix.class, id);
		if (null != Produit) {
			session.delete(Produit);
		}
		session.getTransaction().commit();
	}

	public List<ProduitPrix> list() {
		
		Session session = HibernateUtil2.getSessionfactory().getCurrentSession();
		session.beginTransaction();
		List<ProduitPrix> Produits = null;
		try {
			Produits = (List<ProduitPrix>) session.createQuery("from ProduitPrix").list();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return Produits;
	}

	public ProduitPrix getById(int id) {
		ProduitPrix Produit = null;
		Session session = HibernateUtil2.getSessionfactory().getCurrentSession();
		session.beginTransaction();
		Produit = (ProduitPrix) session.get(ProduitPrix.class, id);
		session.getTransaction().commit();
		return Produit;
	}

	//costum dao 
	
	public int get_total_produitApprovisionnement() {
		Session session = HibernateUtil2.getSessionfactory().getCurrentSession();
		session.beginTransaction();
		try {
			//int total = session.createQuery("select count(*) from A")
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.getTransaction().commit();
		return 0;
	}
	
	public double total_budget() {
		Session session = HibernateUtil2.getSessionfactory().getCurrentSession();
		session.beginTransaction();
		Double total = 0d;
		try {

			total = (Double) session.createQuery("select sum(prixPdt) from ProduitPrix").uniqueResult();
			System.out.println(total);
			total  = (total*(double)(90d/100d));
			
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return total;
	}

	public double total_budget_ce_mois() {
		Session session = HibernateUtil.getSessionfactory().getCurrentSession();
		session.beginTransaction();
		Double total = 0d;
		try {

			total = (Double) session.createQuery("select sum(prixPdt) from ProduitApprovisionnement a where MONTH(a.dateProduitStock) = :date)").setParameter("date", new Date().getMonth()+1).uniqueResult();
			//System.out.println(new Date().getMonth());
			total  = (total*(double)(90d/100d));
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return total;

	}
}
