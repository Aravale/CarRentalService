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
<div class="container">
        <div class="row justify-content-center align-items-center" style="height:100vh">
            <div class="col-6">
                <div class="card">
                    <div class="card-body">
                    <h2>CRS Vehicle Update ${id}</h2>
                        <form action="/Project1/vehicle/UpdateVehicle" method="post">
                        <div class="form-group">
                                <input type="hidden" class="form-control" name="id" placeholder="id" value="${vehicle.id}" required >
                            </div>
                            <div class="form-group">
                                <input type="hidden" class="form-control" name="vcategory" placeholder="catid" value="${vehiclecategory.id}" required >
                            </div>
                            <div class="form-group">
                                <input type="hidden" class="form-control" name="status" placeholder="status" value="${vehicle.status}" required >
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" name="manufacturer" placeholder="manufacturer" value="${vehicle.manufacturer}" required>
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" name="make" placeholder="make"  value="${vehicle.make}" required>
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" name="model" placeholder="model" value="${vehicle.model}" required>
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" name="color" placeholder="color" value="${vehicle.color}" required>
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" name="perdayrent" placeholder="perdayrent" value="${vehicle.perdayrent}" required>
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
