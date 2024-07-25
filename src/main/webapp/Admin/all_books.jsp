<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.DAO.BookDAOImpl" %>
    <%@ page import="com.entity.BookDtls" %>
    <%@ page import="java.util.List" %>
    <%@ page import="com.DB.DBConnect" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin: all books</title>
<%@include file="AdminallCss.jsp" %>
</head>
<body>
   <%@include file="Adminnavbar.jsp" %>
   <c:if test="${empty userobj }">
   <c:redirect url="../login.jsp"/>
</c:if>
   <h3 class="text-center">Hello Admin</h3>
   
   <c:if test="${not empty succMsg }">
       <h5 class="text-center text-success">${succMsg }</h5>
       <c:remove var="succMsg" scope="session"/>
   </c:if>
   <c:if test="${not empty failedMsg }">
       <h5 class="text-center text-success text-danger">${failedMsg }</h5>
       <c:remove var="failedMsg" scope="session"/>
   </c:if>
   <table class="table table-striped">
  <thead class="bg-primary text-white">
    <tr>
    
      <th scope="col">ID</th>
      <th scope="col">Image</th>
      <th scope="col">Book Name</th>
      <th scope="col">Author</th>
      <th scope="col">Price</th>
      <th scope="col">Categories</th>
      <th scope="col">Status</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  
  <%
  BookDAOImpl dao = new BookDAOImpl(DBConnect.getConn());
  List<BookDtls> list = dao.getAllBooks();
  for(BookDtls b:list)
  {
  %>
     <tr>

      <td><%= b.getBookId() %></td>
      <td><img src="../book/<%= b.getPhotoName() %>" style="width: 50px; height: 50px;"></td>
      <td><%= b.getBookname() %></td>
      <td><%= b.getAuthor() %></td>
      <td><%= b.getPrice() %></td>
      <td><%= b.getBookCategory() %></td>
      
      <td><%= b.getStatus() %></td>
      
      
      
      <td>
         <a href="edit_books.jsp?id=<%=b.getBookId()%>" class="btn btn-sm btn-primary"><i class="fa-solid fa-pen-to-square"></i>Edit</a>
         <a href="../delete?id=<%=b.getBookId() %>" class="btn btn-danger"><i class="fa-solid fa-trash-can"></i>Delete</a>
       </td>  
    </tr>
  
  <%
  }
  %>
    
   
  </tbody>
</table>

<div style="margin-top:130px;">  
   <%@include file="Adminfooter.jsp" %>
   </div>
</body>
</html>