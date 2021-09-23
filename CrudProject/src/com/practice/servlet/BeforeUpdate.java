package com.practice.servlet;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.practice.dao.UserDao;
import com.practice.model.User;


@WebServlet("/BeforeUpdate")
public class BeforeUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  UserDao dao;
	    
	    @Override
		public void init() throws ServletException {
			dao = new UserDao();
		}
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		
		User u = new User();
		u.setId(id);
		u.setName(name);
		u.setCity(city);
		
		request.setAttribute("Values", u);
		
		if(id!=null) {
		ResultSet rs = dao.beforeUpdate(u);
		RequestDispatcher rd = request.getRequestDispatcher("Update.jsp");
		rd.forward(request, response);
		}
	}

}
