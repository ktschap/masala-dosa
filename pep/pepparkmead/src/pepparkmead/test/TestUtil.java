package pepparkmead.test;

import pepparkmead.data.PEPClass;
import pepparkmead.data.Registration;

public class TestUtil {

	public static final String REG_NAME_FIRST = "StudentFirstName";
	public static final String REG_NAME_LAST = "StudentLastName";
	public static final String REG_EMAIL = "parent@gmail.com";
	public static final String REG_HOME = "(111) 111-1111";
	public static final String REG_CELL = "(222) 222-2222";
	public static final String REG_PARENT = "Stoodent Parent";
	public static final String REG_TEACHER = "Mrs. Gonsalves";
	public static final String REG_AFTER = "keyspot";

	public static final String CL_NAME = "Test Class1";
	public static final Long CL_ID = new Long(55);
	public static final Long CL_VEND = new Long(-45);
	public static final Long CL_FILE_ID = new Long(123);

	public static final Registration testReg = new Registration();
	public static final PEPClass testClass = new PEPClass();
	
	static {
		testReg.setStudentNameFirst(REG_NAME_FIRST);
		testReg.setStudentNameLast(REG_NAME_LAST);
		testReg.setStudentEmail(REG_EMAIL);
		testReg.setStudentCellPhone(REG_CELL);
		testReg.setStudentHomePhone(REG_HOME);
		testReg.setStudentGuardian(REG_PARENT);
		testReg.setStudentTeacher(REG_TEACHER);
		testReg.setAfterClass(REG_AFTER);
		
		testClass.setClassName(CL_NAME);
		testClass.setVendorId(CL_VEND);
		testClass.setFileId(CL_FILE_ID);
		testClass.setID(CL_ID);
	}
}
