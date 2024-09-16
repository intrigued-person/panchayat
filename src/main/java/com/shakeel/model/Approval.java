package com.shakeel.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Approval {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int appId;

	private String mobileNo;

	private String appName;

	private String gender;

	private String doorNo;

	private String streetName;

	private String city;

	private String aadhar;

	private String gst;

	// dropdown
	private String tradeloc;

	// dropdown
	private String validity;

	// commercial / industry
	private String type;

	// own or rented
	private String property;

	private String status;

	private LocalDateTime generate;

	@Lob
	@Column(columnDefinition = "LONGBLOB", length = 1000000)
	private byte[] appImage;

	@Lob
	@Column(columnDefinition = "LONGBLOB", length = 1000000)
	private byte[] addressProof;

	@Lob
	@Column(columnDefinition = "LONGBLOB", length = 1000000)
	private byte[] propertyTax;

	@Lob
	@Column(columnDefinition = "LONGBLOB", length = 1000000)
	private byte[] noc;

	@ManyToOne
	@JoinColumn(name = "user_Id")
	private User user;

	@OneToOne
	@JoinColumn(name = "payment_Id")
	private Payment payment;

	public Approval() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Approval(int appId, String mobileNo, String appName, String gender, String doorNo, String streetName,
			String city, String aadhar, String gst, String tradeloc, String validity, String type, String property,
			String status, LocalDateTime generate, byte[] appImage, byte[] addressProof, byte[] propertyTax, byte[] noc,
			User user, Payment payment) {
		super();
		this.appId = appId;
		this.mobileNo = mobileNo;
		this.appName = appName;
		this.gender = gender;
		this.doorNo = doorNo;
		this.streetName = streetName;
		this.city = city;
		this.aadhar = aadhar;
		this.gst = gst;
		this.tradeloc = tradeloc;
		this.validity = validity;
		this.type = type;
		this.property = property;
		this.status = status;
		this.generate = generate;
		this.appImage = appImage;
		this.addressProof = addressProof;
		this.propertyTax = propertyTax;
		this.noc = noc;
		this.user = user;
		this.payment = payment;
	}

	public int getAppId() {
		return appId;
	}

	public void setAppId(int appId) {
		this.appId = appId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAadhar() {
		return aadhar;
	}

	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}

	public String getGst() {
		return gst;
	}

	public void setGst(String gst) {
		this.gst = gst;
	}

	public String getTradeloc() {
		return tradeloc;
	}

	public void setTradeloc(String tradeloc) {
		this.tradeloc = tradeloc;
	}

	public String getValidity() {
		return validity;
	}

	public void setValidity(String validity) {
		this.validity = validity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public byte[] getAppImage() {
		return appImage;
	}

	public void setAppImage(byte[] appImage) {
		this.appImage = appImage;
	}

	public byte[] getAddressProof() {
		return addressProof;
	}

	public void setAddressProof(byte[] addressProof) {
		this.addressProof = addressProof;
	}

	public byte[] getPropertyTax() {
		return propertyTax;
	}

	public void setPropertyTax(byte[] propertyTax) {
		this.propertyTax = propertyTax;
	}

	public byte[] getNoc() {
		return noc;
	}

	public void setNoc(byte[] noc) {
		this.noc = noc;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getGenerate() {
		return generate;
	}

	public void setGenerate(LocalDateTime generate) {
		this.generate = generate;
	}

}
