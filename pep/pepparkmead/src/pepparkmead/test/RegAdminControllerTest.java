package pepparkmead.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.ModelMap;

import pepparkmead.controller.RegAdminController;
import pepparkmead.data.Registration;

public class RegAdminControllerTest {

	private Long S_ID = new Long(10);
	private Long C_ID = new Long(40);
	
	private RegAdminController c;
	private ModelMap m;
	private DummyDataMgr db;
	
	@Before
	public void setUp() throws Exception {
		c = new RegAdminController();
		m = new ModelMap();
		db = new DummyDataMgr();
		c.setDataMgr(db);
	}

	@Test
	public void testShowRegistrants() {
	}

	@Test
	public void testUnregister() {
		db.registration = testReg(null);
		assertFalse(db.bDeleteCalled);
		assertTrue(db.registration.isRegisteredFor(C_ID));
		String v = c.unregister(S_ID, C_ID, m);
		assertEquals("ReportReg", v);
		assertTrue(db.bDeleteCalled);
	}

	@Test
	public void testUnregisterTwoClasses() {
		db.registration = testReg(new Long(3423));
		assertFalse(db.bDeleteCalled);
		assertTrue(db.registration.isRegisteredFor(C_ID));
		String v = c.unregister(S_ID, C_ID, m);
		assertEquals("ReportReg", v);
		assertFalse(db.bDeleteCalled);
		assertFalse(db.registration.isRegisteredFor(C_ID));
	}
	
	private Registration testReg(Long addClass) {
		Registration r = new Registration();
		r.setID(S_ID);
		r.addClassID(C_ID);
		if (addClass != null) {
			r.addClassID(addClass);
		}
		return r;
	}

}
