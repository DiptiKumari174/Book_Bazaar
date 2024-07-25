package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entity.User;

public class UserDAOImpl implements UserDAO{
	private Connection conn;

	public UserDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	@Override
	public boolean UserRegister(User us) {
		// TODO Auto-generated method stub
		boolean f = false;
		try {
			String sql = "insert into user(name,email,phno,password) values(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, us.getName());
			ps.setString(2, us.getEmail());
			ps.setString(3, us.getPhno());
			ps.setString(4, us.getPassword());
			
			//ps.executeUpdate();
			
			int i = ps.executeUpdate();
			if(i==1)
			{
				f = true;
			}
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
	}

	@Override
	public User login(String email, String password) {
		// TODO Auto-generated method stub
		User us = null;
		try {
			String sql = "select * from user where email=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1,email);
			ps.setString(2,password);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				 us = new User();
				 us.setID(rs.getInt(1));
				 us.setName(rs.getString(2));
				 us.setEmail(rs.getString(3));
				 us.setPhno(rs.getString(4));
				 us.setPassword(rs.getString(5));
				 us.setLandmark(rs.getString(6));
				 us.setCity(rs.getString(7));
				 us.setState(rs.getString(8));
				 us.setPin(rs.getString(9));
				 
				 
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return us;
		
		
		
	}

	@Override
	public boolean checkPassword(int id, String pswd) {
		boolean f = false;
		try {
			String sql = "select * from user where id=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
		
			ps.setInt(1, id);
			ps.setString(2, pswd);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				f=true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return f;
	}

	@Override
	public boolean updateProfile(User u) {
	    boolean f = false;
	    try {
	        String sql = "UPDATE user SET name=?, email=?, phno=? WHERE ID=?";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setString(1, u.getName());
	        ps.setString(2, u.getEmail());
	        ps.setString(3, u.getPhno());
	        ps.setInt(4, u.getID());

	        int i = ps.executeUpdate();
	        if (i == 1) {
	            f = true;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return f;
	}

	@Override
	public boolean checkUser(String em) {
		boolean f = true;
		try {
	        String sql = "select * from user where email=?";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setString(1, em);
	        
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
            	f=false;
            }
	       
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return f;
		
	}
	
	

}
