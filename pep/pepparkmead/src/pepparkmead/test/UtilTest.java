package pepparkmead.test;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import pepparkmead.controller.ReportController.ReportItem;
import pepparkmead.data.PEPClass;
import pepparkmead.util.Util;

public class UtilTest {

	private ReportItem item;
	@Before
	public void setUp() throws Exception {
		item = new ReportItem();
		item.cl = new PEPClass();
	}

	@Test
	public void testAddRegIfSameClass() {
		assertFalse(Util.isRegisteredForClass(item, TestUtil.testReg));
	}

	@Test
	public void testIsEmpty() {
		assertTrue(Util.isEmpty(null));
		assertTrue(Util.isEmpty(""));
		assertFalse(Util.isEmpty(" "));
		assertFalse(Util.isEmpty("gg"));
	}
	
	@Test
	public void testFriendlySemesterName() {
		assertEquals("", Util.getFriendlySemesterString(null));
		assertEquals("", Util.getFriendlySemesterString("   \t"));
		assertEquals("Spring 2013", Util.getFriendlySemesterString("S13"));
		assertEquals("Fall 2015", Util.getFriendlySemesterString("F15"));
		assertEquals("Winter 2013", Util.getFriendlySemesterString("W13"));
		assertEquals("Winter 2013", Util.getFriendlySemesterString(" W13"));
    assertEquals("Spring 2018", Util.getFriendlySemesterString("S18"));
	}

}
