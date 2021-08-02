package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.notes.NotesManagement;

/**
 * Servlet implementation class HistoryServlet
 */
public class HistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id =Integer.parseInt(request.getParameter("nodeId").trim());
		try {
			new NotesManagement().saveHistory(id);
			
		   request.getRequestDispatcher("all_notes.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.print(e);
			response.sendRedirect("error.jsp");
		}

	}


}
