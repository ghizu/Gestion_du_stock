package com.master.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.master.foreignClasses.ProduitPrix;
import com.master.foreignClasses.Commandes;




public class HibernateUtil2 {

	private static SessionFactory sessionFactory;
	static {
		try {
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg2.xml");
			System.out.println("haulcvwdvpuwevwpuvweuiv");
			configuration.addAnnotatedClass(ProduitPrix.class).addAnnotatedClass(Commandes.class);
			
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
