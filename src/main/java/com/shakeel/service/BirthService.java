package com.shakeel.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.shakeel.model.Approval;
import com.shakeel.model.Birth;

public interface BirthService {

	public Birth addBirth(String district, String mobile, String emailId, String dob, String gender, String childName,
			String fatherName, String motherName, String address, String state, String placeOfBirth,
			String hospitalName, String town, String religion, String focup, String mocup, String motherMrgYr,
			String motherBirthYr, String certificateType, String status, LocalDateTime generate,
			MultipartFile hospitalImg, Integer userId);

	public void delBirth(int birthId);

	public void updateBirth(Birth bth);

	public List<Birth> getAllBirths();

	public Birth findById(int birthid);

	public boolean update(int birthId, String status);

	public Birth findByUserId(int userId);

}
