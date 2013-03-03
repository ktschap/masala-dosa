<%@ include file="/WEB-INF/jsp/include.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="/includes/styles/report.css"> 
	</head>
	<body>				
		<table cellspacing="0">
			<thead>
				<tr>
				<th>Class</th>
				<th>Vendor</th>
				<th>Day</th>
				<th>Time</th>
				<th>Room</th>
				<th>Session Dates</th>
				<th>Vendor Contact &amp;<br />Phone #</th>
				<th>PEP Contact &amp;<br />Phone #</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="ritem" items="${reportItems}" varStatus="loop">
					<tr class="${loop.index % 2 == 0 ? 'white' : 'cream'}">
						<td><span class='bold larger'>${ritem.cl.className}</span><br>
							<span class='smaller'>${ritem.regCount} student(s) enrolled, ${ritem.cl.maxStudents - ritem.regCount} spots left.<br>
									Min:${ritem.cl.minStudents}, Max: ${ritem.cl.maxStudents}<br>
								<c:choose>	
								<c:when test="${ritem.cl.minStudents > ritem.regCount}">
									<span class='red'>Minimum not yet met met.</span>
								</c:when>
								<c:otherwise>
									<span class='green'>Minimum class size met.</span>
								</c:otherwise>		
								</c:choose>	
							</span>
						</td>
						<td>${ritem.vendor.vendorName}<br />(${ritem.cl.lowestAllowedGrade} - ${ritem.cl.highestAllowedGrade})</td>
						<td>${ritem.cl.day}</td>
						<td>${ritem.cl.time}</td>
						<td>${ritem.cl.room}</td>
						<td>${ritem.cl.dates}</td>
						<td>${ritem.vendor.contact}<br />${ritem.vendor.contactPhone}</td>
						<td>${ritem.cl.liaison}<br />${ritem.cl.liaisonPhone}</td>
					</tr>	
				</c:forEach>
			</tbody>
		</table>
									

</body>
</html>				
