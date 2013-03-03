<%@ include file="/WEB-INF/jsp/include.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="/includes/styles/report.css"> 
	</head>
	<body>				
		<c:forEach var="item" items="${reportItems}">
			<br/><br/>
	        <table cellspacing="0" class="schedule">
	        	<thead>
	                <tr>
	                    <td class="bold nolines">Class: </td>
	                    <td class="left nolines" colspan="2">${item.cl.className} (${item.regCount} student(s) enrolled)</td>
	                    <td class="bold nolines">Instructor: </td>
	                    <td class="left nolines" colspan="3">${item.cl.teacher}</td>
	                </tr>
	                <tr>
	                    <td class="bold nolines">Room: </td>
	                    <td class="left nolines" colspan="2">${item.cl.room}</td>
	                    <td class="bold nolines">On-Site Contact Phone: </td>
	                    <td class="left nolines" colspan="3">${item.cl.teacherPhone}</td>
	                </tr>
	                <tr>
	                    <td class="bold nolines">Dates: </td>
	                    <td class="left nolines" colspan="2">${item.cl.dates}</td>
	                    <td class="bold nolines">PEP Contact: </td>
	                    <td class="left nolines" colspan="3">${item.vendor.liaison}</td>
	                </tr>
	                <tr>
	                    <td class="bold nolines">Time: </td>
	                    <td class="left nolines" colspan="2">${item.cl.time}</td>
	                    <td class="bold nolines">PEP Contact Phone: </td>
	                    <td class="left nolines" colspan="3">${item.vendor.liaisonPhone}</td>
	                </tr>
	            	<tr>
	                	<th>Last Name</th>
	                	<th>First Name</th>
	                	<th>Grade</th>
	                	<th>Classroom</th>
	                	<th>Keyspot Code</th>
	                	<th>Emerg. Contact #</th>
	                	<th>Comments</th>
	                </tr>
	            </thead>
	            <tbody>
					<c:forEach var="reg" items="${item.regs}" varStatus="loop2">
						<tr class="${loop2.index % 2 == 0 ? 'white' : 'cream'}">				
							<td>${reg.studentNameLast}</td>
							<td>${reg.studentNameFirst}</td>
							<td>${reg.studentGrade}</td>
							<td>${reg.studentTeacher} - ${reg.studentTeacherRoom}</td>
							<td>&nbsp;</td>
							<td>${reg.emergencyContactName}<br/>Phone:${reg.emergencyContactPhone}<br/>Cell: ${reg.studentCellPhone}</td>
							<td>&nbsp;</td>
						</tr>
					</c:forEach>
	            </tbody>
	        </table>
		</c:forEach>				
	</body>
</html>				
