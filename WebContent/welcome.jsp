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
<script src="http://code.jquery.com/jquery-1.10.2.js"
	type="text/javascript"></script>
</head>
<body>
	<div class="container-fluid">
		<center>
			<h1>මාතා සිංහල ව්‍යාකරණ සම්පාදකය</h1>
		</center>
		<form role="form">
			<div class="row">
				<div class="col-sm-4">
					<h4>වාක්‍යය ගනය</h4>
				</div>
				<div class="col-sm-4">
					<select class="form-control" id="sentence" name="sentence">
						<option id="Active">කතෘ කාරක</option>
						<option id="Passive">කර්ම කාරක</option>
					</select>
				</div>
				<div class="col-sm-4">
					<div class="form-group">
						<input type="text" class="form-control" id="sentenceNew">
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-4">
					<h4>උක්තය</h4>
				</div>
				<div class="col-sm-4">
					<select class="form-control" id="subject" name="subject">
						<option id="singular">ඒක වචන</option>
						<option id="plural">බහු වචන</option>
						<option id="femine">ස්ත්‍රී ලිංග</option>
						<option id="masculine">පුරුෂ ලිංග</option>
						<option id="new">නව යෙදුමක්</option>
						<option id="preWord">පෙර යෙදුමක්</option>
						<option id="postWord">පසු යෙදුමක්</option>
						<option id="conjugation">වරනැගීමක්</option>
						<option id="irrelavant">අදාල නොවේ</option>
					</select>
				</div>
				<div class="col-sm-4">
					<div class="form-group">
						<input type="text" class="form-control" id="subjectNew"
							name="subjectNew">
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-sm-4">
					<h4>ක්‍රියාව</h4>
				</div>
				<div class="col-sm-4">
					<select class="form-control" id="verb">
						<option id="singular">ඒක වචන</option>
						<option id="plural">බහු වචන</option>
						<option id="past">අතීත කාල</option>
						<option id="nonPast">අනතීත කාල</option>
						<option id="new">නව යෙදුමක්</option>
						<option id="preWord">පෙර යෙදුමක්</option>
						<option id="postWord">පසු යෙදුමක්</option>
						<option id="conjugation">වරනැගීමක්</option>
						<option id="irrelavant">අදාල නොවේ</option>
					</select>
				</div>
				<div class="col-sm-4">
					<div class="form-group">
						<input type="text" class="form-control" id="verbNew">
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-4">
					<h4>කර්මය</h4>
				</div>
				<div class="col-sm-4">
					<select class="form-control" id="object">
						<option id="singular">ඒක වචන</option>
						<option id="plural">බහු වචන</option>
						<option id="past">අතීත කාල</option>
						<option id="nonPast">අනතීත කාල</option>
						<option id="new">නව යෙදුමක්</option>
						<option id="preWord">පෙර යෙදුමක්</option>
						<option id="postWord">පසු යෙදුමක්</option>
						<option id="conjugation">වරනැගීමක්</option>
						<option id="irrelavant">අදාල නොවේ</option>
					</select>
				</div>
				<div class="col-sm-4">
					<div class="form-group">
						<input type="text" class="form-control" id="objectNew">
					</div>
				</div>
			</div>
			<button type="button" class="btn btn-info btn-lg" id="submit">ව්‍යාකරණ
				නීතිය ඇතුලත් කරන්න</button>
		</form>
	</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script type="text/javascript" src='js/bootstrap.min.js'></script>
	<script type="text/javascript" src='js/ajax.js'></script>
	<p id="ajaxGetUserServletResponse"></p>
	<p id="subject"></p>
</body>
</html>