<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CRS</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
$(document).ready(function(){   
   $('#navdiv').load("/Project1/employee/employeepanel");
});
</script>
</head>
<body>
<div id="navdiv"></div>
<br><br>
<div class="container">
    <div class="row col-md-6 col-md-offset-2 custyle">
    <table class="table table-striped custab">
    <thead><tr><th>Customer Bookings</th></tr></thead>
    <thead>
        <tr>
        	<th>Customer</th>
            <th>Vehicle</th>
            <th>Days</th>
            <th>Total Rent</th>
            <th class="text-center">Action</th>
        </tr>
    </thead>
            <c:forEach var="booking" items="${bookings}">
                <tr>
 					<td>${booking.customer.name}</td>
                    <td>${booking.vehicle.color} ${booking.vehicle.manufacturer} ${booking.vehicle.make} ${booking.vehicle.model}</td>
                    <td>${booking.days}</td>
                    <td>${booking.totalrent}</td> 
                <td class="text-center">
                <a class='btn btn-info btn-xs' href="/Project1/booking/cancelBooking?bookid=${booking.id}}&&vehicleid=${booking.vehicle.id}">
                <span class="glyphicon glyphicon-edit"></span>Cancel Booking</a> 
                </td>
                </tr>
            </c:forEach>
    </table>
    </div>
    </div>
</body>
</html>