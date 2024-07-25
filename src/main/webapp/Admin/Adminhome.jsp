<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin:Home</title>
<%@include file="AdminallCss.jsp" %>
<style type="text/css">
  a{
    text-decoration:none;
    color: black;
  }
  a:hover{
    text-decoration: none;
    color: black;
  }
</style>
</head>
<body>
<%@include file="Adminnavbar.jsp" %>
<c:if test="${empty userobj }">
   <c:redirect url="../login.jsp"/>
</c:if>
   <div class="container">
       <div class="row p-5">
           <div class="col-md-3">
               <a href="add_books.jsp">
	               <div class="card">
	                   <div class="card-body text-center">
	                      <i class="fa-solid fa-circle-plus fa-3x text-primary"></i><br>
	                      <h4>Add Books</h4>
	                      -----------------
	                   </div>
	               </div>
	            </a>   
           </div>
           
           <div class="col-md-3">
               <a href="all_books.jsp">
	               <div class="card">
	                   <div class="card-body text-center">
	                      <i class="fa-solid fa-book-open fa-3x" style="color: #B197FC;"></i><br>
	                      <h4>All Books</h4>
	                      -----------------
	                   </div>
	               </div>
	            </a>   
           </div>
           
           
           <div class="col-md-3">
             <a href="orders.jsp">
	               <div class="card">
	                   <div class="card-body text-center">
	                      <i class="fa-solid fa-box fa-3x" style="color: #74C0FC;"></i><br>
	                      <h4>Orders</h4>
	                      -----------------
	                   </div>
	               </div>
	           </a>    
           </div>
           
           
           <div class="col-md-3">
             <a href=""data-toggle="modal" data-target="#exampleModalCenter">
	               <div class="card">
	                   <div class="card-body text-center">
	                      <i class="fa-solid fa-right-from-bracket fa-3x text-primary"></i><br>
	                      <h4>Logout</h4>
	                      -----------------
	                   </div>
	               </div>
	            </a>   
           </div>
       </div>
   </div>
   
   
   <!-- Logout modal -->

<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle"></h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <div class="text-center">
            <h4>Do you want logout?</h4>
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
	        <a href="../logout" type="button" class="btn btn-primary">Logout</a>
        
        </div>
      
      </div>
      <div class="modal-footer">
        </div>
    </div>
  </div>
</div>
<!-- End logout modal -->
   
 <div style="margin-top:130px;">  
   <%@include file="Adminfooter.jsp" %>
   </div>
</body>
</html>