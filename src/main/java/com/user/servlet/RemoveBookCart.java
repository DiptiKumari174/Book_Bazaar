package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.CartDAOImpl;
import com.DB.DBConnect;

@WebServlet("/remove_book")
public class RemoveBookCart extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO
		//bookid fetch krke book delete hoga
//		String bidparam = req.getParameter("bid");
//		String uidparam = req.getParameter("uid");
//		String cidparam = req.getParameter("cid");
		
//		if(bidparam != null && !bidparam.trim().isEmpty() && uidparam != null && !uidparam.trim().isEmpty() && cidparam != null && !cidparam.trim().isEmpty())
//		{
//			int bid = Integer.parseInt(bidparam.trim());
//			int uid = Integer.parseInt(uidparam.trim());
//			int cid = Integer.parseInt(cidparam.trim());
		int  bid = Integer.parseInt(req.getParameter("bid"));
		int  uid = Integer.parseInt(req.getParameter("uid"));
		int  cid = Integer.parseInt(req.getParameter("cid"));
		CartDAOImpl dao = new CartDAOImpl(DBConnect.getConn());
		boolean f = dao.deleteBook(bid,uid,cid);
		
		HttpSession session = req.getSession();
		if(f)
		{
			session.setAttribute("succMsg","Book removed from cart");
			
		}
		else
		{
			session.setAttribute("failedMsg", "Something wrong on server");
			
		}
		
//		else
//		{
//			HttpSession session = req.getSession();
//			session.setAttribute("failedMsg", "Invalid book or user ID");
//		}
		resp.sendRedirect("checkout.jsp");
		
	}
 
}
