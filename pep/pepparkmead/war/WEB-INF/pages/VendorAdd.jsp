<%@ include file="/WEB-INF/jsp/include.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<%@ include file="commonjs.jspf" %>
		
		<script type="text/JavaScript">
		$(document).ready(function(){

			$("#vendorForm").validate();
			$("#contactPhone").mask("(999) 999-9999",{placeholder:" "}); 
			$("#instructorPhone").mask("(999) 999-9999",{placeholder:" "}); 
			$("#liaisonPhone").mask("(999) 999-9999",{placeholder:" "}); 

			$("#contact").yitihit({
				'format':'title',
				'event':'blur',
				'editable':'realtime'
			});
			
			$("#instructor").yitihit({
				'format':'title',
				'event':'blur',
				'editable':'realtime'
			});

			$("#liaison").yitihit({
				'format':'title',
				'event':'blur',
				'editable':'realtime'
			});			
		});
		</script>		
	</head>
	<body>				
		<form name="vendorForm" id="vendorForm" action="CreateVendor.do" method="post">
			<div id="demographics" >
				<fieldset class="data_input"><h3>Vendor Information</h3>
					<c:if test="${not empty vendor}">					
						<input type="hidden" name="ID" id="ID" maxlength="60" value="${vendor.ID}" class="" />
					</c:if>
					<div class="txtbox"><label>Vendor Name:</label><div class="fld"><input type="text" name="vendorName" id="vendorName" maxlength="60" value="${vendor.vendorName}" class="required" /></div></div>
					<div class="txtbox"><label>Contact Name:</label><div class="fld"><input type="text" name="contact" id="contact" maxlength="50" value="${vendor.contact}" class="required" /></div></div>
					<div class="txtbox"><label>Contact Email:</label><div class="fld"><input type="text" name="contactEmail" id="contactEmail" maxlength="50" value="${vendor.contactEmail}" class="required email" /></div></div>
					<div class="txtbox"><label>Contact Phone:</label><div class="fld"><input type="text" name="contactPhone" id="contactPhone" maxlength="50" value="${vendor.contactPhone}" class="required" /></div></div>
					<div class="txtbox"><label>Vendor Address:</label><div class="fld"><input type="text" name="address" id="address" maxlength="50" value="${vendor.address}" class="" /></div></div> 
					<div class="txtbox"><label>Vendor Notes:</label><div class="fld"><textarea name="notes" id="notes" rows="5" cols="40" maxlength="500" class="">${vendor.notes}</textarea></div></div>
					<div class="txtbox"><label>Facility Use Form Date:</label><div class="fld"><input type="text" name="facilityUseFormDate" id="facilityUseFormDate" maxlength="50" value="${vendor.facilityUseFormDate}" class="" /></div></div> 
					<div class="txtbox"><label>WCSD Payment Date:</label><div class="fld"><input type="text" name="wcsdPaymentDate" id="wcsdPaymentDate" maxlength="50" value="${vendor.wcsdPaymentDate}" class="" /></div></div> 
					<div class="txtbox"><label>PERC Payment Date:</label><div class="fld"><input type="text" name="percPaymentDate" id="percPaymentDate" maxlength="50" value="${vendor.percPaymentDate}" class="" /></div></div> 
					<div class="txtbox"><label>Vendor Info Sheet Date:</label><div class="fld"><input type="text" name="vendorInformationSheetDate" id="vendorInformationSheetDate" maxlength="50" value="${vendor.vendorInformationSheetDate}" class="" /></div></div> 
					<div class="txtbox"><label>Fingerprint Date:</label><div class="fld"><input type="text" name="fingerprintDate" id="fingerprintDate" maxlength="50" value="${vendor.fingerprintDate}" class="" /></div></div> 
					<div class="txtbox"><label>TB Test Date:</label><div class="fld"><input type="text" name="tbTestDate" id="tbTestDate" maxlength="50" value="${vendor.tbTestDate}" class="" /></div></div> 					 
					<input id="create-vendor" type="submit" value="Submit">
				</fieldset>
			</div>
		</form>
	</body>
</html>