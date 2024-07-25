package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.BookDAO;
import com.DAO.BookDAOImpl;
import com.DAO.CartDAOImpl;
import com.DB.DBConnect;
import com.entity.Add_to_cart;
import com.entity.BookDtls;
//url mapping
@WebServlet("/cart")
public class CartServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    try {
	    	int bid = Integer.parseInt(req.getParameter("bid"));
	    	int uid = Integer.parseInt(req.getParameter("uid"));
	    	
	    	BookDAO dao = new BookDAOImpl(DBConnect.getConn());
	    	BookDtls b = dao.getBookById(bid);
	    	
	    	Add_to_cart c = new Add_to_cart();
	    	c.setBid(bid);
	    	c.setUid(uid);
	    	c.setBookname(b.getBookname());
	    	c.setAuthor(b.getAuthor());
	    	c.setPrice(Double.parseDouble(b.getPrice()));
	        c.setTotal_price(Double.parseDouble(b.getPrice()));
	    	
	    	CartDAOImpl dao2 = new CartDAOImpl(DBConnect.getConn());
	    	boolean f = dao2.addCart(c);
	    	
	    	HttpSession session = req.getSession();
	  
	    	
	    	if(f && c.getTotal_price()!=null)
	    	{
	    		session.setAttribute("addCart","Book Added to cart"); 
	    		resp.sendRedirect("all_new_book.jsp");
//	    	System.out.println("Add cart Success");
	    	}
	    	else
	    	{
	    		session.setAttribute("failed","Something gonna wrong on server"); 
	    		resp.sendRedirect("all_new_book.jsp");
	    		//System.out.println("not added to cart");
	    	}
	    	
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
		
	}
   
}
