package pepparkmead.test;

import java.util.ArrayList;
import java.util.List;

import pepparkmead.IDataMgr;
import pepparkmead.data.GlobalConfig;
import pepparkmead.data.IDbID;
import pepparkmead.data.PEPClass;
import pepparkmead.data.Registration;
import pepparkmead.data.Vendor;

public class DummyDataMgr implements IDataMgr {

	public List<PEPClass> pepClasses = new ArrayList<PEPClass>();
	public Registration registration;
	public boolean bDeleteCalled = false;
	public boolean bAllVendorsCalled = false;
	public List<Vendor> vendors = null;
	
	@Override
	public void addClass(PEPClass c) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<PEPClass> getAllClasses(String semester) {
		return pepClasses;
	}

	@Override
	public List<Vendor> getAllVendors() {
		bAllVendorsCalled = true;
		return vendors;
	}

	@Override
	public Vendor getVendor(Long ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PEPClass getClass(Long classID) {
		// TODO Auto-generated method stub
		return pepClasses.get(0);
	}

	@Override
	public List<Registration> getRegistrationsForClass(Long classId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Registration getRegistration(Long id) {
		return registration;
	}

	@Override
	public void delete(@SuppressWarnings("rawtypes") Class c, IDbID dbObj) {
		bDeleteCalled = true;		
	}

	@Override
	public void save(Object o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public GlobalConfig getConfig() {
		GlobalConfig c = new GlobalConfig();
		c.setCurrentSemester("W13");
		return c;
	}

	@Override
	public void saveConfig(GlobalConfig c) {
		// TODO Auto-generated method stub
		
	}

}
