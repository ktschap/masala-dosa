define([
  'jquery',
  'jqueryvalidate',
  'jquerymaskedinput',
  'jqueryyitihit'
], function($){
	
	var initialize = function() {
		
		$("#frontpage").show();
		$("#pepForm").validate({
			rules: {
				waiverAcknowledgment: "required"
			}					
		});
		$("#homePhone").mask("(999) 999-9999",{placeholder:" "}); 
		$("#cellPhone").mask("(999) 999-9999",{placeholder:" "}); 
		$("#emergencyContactPhone").mask("(999) 999-9999",{placeholder:" "}); 
		$("#insurancePhone").mask("(999) 999-9999",{placeholder:" "}); 

		$("#studentNameFirst").yitihit({
			'format':'title',
			'event':'blur',
			'editable':'realtime'
		});
		
		$("#studentNameLast").yitihit({
			'format':'title',
			'event':'blur',
			'editable':'realtime'
		});
		
		$("#parentName").yitihit({
			'format':'title',
			'event':'blur',
			'editable':'realtime'
		});

		$("#pickedupby").yitihit({
			'format':'title',
			'event':'blur',
			'editable':'realtime'
		});
		
		$("#btn-next-3").click(function() {
			$("#frontpage").hide();
			$("form#pepForm").show();
			$("#demographics").show();
			setCurrentCrumb("#crumb2");
			setNormalCrumb("#crumb1");
		});
		
		$("#btn-back-3").click(function() {
			$("form#pepForm").hide();
			$("#frontpage").show();
			setCurrentCrumb("#crumb1");
			setNormalCrumb("#crumb2");
		});

		$("#btn-next-1").click(function() {
			if ( $("#pepForm").validate({errorClass: "invalid", errorPlacement: function(error, element) { error.appendTo( element.parent("div") );	}}).form() ) {
				$("#demographics").hide();
				$("#classes").show();
				setCurrentCrumb("#crumb3");
				setNormalCrumb("#crumb2");
			}
		});

		$("#btn-next-2").click(function() {
			if ( $("#pepForm").validate({errorClass: "invalid", errorPlacement: function(error, element) { error.appendTo( element.parent("div") );	}}).form() ) {
				$("#classes").hide();
				$("#waiver").show();
				setNormalCrumb("#crumb3");
				setCurrentCrumb("#crumb4");
				loadStudentNameOnWaiver();
			}
		});

		$("#btn-back-1").click(function() {
				$("#classes").hide();
				$("#demographics").show();
				setNormalCrumb("#crumb3");
				setCurrentCrumb("#crumb2");
		});
		
		$("#btn-back-2").click(function() {
				$("#waiver").hide();
				$("#classes").show();
				setNormalCrumb("#crumb4");
				setCurrentCrumb("#crumb3");
		});
		
		$("input[name=afterClass]").change(function() {
			if ($(this).val() != "pickedup") {
				$("#pickedupby").val("");
			}
			if ($(this).val() != "other") {
				$("#otherinstructions").val("");
			}
		});
		
		$("#btn-submit").click(function() {
			if ( $("#pepForm").validate({errorClass: "invalid", errorPlacement: function(error, element) { error.appendTo( element.parent("div") );	}}).form() ) {
				var studentFirst = $("input[name=studentNameFirst]").val();
				var studentLast = $("input[name=studentNameLast]").val();
				var grade = $("#studentGrade option:selected").val();
				var teacher = $("#teacherName option:selected").val();
				var guardian = $("input[name=parentName]").val();
				var homePhone = $("input[name=homePhone]").val();
				var cellPhone = $("input[name=cellPhone]").val();
				var email = $("input[name=email]").val();
				var afterClass = $("input[name=afterClass]:checked").val();
				var pickedupby = $("input[name=pickedupby]").val();
				var otherinstructions = $("input[name=otherinstructions]").val();
				var childcarePolicy = $("#childcarePolicy").is(":checked");
				var behaviorPolicy = $("#behaviorPolicy").is(":checked");
				var medicineAllergies = $("input[name=medicineAllergies]").val();
				var otherAllergies = $("input[name=otherAllergies]").val();
				var emergencyContactName = $("input[name=emergencyContactName]").val();
				var emergencyContactPhone = $("input[name=emergencyContactPhone]").val();
				var insuranceCompany = $("input[name=insuranceCompany]").val();
				var insurancePolicyNumber = $("input[name=insurancePolicyNumber]").val();
				var insurancePhone = $("input[name=insurancePhone]").val();
				var waiverAcknowledgement = $("#waiverAcknowledgment").is(":checked");
				
				var data = "studentNameFirst=" + studentFirst + "&studentNameLast=" + studentLast + "&studentGrade=" + grade +
					"&studentTeacher=" + teacher + "&studentGuardian=" + guardian + "&studentHomePhone=" + homePhone + 
					"&studentCellPhone=" + cellPhone + "&studentEmail=" + email + "&afterClass=" + afterClass + 
					"&pickedUpBy=" + pickedupby + "&otherInstructions=" + otherinstructions + "&childcarePolicy=" + childcarePolicy + 
					"&behaviorPolicy=" + behaviorPolicy + "&medicineAllergies=" + medicineAllergies + 
					"&otherAllergies=" + otherAllergies + "&emergencyContactName=" + emergencyContactName + 
					"&emergencyContactPhone=" + emergencyContactPhone + "&insuranceCompany=" + insuranceCompany + 
					"&insurancePolicyNumber=" + insurancePolicyNumber + "&insurancePhone=" + insurancePhone + 
					"&waiverAcknowledgement=" + waiverAcknowledgement;

				data += "&chosenClasses=";
				$(".classChoice:checked").each(function(){
					data += "___" + $(this).attr("value");
				});
				
				setNormalCrumb("#crumb4");
				setCurrentCrumb("#crumb5");
				$.ajax({
					url: "Register.do",
					async: false,
					type: "post",
					data: data,
					cache: false,
					success: function (html) {
						$("#waiver").hide();
						$("#contactVendor").show();
					},
					error: function (jqXHR, textStatus, errorThrown) {
						alert(textStatus);
					}
				});
			}
		});

		$("#btn-restart").click(function() {
			$("#contactVendor").hide();
			clearPEPForm();
			$("#frontpage").show();
			setNormalCrumb("#crumb5");
			setCurrentCrumb("#crumb1");							
		});

		function setNormalCrumb(elem) {
			$(elem).css("font-weight","normal");
			$(elem).css("color","black");
			$(elem).css("font-style","normal");
		}

		function setCurrentCrumb(elem) {
			$(elem).css("font-weight","bold");
			$(elem).css("color","orange");
			$(elem).css("font-style","italic");
		}

		function loadStudentNameOnWaiver() {
			var studentName = $("input[name=studentNameFirst]").val();
			studentName += " ";
			studentName += $("input[name=studentNameLast]").val();
			$("#insertstudentnamehere").text(studentName);									
		}
		
		function clearPEPForm() {
			$("#pepForm").find(':input').each(function() {
		        switch(this.type) {
		            case 'password':
		            case 'select-multiple':
		            case 'select-one':
		            case 'text':
		            case 'textarea':
		                $(this).val('');
		                break;
		            case 'checkbox':
		            case 'radio':
		                this.checked = false;
		        }
		    });	
		}
	};
	return {initialize:initialize};
});
