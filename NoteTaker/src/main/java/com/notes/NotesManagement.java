package com.notes;

import java.io.PrintWriter;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entities.Notes;
import com.helper.SessionHelper;

public class NotesManagement {
	
	public static final SessionHelper session=new SessionHelper();
	
	public void addNotes(Notes note) 
	{

		Session s=session.getSession();
		
		s.beginTransaction();
		
		s.save(note);
		
		s.getTransaction().commit();
		s.close();
	}
	
	public void saveHistory(int id) {
		Session s=session.getSession();
		
		s.beginTransaction();
		
		Notes note=s.get(Notes.class, id);
		
		note.setHistory(false);
		
		s.getTransaction().commit();
		
		s.close();
	}
	
	public void restoreNotes(int id) {
       Session s=session.getSession();
		
		s.beginTransaction();
		
		Notes note=s.get(Notes.class, id);
		
		note.setHistory(true);
		
		s.getTransaction().commit();
		
		s.close();
	}
	
	
	public void deleteNotes(int id) {
		
		Session s=session.getSession();
		
		s.beginTransaction();
		
		Notes note=s.get(Notes.class, id);
		
		 s.delete(note);
		
		s.getTransaction().commit();
		
		s.close();
	
	}
	
	public Notes editNotes(int id) {
		System.out.print("hii");
		Session s = session.getSession();

		s.beginTransaction();

		Notes note = s.get(Notes.class, id);

		s.getTransaction().commit();

		s.close();
		
		return note;
	}

	
	public void updateNotes(String title,String content,int id) {
		Session s=session.getSession();
		
		s.beginTransaction();
		
		Notes note=s.get(Notes.class, id);
		
		note.setContent(content);
		
		note.setTitle(title);
		
		note.setAddedDate(new Date());
		
		s.getTransaction().commit();
		
		s.close();
	}
}
