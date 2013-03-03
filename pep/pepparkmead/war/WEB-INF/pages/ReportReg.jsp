<%@ include file="/WEB-INF/jsp/include.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="/includes/styles/report.css"> 
	</head>
	<body>
		<c:forEach var="item" items="${regItems}" varStatus="loop">
			<br/>
			<table cellspacing="0">
				<thead>
					<tr>
						<th>On Vendor List?</th>
						<th>Class</th>
						<th>Child</th>
						<th>Teacher/Grade</th>
						<th>Guardian</th>
						<th>Phone</th>
						<th>Cell</th>
						<th>Email</th>
						<th>After Class</th>
						<th>After Class Details</th>
						<th>Needs?</th>
						<th>Medicine Allergies</th>
						<th>Other Allergies</th>
						<th>Emergency Contact</th>
						<th>Emergency Phone</th>
						<th>Insurance Co.</th>
						<th>Policy # </th>
						<th>Insurance Phone</th>
						<th>Reg. Date</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="reg" items="${item.regs}">
						<c:set var="acdetails" value=""/>
						<c:if test="${reg.afterClass eq 'pickedup'}"><c:set var="acdetails" value="${reg.pickedUpBy}"/></c:if>
						<c:if test="${reg.afterClass eq 'other'}"><c:set var="acdetails" value="${reg.otherInstructions}"/></c:if>
						<tr class="${loop.index % 2 == 0 ? 'white' : 'cream'}">
							<td></td>
							<td>${item.cl.className}</td>
							<td>${reg.studentNameFirst} ${reg.studentNameLast}</td>
							<td>${reg.studentTeacher}<br/>${reg.studentGrade}</td>
							<td>${reg.studentGuardian}</td>
							<td>${reg.studentHomePhone}</td>
							<td>${reg.studentCellPhone}</td>
							<td>${reg.studentEmail}</td>
							<td>${reg.afterClass}</td>
							<td>${acdetails}</td>
							<td>${reg.specialNeeds}</td>
							<td>${reg.medicineAllergies}</td>
							<td>${reg.otherAllergies}</td>
							<td>${reg.emergencyContactName}</td>
							<td>${reg.emergencyContactPhone}</td>
							<td>${reg.insuranceCompany}</td>
							<td>${reg.insurancePolicyNumber}</td>
							<td>${reg.insurancePhone}</td>
							<td>${reg.date}</td>						
							<td><a class=bold href="/admin/DeleteRegistration.do?regID=${reg.ID}&clToDelete=${item.cl.ID}" onclick="return confirm('Really delete this registration?')">Delete</a><br/><a class=bold href="/admin/EditRegistration.do?regID=${reg.ID}">Edit</a></td>
						</tr>
					</c:forEach>				
				</tbody>
			</table>
		</c:forEach>				
	</body>
</html>	