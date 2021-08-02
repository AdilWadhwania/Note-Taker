package com.helper;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entities.Notes;

public class GetAllRecords {
	public static final SessionHelper session=new SessionHelper();
	public List<Notes> getRecords(){
		Session s = session.getSession();
		
		s.beginTransaction();
		
		@SuppressWarnings("unchecked")
		org.hibernate.query.Query<Notes> q=s.createQuery("from Notes where history=1");
		List<Notes> list=q.list();
		
		s.getTransaction().commit();
		
		return list;
	}
	public List<Notes> getHistory(){
		Session s = session.getSession();
		
		s.beginTransaction();
		
		@SuppressWarnings("unchecked")
		org.hibernate.query.Query<Notes> q=s.createQuery("from Notes where history=0");
		List<Notes> list=q.list();
		
		s.getTransaction().commit();

		return list;
	}
}
