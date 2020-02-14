<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
$(document).ready(function(){   
   $('#navdiv').load("/Project1/employee/employeepanel");
});
</script>
<style>
.custab{
    border: 1px solid #ccc;
    padding: 5px;
    margin: 5% 0;
    box-shadow: 3px 3px 2px #ccc;
    transition: 0.5s;
    }
.custab:hover{
    box-shadow: 3px 3px 0px transparent;
    transition: 0.5s;
    }
</style>
</head>
<body>
<div id="navdiv"></div>
<br><br>
    <div class="container">
    <div class="row col-md-6 col-md-offset-2 custyle">
    <table class="table table-striped custab">
    <thead>
        <tr>
            <th>Manufacturer</th>
            <th>Make</th>
            <th>Model</th>
            <th>Status</th>
            <th>Rent/Day</th>
            <th class="text-center">Action</th>
        </tr>
    </thead>
            <c:forEach var="vehicle" items="${vc}">
                <tr>
 
                    <td>${vehicle.manufacturer}</td>
                    <td>${vehicle.make}</td>
                    <td>${vehicle.model}</td>
                    <td>${vehicle.status}</td>
                    <td>${vehicle.perdayrent}</td>
                <td class="text-center">
                <a class='btn btn-info btn-xs' href="/Project1/vehicle/editVehicle?id=${vehicle.id}">
                <span class="glyphicon glyphicon-edit"></span>Edit</a> 
                <a href="/Project1/vehicle/deleteVehicle?id=${vehicle.id}" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span> Del</a>
                </td>
                </tr>
            </c:forEach>
    </table>
    </div>
</div>
</body>
</html>