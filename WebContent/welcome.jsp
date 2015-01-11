<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Martha</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-responsive.min.css" rel="stylesheet">
<script src="http://code.jquery.com/jquery-1.10.2.js" type="text/javascript"></script>
</head>
<body>
	<div class="container-fluid">
		<center>
			<h1>Martha Grammer Rules Definer Framework</h1>
		</center>
		<form role="form">
			<div class="row">
				<div class="col-sm-4" style="background-color: lavender;">
					<h4>වාක්‍යය ගනය</h4>
				</div>
				<div class="col-sm-8" style="background-color: lavenderblush;">
					<select class="form-control" id="sentence" name="sentence">
						<option>කතෘ කාරක</option>
						<option>කර්ම කාරක</option> 
					</select> 
				</div>
			</div>
			<div class="row">
				<div class="col-sm-4" style="background-color: lavender;">
					<h4>උක්තය</h4>
				</div>
				<div class="col-sm-8" style="background-color: lavenderblush;">
					<select class="form-control" id="sel1">
						<option>ඒක වචන</option>
						<option>බහු වචන</option>
					</select>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-4" style="background-color: lavender;">
					<h4>ක්‍රියාව</h4>
				</div>
				<div class="col-sm-8" style="background-color: lavenderblush;">
					<select class="form-control" id="sel1">
						<option>Singular</option>
						<option>Plural</option>
					</select>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-4" style="background-color: lavender;">
					<h4>කර්මය</h4>
				</div>
				<div class="col-sm-8" style="background-color: lavenderblush;">
					<select class="form-control" id="sel1">
						<option>Singular</option>
						<option>Plural</option>
					</select>
				</div>
			</div>
		</form>
	</div>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script type="text/javascript" src='js/bootstrap.min.js'></script>
	<script type="text/javascript" src='js/ajax.js'></script>
	<p id="ajaxGetUserServletResponse"></p>
</body>
</html>