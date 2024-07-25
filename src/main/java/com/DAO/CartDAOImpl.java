package com.DAO;

import com.entity.Add_to_cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CartDAOImpl implements CartDAO {
	private Connection conn;
	public CartDAOImpl(Connection conn)
	{
		this.conn = conn;
	}
	
	
	public boolean addCart(Add_to_cart c)
	{
		boolean f = false;
		try {
			String sql = "insert into add_to_cart(bid,uid,bookname,author,price,total_price) values(?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, c.getBid());
			ps.setInt(2, c.getUid());
			ps.setString(3, c.getBookname());
			ps.setString(4, c.getAuthor());
			ps.setDouble(5, c.getPrice());
			ps.setDouble(6, c.getTotal_price() != null ? c.getTotal_price() : 0.0);
			
			
			int i = ps.executeUpdate();
			if(i==1)
			{
				f=true;
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
	}
	
	@Override
	public boolean deleteBook(int bid,int uid, int cid) {
		// TODO Auto-generated method stub
		
		boolean f = false;
		try {
			
			String sql = "delete from add_to_cart where bid=? and uid=? and cid=?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, bid);
			ps.setInt(2, uid);
			ps.setInt(3, cid);
			int i = ps.executeUpdate();
			if(i == 1)
			{
				f = true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return f;
	}


	public List<Add_to_cart> getBookByUser(int userId)
	{
		List<Add_to_cart> list = new ArrayList<>();
        Add_to_cart c = null;
        double totalPrice = 0;
		try {
			String sql = "select * from add_to_cart where uid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				c=new Add_to_cart();
				c.setCid(rs.getInt(1));
				c.setBid(rs.getInt(2));
				
				c.setUid(rs.getInt(3));
				c.setBookname(rs.getString(4));
				c.setAuthor(rs.getString(5));
				c.setPrice(rs.getDouble(6));
				
				
				totalPrice = totalPrice+rs.getDouble(7);
				c.setTotal_price(totalPrice);
				list.add(c);
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return list;
	}

}
