package com.example.littleloomlocator.model;

import com.example.littleloomlocator.util.ChildAgeGroup;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "institutes")
public class Institute {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "unitNumber")
	private String unitNumber;
	
	@Column(name = "buildingNumber")
	private String buildingNumber;
	
	@Column(name = "street")
	private String street;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "province")
	private String province;
	
	@Column(name = "postalCode")
	private String postalCode;
	
	@Column(name = "contactName")
	private String contactName;
	
	@Column(name = "contactPhone")
	private String contactPhone;
	
	@Column(name = "webSite")
	private String webSite;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "programName")
	private String programName;
	
	@Column(name = "ageGroup")
	private ChildAgeGroup ageGroup;

	@Column(name = "programCapacity")
	private int programCapacity;
	
	@Column(name = "programRemainingSlots")
	private int programRemainingSlots;
	
	@Column(name = "waitlistingAllowed")
	private String waitlistingAllowed;
	
	@Column(name = "waitlistCapacity")
	private int waitlistCapacity;
	
	@Column(name="userId")
	private long userId;

	public Institute() {
		super();
	}

	public Institute(String name, String unitNumber, String buildingNumber, String street, String city, String province,
			String postalCode, String contactName, String contactPhone, String webSite, String email, 
			String programName, ChildAgeGroup ageGroup, int programCapacity, String waitlistingAllowed,
			int waitlistCapacity, long userId, int programRemainingSlots) {
		super();
		this.name = name;
		this.unitNumber = unitNumber;
		this.buildingNumber = buildingNumber;
		this.street = street;
		this.city = city;
		this.province = province;
		this.postalCode = postalCode;
		this.contactName = contactName;
		this.contactPhone = contactPhone;
		this.webSite = webSite;
		this.email = email;
		this.programName = programName;
		this.ageGroup = ageGroup;
		this.programCapacity = programCapacity;
		this.waitlistingAllowed = waitlistingAllowed;
		this.waitlistCapacity = waitlistCapacity;
		this.userId = userId;
		this.programRemainingSlots = programRemainingSlots;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getProgramRemainingSlots() {
		return programRemainingSlots;
	}

	public void setProgramRemainingSlots(int programRemainingSlots) {
		this.programRemainingSlots = programRemainingSlots;
	}
	
	public String getUnitNumber() {
		return unitNumber;
	}

	public void setUnitNumber(String unitNumber) {
		this.unitNumber = unitNumber;
	}

	public String getBuildingNumber() {
		return buildingNumber;
	}

	public void setBuildingNumber(String buildingNumber) {
		this.buildingNumber = buildingNumber;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public ChildAgeGroup getAgeGroup() {
		return ageGroup;
	}

	public void setAgeGroup(ChildAgeGroup ageGroup) {
		this.ageGroup = ageGroup;
	}

	public int getProgramCapacity() {
		return programCapacity;
	}

	public void setProgramCapacity(int programCapacity) {
		this.programCapacity = programCapacity;
	}

	public String getWaitlistingAllowed() {
		return waitlistingAllowed;
	}

	public void setWaitlistingAllowed(String waitlistingAllowed) {
		this.waitlistingAllowed = waitlistingAllowed;
	}

	public int getWaitlistCapacity() {
		return waitlistCapacity;
	}

	public void setWaitlistCapacity(int waitlistCapacity) {
		this.waitlistCapacity = waitlistCapacity;
	}
	
}
