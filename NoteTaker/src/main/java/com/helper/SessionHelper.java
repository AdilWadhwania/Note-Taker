package com.helper;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entities.Notes;

public class SessionHelper {

	public Session getSession() {
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Notes.class);

		SessionFactory sf = con.buildSessionFactory();
		
		Session s=sf.openSession();
		return s;
	}
	
	
}
