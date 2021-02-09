package com.master.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.master.entities.ProduitApprovisionnement;
import com.master.entities.ProduitStock;
import com.master.entities.Users;




public class HibernateUtil {

	private static SessionFactory sessionFactory;
	static {
		try {
			Configuration configuration = new Configuration();
			configuration.configure();
			configuration.addAnnotatedClass(ProduitStock.class).addAnnotatedClass(Users.class).addAnnotatedClass(ProduitApprovisionnement.class);
			
			ServiceRegistry srvcReg = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
					.build();
			sessionFactory = configuration.buildSessionFactory(srvcReg);
		} catch (Exception e) {
			System.err.println("Exception while initializing hibernate util.. ");
			e.printStackTrace();
		}
	}
	public static SessionFactory getSessionfactory() {
		return sessionFactory;
	}
}
