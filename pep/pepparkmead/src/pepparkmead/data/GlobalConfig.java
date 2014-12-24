package pepparkmead.data;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class GlobalConfig {

	public final static String KEY = "PEPParkmeadConfig";
	@SuppressWarnings("unused")
	@PrimaryKey
    private String id = KEY;

	@Persistent
	private String currentSemester;	

	@Persistent
	private boolean mailVendor;	

	@Persistent
	private boolean registrationOn;

  @Persistent
  private String registrationClosedMessage;

	public String getCurrentSemester() {
		return currentSemester;
	}

	public void setCurrentSemester(String c) {
		this.currentSemester = c;
	}
	
	public String toString() { return getCurrentSemester(); }

	public boolean getMailVendor() {
		return mailVendor;
	}

	public void setMailVendor(boolean mailVendor) {
		this.mailVendor = mailVendor;
	}
	
	public boolean getRegistrationOn() {
		return registrationOn;
	}
	
	public void setRegistrationOn(boolean b) {
		this.registrationOn = b;
	}

  public String getRegistrationClosedMessage() {
    return registrationClosedMessage;
  }

  public void setRegistrationClosedMessage(String registrationClosedMessage) {
    this.registrationClosedMessage = registrationClosedMessage;
  }
}
