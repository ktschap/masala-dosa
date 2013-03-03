package pepparkmead.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.ModelMap;

import pepparkmead.EmailMsgFormatter;
import pepparkmead.ISender;
import pepparkmead.controller.RegistrationController;
import pepparkmead.data.Registration;
import pepparkmead.data.Vendor;

public class RegistrationControllerTest {

	private RegistrationController controller;
	
	@Before
	public void setUp() throws Exception {
		controller = new RegistrationController();
		DummyDataMgr dmgr = new DummyDataMgr();
		dmgr.pepClasses.add(TestUtil.testClass);
		dmgr.vendors = new ArrayList<Vendor>();
		controller.setDataMgr(dmgr);
		controller.setMessageFormatter(new EmailMsgFormatter());
		controller.setMessageSender(new ISender() {
			public void send(String toAddr, Set<String> ccs, String fromAddr, String sender,
					String msg) { assertNotNull(msg); }
		});
	}

	@Test
	public void testCreateNewSemester() {
		Registration reg = new Registration();
		reg.setStudentNameFirst("Billy");
		reg.setStudentNameLast("Bob");
		String ret = controller.registerNow(null,
				reg, "___" + Long.MAX_VALUE + "___452___654___" + Long.MIN_VALUE,
				new ModelMap());
		assertEquals("Semesters", ret);
		List<Long> l = reg.getClassIDs();
		assertEquals(new Long(Long.MAX_VALUE), l.get(0));
		assertEquals(new Long(452), l.get(1));
		assertEquals(new Long(654), l.get(2));
		assertEquals(new Long(Long.MIN_VALUE), l.get(3));
	}
}
