package pepparkmead.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.ModelMap;

import pepparkmead.controller.ReportController;
import pepparkmead.controller.ReportController.ReportItem;

public class ReportControllerTest {

	private ReportController c;
	private ModelMap model;
	private DummyDataMgr mgr;
	
	@Before
	public void setUp() throws Exception {
		c = new ReportController();
		model = new ModelMap();
		mgr = new DummyDataMgr();
		c.setDataMgr(mgr);
	}

	@Test
	public void testMasterScheduleNoData() {
		mgr.pepClasses = null;
		masterReportTest(0);
	}

	@Test
	public void testMasterSchedule() {
		mgr.pepClasses.add(TestUtil.testClass);
		mgr.pepClasses.add(TestUtil.testClass);
		masterReportTest(2);
	}

	private void masterReportTest(final int exp) {
		String v = c.masterSchedule(model);
		assertEquals("ReportMasterSchedule", v);
		List<ReportItem> l = getReportItems();
		assertEquals(exp, l.size());
	}

	private List<ReportItem> getReportItems() {
		return (List<ReportItem>)model.get("reportItems");
	}

	@Test
	public void testEmergencyReport() {
	}

	@Test
	public void testKeyspotReport() {
	}

}
