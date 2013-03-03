package pepparkmead.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import pepparkmead.PEPCache;
import pepparkmead.data.Vendor;

public class PEPCacheTest {

	private DummyDataMgr testMgr;
	private PEPCache c;
	private Vendor vendor;

	@Before
	public void setUp() throws Exception {
		testMgr = new DummyDataMgr();
		testMgr.vendors = new ArrayList<Vendor>();
		vendor = new Vendor();
		vendor.setID("1234");
		testMgr.vendors.add(vendor);
		c = new PEPCache();
		c.setDataMgr(testMgr);		
	}

	@Test
	public void testVendorCache() {
		checkLoadedFromDataMgr();
		checkGotFromCache(2);
		c.invalidateVendors();
		this.checkLoadedFromDataMgr();
		this.checkGotFromCache(3);
	}
	
	@Test
	public void testGetVendor() {
		Vendor v = c.getVendor(new Long(1234));
		assertTrue(v == vendor);
	}
	
	@Test
	public void testCacheClearedAfterSave() {
		checkLoadedFromDataMgr();
		c.save(new Vendor());
		checkLoadedFromDataMgr();
		this.checkGotFromCache(3);
	}

	private void checkLoadedFromDataMgr() {
		testMgr.bAllVendorsCalled = false;
		List<Vendor> v = c.getAllVendors();
		assertTrue(testMgr.bAllVendorsCalled);
	}

	private void checkGotFromCache(int cnt) {
		List<Vendor> v;
		testMgr.bAllVendorsCalled = false;
		for (int i=0; i<cnt; i++) {
			v = c.getAllVendors();
			assertFalse(testMgr.bAllVendorsCalled);
		}
	}

}
