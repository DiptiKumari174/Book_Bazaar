package com.DAO;

import com.entity.User;

public interface UserDAO {
     public boolean UserRegister(User us);
     //to check that the email id and password is already in my database or not
     public User login(String email,String password);
     public boolean checkPassword(int id, String pswd);
     //database me update hone ke liye
     public boolean updateProfile(User u);
     //Checking for existing a unique email id
     public boolean checkUser(String em);
     
}
