package pepparkmead;

import java.text.MessageFormat;
import java.util.List;

import pepparkmead.data.PEPClass;
import pepparkmead.data.Registration;

public class EmailMsgFormatter implements IMsgFormatter {

	private static final String REG_MSG_TEMPLATE = 
		"Thank you for completing step 1 of 2 of the PEP registration process. Please check the information submitted through the on-line registration recorded below and notify the PEP Commitee (parkmeadPEP@gmail.com) if any changes need to be made.\r\n\r\n" +
		"Student:\t\t{0}\r\n" + 
		"Teacher:\t\t{1}\r\n" +
		"Parent/Guardian:\t{2}\r\n" +
		"Telephone:\t\t{3}\r\n" +
		"Cell:\t\t\t{4}\r\n" +
		"Email:\t\t\t{5}\r\n\r\n" +
		"{0} is signed up for the following PEP activity(ies):\r\n\r\n{7}\r\nYou have stated that after enrichment class {0} will {6}.\r\n\r\n\r\n" +
		"Now for Step 2 of the Registration process:\r\n\r\n\r\n" +
		"Register for each class directly with the vendors.  Payment is also to be submitted to the vendor.\r\n\r\n{8}" +
	    "\r\n\r\nIf your child will miss a class please notify the instructor directly so they don't waste class time attempting to locate your child.\r\n\r\n" +

		"1.\t\tSAFETY FIRST - Remember! Students must be supervised at all times while on school grounds, including before and/or after after-school classes. Sign your child up for Keyspot (www.keyspot.org) if there is a gap between school dismissal and the start of an after-school activity.\r\n" +
		"2.\t\tIn the event your student will be absent from the activity, you must contact the vendor directly to let them know – and in advance of the activity.  Otherwise, the vendor will have to spend precious activity time tracking down your student.\r\n" + 
		"3.\t\tPlease provide your child a snack.\r\n" + 
		"4.\t\tDouble check that you did not double book your student for multiple activities.\r\n\r\n" + 
		
		"Questions? Contact Heidi Benenson or Penny Terry at ParkmeadPEP@gmail.com\r\n" +
		"(Please do not contact the school secretary)";
	
	public String registrationMsg(Registration reg, List<PEPClass> classes, String semesterSubfolder) {
		final String afterClassMsg = afterClass(reg);
		final String[] classMsgs = formatClassMsgs(classes, semesterSubfolder);
		return MessageFormat.format(
			REG_MSG_TEMPLATE, 
			new Object[] { 
				reg.getStudentNameFirst() + " " + reg.getStudentNameLast(),
				reg.getStudentTeacher(),
				reg.getStudentGuardian(),
				reg.getStudentHomePhone(),
				reg.getStudentCellPhone(),
				reg.getStudentEmail(),
				afterClassMsg,
				classMsgs[0],
				classMsgs[1]
			}
		);
	}

	private String[] formatClassMsgs(List<PEPClass> classes, String semesterSubfolder) {
		String[] ret = new String[2];
		StringBuilder sb0 = new StringBuilder(), sb1 = new StringBuilder();
		for (PEPClass c : classes) {
			buildListMsgForClass(sb0, c);			
			buildRegistrationMsgForClass(sb1, c, semesterSubfolder);
		}
		ret[0] = sb0.toString();
		ret[1] = sb1.toString();
		return ret;
	}

	private void buildListMsgForClass(StringBuilder sb, PEPClass c) {
		sb.append(c.getClassName());
		addNewline(sb);
	}

	private void buildRegistrationMsgForClass(StringBuilder sb, PEPClass c, String semesterSubfolder) {
		sb.append("Registration Instructions for ");
		sb.append(c.getClassName());
		sb.append(" can be found at ");
		sb.append("http://pepparkmead.appspot.com/details?id=");
		sb.append(c.getFileId());
		addNewline(sb);
	}

	private void addNewline(StringBuilder sb) {
		sb.append("\r\n");
	}

	private static String afterClass(Registration reg) {
		if (reg.isPickupAfterClass()) 
			return "be picked up by " + reg.getPickedUpBy(); 
		if (reg.isOtherAfterClass()) 
			return reg.getOtherInstructions();
		else
			 return "go to keyspot";
	}

}
