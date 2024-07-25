package com.user.servlet;
import java.io.File;
import java.io.IOException;
import javax.servlet.http.Part;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.BookDAOImpl;
import com.DB.DBConnect;

import com.entity.BookDtls;
@WebServlet("/add_old_book")
@MultipartConfig
public class AddOldBook extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String bookName = req.getParameter("bname");
			String author = req.getParameter("author");
		    String price = req.getParameter("price");
			String categories = "Old";
			String status = "Active";
			Part part = req.getPart("bimg");
			String fileName = part.getSubmittedFileName();
			
			String useremail = req.getParameter("user");
			
			BookDtls b = new BookDtls(bookName,author,price,categories,status,fileName,useremail);
//			System.out.println(b);
			
			BookDAOImpl dao = new BookDAOImpl(DBConnect.getConn());
			
			
//			String path = getServletContext().getRealPath("")+"book";
////			System.out.println(path);
//			//at get the path with help of context for adding the book after that upload
//			File f = new File(path);
//			part.write(path+File.separator+fileName);//same file me add krna hai photo to write function use kr rahe ahi
		//file name that means file ka kya name rhne wala hai	
			
			boolean f = dao.addBooks(b);
			HttpSession session=req.getSession();
			if(f){
				String path = getServletContext().getRealPath("")+"book";
				File file = new File(path);
				
				session.setAttribute("succMsg","Book Add Successfully");
			    resp.sendRedirect("sell_book.jsp");
			}
			else
			{
				session.setAttribute("failedMsg","Something wrong on server");
			    resp.sendRedirect("sell_book.jsp");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	}


