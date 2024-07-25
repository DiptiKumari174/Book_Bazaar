package com.DAO;

import java.util.List;

import com.entity.Book_Order_Dtls;

public interface BookOrderDAO {
  //public int getOrderNo();
  public boolean saveOrder(List<Book_Order_Dtls> b);
  
  public List<Book_Order_Dtls> getBook(String email);
  public List<Book_Order_Dtls> getAllOrder();
}
