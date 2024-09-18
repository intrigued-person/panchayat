package com.shakeel.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;

@Entity
public class Death {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int deathId;

	private String district;

	private String state;

	private String address;

	private String mobile;

	private String gender;

	private String dname;

	private String nominee;

	private String nomineeName;

	private String placeOfBirth;

	private String hospitalName;

	private String date;

	private String time;

	@Lob
	@Column(columnDefinition = "LONGBLOB", length = 1000000)
	private byte[] deathImg;

	private String status;

	@OneToOne
	private User user;

	@OneToOne
	private Payment payment;

	public Death() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Death(int deathId, String district, String state, String address, String mobile, String gender, String dname,
			String nominee, String nomineeName, String placeOfBirth, String hospitalName, String date, String time,
			byte[] deathImg, String status, User user, Payment payment) {
		super();
		this.deathId = deathId;
		this.district = district;
		this.state = state;
		this.address = address;
		this.mobile = mobile;
		this.gender = gender;
		this.dname = dname;
		this.nominee = nominee;
		this.nomineeName = nomineeName;
		this.placeOfBirth = placeOfBirth;
		this.hospitalName = hospitalName;
		this.date = date;
		this.time = time;
		this.deathImg = deathImg;
		this.status = status;
		this.user = user;
		this.payment = payment;
	}

	public int getDeathId() {
		return deathId;
	}

	public void setDeathId(int deathId) {
		this.deathId = deathId;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getNominee() {
		return nominee;
	}

	public void setNominee(String nominee) {
		this.nominee = nominee;
	}

	public String getNomineeName() {
		return nomineeName;
	}

	public void setNomineeName(String nomineeName) {
		this.nomineeName = nomineeName;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public byte[] getDeathImg() {
		return deathImg;
	}

	public void setDeathImg(byte[] deathImg) {
		this.deathImg = deathImg;
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

}
