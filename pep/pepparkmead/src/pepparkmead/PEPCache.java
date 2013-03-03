package pepparkmead;

import java.util.List;

import pepparkmead.data.GlobalConfig;
import pepparkmead.data.IDbID;
import pepparkmead.data.PEPClass;
import pepparkmead.data.Registration;
import pepparkmead.data.Vendor;

public class PEPCache implements IPEPDataMgr {
	
	private List<Vendor> vendorCache;
	private IPEPDataMgr dataMgr;
	
	public void setDataMgr(IPEPDataMgr mgr) {
		dataMgr = mgr;
	}
	
	synchronized public void invalidateVendors() {
		vendorCache = null;
	}
	
	synchronized public List<Vendor> getAllVendors() {
		if (vendorCache == null)
			vendorCache = dataMgr.getAllVendors();
		return vendorCache;
	}

	@Override
	public Vendor getVendor(Long ID) {
		getAllVendors();
		for (Vendor v : vendorCache) {
			if (v.getID().equals(ID.toString()))
				return v;
		}
		return null;
	}

	@Override
	public void addClass(PEPClass c) {
		dataMgr.addClass(c);
	}

	@Override
	public List<PEPClass> getAllClasses(String semester) {
		return dataMgr.getAllClasses(semester);
	}

	@Override
	public PEPClass getClass(Long classID) {
		return dataMgr.getClass(classID);
	}

	@Override
	public void save(Object o) {
		if (o instanceof Vendor)
			this.invalidateVendors();
		dataMgr.save(o);
	}

	@Override
	public List<Registration> getRegistrationsForClass(Long classId) {
		return dataMgr.getRegistrationsForClass(classId);
	}

	@Override
	public Registration getRegistration(Long id) {
		return dataMgr.getRegistration(id);
	}

	@Override
	public void delete(Class c, IDbID dbObj) {
		dataMgr.delete(c, dbObj);
	}

	@Override
	public GlobalConfig getConfig() {
		return dataMgr.getConfig();
	}

	@Override
	public void saveConfig(GlobalConfig c) {
		dataMgr.saveConfig(c);
	}
}
