function sendNewSemester() {
	var name = $("#semesterName").val();
	var dataString = 'semesterName='+ name;
	alert(dataString);
	$.ajax({
		url : "/admin/Semesters.do",
		type : "POST",
		data : dataString
	}).success(function(resp) {
		alert(resp);
		$("#semesterlinks").html(resp);
	}).error(function(jqXHR, textStatus, errorThrown) {
		alert("Error creating new semester: " + textStatus + ":" + errorThrown);
	});
}
		
