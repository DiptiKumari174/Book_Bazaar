package com.user.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDAOImpl;
import com.entity.User;
import com.DB.DBConnect;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  System.out.println("RegisterServlet doPost called");
		try {
			String name = req.getParameter("fname");
			String email = req.getParameter("email");
			String phno = req.getParameter("phno");
			String password = req.getParameter("password");
			String check = req.getParameter("check");
			
			System.out.println(name +" "+email+" "+phno+" "+password+" "+check);
			
			
			User us = new User();
			us.setName(name);
			us.setEmail(email);
			us.setPhno(phno);
			us.setPassword(password);
			
			HttpSession session = req.getSession();
			
			if(check!=null)
			{
				//because we have to check for a unique email 
				UserDAOImpl dao = new UserDAOImpl(DBConnect.getConn());
				boolean f2 = dao.checkUser(email);
				if(f2)
				{
					boolean f = dao.UserRegister(us);
					
					if(f)
					{
						session.setAttribute("succMsg","Registration Successfully...");
						resp.sendRedirect("register.jsp");
				     }
					else
					{
						session.setAttribute("failedMsg","Something wrong on server...");
						resp.sendRedirect("register.jsp");
				    }
				}
				else 
				{
					session.setAttribute("failedMsg","User already exists try another email id");
					resp.sendRedirect("register.jsp");
				}
			}
			else
			{
				session.setAttribute("failedMsg","Please check Agree and Terms condition");
				resp.sendRedirect("register.jsp");
			}
			}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
