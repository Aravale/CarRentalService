<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
$(document).ready(function(){   
   $('#navdiv').load("/Project1/employee/employeepanel");
});
</script>
</head>
<body>
<div id="navdiv"></div>

<br>
<div class="container">
        <div class="row justify-content-center align-items-center" style="height:100vh">
            <div class="col-6">
                <div class="card">
                    <div class="card-body">
                    <h2>Add Vehicle</h2>
                        <form action="vehicleadd" method="post">
                        <div class="form-group">
                                <input type="text" class="form-control" name="manufacturer" placeholder="manufacturer" required >
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" name="make" placeholder="make" required>
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" name="model" placeholder="model" required>
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control" name="color" placeholder="color" required>
                            </div>
                            <div class="form-group">
                                <input type="number" class="form-control" name="perdayrent" placeholder="perdayrent" required>
                            </div>
                            <div class="form-group">
                                    <select id = "vcategory" name = "vcategory" required>
   <option value = "Sedan">Sedan</option>
   <option value = "SUV">SUV</option>
   <option value = "Bike">Bike</option>
</select><br>
                            </div>
                            <button type="submit" id="vehicleadd" class="btn btn-primary">Add</button>
                        </form>
                        <br>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>