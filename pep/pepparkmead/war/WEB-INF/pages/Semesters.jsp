<%@ include file="/WEB-INF/jsp/include.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<script type="text/JavaScript" src="http://code.jquery.com/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="/includes/js/common.js"></script>
		<script type="text/javascript">
			$("#btn-show-classes").click(function() {
				loadClasses();
			});
			
			$("#btn-new-semester").click(function() {
				sendNewSemester();
			});
						
			function loadClasses() {
				var selected = $("#semesterSelector option:selected").val();
				var dataString = 'selectedSemesterName='+ selected;
				alert(dataString);
				$.ajax({
					url : "/GetClasses.do",
					type : "get",
					cache : false,
					data : dataString
				}).success(function(resp) {
					alert(resp);
					$("#allclasses").show();
					
					$("#allclasseslist").html(resp);
				}).error(function(jqXHR, textStatus, errorThrown) {
					alert("Error creating new semester: " + textStatus + ":" + errorThrown);
				});
			}
		</script>
	</head>
	<body>				
		<b>Choose Semester</b>
		<form name="semesterChooser" id="semesterChooser" action="Semesters.do" method="post">
			<select id="semesterSelector">
				<c:if test="${not empty names}">
					<c:forEach var="classObj" items="${names}">
				    	<option value="${classObj}"><c:out value="${classObj}"></c:out> </option>
					</c:forEach>
				</c:if>
			</select>
			<input id="btn-show-classes" type="button" value="Show Classes">					
		</form>	
		<div id="semesters">
			<form name="newSemesterForm" id="newSemesterForm" action="Semesters.do" method="post">
				<fieldset class="data_input"><h3>Create New Semester:</h3>
				<div class="txtbox"><label>New Semester Name:</label><div class="fld"><input type="text" name="semesterName" id="semesterName" maxlength="20" value="" class="required" /></div></div>
				<fieldset id="submit2"><input id="btn-new-semester" type="Submit" value="Save"></fieldset>					
			</form>
		</div>
	</body>
</html>				
