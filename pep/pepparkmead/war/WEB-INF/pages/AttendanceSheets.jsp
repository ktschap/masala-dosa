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
	                    <td class="left nolines" colspan="2">${item.cl.className}</td>
	                </tr>
	                <tr>
	                    <td class="bold nolines">Liaison: </td>
	                    <td class="left nolines" colspan="2">${item.cl.liaison}</td>
	                </tr>
	                <tr>
	                    <td class="bold nolines">Liaison Contact: </td>
	                    <td class="left nolines" colspan="2">${item.cl.liaisonPhone}, ${item.cl.liaisonEmail}</td>
	                </tr>
	                <tr>
	                    <td class="bold nolines">Keyspot Office Phone: </td>
	                    <td class="left nolines" colspan="2">(925) 939-1543</td>
	                </tr>
	                <tr>
	                    <td class="bold nolines">Keyspot Email: </td>
	                    <td class="left nolines" colspan="2">info@keyspot.org</td>
	                </tr>
	            	<tr>
	                	<th>Last Name</th>
	                	<th>First Name</th>
	                	<th>Parent</th>
	                	<th>Parent Phone</th>
	                	<th>Parent Cell</th>
	                	<th>Emerg. Contact </th>
	                	<th>Emerg. Contact Phone</th>
	                	<th>Class 1</td>
	                	<th>Class 2</td>
	                	<th>Class 3</td>
	                	<th>Class 4</td>
	                	<th>Class 5</td>
	                	<th>Class 6</td>
	                	<th>Class 7</td>
	                	<th>Class 8</td>
	                	<th>Class 9</td>
	                	<th>Class 10</td>
	                </tr>
	            </thead>
	            <tbody>
					<c:forEach var="reg" items="${item.regs}" varStatus="loop2">
						<tr class="${loop2.index % 2 == 0 ? 'white' : 'cream'}">				
							<td>${reg.studentNameLast}</td>
							<td>${reg.studentNameFirst}</td>
							<td>${reg.studentGuardian}</td>
							<td>${reg.studentHomePhone}</td>
							<td>${reg.studentCellPhone}</td>
							<td>${reg.emergencyContactName}</td>
							<td>${reg.emergencyContactPhone}</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
						</tr>
					</c:forEach>
	            </tbody>
	        </table>
		</c:forEach>				
	</body>
</html>				
