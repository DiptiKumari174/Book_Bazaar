package com.user.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.BookOrderDAOImpl;
import com.DAO.CartDAOImpl;
import com.DB.DBConnect;
import com.entity.Add_to_cart;
import com.entity.Book_Order_Dtls;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
        	HttpSession session = req.getSession();
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("username");
            String email = req.getParameter("email");
            String phno = req.getParameter("phno");
            String address = req.getParameter("address");
            String landmark = req.getParameter("landmark");
            String city = req.getParameter("city");
            String state = req.getParameter("state");
            String pincode = req.getParameter("pin_code");
            String paymentType = req.getParameter("payment");
            String fullAdd = address + "," + landmark + "," + city + "," + state + "," + pincode;

            CartDAOImpl cartDAO = new CartDAOImpl(DBConnect.getConn());
            
            List<Add_to_cart> bList = cartDAO.getBookByUser(id);
            if(bList.isEmpty())
            {
            	session.setAttribute("failedMsg", "Please add items. ");
            	resp.sendRedirect("checkout.jsp");
            }
            else {
            	BookOrderDAOImpl dao2 = new BookOrderDAOImpl(DBConnect.getConn());

                ArrayList<Book_Order_Dtls> orderList = new ArrayList<>();
                Random r = new Random();
                

                for (Add_to_cart c : bList) {
                	Book_Order_Dtls bod = new Book_Order_Dtls();
                    bod.setOrderId("BOOK-ORD-00" + r.nextInt(1000));
                    bod.setUserName(name);
                    bod.setEmail(email);
                    bod.setPhno(phno);
                    bod.setFulladd(fullAdd);
                    bod.setBookName(c.getBookname());
                    bod.setAuthor(c.getAuthor());
                    bod.setPrice(c.getPrice() + "");
                    bod.setPaymentType(paymentType);
                  
                    orderList.add(bod);
                }
            
               if ("noselect".equals(paymentType)) {
                //System.out.println("Ordered Success");
            	session.setAttribute("failedMsg", "Choose your payment mode");
                resp.sendRedirect("checkout.jsp");
              } else {
                //System.out.println("Ordered failed");
                //resp.sendRedirect("order_failure.jsp");
            	boolean f = dao2.saveOrder(orderList);
            	if(f)
            	{
            		resp.sendRedirect("order_success.jsp");
            		//System.out.println("Ordered Success");
				}
				else {
					//System.out.println("Ordered failed ");
					session.setAttribute("failedMsg", "Choose your payment mode");
	                resp.sendRedirect("checkout.jsp");
				}
              }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            //resp.sendRedirect("error.jsp");
        }
    }
}
