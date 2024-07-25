package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Book_Order_Dtls;

public class BookOrderDAOImpl implements BookOrderDAO {

	private Connection conn;
	public BookOrderDAOImpl(Connection conn) {
		super();
		this.conn = conn;
		
	}

	

	


	@Override
	public boolean saveOrder(List<Book_Order_Dtls> blist) {
		boolean f = false;
		
		try {
			String sql = "insert into book_order(order_id,user_name,email,address,phone,book_name,author,price,payment) values(?,?,?,?,?,?,?,?,?)";
			conn.setAutoCommit(f);
			PreparedStatement ps = conn.prepareStatement(sql);
			for(Book_Order_Dtls b :blist )
			{
				ps.setString(1, b.getOrderId());
				ps.setString(2, b.getUserName());
				ps.setString(3, b.getEmail());
				
				ps.setString(4, b.getFulladd());
				ps.setString(5, b.getPhno());
				ps.setString(6, b.getBookName());
				ps.setString(7, b.getAuthor());
				ps.setString(8, b.getPrice());
				ps.setString(9, b.getPaymentType());
				ps.addBatch();
				
			}
			int[] count = ps.executeBatch();
			conn.commit();
			f= true;
			conn.setAutoCommit(true);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}






	@Override
	public List<Book_Order_Dtls> getBook(String email) {
		List<Book_Order_Dtls> list = new ArrayList<Book_Order_Dtls>();
		Book_Order_Dtls bod = null;
		
		try {
			String sql = "select * from book_order where email=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				bod = new Book_Order_Dtls();
				bod.setId(rs.getInt(1));
				bod.setOrderId(rs.getString(2));
				bod.setUserName(rs.getString(3));
				bod.setEmail(rs.getString(4));
				bod.setFulladd(rs.getString(5));
				bod.setPhno(rs.getString(6));
				bod.setBookName(rs.getString(7));
				bod.setAuthor(rs.getString(8));
				bod.setPrice(rs.getString(9));
				bod.setPaymentType(rs.getString(10));
				list.add(bod);
			}
		}catch (Exception e) {
			
		}
		return list;
	}
	
	@Override
	public List<Book_Order_Dtls> getAllOrder() {
		List<Book_Order_Dtls> list = new ArrayList<Book_Order_Dtls>();
		Book_Order_Dtls bod = null;
		
		try {
			String sql = "select * from book_order";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				bod = new Book_Order_Dtls();
				bod.setId(rs.getInt(1));
				bod.setOrderId(rs.getString(2));
				bod.setUserName(rs.getString(3));
				bod.setEmail(rs.getString(4));
				bod.setFulladd(rs.getString(5));
				bod.setPhno(rs.getString(6));
				bod.setBookName(rs.getString(7));
				bod.setAuthor(rs.getString(8));
				bod.setPrice(rs.getString(9));
				bod.setPaymentType(rs.getString(10));
				list.add(bod);
			}
		}catch (Exception e) {
			
		}
		return list;
	}
	

}
