package com.shakeel.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;

@Entity
public class Birth {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int birthId;

	private String district;

	private String mobile;

	private String emailId;

	private String dob;

	private String gender;

	@Column(nullable = true)
	private String childName;

	private String fatherName;

	private String motherName;

	private String address;

	private String state;

	private String placeOfBirth;

	private String hospitalName;

	private String town;

	private String religion;

	private String focup;

	private String mocup;

	private String motherMrgYr;

	private String motherBirthYr;

	private String certificateType;

	private String status;

	private String reason;

	@Lob
	@Column(columnDefinition = "LONGBLOB", length = 1000000)
	private byte[] hospitalImg;

	@OneToOne
	private User user;

	@OneToOne
	private Payment payment;

	public Birth() {
		super();
	}

	public Birth(int birthId, String district, String mobile, String emailId, String dob, String gender,
			String childName, String fatherName, String motherName, String address, String state, String placeOfBirth,
			String hospitalName, String town, String religion, String focup, String mocup, String motherMrgYr,
			String motherBirthYr, String certificateType, String status, String reason, byte[] hospitalImg, User user,
			Payment payment) {
		super();
		this.birthId = birthId;
		this.district = district;
		this.mobile = mobile;
		this.emailId = emailId;
		this.dob = dob;
		this.gender = gender;
		this.childName = childName;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.address = address;
		this.state = state;
		this.placeOfBirth = placeOfBirth;
		this.hospitalName = hospitalName;
		this.town = town;
		this.religion = religion;
		this.focup = focup;
		this.mocup = mocup;
		this.motherMrgYr = motherMrgYr;
		this.motherBirthYr = motherBirthYr;
		this.certificateType = certificateType;
		this.status = status;
		this.reason = reason;
		this.hospitalImg = hospitalImg;
		this.user = user;
		this.payment = payment;
	}

	public int getBirthId() {
		return birthId;
	}

	public void setBirthId(int birthId) {
		this.birthId = birthId;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getChildName() {
		return childName;
	}

	public void setChildName(String childName) {
		this.childName = childName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getFocup() {
		return focup;
	}

	public void setFocup(String focup) {
		this.focup = focup;
	}

	public String getMocup() {
		return mocup;
	}

	public void setMocup(String mocup) {
		this.mocup = mocup;
	}

	public String getMotherMrgYr() {
		return motherMrgYr;
	}

	public void setMotherMrgYr(String motherMrgYr) {
		this.motherMrgYr = motherMrgYr;
	}

	public String getMotherBirthYr() {
		return motherBirthYr;
	}

	public void setMotherBirthYr(String motherBirthYr) {
		this.motherBirthYr = motherBirthYr;
	}

	public String getCertificateType() {
		return certificateType;
	}

	public void setCertificateType(String certificateType) {
		this.certificateType = certificateType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public byte[] getHospitalImg() {
		return hospitalImg;
	}

	public void setHospitalImg(byte[] hospitalImg) {
		this.hospitalImg = hospitalImg;
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

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

}
