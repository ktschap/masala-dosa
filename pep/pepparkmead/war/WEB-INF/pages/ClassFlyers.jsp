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
		<br/><p class="bold"> Flyers currently available:</p><br/>
		<table id="tblFiles">
 			<tr id="filesHeader">
				<td class=bold>Flyer Name</td>
				<td class=bold>Unique File ID</td>
				<td class=bold>Actions</td>
			</tr>
	 		<c:forEach var="dbFile" items="${dbFiles}" varStatus="loop">
	 			<tr class="${loop.index % 2 == 0 ? 'white' : 'cream'}">
	 				<td>${dbFile.name}</td>
	 				<td>${dbFile.ID}</td>
	 				<td><a href="/admin/DeleteUpload.do?id=${dbFile.ID}" onclick="return confirm('Really delete this file? This cannot be undone!')">Delete Permanently</a></td>
	 			</tr>
        	</c:forEach>
        </table>
        <br/>
		<div id="errors">${errorMsg}</div>				
		<form:form id="fileUploadForm" modelAttribute="uploadItem" method="post" enctype="multipart/form-data">
            <fieldset>
                <legend>Flyer Import</legend>
                <p>
                    <form:label for="name" path="name">Unique name (ie "S13_Tennis")</form:label><form:input path="name" class="required"/>
                </p>
                <p>
                    <form:label for="fileData" path="fileData">File from your computer</form:label><form:input path="fileData" type="file" class="required"/>
                </p>
                <p>
                    <input type="submit" value="Import Flyer"/>
                </p> 
            </fieldset>
        </form:form>
        
       
	</body>
</html>				
