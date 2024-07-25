<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="com.DAO.BookDAOImpl" %>
    <%@ page import="com.entity.BookDtls" %>
    <%@ page import="com.DB.DBConnect" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin: Add books</title>
<%@include file="AdminallCss.jsp" %>
</head>
<body style="background-color:#f0f2f2;">
  <%@include file="Adminnavbar.jsp" %>
  <div class="container">
      <div class="row">
           <div class="col-md-4 offset-md-4">
               <div class="card">
	                   <div class="card-body">
	                       <h4 class="text-center">Edit Books</h4>
	                       
	                       <%
	                       int id = Integer.parseInt(request.getParameter("id"));
	                       BookDAOImpl dao = new BookDAOImpl(DBConnect.getConn());
	                       BookDtls b = dao.getBookById(id);
	                       %>
	                   
	                       <form action="../EditBooks" method="post" >
	                       
	                       <!-- hidden concept used -->
	                       
	                       <input type="hidden" name="id" value="<%=b.getBookId()%>">
	                           <div class="form-group">
								    <label for="exampleInputEmail1">Book Name*</label>
								    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"  name="bname" value="<%=b.getBookname()%>">
								</div>
								  <div class="form-group">
								    <label for="exampleInputEmail1">Author Name*</label>
								    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"  name="author" value="<%=b.getAuthor()%>">
								    
								  </div>
								  <div class="form-group">
								    <label for="exampleInputEmail1">Price*</label>
								    <input type="number" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required="required" name="price" value="<%=b.getPrice()%>">
								    
								  </div>
								  
								  <div class="form-group">
								    <label for="inputState">Book Status</label>
								    <select class="form-control" id="inputState"  name="bstatus">
								           <% 
								           if("Active".equals(b.getStatus())){
								        	   %>
								        	   <option value="Active">Active</option>
								        	   <option value="Inactive">Inactive</option>
								        	  <%  
								        	  }
								           else{
								        	   %>
								        	   <option value="Inactive">Inactive</option>
								        	   <option value="Active">Active</option>
								        	   <%
								        	   }
								        	   %>
								        	   
								        	  
								   </select>
								 </div>
								  
								  
								 
								  
								  <button type="submit" class="btn btn-primary">Update</button>
						
	                      </form>
	                   </div>
	            </div>       
           
           </div>
      </div>     
  </div>
  <div style="margin-top:130px;">  
   <%@include file="Adminfooter.jsp" %>
   </div>
</body>
</html>