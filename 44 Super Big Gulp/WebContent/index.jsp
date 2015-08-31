<!DOCTYPE html>
<html lang="en">
<head>
<title>GradeInput</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
<h2>Enter Grades</h2>
<form role="form" action="Gradebook" method = "post" >
<div class="form-group">
<label for="a1">Assignment:</label>
<input type="text" class="form-control" id="a1" name="a1" placeholder="Enter assignment">
</div>
<div class="form-group">
<label for="g1">Grade:</label>
<input type="number" class="form-control" id="g1" name="g1" placeholder="Enter grade">
</div> 
<input type = "submit" value = "Gradebook"/>
</form>
</div>

</body>
</html>