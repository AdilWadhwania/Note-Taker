package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.notes.NotesManagement;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateNote extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			String title= request.getParameter("title");
			String content=request.getParameter("content");
			
			int id=Integer.parseInt(request.getParameter("id").trim());
			
			new NotesManagement().updateNotes(title, content, id);
			
			response.sendRedirect("all_notes.jsp");
		} catch (Exception e) {
			response.sendRedirect("error.jsp");
		}
		
	}

}
