<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CRS Login</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style>
body{
background-image: url(https://media.wired.com/photos/5b86fce8900cb57bbfd1e7ee/master/pass/Jaguar_I-PACE_S_Indus-Silver_065.jpg);
background-repeat: no-repeat;
background-size: cover;
background-color: #cccccc;
}
</style>
</head>
<body>
<div class="container">
        <div class="row justify-content-center align-items-center" style="height:100vh">
            <div class="col-6">
                <div class="card">
                    <div class="card-body">
                    <h2>Welcome to CRS Car Rental</h2>
                        <form action="/Project1/customer/login" method="post">
                            <div class="form-group">
                                <input type="text" class="form-control" name="uname" placeholder="username" required>
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control" name="pass" placeholder="password" required>
                            </div>
                            <div style="font-style: italic; color: red;">${errmsg}</div>
                            <button type="submit" id="sendlogin" class="btn btn-primary">login</button>
                        </form>
                        <br>
                        <form action="/Project1/customer/register">
                           <button type="submit" id="sendregister" class="btn btn-primary" onclick="">Register</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>