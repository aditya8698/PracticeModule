package com.practice.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.practice.dao.UserDao;
import com.practice.model.User;


@WebServlet("/DeleteUser")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 UserDao dao;
	    
	    @Override
		public void init() throws ServletException {
			dao = new UserDao();
		}
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		User u = new User();
		u.setId(id);
		
		int a = dao.deleteUser(id);
		
		if(a==1) {
			RequestDispatcher rd = request.getRequestDispatcher("Show.jsp");
			rd.forward(request, response);
		}
	}

	
	

}
