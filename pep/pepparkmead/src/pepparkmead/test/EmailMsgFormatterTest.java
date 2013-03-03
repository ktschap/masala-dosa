package pepparkmead.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import pepparkmead.EmailMsgFormatter;
import pepparkmead.IMsgFormatter;
import pepparkmead.data.PEPClass;

public class EmailMsgFormatterTest {

	private IMsgFormatter fmt;
	private List<PEPClass> classes;
	@Before
	public void setUp() throws Exception {
		fmt = new EmailMsgFormatter();
		classes = new ArrayList<PEPClass>();
		classes.add(TestUtil.testClass);
	}

	@Test
	public void testRegistrationMsgKeyspot() {
		String msg = basicEmailTest();
		checkKeyspot(msg);
	}

	@Test
	public void testRegistrationMsgPickup() {
		TestUtil.testReg.setAfterClass("pickedup");
		TestUtil.testReg.setPickedUpBy("Grandpapa");
		String msg = basicEmailTest();
		checkPickedUp(msg);
	}

	@Test
	public void testRegistrationMsgOther() {
		TestUtil.testReg.setAfterClass("other");
		TestUtil.testReg.setOtherInstructions("Just keep the kid");
		String msg = basicEmailTest();
		checkOther(msg);
	}

	private void checkPickedUp(String msg) {
		assertTrue("Didn't find picked up message: " + msg, msg.indexOf("picked up by Grandpapa.") >= 0);
	}

	private void checkOther(String msg) {
		assertTrue("Didn't find other message: " + msg, msg.indexOf("Just keep the kid.") >= 0);
	}

	private String basicEmailTest() {
		String msg = fmt.registrationMsg(TestUtil.testReg, classes, "S13");
		checkSimpleStrings(msg);
		checkBracesReplaced(msg);
		checkUrl(msg);
		return msg;
	}

	private void checkUrl(String msg) {
		assertTrue(msg.indexOf(TestUtil.testClass.getClassName()) > 0);
		assertTrue(msg.indexOf("http://pepparkmead.appspot.com/pdf/S13/" + TestUtil.testClass.getFileName()) > 0);		
	}

	private void checkBracesReplaced(String msg) {
		assertFalse("Found a curly brace not replaced in: " + msg, msg.indexOf('{') >= 0);
		assertFalse("Found a curly brace not replaced in: " + msg, msg.indexOf('}') >= 0);
	}

	private void checkSimpleStrings(String msg) {
		assertNotNull(msg);
		assertPresent(msg, TestUtil.REG_NAME_FIRST);
		assertPresent(msg, TestUtil.REG_NAME_LAST);
		assertPresent(msg, TestUtil.REG_CELL);
		assertPresent(msg, TestUtil.REG_HOME);
		assertPresent(msg, TestUtil.REG_PARENT);
		assertPresent(msg, TestUtil.REG_TEACHER);
	}

	private void checkKeyspot(String msg) {
		assertTrue("Didn't find keyspot message: " + msg, msg.indexOf("will go to keyspot.") >= 0);
	}

	private void assertPresent(String msg, String s) {
		assertTrue("Not found: " + s, msg.indexOf(s) >= 0);
	}

}
