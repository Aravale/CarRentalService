<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CRS Register</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
$(document).ready(function(){   
   $('#navdiv').load("/Project1/employee/employeepanel");
});
</script>
<style>
body{
background-image: url(http://s1.1zoom.me/big3/823/Land_Rover_Coast_2016_444039.jpg);
 background-repeat: no-repeat;
background-size: cover;
background-color: #cccccc;
}
</style>
</head>
<body>
<div id="navdiv"></div>
<br><br>

<div class="container">
        <div class="row justify-content-center align-items-center" style="height:100vh">
            <div class="col-6">
                <div class="card">
                    <div class="card-body">
                    <h2>CRS Employee Update ${id}</h2>
                        <form action="/Project1/employee/UpdateEmployee" method="post">
                        <div class="form-group">
                                <input type="hidden" class="form-control" name="id" placeholder="id" value="${employee.id}" required >
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" name="username" placeholder="username" value="${employee.username}" required>
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control" name="password" placeholder="password"  value="${employee.password}" required>
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" name="name" placeholder="Full Name" value="${employee.name}" required>
                            </div>
                            <div class="form-group">
                                <input type="tel" class="form-control" name="contact" pattern="[0-9]{4}-[0-9]{7}" placeholder="Contact:03xx-xxxxxxx" value="${employee.contact}" required>
                            </div>
                            <div class="form-group">
                                <input type="textarea" class="form-control" name="address" placeholder="Address" value="${employee.address}" required>
                            </div>
                            <button type="submit" id="sendregister" class="btn btn-primary">Update</button>
                        </form>
                        <br>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
