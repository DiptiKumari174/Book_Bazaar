<%@page import="com.entity.BookDtls"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.DAO.BookDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<%@include file="all_component/allCss.jsp" %>
</head>
<body style="background-color:#f0f1f2;">
<%@include file="all_component/navbar.jsp" %>

 <%
   int bid = Integer.parseInt(request.getParameter("bid"));
   BookDAOImpl dao = new BookDAOImpl(DBConnect.getConn());
   BookDtls b = dao.getBookById(bid);
 %>
<div class="container p-3">
    <div class="row">
    <!-- 2 grid ka hai isliye 2 div and left side book ka details and right side me continue shopping  -->
        <div class="col-md-6 text-center p5 border bg-white">
        <img src="book/<%=b.getPhotoName() %>" style="height : 150px; width:150px"><br>
        <!-- static  -->
        
        <h4 class="mt-2">Book Name :<span class="text-success"><%=b.getBookname() %></span></h4>
        <h4>Author Name :<span class="text-success"><%=b.getAuthor() %></span></h4>
        <h4>Category : <span class="text-success"><%=b.getBookCategory() %></span></h4>
        </div>
        
        <div class="col-md-6 text-center p-5 border bg-white">
        <h2><%=b.getBookname() %></h2>
        
        <!-- old book rahega to add cart ka option nhi rahega i.e if category = "status" then -->
        
        <%
           if("Old".equals(b.getBookCategory())) {    
         %>
	        <h5 class="text-primary">Contact to Seller</h5>
	        <h5 class="text-primary"><i class="fa-regular fa-envelope"></i>Email : 
	        <%= b.getUser_email() %></h5>
        <%
        }
     %>
        <div class="row ">
            <div class="col-md-4 text-danger text-center p-2">
               <i class="fa-solid fa-money-bill fa-2x"></i>
               <p>Cash on Delivery</p>
            </div>
	        <div class="col-md-4 text-danger text-center p-2">
	          <i class="fa-solid fa-rotate-left fa-2x"></i>
	           <p>10 Days Return Policy</p>
	        </div>
	        <div class="col-md-4 text-danger text-center p-2">
	          <i class="fa-solid fa-truck fa-2x"></i>
	          <p>Free Delivery</p>
	        </div>
        </div>
        
        <%
           if("Old".equals(b.getBookCategory())) {    
         %>
         <div class="text-center p-3">
          <a href="index.jsp" class="btn btn-success"><i class="fa-solid fa-cart-plus"></i>Continue Shopping</a>
          <a href="" class="btn btn-danger"><i class="fa-solid fa-indian-rupee-sign"></i>200</a>
        </div>
        <%}
        else{
        %>
        <div class="text-center p-3">
          <a href="" class="btn btn-primary"><i class="fa-solid fa-cart-plus"></i>Add Cart</a>
          <a href="" class="btn btn-danger"><i class="fa-solid fa-indian-rupee-sign"></i>200</a>
        </div>
        <%
        }%>
         
         
         
        
        </div>
    </div>
</div>
</body>
</html>