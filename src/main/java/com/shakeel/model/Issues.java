package com.shakeel.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;

@Entity
public class Issues {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int issueId;

	private String issueType;

	private String description;

	private String location;

	private String status;

	@Lob
	@Column(columnDefinition = "LONGBLOB", length = 1000000)
	private byte[] proofImage;

	@ManyToOne
	private User user;

	public Issues() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Issues(int issueId, String issueType, String description, String location, String status, byte[] proofImage,
			User user) {
		super();
		this.issueId = issueId;
		this.issueType = issueType;
		this.description = description;
		this.location = location;
		this.status = status;
		this.proofImage = proofImage;
		this.user = user;
	}

	public int getIssueId() {
		return issueId;
	}

	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}

	public String getIssueType() {
		return issueType;
	}

	public void setIssueType(String issueType) {
		this.issueType = issueType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public byte[] getProofImage() {
		return proofImage;
	}

	public void setProofImage(byte[] proofImage) {
		this.proofImage = proofImage;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
