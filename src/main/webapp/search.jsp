<%@page import="com.entity.BookDtls"%>
<%@page import="java.util.List"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.DAO.BookDAOImpl"%>
<%@page import="com.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Recent Books</title>
<%@include file="all_component/allCss.jsp" %>

<style type="text/css">
  .crd-ho:hover{
    background:#e5beed;
  }
</style>

</head>
<body>
  <%@include file="all_component/navbar.jsp" %>
  <div class="container-fluid">
      <div class="row p-3">
          <%
          String ch = request.getParameter("ch");
          User u = (User) session.getAttribute("userobj"); 
          BookDAOImpl dao2 = new BookDAOImpl(DBConnect.getConn());
          List<BookDtls> list2 = dao2.getBookBySearch(ch);
          for(BookDtls b : list2) {
          %>
           
          <div class="col-md-3">
               <div class="card crd-ho mt-3">
	               <div class="card-body text-center">
		               <img alt="" src="book/<%= b.getPhotoName() %>" style="width:150px; height: 200px" class="img-thumbnail">
		               <p><%= b.getBookname() %></p>
		               <p><%= b.getAuthor() %></p>
		               <p>Category: <%= b.getBookCategory() %></p>
		               <div class="row">	
		               <%
		                 if (!b.getBookCategory().equals("Old")) {
		                   if (u == null) {
		               %>
		                    <a href="login.jsp" class="btn btn-danger btn-sm ml-2">Add Cart</a>
                            <% } else { %>
                                <a href="cart?bid=<%= b.getBookId() %>&uid=<%= u.getID() %>" class="btn btn-danger btn-sm ml-2">Add Cart</a>
                            <% }
		                 } %>
						     <a href="view_book.jsp?bid=<%= b.getBookId() %>" class="btn btn-success btn-sm">View Details</a>
						     <a href="" class="btn btn-danger btn-sm"><i class="fa-solid fa-indian-rupee-sign"></i><%= b.getPrice() %></a>
		                   </div>
		             </div>
	           </div>    
           </div>
         
        <% 
           }
         %>
              
      </div>
  </div>

</body>
</html>
