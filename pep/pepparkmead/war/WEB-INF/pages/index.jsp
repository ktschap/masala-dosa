<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"> 
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
		<meta name="viewport" content="width=device-width">
		<title>Parkmead Education Resources Council (PERC) PEP Classes</title>
		<link rel="stylesheet" type="text/css" href="includes/styles/reset.css">
		<link rel="stylesheet" type="text/css" href="includes/styles/pep.css">
		
		<script data-main="includes/js/main" src="includes/js/require.js"></script>
	</head>
	<body>
		<c:set var="regDisabled" scope='page'>disabled</c:set>
		<c:set var="nextLabel" value="Registration Closed" scope="page"/>
		<c:set var="classListInstructions" value="Registration is currently closed" scope="page"/>
		<c:if test="${regOn}">
			<c:set var="regDisabled" value="" scope="page"/>
			<c:set var="nextLabel" value="Next Step" scope="page"/>
			<c:set var="classListInstructions" value="Click the class name to view the brochure" scope="page"/>
		</c:if> 			
		<div id="container">
			<div id="header">
				<img src="images/untitled.bmp" height="200" width="200" border="0" alt="Parkmead Enrichment Program" id="img_logo" /> 
				<h1>Parkmead Enrichment Program (PEP)<br/>Enrollment</h1>

				<h2>${semesterFriendlyDescription}</h2>
				<div id="breadcrumb">
					<div><span class="crumb" id="crumb1">Step 1:<br>Review Classes</span></div>
					<div><span class="crumb" id="crumb2">Step 2:<br>Student Information</span></div>
					<div><span class="crumb" id="crumb3">Step 3:<br>Choose Class(es)</span></div>
					<div><span class="crumb" id="crumb4">Step 4:<br>Waiver</span></div>
					<div><span class="lastcrumb" id="crumb5">Step 5:<br>Contact Vendor</span></div>
				</div>
			</div>
			<div id="header-narrow">
				<h1>PEP Enrollment</h1>
				<h2>${semesterFriendlyDescription}</h2>
			</div>

			<div id="frontpage">
				<c:choose>
					<c:when test="${not empty classes}">
						<br/>
						<span id="classListInstructions">${classListInstructions}</span>
						<table id="tblClasses">
							<tr id="classHeader">
								<TD class=bold>Enrichment Class</TD>
								<TD class=bold>Grades</TD>
								<TD class=bold>Meets</TD>
								<TD class=bold>Fee</TD>
								<TD class=bold>Class runs from - to</TD>
							</tr>
							<c:forEach var="classObj" items="${classes}" varStatus="loop">
								<tr class="${loop.index % 2 == 0 ? 'white' : 'cream'}">
								<td class="classname"><a class=bold href="/details?id=${classObj.fileId}"> ${classObj.className} </a> <br/> (${classObj.notes}) </td>
								<td class="grades"> ${classObj.lowestAllowedGrade} - ${classObj.highestAllowedGrade} </td>
								<td class="meets"> ${classObj.day} <br/> ${classObj.time}</td>
								<td class="fee"> ${classObj.feeString} </td>
								<td class="dates"> ${classObj.dates} </td>
								</tr>	
							</c:forEach>
						</table>
					</c:when>
					<c:otherwise><br/>Classes Coming Soon!</c:otherwise>		
				</c:choose>
				<fieldset id="submit0"><input id="btn-next-3" type="button" ${regDisabled} value="${nextLabel}"></fieldset>
			</div>
			
			<form name="pepForm" id="pepForm" action="" method="post">

				<div id="demographics" >
					<fieldset class="data_input"><h3>Student Information</h3>
						<div class="txtbox"><label>Student First Name:</label><div class="fld"><input type="text" name="studentNameFirst" id="studentNameFirst" maxlength="50" value="" class="required" /></div></div>
						<div class="txtbox"><label>Student Last Name:</label><div class="fld"><input type="text" name="studentNameLast" id="studentNameLast" maxlength="50" value="" class="required" /></div></div>
						<div class="select"><label>Grade:</label><div class="fld"><select name="studentGrade" id="studentGrade" class="required"><option value="">Choose One</option><option value="K">Kinder</option><option value="1">1st</option><option value="2">2nd</option><option value="3">3rd</option><option value="4">4th</option><option value="5">5th</option></select></div></div>

						<div class="select"><label>Teacher:</label><div class="fld">
							<select name="teacherName" id="teacherName" class="required">
								<c:forEach var="teacher" items="${teachers}" varStatus="loop">
									<option>${teacher}</option>
								</c:forEach>
							</select>
						</div></div>
						<div class="txtbox"><label>Parent/Guardian:</label><div class="fld"><input type="text" name="parentName" id="parentName" maxlength="50" value="" class="required" /></div></div>
						<div class="txtbox"><label>Home Phone:</label><div class="fld"><input type="text" name="homePhone" id="homePhone" maxlength="50" value="" class="required" /></div></div>
						<div class="txtbox"><label>Cell Phone:</label><div class="fld"><input type="text" name="cellPhone" id="cellPhone" maxlength="50" value="" /></div></div>
						<div class="txtbox"><label>Email:</label><div class="fld"><input type="text" name="email" maxlength="50" value="" class="required email" /></div></div>

						<div class="inp_group checkboxes" id="inp_group-1">
							After class my child will:
							<div class="fld"><input type="radio" name="afterClass" id="afterClass1" value="keyspot" class="required" onclick="$('#pickedupby').attr('disabled',true); $('#otherinstructions').attr('disabled',true)" /><label>Go to Keyspot</label></div>
							<div class="fld"><input type="radio" name="afterClass" id="afterClass2" value="pickedup" class="required" onclick="$('#pickedupby').attr('disabled',false); $('#otherinstructions').attr('disabled',true)" /><label>Be picked up at class by </label><input type="text" class="moreinfo" name="pickedupby" id="pickedupby" maxlength="50" value="" disabled="disabled" /></div>
							<div class="fld"><input type="radio" name="afterClass" id="afterClass3" value="other" class="required" onclick="$('#otherinstructions').attr('disabled',false); $('#pickedupby').attr('disabled',true)" /><label>Other instructions:</label><input type="text" class="moreinfo" name="otherinstructions" id="otherinstructions" maxlength="50" value="" disabled="disabled" /></div>
							<label class="invalid" for="afterClass">One selection is required</label>
						</div>		
					</fieldset>

					<fieldset id="submit1">
						<input id="btn-back-3" type="button" value="Back to Step 1"><input id="btn-next-1" type="button" value="Next Step">
					</fieldset>
				</div>
				<div id="classes">
					<div id="classList">
						<br/>
						Click the class name to view brochure
						<c:choose>
							<c:when test="${not empty classes}">
								<table id="tblClasses">
								<tr id="classHeader">
									<TD class=bold>Select</TD>
									<TD class=bold>Enrichment Class</TD>
									<TD class=bold>Grades</TD>
									<TD class=bold>Meets</TD>
									<TD class=bold>Fee</TD>
									<TD class=bold>Class runs from - to</TD>
								</tr>
								<c:forEach var="classObj" items="${classes}" varStatus="loop">
									<tr class="${loop.index % 2 == 0 ? 'white' : 'cream'}">
									<td class="selectclass"> <input name="classChoicesCB" class="required classChoice" id="class${classObj.ID}" type="checkbox" value="${classObj.ID}" /> </td>
									<td class="classname2"><a class=bold href="/details?id=${classObj.fileId}"> ${classObj.className} </a> <br/> (${classObj.notes}) </td>
									<td class="grades"> ${classObj.lowestAllowedGrade} - ${classObj.highestAllowedGrade} </td>
									<td class="meets"> ${classObj.day}<br/>${classObj.time}</td>
									<td class="fee"> ${classObj.feeString}</td>
									<td class="dates"> ${classObj.dates}</td>
									</tr>	
								</c:forEach>
								</table>
							</c:when>
							<c:otherwise>No classes defined yet</c:otherwise>		
						</c:choose>
					</div>
					<fieldset id="submit2">
						<input id="btn-back-1" type="button" value="Back to Step 2">
						<input id="btn-next-2" type="button" value="Next Step">
					</fieldset>
				</div>
				<div id="waiver">
				
					<p class="bold margined">* I have read and agree to the following:</p>
					<input type="checkbox" name="childcarePolicy" id="childcarePolicy" class="required" style="float: left; margin-top: 15px;">

					<ul class="pepForm">
						<li><span class="bold">Childcare Policy</span>&nbsp;All children must be enrolled in Keyspot, at a minimum as a backup for an
						unexpected class cancellation and/or backup for late pickups. Children in the Keyspot program
						will be escorted to and from their registered activity. Otherwise, parent/guardian is responsible
						for ensuring their child is dropped off and picked up from class. In the event a parent/guardian
						pickup is late, children will be escorted to Keyspot and the drop-in fee will be due at time of
						pickup directly to Keyspot.</li>
					</ul>

					<input type="checkbox" name="behaviorPolicy" id="behaviorPolicy" class="required" style="float: left; margin-top: 15px;">
					<ul class="pepForm">
						<li><span class="bold">Behavior Policy</span>&nbsp;Students are expected to conduct themselves in a manner that shows respect
						for the feelings, rights and property of others in accordance with all Walnut Creek School
						District policies. Students that put themselves or others in danger or disrupt the class or
						continuously break class rules will be subject to expulsion at the instructor&rsquo;s discretion.</li>
					</ul>

					<div id="agreements" style="padding: 10px; border: 1px solid black; margin: 20px 0;"> 
						<span class="bold" style="font-size: large">Parent Approval, Student Waiver & Medical Authorization Form</span>
						<p><span id="insertstudentnamehere"></span> has my permission to participate in all Parkmead Education Resources Council (PERC) sponsored events.  The undersigned parent or guardian agrees to, certifies and acknowledges the following:
						<ol><li>Parent or Guardian assumes all risks in connection with the student's participation in any and all PERC sponsored events.</li>
						<li>The PERC officers, employees and agents are released and discharged from all liability for any damage, loss or injury to the student, the student&rsquo;s property, or the parent&rsquo;s property in connection with participation in these activities.</li></ol></p>

						<p>I am aware and acknowledge that any activity covered by this permission slip, by its very nature, poses
						the potential risk of injury/illness to the individuals who participate. For and in consideration of the
						opportunity for my child/ward to participate in the activities covered by this permission slip, I do hereby
						agree as follows:

						<ol><li>All persons participating in Parkmead Education Program (PEP) classes shall be deemed to have
						waived all claims against the District or the State of California for injury, accident, illness or death
						occurring during or by reason of the class.</li>
						<li>In the event of illness or injury, I consent to all routine and/or emergency medical treatments and/or
						services prescribed by the attending physician, surgeon, or dentist, and to the administration and
						performance of all examinations, treatments, anesthetics, operations, and other procedures which are
						deemed necessary or advisable by the attending physician at the scene and/or at the hospital or other
						medical facility.</li>

						<li>That I am solely financially responsible for any cost and/or all indebtedness incurred as a result of
						any emergency and/or routine medical and/or surgical treatment and services prescribed by the
						attending physician for my child/ward, including all charges not covered by insurance.</li>
						<li>To indemnify and hold harmless the District, its officers, employees, agents, representatives, and
						volunteers from each and every claim or demand made, and each and every liability, action, loss,
						debt, or damage which may arise by or in connection with, or result from, any routine and/or
						emergency medical services, or participation or my child/ward in any activities covered by this
						permission slip.</li>

						<li>I fully understand that all persons participating in PEP classes are to abide by all rules and
						regulations governing conduct during the class. Any violation of these rules and regulations may
						result in the individual being sent home at the expense of his/her parent/guardian.</li>
						<li>If my child/ward has a special medical condition and/or physical disability diagnosed by a physician.</li></ol></p>

						<p>A description of that medical condition and/or physical disability is attached hereto.     * OR *</p>

						<p>A description of that medical condition and/or physical disability is on file with the school office.</p>

						<p>A special note to parent/guardian:<br><br>
						<div id="specialneedsdiv">
							<div id="check1" style="width: 25px; float: left;"><input type="checkbox" name="specialneeds"></div>
							<div id="text1">Check here if your child/ward has special needs that we should be aware of, and, if medication will be required during this activity concerning this condition.</div>
						</div>

						<ol><li>My child/ward is allergic to the following medications:&nbsp;<input type="text" name="medicineAllergies" value="" width="20" maxlength="250"></li>
						<li>My child/ward is allergic to the following foods, materials, etc.&nbsp;<input type="text" name="otherAllergies" value="" width="20" maxlength="250"></li></ol></p>

						<p>Emergency contact if I cannot be reached:<br>
						<ul>
						<li><span id="emergencyContactName">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;* Name:&nbsp;&nbsp;</span><input type="text" name="emergencyContactName" value="" class="required" size="25" maxlength="250"></li><br>
						<li><span id="emergencyContactPhone">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;* Phone:&nbsp;</span><input type="text" name="emergencyContactPhone" class="required" id="emergencyContactPhone" value="" size="25" maxlength="250"></li><br>
						</ul>
						</p>
						<p>Student&rsquo;s Medical Insurance Carrier:<br>
						<ul>
						<li><span id="insuranceName">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;* Company Name:&nbsp;</span><input type="text" name="insuranceCompany" value="" class="required" size="25" maxlength="50"></li><br>
						<li><span id="insurancePolicy">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;* Policy Number:&nbsp;</span><input type="text" name="insurancePolicyNumber" value="" class="required" size="25" maxlength="50"></li><br>
						<li><span id="insurancePhone">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;* Phone:&nbsp;</span><input type="text" name="insurancePhone" id="insurancePhone" value="" class="required" size="25" maxlength="250"></li><br>
						</ul>
						</p>
						<div id="waiverAcknowledgmentDiv">
							<div id="check2" style="width: 35px; float: left;"><input type="checkbox" name="waiverAcknowledgment" id="waiverAcknowledgment" class="required">&nbsp;<span class="bold red">*</span></div>
							<div id="text2"><span class="bold red">I acknowledge that I have carefully read this Parent Approval, Student Waiver &amp; Medical Authorization Form and I understand and agree to its terms.</span></div>
						</div>
					</div> 				
				
					<fieldset id="submit3"><input id="btn-back-2" type="button" value="Back to Step 3"><input id="btn-submit" type="button" value="Submit"></fieldset>
				</div>
				<div id="contactVendor">
					<br/>Your registration has been saved. We have sent you an email with the details.<p style="font-weight: bold;"><br/>In order to complete the registration process, please contact the vendor(s) for each class for which you signed up, to arrange payment.</p><br/>
					<fieldset id="submit4"><input id="btn-restart" type="button" value="Back to Start"></fieldset>					
				</div>
			</form>
			<div id="footer"><a href="mailto: ParkmeadPEP@gmail.com">Contact Us</a></div>
		</div>
	</body>
</html>
