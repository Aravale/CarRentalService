<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CRS</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style>
@import url(http://fonts.googleapis.com/css?family=Raleway);

.nav-item {
    font-family: Century Gothic;
    margin: 0 auto;
    
    text-align: center;
}
.nav-item a {
    color: 	#000000;
    text-decoration: none;
    font: 20px Century Gothic;
    margin: 0px 10px;
    padding: 10px 10px;
    position: relative;
    z-index: 0;
}

/* Top & Bottom Borders Out */
.topBotomBordersOut a:before, .topBotomBordersOut a:after {
    position: absolute;
    left: 0px;
    width: 100%;
    height: 2px;
    background: #000000;
    content:"";
    opacity: 0;
    -webkit-transition: all 0.3s;
    transition: all 0.3s;
}
.topBotomBordersOut a:before {
    top: 0px;
    transform: translateY(10px);
}
.topBotomBordersOut a:after {
    bottom: 0px;
    transform: translateY(-10px);
}
.topBotomBordersOut a:hover:before, .topBotomBordersOut a:hover:after {
    opacity: 1;
    transform: translateY(0px);
}
</style>
</head>
<body>
   <nav class="menum navbar navbar-light navbar-expand-md justify-content-center fixed-top">
     <div class="container">
     <div class="navbar-collapse collapse justify-content-between align-items-center w-100" id="collapsingNavbar2">
       <ul class="topBotomBordersOut navbar-nav mx-auto text-center">
         <li class="nav-item"><a class="nav-link" href="/Project1/customer/customerhome">Home</a></li>
         <li class="nav-item"><a class="nav-link" href="/Project1/booking/ViewBookings?id=<%= session.getAttribute("customerid") %>">Booking</a></li>
         <li class="nav-item"> <a class="nav-link" href="/Project1/customer/editCustomer?id=<%= session.getAttribute("customerid") %>">Profile</a> 
         <li class="nav-item"> <a class="nav-link" href="/Project1/customer/feedbackform">Feedback</a> 
         <li class="nav-item"> <a class="nav-link" href="/Project1/customer/logout">Logout</a>  
         </li>
       </ul>
     </div>
     </div>   
   </nav>  
</body>
</html>