package com.DAO;

import java.util.List;

import com.entity.Add_to_cart;


public interface CartDAO {
    public boolean addCart(Add_to_cart c); 
    
    public List<Add_to_cart> getBookByUser(int userId);
    
    public boolean deleteBook(int bid, int uid, int cid);
}
