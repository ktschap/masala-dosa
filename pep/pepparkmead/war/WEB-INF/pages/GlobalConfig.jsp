<%@ include file="/WEB-INF/jsp/include.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="/includes/styles/admin.css"> 
	</head>
	<body>	
		<c:set var="semesters" scope='page'>W14,S14,F14,W15,S15,F15,S16,F16,S17,F17,S18,F18</c:set>
		<c:if test="${config.mailVendor}">
			<c:set var="checkedMailVendor" value="checked" scope="page"/>
		</c:if> 			
		<c:if test="${config.registrationOn}">
			<c:set var="checkedRegOn" value="checked" scope="page"/>
		</c:if> 			
		<form name="configForm" id="configForm" action="Config.do" method="post">
			
			<div class="txtbox">
				<label>Mail Vendor on Registration?</label>
				<input type="checkbox" id="mailVendor" style="float: left;" name="mailVendor" ${checkedMailVendor}></input>
			</div>
			<div class="txtbox">
				<label>Registration On?</label>
				<input type="checkbox" id="registrationOn" style="float: left;" name="registrationOn" ${checkedRegOn}></input>
			</div>
      <div class="txtbox">
        <label>Registration Closed Text</label>
        <input type="text" id="registrationClosedMessage" style="float: left;" name="registrationClosedMessage" value="${config.registrationClosedMessage}"></input>
      </div>
			<div class="txtbox">
				<label>Set Current Semester:</label>
				<div class="select"><div class="fld">
					<select name="currentSemester" id="currentSemester" class="required">
						<c:forEach var="sem" items="${semesters}">
							<c:choose>
								<c:when test="${sem == config.currentSemester}">
									<option value="${sem}" selected="selected">${sem}</option>
								</c:when>
							  	<c:otherwise>
									<option value="${sem}">${sem}</option>
							  	</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</div></div>				
			</div>
			<input id="create-class" class=adminbutton type="submit" value="Save">
		</form>
	</body>
</html>				
