<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Setting page</title>
<%@include file="all_component/allCss.jsp" %>
<style type="text/css">
a{
text-decoration: none;
color: black;
}
a:hover{
text-decoration: none;
}

</style>
</head>
<body style="background-color:#f0f1f2;">
<c:if test="${empty userobj }">
  <c:redirect url="login.jsp"/>
</c:if>
    <%@include file="all_component/navbar.jsp" %>
    <div class="container">
    
      <h3 class="text-center">Hello, ${userobj.name} </h3>
    
   <!-- User u = (User)session.getAttribute("userobj");-->
     
      <div class="row p-5">
        <div class="col-md-4">
          <a href="sell_book.jsp">
            <div class="card">
             <div class="card-body text-center">
             <div class="text-primary">
             <i class="fas fa-book-open fa-3x"></i>
             </div>
             <h3>Sell Old Book</h3>
            </div>
          </div>
         </a>
        </div>
        
        <div class="col-md-4">
          <a href="old_book.jsp">
            <div class="card">
             <div class="card-body text-center">
             <div class="text-primary">
             <i class="fas fa-book-open fa-3x"></i>
             </div>
             <h3>Old Book</h3>
            </div>
          </div>
         </a>
        </div>
        
        <div class="col-md-4">
          <a href="edit_profile.jsp">
            <div class="card">
             <div class="card-body text-center">
             <div class="text-primary">
             <i class="fas fa-edit fa-3x"></i>
             </div>
             <h4>Edit Profile</h4>
            </div>
          </div>
         </a>
        </div>
        
        <div class="col-md-6 mt-3">
          <a href="my_order.jsp">
            <div class="card">
             <div class="card-body text-center">
             <div class="text-danger">
             <i class="fa-solid fa-basket-shopping fa-3x"></i>
             </div>
             <h4>My Order</h4>
             <h6>Track your Order</h6>
            </div>
          </div>
         </a>
        </div>
        
        
        <div class="col-md-6 mt-3">
          <a href="help_center.jsp">
            <div class="card">
              <div class="card-body text-center">
                <div class="text-primary">
                  <i class="fa-solid fa-question fa-3x"></i>
                </div>
                <h4>Help Center</h4>
                <h6>24x7</h6>
             </div>
            </div>
          </a>
        </div>
        
      </div>
     </div>
  <%@include file="all_component/footer.jsp"%>
</body>
</html>