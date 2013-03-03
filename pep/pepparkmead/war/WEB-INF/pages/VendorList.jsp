<%@ include file="/WEB-INF/jsp/include.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="/includes/styles/admin.css"> 
	</head>
	<body>				
		<div id="vendors">
			<h3>PEP Vendors</h3>
			<c:choose>
				<c:when test="${not empty vendors}">
					<table id="tblClasses">
					<tr id="classHeader">
						<TD class=bold>Action</TD>
						<TD class=bold>Vendor Name</TD>
						<TD class=bold>Contact Name</TD>
						<TD class=bold>Contact Email</TD>
						<TD class=bold>Contact Phone</TD>
						<TD class=bold>Vendor ID</TD>
						<TD class=bold>Facility Use Form Date</TD>
						<TD class=bold>WCSD Payment Date</TD>
						<TD class=bold>PERC Payment Date</TD>
						<TD class=bold>Vendor Info Sheet Date</TD>
						<TD class=bold>Fingerprint Date</TD>
						<TD class=bold>TB Test Date</TD>
					</tr>
					<c:forEach var="vendorObj" items="${vendors}" varStatus="loop">
						<tr class="${loop.index % 2 == 0 ? 'white' : 'cream'}">
						<td><a class=bold href="VendorEdit.do?vendorToEdit=${vendorObj.ID}">Edit</a></td>
						<td> ${vendorObj.vendorName} </td>
						<td> ${vendorObj.contact} </td>
						<td> ${vendorObj.contactEmail} </td>
						<td> ${vendorObj.contactPhone} </td>
						<td> ${vendorObj.ID} </td>
						<td> ${vendorObj.facilityUseFormDate} </td>
						<td> ${vendorObj.wcsdPaymentDate} </td>
						<td> ${vendorObj.percPaymentDate} </td>
						<td> ${vendorObj.vendorInformationSheetDate} </td>
						<td> ${vendorObj.fingerprintDate} </td>
						<td> ${vendorObj.tbTestDate} </td>
						</tr>	
					</c:forEach>
					</table>
				</c:when>
				<c:otherwise>No vendors defined</c:otherwise>		
			</c:choose>
			<a class=bold href="VendorAdd.do">Add New Vendor</a>
		</div>
	</body>
</html>				
