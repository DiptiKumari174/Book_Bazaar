<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Success</title>
<%@include file="all_component/allCss.jsp" %>
</head>
<body style="background-color:#f0f1f2;">
  <%@include file="all_component/navbar.jsp" %>
  <div class="container text-center mt-3">
       <i class="fas fa-check-circle fa-5x text-success"></i>
       <h1>Thank You</h1>
       <h2>Your Order Successfully</h2>
       <h5>Your ordered will be placed within 7 days.</h5>
       <a href="index.jsp" class="btn btn-primary mt-3">Home</a>
       <a href="my_order.jsp" class="btn btn-danger mt-3">view order</a>
  
  </div>

</body>
</html>