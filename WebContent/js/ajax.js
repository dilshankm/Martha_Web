/**
 * This file is about ajax and jquery operations operations
 */

$(document).ready(function() {
	$('#sentenceNew').hide();
	$('#subjectNew').hide();
	$('#verbNew').hide();
	$('#objectNew').hide();
	var sentenceId
	var subjectId
	var subjNewValue
	var verbId
	var objectId
	var submitId
	
	$('#sentence').change(function() {
		sentenceId = $(this).children(":selected").attr("id");
	});
	$('#subject').change(function() {
		subjectId = $(this).children(":selected").attr("id");
		if (subjectId == "new") {
			$('#subjectNew').show()
			subjNewValue=$("#subjectNew").value()
		}
		else if(subjectId == "preWord"){
			$('#subjectNew').show()
			subjNewValue=$("#subjectNew").value()
		}
		else if(subjectId == "postWord"){
			$('#subjectNew').show()
			subjNewValue=$("#subjectNew").value()
		}
		else if(subjectId == "conjugation"){
			$('#subjectNew').show()
			subjNewValue=$("#subjectNew").value()
			
		}
		else {
			$('#subjectNew').hide();	
		}
	});
	$('#verb').change(function() {
		verbId = $(this).children(":selected").attr("id");
		if (verbId == "new") {
			$('#verbNew').show()
		}
		else if(verbId == "preWord"){
			$('#verbNew').show()
		}
		else if(verbId == "postWord"){
			$('#verbNew').show()
		}
		else if(verbId == "conjugation"){
			$('#verbNew').show()
			alert($('#verb').children(":selected").attr("id"))
		}
		else {
			$('#verbNew').hide()
		}
	});
	$('#object').change(function() {
		objectId = $(this).children(":selected").attr("id");
		if (objectId == "new") {
			$('#objectNew').show()
		}
		else if(objectId == "preWord"){
			$('#objectNew').show()
		}
		else if(objectId == "postWord"){
			$('#objectNew').show()
		}
		else if(objectId == "conjugation"){
			$('#objectNew').show()
		}
		else {
			$('#objectNew').hide()
		}
	});
	$('#submitNew').click(function() {
		 location.reload();
	});
	$('#submit').click(function() {	
		$.ajax({
		url : 'DecisionServlet',
		data : {
			sentence : $('#sentence').children(":selected").attr("id"),
			subject : $('#subject').children(":selected").attr("id"),
			subjectNewValue :$("#subjectNew").val(),
			verb    : $('#verb').children(":selected").attr("id"),
			verbNewValue:$("#verbNew").val(),
			object  : $("#object").children(":selected").attr("id"),
			objectNewValue:$("#objectNew").val()
		},
		success : function(responseText) {
			$('#ajaxGetUserServletResponse').text(responseText);
		}
	});
	});
});

