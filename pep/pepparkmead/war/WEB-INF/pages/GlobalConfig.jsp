<%@ include file="/WEB-INF/jsp/include.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="/includes/styles/admin.css"> 
	</head>
	<body>	
		<c:set var="semesters" scope='application'>F12,W13,S13,F13,W14,S14,F14,W15,S15,F15</c:set>
		<c:if test="${config.mailVendor}">
			<c:set var="checked" value="checked" scope="page"/>
		</c:if> 			
		<form name="configForm" id="configForm" action="Config.do" method="post">
			
			<div class="txtbox">
				<label>Mail Vendor on Registration?</label>
				<input type="checkbox" id="mailVendor" style="float: left;" name="mailVendor" ${checked}></input>
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
			<input id="create-class" class=adminbutton type="submit" value="Submit">
		</form>
	</body>
</html>				
