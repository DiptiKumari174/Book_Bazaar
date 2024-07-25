package com.DAO;

import java.sql.Connection;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.DB.DBConnect;
import com.entity.BookDtls;

public class BookDAOImpl implements BookDAO{
	private Connection conn;

	public BookDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	@Override
	public boolean addBooks(BookDtls b) {
		// TODO Auto-generated method stub
		boolean f = false;
		try {
			String sql ="insert into book_dtls(bookname,author,price,bookCategory,status,photo,user_email) values(?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,b.getBookname());
			ps.setString(2,b.getAuthor());
			ps.setString(3,b.getPrice());
			
			ps.setString(4,b.getBookCategory());
			ps.setString(5,b.getStatus());
			ps.setString(6,b.getPhotoName());
			ps.setString(7,b.getUser_email());
			
			int i = ps.executeUpdate();
			if(i == 1)
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
	public List<BookDtls> getAllBooks() {
		
		//database me bahut sara book hai to sara dikhayenge so we have to take list 
		List<BookDtls> list = new ArrayList<BookDtls>();	
		BookDtls b = null;
		
		try {
			String sql ="select * from book_dtls";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				b = new BookDtls();
				b.setBookId(rs.getInt(1));
				b.setBookname(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookCategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhotoName(rs.getString(7));
				b.setUser_email(rs.getString(8));
				list.add(b);
				
			}
					
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public BookDtls getBookById(int id) {
		// TODO Auto-generated method stub
		BookDtls b = null;
		try {
			String sql ="select *from book_dtls where bookId = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs =  ps.executeQuery();
			//row check kr rahe available hai yaa nhi
			
			while(rs.next())
			{
				b= new BookDtls();
				b.setBookId(rs.getInt(1));
				b.setBookname(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookCategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhotoName(rs.getString(7));
				b.setUser_email(rs.getString(8));
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public boolean updateEditBooks(BookDtls b) {
		boolean f = false;
		try {
			 String sql = "update book_dtls set bookname=?,author=?,price=?,status=? where bookId=?";
			 PreparedStatement ps = conn.prepareStatement(sql);
			 
			 ps.setString(1, b.getBookname());
			 ps.setString(2, b.getAuthor());
			 ps.setString(3, b.getPrice());
			 ps.setString(4, b.getStatus());
			 ps.setInt(5, b.getBookId());
			 
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

	@Override
	public boolean deleteBooks(int id) {
		boolean f = false;
		try {
		  
			String sql = "delete from book_dtls where bookId=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if(i == 1)
			{
				f = true;
			}
			
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return f;
	}
//New Book
	@Override
	public List<BookDtls> getNewBook() {
		List<BookDtls> list = new ArrayList<BookDtls>();
		BookDtls b = null;
		try {
			String sql = "select * from book_dtls  where bookCategory=? and status=? order by bookId DESC";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "New");
			ps.setString(2,"Active");//jo active and new usi ko show kareyenge
		    ResultSet rs = ps.executeQuery();
		    int i = 1;
		    while(rs.next() && i<=4)//samne me hmlog 4 book hi show krwayenge isliye 4 liye hai
		    {
		    	b = new BookDtls();
		    	b.setBookId(rs.getInt(1));
				b.setBookname(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookCategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhotoName(rs.getString(7));
				b.setUser_email(rs.getString(8));
				list.add(b);
				i++;
		    	
		    }
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	//Recent Book
	@Override
	public List<BookDtls> getRecentBook() {
		List<BookDtls> list = new ArrayList<BookDtls>();
		BookDtls b = null;
		
		try {
			String sql = "select * from book_dtls where status=? order by bookId DESC";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1,"Active");//jo active and new usi ko show kareyenge
		    ResultSet rs = ps.executeQuery();
		    int i = 1;
		    while(rs.next() && i<=4)//samne me hmlog 4 book hi show krwayenge isliye 4 liye hai
		    {
		    	b = new BookDtls();
		    	b.setBookId(rs.getInt(1));
				b.setBookname(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookCategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhotoName(rs.getString(7));
				b.setUser_email(rs.getString(8));
				list.add(b);
				i++;
		    	
		    }
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return list;
	}

	
	//OLd Book
	
	@Override
	public List<BookDtls> getOldBook() {
		List<BookDtls> list = new ArrayList<BookDtls>();
		BookDtls b = null;
		
		try {
			String sql = "select * from book_dtls where bookCategory=? and status=? order by bookId DESC";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1,"Old");
			ps.setString(2, "Active");
		    ResultSet rs = ps.executeQuery();
		    int i = 1;
		    while(rs.next() && i<=4)
		    {
		    	b = new BookDtls();
		    	b.setBookId(rs.getInt(1));
				b.setBookname(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookCategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhotoName(rs.getString(7));
				b.setUser_email(rs.getString(8));
				list.add(b);
				i++;
		    	
		    }
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return list;
	}

	
	
	//GetAllBook
	@Override
	public List<BookDtls> getAllRecentBook() {
		// TODO Auto-generated method stub
		
		List<BookDtls> list = new ArrayList<BookDtls>();
		BookDtls b = null;
		
		try {
			String sql = "select * from book_dtls where status=? order by bookId DESC";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1,"Active");//jo active and new usi ko show kareyenge
		    ResultSet rs = ps.executeQuery();
		    while(rs.next())
		    {
		    		    	b = new BookDtls();
		    	b.setBookId(rs.getInt(1));
				b.setBookname(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookCategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhotoName(rs.getString(7));
				b.setUser_email(rs.getString(8));
				list.add(b);
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return list;
		
	}

	@Override
	public List<BookDtls> getAllNewBook() {
		// TODO Auto-generated method stub
		
		List<BookDtls> list = new ArrayList<BookDtls>();
		BookDtls b = null;
		try {
			String sql = "select * from book_dtls  where bookCategory=? and status=? order by bookId DESC";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "New");
			ps.setString(2,"Active");//jo active and new usi ko show kareyenge
		    ResultSet rs = ps.executeQuery();
		    while(rs.next())
		    {
		    	b = new BookDtls();
		    	b.setBookId(rs.getInt(1));
				b.setBookname(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookCategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhotoName(rs.getString(7));
				b.setUser_email(rs.getString(8));
				list.add(b);
		    }
				
		    	
		    
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
		
	}

	@Override
	public List<BookDtls> getAllOldBook() {
		// TODO Auto-generated method stub
		
		List<BookDtls> list = new ArrayList<BookDtls>();
		BookDtls b = null;
		
		try {
			String sql = "select * from book_dtls where bookCategory=? and status=? order by bookId DESC";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1,"Old");
			ps.setString(2, "Active");
		    ResultSet rs = ps.executeQuery();
		    while(rs.next())
		    {
		    	b = new BookDtls();
		    	b.setBookId(rs.getInt(1));
				b.setBookname(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookCategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhotoName(rs.getString(7));
				b.setUser_email(rs.getString(8));
				list.add(b);
		    }
				
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<BookDtls> getBookByOld(String email, String cate) {
		List<BookDtls> list = new ArrayList<>();
		BookDtls b = null;
		try {
			String sql = "Select * from book_dtls where bookCategory=? and user_email=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,cate);
			ps.setString(2, email);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
			    b = new BookDtls();
			    b.setBookId(rs.getInt(1));
				b.setBookname(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookCategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhotoName(rs.getString(7));
				b.setUser_email(rs.getString(8));
				list.add(b);
				
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}

	@Override
	public boolean oldBookDelete(String email, String cate, int id) {
		boolean f = false;
		try {
			String sql = "delete from book_dtls where bookCategory=? and user_email=? and bookId=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,cate);
			ps.setString(2, email);
			ps.setInt(3, id);
			int i = ps.executeUpdate();
			if(i == 1)
			{
				f = true;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	@Override
	public List<BookDtls> getBookBySearch(String ch) {
		List<BookDtls> list = new ArrayList<>();
		BookDtls b = null;
		try {
			String sql = "Select * from book_dtls where (bookname like ? or author like ? or bookCategory like ?) and status=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+ch+"%");
			ps.setString(2, "%"+ch+"%");
			ps.setString(3, "%"+ch+"%");
			ps.setString(4, "Active");
			
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
			    b = new BookDtls();
			    b.setBookId(rs.getInt(1));
				b.setBookname(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookCategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhotoName(rs.getString(7));
				b.setUser_email(rs.getString(8));
				list.add(b);
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	

	
	
	
	
	

}
