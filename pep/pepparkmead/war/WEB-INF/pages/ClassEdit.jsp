<%@ include file="/WEB-INF/jsp/include.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="/includes/styles/admin.css"> 
		<%@ include file="commonjs.jspf" %>
		
		<script type="text/JavaScript">
		$(document).ready(function(){
			$("#classForm").validate();
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
		<c:set var="semesters" scope='page'>S13,F13,W14,S14,F14,W15,S15,F15,W16,S16</c:set>		
		<form name="classForm" id="classForm" action="ClassSave.do" method="post">
			<fieldset class="data_input"><h3>Class Information</h3>
				<c:if test="${not empty classToEdit}">					
					<input type="hidden" name="ID" id="ID" maxlength="60" value="${classToEdit.ID}" class="" />
				</c:if>
				<div class="txtbox"><label>Class Name:</label><div class="fld"><input type="text" name="className" id="className" maxlength="60" value="${classToEdit.className}" class="required" /></div></div>
				<div class="txtbox"><label>Day:</label><div class="fld"><input type="text" name="day" id="day" maxlength="50" value="${classToEdit.day}" class="required" /></div></div>
				<div class="txtbox"><label>Dates:</label><div class="fld"><input type="text" name="dates" id="dates" maxlength="50" value="${classToEdit.dates}" class="required" /></div></div>
				<div class="txtbox"><label>Lowest Allowed Grade:</label>
					<div class="select"><div class="fld"><select name="lowestAllowedGrade" id="lowestAllowedGrade" class="required">
						<c:forEach var="grade" items="${grades}">
							<c:choose>
								<c:when test="${grade == classToEdit.lowestAllowedGrade}">
									<option value="${grade}" selected="selected">${grade}</option>
								</c:when>
							  	<c:otherwise>
									<option value="${grade}">${grade}</option>
							  	</c:otherwise>
							</c:choose>
						</c:forEach>
					</select></div></div>				
				</div>
				<div class="txtbox"><label>Highest Allowed Grade:</label>
					<div class="select"><div class="fld"><select name="highestAllowedGrade" id="highestAllowedGrade" class="required">
						<c:forEach var="grade" items="${grades}">
							<c:choose>
								<c:when test="${grade == classToEdit.highestAllowedGrade}">
									<option value="${grade}" selected="selected">${grade}</option>
								</c:when>
							  	<c:otherwise>
									<option value="${grade}">${grade}</option>
							  	</c:otherwise>
							</c:choose>
						</c:forEach>
					</select></div></div>				
				</div>
				<div class="txtbox"><label>Time:</label><div class="fld"><input type="text" name="time" id="time" maxlength="50" value="${classToEdit.time}" class="required" /></div></div>
				<div class="txtbox"><label>Fee:</label><div class="fld"><input type="text" name="feeString" id="feeString" maxlength="50" value="${classToEdit.feeString}" class="required" /></div></div>
				<div class="txtbox">
					<label>Choose Uploaded Flyer:</label>
					<div class="select"><div class="fld"><select name="fileId" id="fileId" class="required">
						<c:forEach var="uploadedFile" items="${uploadedFileList}">
							<c:choose>
								<c:when test="${uploadedFile.ID == classToEdit.fileId}">
									<option value="${uploadedFile.ID}" selected="selected">${uploadedFile.name}</option>
								</c:when>
							  	<c:otherwise>
									<option value="${uploadedFile.ID}">${uploadedFile.name}</option>
							  	</c:otherwise>
							</c:choose>
						</c:forEach>
					</select></div></div>				
				</div>
				<div class="txtbox"><label>Class Description:</label><div class="fld"><input type="text" name="notes" id="notes" maxlength="50" value="${classToEdit.notes}" class="required" /></div></div>
				<div class="select"><label>Semester:</label><div class="fld">
					<select name="semester" id="semester">
						<c:forEach var="currentSemester" items="${semesters}">
							<c:choose>
								<c:when test="${currentSemester == classToEdit.fileId}">
									<option value="${currentSemester}" selected="selected">${currentSemester}</option>
								</c:when>
							  	<c:otherwise>
									<option value="${currentSemester}">${currentSemester}</option>
							  	</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</div></div>	
				<div class="txtbox"><label>Minimum:</label><div class="fld"><input type="text" name="minStudents" id="minStudents" maxlength="4" value="${classToEdit.minStudents}" class="required" /></div></div>
				<div class="txtbox"><label>Maximum:</label><div class="fld"><input type="text" name="maxStudents" id="maxStudents" maxlength="4" value="${classToEdit.maxStudents}" class="required" /></div></div>
				<div class="txtbox"><label>Room:</label><div class="fld"><input type="text" name="room" id="room" maxlength="20" value="${classToEdit.room}" class="required" /></div></div>

				<div class="txtbox"><label>Vendor:</label>
					<div class="select"><div class="fld"><select name="vendorId" id="vendorId" class="required">
						<c:forEach var="vendor" items="${vendorList}">
							<c:choose>
								<c:when test="${vendor.ID == classToEdit.vendorId}">
									<option value="${vendor.ID}" selected="selected">${vendor.vendorName}</option>
								</c:when>
							  	<c:otherwise>
									<option value="${vendor.ID}">${vendor.vendorName}</option>
							  	</c:otherwise>
							</c:choose>
						</c:forEach>
					</select></div></div>				
				</div>
				<div class="txtbox"><label>Liaison Name:</label><div class="fld"><input type="text" name="liaison" id="liaison" maxlength="50" value="${classToEdit.liaison}" class="" /></div></div>
				<div class="txtbox"><label>Liaison Email:</label><div class="fld"><input type="text" name="liaisonEmail" id="liaisonEmail" maxlength="50" value="${classToEdit.liaisonEmail}" class="email" /></div></div>
				<div class="txtbox"><label>Liaison Phone:</label><div class="fld"><input type="text" name="liaisonPhone" id="liaisonPhone" maxlength="50" value="${classToEdit.liaisonPhone}" class="" /></div></div>
				<div class="txtbox"><label>Teacher Name:</label><div class="fld"><input type="text" name="teacher" id="teacher" maxlength="50" value="${classToEdit.teacher}" class="" /></div></div>
				<div class="txtbox"><label>Teacher Email:</label><div class="fld"><input type="text" name="teacherEmail" id="teacherEmail" maxlength="50" value="${classToEdit.teacherEmail}" class="email" /></div></div>
				<div class="txtbox"><label>Teacher Phone:</label><div class="fld"><input type="text" name="teacherPhone" id="teacherPhone" maxlength="50" value="${classToEdit.teacherPhone}" class="" /></div></div>
			</fieldset>		
			<input id="create-class" class=adminbutton type="submit" value="Save">
		</form>
	</body>
</html>				
