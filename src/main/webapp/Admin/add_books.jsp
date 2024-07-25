<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin: Add books</title>
<%@include file="AdminallCss.jsp" %>
</head>
<body style="background-color:#f0f2f2;">
  <%@include file="Adminnavbar.jsp" %>
  <c:if test="${empty userobj }">
   <c:redirect url="../login.jsp"/>
</c:if>
  <div class="container">
      <div class="row">
           <div class="col-md-4 offset-md-4">
               <div class="card">
	                   <div class="card-body">
	                       <h4 class="text-center">Add Books</h4>
	                       <c:if test="${not empty succMsg }">
	                           <p class="text-center text-success">${succMsg }</p>
	                           <c:remove var="succMsg" scope="session"/>
	                       </c:if>
	                       <c:if test="${not empty failedMsg }">
	                           <p class="text-center text-success text-danger">${failedMsg }</p>
	                           <c:remove var="failedMsg" scope="session"/>
	                       </c:if>
	                       
	                   
	                       <form action="../add_books" method="post" enctype="multipart/form-data">
	                           <div class="form-group">
								    <label for="exampleInputEmail1">Book Name<span style="color: red;">*</span></label>
								    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"  name="bname" >
								</div>
								  <div class="form-group">
								    <label for="exampleInputEmail1">Author Name<span style="color: red;">*</span></label>
								    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"  name="author">
								    
								  </div>
								  <div class="form-group">
								    <label for="exampleInputEmail1">Price<span style="color: red;">*</span></label>
								    <input type="number" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" required="required" name="price">
								    
								  </div>
								  <div class="form-group">
								    <label for="inputState">Book Categories</label>
								    <select id="inputState" name="btype" class="form-control">
										    <option selected>----select---</option>
										    <option value="New">New Book</option>
										    <option value="Old">Old Book</option>
								    </select>
								  </div>
								  <div class="form-group">
								    <label for="inputState">Book Status</label>
								    <select class="form-control" id="inputState"  name="bstatus">
								           <option selected>-----select-----</option>
								           <option value="Active">Active</option>
								           <option value="Inactive">Inactive</option>
								    
								    </select>
								  </div>
								  
								  
								  <div class="form-group">
								    
								    <label for="exampleFormControlFile1">Upload Photo</label><input name="bimg" type="file" class="form-control-file" id="exampleForControlFile1">
								  </div>
								  
								  <button type="submit" class="btn btn-primary">Add</button>
						
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