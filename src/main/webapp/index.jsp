<%@page import="com.entity.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.DB.*" %>
<%@page import="java.sql.*" %>


<%@ page import="java.util.List" %>
<%@ page import="com.DAO.BookDAO" %>
<%@ page import="com.DAO.BookDAOImpl" %>
<%@ page import="com.DB.DBConnect" %>
<%@ page import="com.entity.BookDtls" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ebook: Index</title>
<%@include file="all_component/allCss.jsp" %>

<style type="text/css">
  .back-img{
  background: url("img/book.jpg");
  height: 60vh;
  width:100%;
  background-repeat:no-repeat;
  background-size:cover;
  }
  .crd-ho:hover{
    background:#e5beed;
  }
</style>
</head>


<body style="background-color:#bee6e1">
<!-- Add cart krne ke liye login hona jaruri hai agr add cart pe click karega or wah login nhi  hai to redirect login page pe hona chahiye   -->
<%
User u = (User)session.getAttribute("userobj"); 
%>
   <%@include file="all_component/navbar.jsp" %>
   
<div class="container-fluid back-img">
     <h2 class="text-center text-white">EBook Management System</h2>
</div>
   
   <% 
    
    Connection conn = DBConnect.getConn();
  //   if (conn != null) {
    //    out.println("Connection established successfully.");
      //  out.println(conn);
        // Use the connection object here
    //} else {
      //  out.println("Failed to establish connection.");
    //}
    
%>
   
   
   <!-- Start recent book -->
<div class="container">
    <h3 class="text-center">Recent Book</h3>
    <div class="row">
        <%
            BookDAOImpl dao2 = new BookDAOImpl(DBConnect.getConn());
            List<BookDtls> list2 = dao2.getRecentBook();
            for (BookDtls b : list2) {
        %>
        <div class="col-md-3">
            <div class="card crd-ho">
                <div class="card-body text-center">
                    <img alt="" src="book/<%= b.getPhotoName() %>" style="width:150px; height: 200px" class="img-thumbnail">
                    <p><%= b.getBookname() %></p>
                    <p><%= b.getAuthor() %></p>
                    <p>Category: <%= b.getBookCategory() %></p>
                    <div class="row">
                        <% if (b.getBookCategory().equals("Old")) { %>
                            <a href="view_book.jsp?bid=<%= b.getBookId() %>" class="btn btn-success btn-sm">View Details</a>
                            <a href="" class="btn btn-danger btn-sm"><%= b.getPrice() %><i class="fa-solid fa-indian-rupee-sign"></i></a>
                        <% } else { %>
                            <% if (u == null) { %>
                                <a href="login.jsp" class="btn btn-danger btn-sm ml-2">Add Cart</a>
                            <% } else { %>
                                <a href="cart?bid=<%= b.getBookId() %>&uid=<%= u.getID() %>" class="btn btn-danger btn-sm ml-2">Add Cart</a>
                            <% } %>
                            <a href="view_book.jsp?bid=<%= b.getBookId() %>" class="btn btn-success btn-sm">View Details</a>
                            <a href="" class="btn btn-danger btn-sm"><%= b.getPrice() %><i class="fa-solid fa-indian-rupee-sign"></i></a>
                        <% } %>
                    </div>
                </div>
            </div>
        </div>
        <% } %>
    </div>
    <div class="text-center mt-1">
        <a href="all_recent_book.jsp" class="btn btn-danger btn-sm text-white">View All</a>
    </div>
</div>


<!-- End recent book -->


<hr>


<!-- Start new book -->
   <div class="container" >
       <h3 class="text-center">New Book</h3>
       <div class="row">
           
           <!-- yaha use krne se data column wise show kr rha hai isliye is code ko for loop me likheyenge <div class="col-md-3"> -->
           <!-- ek hi div ko baar baar use karenge isliye loop ka use karenge -->
           <%
           BookDAOImpl dao = new BookDAOImpl(DBConnect.getConn());
           List<BookDtls> list = dao.getNewBook();
           for(BookDtls b :list){
           %>
           <div class="col-md-3">
               <div class="card crd-ho">
	               <div class="card-body text-center">
		               <img alt="" src="book/<%= b.getPhotoName() %>" style="width:150px; height: 200px"
		                   class="img-thumblin">
		               <p><%=b.getBookname() %></p><!-- data get from database -->
		               <p><%=b.getAuthor() %></p>
		               <p>Category: <%=b.getBookCategory()%></p>
		               <div class="row">
		               
		                <% if(u==null)
		                	{%>
		                	<a href="login.jsp" class="btn btn-danger btn-sm ml-2">Add Cart</a>
		                	<%}else{
		                	%>
		                	<a href="cart?bid=<%=b.getBookId() %>&&uid=<%=u.getID() %>" class="btn btn-danger btn-sm ml-2">Add Cart</a>
		                <%}
		                %>
		                  
		                  <a href="view_book.jsp?bid=<%=b.getBookId() %> " class="btn btn-success btn-sm ml-1">view Details</a>
		                  <a href="" class="btn btn-danger btn-sm ml-1"><i class="fa-solid fa-indian-rupee-sign"><%=b.getPrice()%></i></a>
		               </div>
	               </div>
	           </div>  
        	</div>   
           <% 
           }
           %>  
           
           <!-- Yaha 3 div or but usko hmlog delete kr diye kyuki usko loop me likha gya hai -->   
          
          
           
    </div>
    <div class="text-center mt-1">
    <a href="all_new_book.jsp" class="btn btn-danger btn-sm text-white">View All</a>
    </div>
</div>

<hr>
<!-- End new book -->


<!-- Start OLd book -->
   <div class="container" >
       <h3 class="text-center">Old Book</h3>
       <div class="row">
           <%
           BookDAOImpl dao3 = new BookDAOImpl(DBConnect.getConn());
           List<BookDtls> list3 = dao3.getOldBook();
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
    <div class="text-center mt-1">
    <a href="all_old_book.jsp" class="btn btn-danger btn-sm text-white">View All</a>
    </div>
</div>


<!-- End old book -->
<!-- footer -->
<%@include file="all_component/footer.jsp" %>

</body>
</html>