package com.master.DAO;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.master.entities.ProduitApprovisionnement;
import com.master.utils.HibernateUtil;


public class ProduitApprovisionnementDAO {

	public void add(ProduitApprovisionnement produitApprovisionnement) {
		Session session = HibernateUtil.getSessionfactory().getCurrentSession();
		session.beginTransaction();
		session.saveOrUpdate(produitApprovisionnement);
		session.getTransaction().commit();
	}

	public void delete(int id) {
		Session session = HibernateUtil.getSessionfactory().getCurrentSession();
		session.beginTransaction();
		ProduitApprovisionnement ProduitApprovisionnement = (ProduitApprovisionnement) session.get(ProduitApprovisionnement.class, id);
		if (null != ProduitApprovisionnement) {
			session.delete(ProduitApprovisionnement);
		}
		session.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List<ProduitApprovisionnement> list() {

		Session session = HibernateUtil.getSessionfactory().getCurrentSession();
		session.beginTransaction();
		List<ProduitApprovisionnement> produitsApprovisionnement = null;
		try {
			produitsApprovisionnement = (List<ProduitApprovisionnement>) session.createQuery("from ProduitApprovisionnement").list();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return produitsApprovisionnement;
	}

	public ProduitApprovisionnement getById(int id) {
		ProduitApprovisionnement produitsApprovisionnement = null;
		Session session = HibernateUtil.getSessionfactory().getCurrentSession();
		session.beginTransaction();
		produitsApprovisionnement = (ProduitApprovisionnement) session.get(ProduitApprovisionnement.class, id);
		session.getTransaction().commit();
		return produitsApprovisionnement;
	}

	@SuppressWarnings("unchecked")
	public List<ProduitApprovisionnement> get_produitsApprovisionnement_by_date(Date dateProduitStock, Date dateCurrent) {

		Session session = HibernateUtil.getSessionfactory().getCurrentSession();
		session.beginTransaction();
		List<ProduitApprovisionnement> produitsApprovisionnement = null;
		try {

			Query query = session.createQuery("from ProduitApprovisionnement a where a.datePrevueLivraison >= :x and a.datePrevueLivraison <= :y ");
			query.setParameter("x", dateProduitStock);
			query.setParameter("y", dateCurrent);
			produitsApprovisionnement = (List<ProduitApprovisionnement>) query.list();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return produitsApprovisionnement;
	}

	public int get_total_produitApprovisionnement() {
		Session session = HibernateUtil.getSessionfactory().getCurrentSession();
		session.beginTransaction();
		Long total = 0l;
		try {

			total = (Long) session.createQuery("select count(*) from ProduitApprovisionnement").uniqueResult();

		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return total.intValue();
	}
	
	@SuppressWarnings("deprecation")
	public int total_produitApprovisionnement_ce_mois() {
		Session session = HibernateUtil.getSessionfactory().getCurrentSession();
		session.beginTransaction();
		Long total = 0l;
		try {

			total = (Long) session.createQuery("select count(*) from ProduitApprovisionnement a where MONTH(a.datePrevueLivraison) = :date)").setParameter("date", new Date().getMonth()+1).uniqueResult();
			System.out.println(new Date().getMonth());
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return total.intValue();
	}
	
	
	
}
