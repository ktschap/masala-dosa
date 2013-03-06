<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="/includes/styles/admin.css"> 
		<script type="text/JavaScript" src="http://ajax.aspnetcdn.com/ajax/jquery/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
		<script type="text/JavaScript">
			$(document).ready(function(){
				$("#fileUploadForm").validate();
			});
		</script>
	</head>
	<body>
		<div id="errors">${errorMsg}</div>				
		<form:form modelAttribute="uploadItem" method="post" enctype="multipart/form-data">
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
