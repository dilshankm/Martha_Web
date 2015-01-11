/**
 * This file is about ajax operations
 */

//function sendSentenceData(sentenceType) {
//	var xmlhttp;
//	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
//		xmlhttp = new XMLHttpRequest();
//	} else {// code for IE6, IE5
//		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
//	}
//	xmlhttp.onreadystatechange = function() {
//		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
//			document.getElementById("myDiv").innerHTML = xmlhttp.responseText;
//		}
//	}
//	xmlhttp.open("GET", "ajax_info.txt", true);
//	xmlhttp.send();
//}

$(document).ready(function() {
	$('#sentence').change(function() {
		$.ajax({
			url : 'DecisionServlet',
			data : {
				sentence : $('#sentence option:selected').text()
			},
			success : function(responseText) {
				$('#ajaxGetUserServletResponse').text(responseText);
			}
		});
	});
});