package com.shakeel.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.shakeel.model.Approval;

public interface ApprovalRepo {

	public void save(String mobileNo, String appName, String gender, String doorNo, String streetName, String city,
			String aadhar, String gst, String tradeloc, String validity, String type, String property, String status,
			LocalDateTime generate, MultipartFile appImage, MultipartFile addressProof, MultipartFile propertyTax,
			MultipartFile noc, int userId, int paymentId);

	public void delete(int appId);

	public List<Approval> getAllApprovals();

	public void update(Approval app);

	public Approval findById(int appId);

	public Approval findByUserId(int userId);

}
