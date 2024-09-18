package com.shakeel.repo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.shakeel.model.Birth;

public interface BirthRepo {

	public Birth save(String district, String mobile, String emailId, String dob, String gender, String childName,
			String fatherName, String motherName, String address, String state, String placeOfBirth,
			String hospitalName, String town, String religion, String focup, String mocup, String motherMrgYr,
			String motherBirthYr, String certificateType, String status, MultipartFile hospitalImg, Integer userId,
			String reason, Integer paymentId);

	public void delete(int birthId);

	public List<Birth> getAllBirths();

	public void update(Birth bth);

	public Birth findById(int birthId);

	public Birth findByUserId(int userId);

	List<Birth> findApprovedBirthsByAdmin();

}
