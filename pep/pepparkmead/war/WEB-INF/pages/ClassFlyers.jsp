<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="/includes/styles/admin.css"> 
		<%@ include file="commonjs.jspf" %>
		<script type="text/JavaScript">
			$(document).ready(function(){
				$("#fileUploadForm").validate();
			});
		</script>
	</head>
	<body>
	
		<table>
 			<tr id="classHeader">
				<td class=bold>Flyer Name</td>
				<td class=bold>Database ID</td>
				<td class=bold>Action(s)</td>
			</tr>
	 		<c:forEach var="dbFile" items="${dbFiles}" varStatus="loop">
	 			<tr>
	 				<td>${dbFile.name}</td>
	 				<td>${dbFile.ID}</td>
	 				<td><a href="/admin/DeleteUpload.do?id=${dbFile.ID}" onclick="return confirm('Really delete this file? This cannot be undone!')">Delete Permanently</a></td>
	 			</tr>
        	</c:forEach>
        </table>
		<div id="errors">${errorMsg}</div>				
		<form:form id="fileUploadForm" modelAttribute="uploadItem" method="post" enctype="multipart/form-data">
            <fieldset>
                <legend>Upload Fields</legend>
                <p>
                    <form:label for="name" path="name">Name</form:label><br/>
                    <form:input path="name"/>
                </p>
 
                <p>
                    <form:label for="fileData" path="fileData">File</form:label><br/>
                    <form:input path="fileData" type="file"/>
                </p>
 
                <p>
                    <input type="submit" />
                </p> 
            </fieldset>
        </form:form>
        
       
	</body>
</html>				
