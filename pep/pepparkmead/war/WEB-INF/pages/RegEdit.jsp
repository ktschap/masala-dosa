<%@ include file="/WEB-INF/jsp/include.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="/includes/styles/admin.css"> 
		<script type="text/JavaScript" src="http://ajax.aspnetcdn.com/ajax/jquery/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
		<script type="text/javascript" src="/includes/js/jquery.maskedinput-1.3.min.js"></script>
		<script type="text/javascript" src="/includes/js/jquery.yitihit.min.js"></script>
		<script type="text/JavaScript">
		$(document).ready(function(){
			$("#regForm").validate();
			$("#fee").yitihit({
				'format':'numeric',
				'event':'realtime',
				'editable':'realtime'
			});
			$("#minStudents").yitihit({
				'format':'numeric',
				'event':'realtime',
				'editable':'realtime'
			});
			$("#maxStudents").yitihit({
				'format':'numeric',
				'event':'realtime',
				'editable':'realtime'
			});
			
			
		});
		</script>
	</head>
	<body>				
		<form name="regForm" id="regForm" action="RegSave.do" method="post">
			<fieldset class="data_input"><h3>Registration Information</h3>
				<c:if test="${not empty regToEdit}">					
					<input type="hidden" name="regID" id="regID" maxlength="60" value="${regToEdit.ID}" class="" />
				</c:if>
				<div class="txtbox"><label>Student Name:</label><div class="fld">${regToEdit.studentNameFirst}  ${regToEdit.studentNameLast} </div></div>
				<div class="select"><label>Teacher:</label><div class="fld">
					<select name="teacherName" id="teacherName" class="required">
						<c:forEach var="teacher" items="${teachers}" varStatus="loop">
							<c:choose>
								<c:when test="${teacher == regToEdit.studentTeacher}">
									<option value="${teacher}" selected="selected">${teacher}</option>
								</c:when>
							  	<c:otherwise>
									<option value="${teacher}">${teacher}</option>
							  	</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</div></div>
				<div class="txtbox"><label>Parent/Guardian:</label><div class="fld">${regToEdit.studentGuardian}</div></div>
				<div class="txtbox"><label>Home Phone:</label><div class="fld"><input type="text" name="homePhone" id="homePhone" maxlength="50" value="${regToEdit.studentHomePhone}" class="required" /></div></div>
				<div class="txtbox"><label>Cell Phone:</label><div class="fld"><input type="text" name="cellPhone" id="cellPhone" maxlength="50" value="${regToEdit.studentCellPhone}" /></div></div>
				<div class="txtbox"><label>Email:</label><div class="fld"><input type="text" name="email" maxlength="50" value="${regToEdit.studentEmail}" class="required email" /></div></div>
			</fieldset>		
			<input id="edit-reg" class=adminbutton type="submit" value="Submit">
		</form>
	</body>
</html>				
