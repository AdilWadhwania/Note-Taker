package com.servlets;


import java.io.IOException;

import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entities.Notes;
import com.notes.NotesManagement;

public class SaveNote extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public SaveNote() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String title=request.getParameter("title");
			String content=request.getParameter("content");
			
			Notes note=new Notes(title,content,new Date(),true);

			new NotesManagement().addNotes(note);

			request.setAttribute("noteId", note.getId());
			request.getRequestDispatcher("all_notes.jsp").forward(request, response);
			
			
		}catch(Exception e) {
			response.sendRedirect("error.jsp");
		}
		
	}

}
