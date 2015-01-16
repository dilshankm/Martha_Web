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
	$('#submit').click(function() {	
		$.ajax({
		url : 'DecisionServlet',
		data : {
			sentence : sentenceId,
			subject : subjectId,
			subjectNewValue :$("#subjectNew").val(),
			verb    : verbId,
			verbNewValue:$("#verbNew").val(),
			object  : objectId,
			objectNewValue:$("#objectNew").val()
		},
		success : function(responseText) {
			$('#ajaxGetUserServletResponse').text(responseText);
		}
	});
	});
});


