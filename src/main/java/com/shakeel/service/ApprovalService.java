package com.shakeel.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.shakeel.model.Approval;

public interface ApprovalService {

	public void addApproval(String mobileNo, String appName, String gender, String doorNo, String streetName,
			String city, String aadhar, String gst, String tradeloc, String validity, String type, String property,
			String status, LocalDateTime generate, MultipartFile appImage, MultipartFile addressProof,
			MultipartFile propertyTax, MultipartFile noc, int userId, int paymentId);

	public void delApproval(int appId);

	public void updateApproval(Approval app);

	public List<Approval> getAllApprovals();

	public Approval findById(int appId);

	public boolean updateApplication(int applicationId, String status);

	public Approval findByUserId(int userId);

}
