<%@page import="com.entity.BookDtls"%>
<%@page import="java.util.List"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.DAO.BookDAOImpl"%>
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
      <div class = "row p-3">
          <%
           BookDAOImpl dao3 = new BookDAOImpl(DBConnect.getConn());
           List<BookDtls> list3 = dao3.getAllOldBook();
           for(BookDtls b :list3){
           %>
           <div class="col-md-3">
               <div class="card crd-ho">
	               <div class="card-body text-center">
		               <img alt="" src="book/<%= b.getPhotoName() %>" style="width:150px; height: 200px"
		                   class="img-thumblin">
		               <p><%=b.getBookname() %></p><!-- data get from database -->
		               <p><%=b.getAuthor() %></p>
		               <p>Category : <%=b.getBookCategory()%></p>
		               <div class="row">
		                 
		                  <a href="view_book.jsp?bid=<%=b.getBookId() %>" class="btn btn-success btn-sm ml-5">view Details</a>
		                  <a href="" class="btn btn-danger btn-sm ml-1"><i class="fa-solid fa-indian-rupee-sign"><%=b.getPrice()%></i></a>
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