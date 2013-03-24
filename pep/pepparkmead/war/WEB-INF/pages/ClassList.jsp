<%@ include file="/WEB-INF/jsp/include.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="/includes/styles/admin.css"> 
	</head>
	<body>				
		<div id="classes">
			<h3>PEP Classes</h3>
			<c:choose>
				<c:when test="${not empty classes}">
					<table id="tblClasses">
					<tr id="classHeader">
						<TD class=bold>Action</TD>
						<TD class=bold>Class</TD>
						<TD class=bold>Grades</TD>
						<TD class=bold>Meets</TD>
						<TD class=bold>Fee</TD>
						<TD class=bold>Class runs from - to</TD>
						<TD class=bold>Min/Max</TD>
						<TD class=bold>Room</TD>
						<TD class=bold>Vendor ID</TD>
						<TD class=bold>Flyer File ID</TD>
						<TD class=bold>Delete</TD>
					</tr>
					<c:forEach var="classObj" items="${classes}" varStatus="loop">
						<tr class="${loop.index % 2 == 0 ? 'white' : 'cream'}">
							<td><a class=ulink href="ClassEdit.do?classToEdit=${classObj.ID}">Edit</a></td>
							<td><a class=bold href="/details?id=${classObj.fileId}"> ${classObj.className} </a> <br/> (${classObj.notes}) </td>
							<td> ${classObj.lowestAllowedGrade} - ${classObj.highestAllowedGrade} </td>
							<td> ${classObj.day} <br/> ${classObj.time}</td>
							<td> ${classObj.feeString} </td>
							<td> ${classObj.dates} </td>
							<td> Min:${classObj.minStudents} <br/> Max:${classObj.maxStudents}</td>
							<td> ${classObj.room} </td>
							<td> ${classObj.vendorId} </td>
							<td> ${classObj.fileId} </td>
							<td><a class=ulink onclick="return confirm('Are you sure you want to delete this class?')" href="ClassDelete.do?classToDelete=${classObj.ID}">Delete</a></td>
						</tr>	
					</c:forEach>
					</table>
				</c:when>
				<c:otherwise>No classes defined yet</c:otherwise>		
			</c:choose>
			<a class=ulink href="ClassAdd.do">Add New Class</a>
		</div>
	</body>
</html>				
