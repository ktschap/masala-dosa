package pepparkmead.data;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Vendor {
	
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long ID;

	@Persistent
    private String vendorName;
	@Persistent
    private String contact;
	@Persistent
    private String contactEmail;
	@Persistent
    private String contactPhone;
	@Persistent
    private String instructor;
	@Persistent
    private String instructorEmail;
	@Persistent
    private String instructorPhone;
	@Persistent
    private String liaison;
	@Persistent
    private String liaisonEmail;
	@Persistent
    private String liaisonPhone;
	@Persistent
	private String address;
	@Persistent
	private String notes;
	@Persistent
	private String facilityUseFormDate;
	@Persistent
	private String wcsdPaymentDate;
	@Persistent
	private String percPaymentDate;
	@Persistent
	private String vendorInformationSheetDate;
	@Persistent
	private String fingerprintDate;
	@Persistent
	private String tbTestDate;

	public Vendor() {}
	
	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getLiaisonPhone() {
		return liaisonPhone;
	}

	public void setLiaisonPhone(String p) {
		this.liaisonPhone = p;
	}

	public String getLiaisonEmail() {
		return liaisonEmail;
	}

	public void setLiaisonEmail(String e) {
		this.liaisonEmail = e;
	}

	public String getLiaison() {
		return liaison;
	}

	public void setLiaison(String l) {
		this.liaison = l;
	}

	public String getInstructorPhone() {
		return instructorPhone;
	}

	public void setInstructorPhone(String instructorPhone) {
		this.instructorPhone = instructorPhone;
	}

	public String getInstructorEmail() {
		return instructorEmail;
	}

	public void setInstructorEmail(String instructorEmail) {
		this.instructorEmail = instructorEmail;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getID() {
		return (ID != null) ? ID.toString() : null;
	}

	public void setID(String ID) {
		this.ID = Long.valueOf(ID);
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getFacilityUseFormDate() {
		return facilityUseFormDate;
	}

	public void setFacilityUseFormDate(String facilityUseFormDate) {
		this.facilityUseFormDate = facilityUseFormDate;
	}

	public String getWcsdPaymentDate() {
		return wcsdPaymentDate;
	}

	public void setWcsdPaymentDate(String wcsdPaymentDate) {
		this.wcsdPaymentDate = wcsdPaymentDate;
	}

	public String getPercPaymentDate() {
		return percPaymentDate;
	}

	public void setPercPaymentDate(String percPaymentDate) {
		this.percPaymentDate = percPaymentDate;
	}

	public String getVendorInformationSheetDate() {
		return vendorInformationSheetDate;
	}

	public void setVendorInformationSheetDate(String vendorInformationSheetDate) {
		this.vendorInformationSheetDate = vendorInformationSheetDate;
	}

	public String getFingerprintDate() {
		return fingerprintDate;
	}

	public void setFingerprintDate(String fingerprintDate) {
		this.fingerprintDate = fingerprintDate;
	}

	public String getTbTestDate() {
		return tbTestDate;
	}

	public void setTbTestDate(String tbTestDate) {
		this.tbTestDate = tbTestDate;
	}


}
