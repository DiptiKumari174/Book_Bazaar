<%@page import="com.entity.Book_Order_Dtls"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.DAO.BookOrderDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin: All Orderes</title>
<%@include file="AdminallCss.jsp" %>
</head>
<body>
   <%@include file="Adminnavbar.jsp" %>
   <c:if test="${empty userobj }">
   <c:redirect url="../login.jsp"/>
</c:if>
   <h3 class="text-center">Hello Admin</h3>
   <table class="table table-striped">
  <thead class="bg-primary text-white">
    <tr>
      <th scope="col">Order Id</th>
      <th scope="col">Name</th>
      <th scope="col">Email</th>
      <th scope="col">Address</th>
      <th scope="col">Phone no.</th>
      <th scope="col">Book Name</th>
      <th scope="col">Author</th>
      <th scope="col">Price</th>
      <th scope="col">Payment type</th>
    </tr>
  </thead>
  <tbody>
  <%
  BookOrderDAOImpl dao = new BookOrderDAOImpl(DBConnect.getConn());
  List<Book_Order_Dtls> blist = dao.getAllOrder();
  for(Book_Order_Dtls b:blist)
  {%>
  <tr>
	  <th scope="row"><%=b.getOrderId() %></th>
      <td><%=b.getUserName() %></td>
      <td><%=b.getEmail() %></td>
      <td><%=b.getFulladd() %></td>
      <td><%=b.getPhno() %></td>
      <td><%=b.getBookName() %></td>
      <td><%=b.getAuthor() %></td>
      <td><%=b.getPrice() %></td>
      <td><%=b.getPaymentType() %></td>
     </tr>
  <%}
  %>
  
    <tr>
    
   
  </tbody>
</table>
<div style="margin-top:130px;">  
   <%@include file="Adminfooter.jsp" %>
   </div>
</body>
</html>