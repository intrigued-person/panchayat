package com.shakeel.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.shakeel.model.Birth;
import com.shakeel.repos.BirthRepoImp;
import com.shakeel.service.BirthService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BirthImp implements BirthService {

	@Autowired
	BirthRepoImp repo;

	@Override
	public void delBirth(int birthId) {
		repo.delete(birthId);
	}

	@Override
	public void updateBirth(Birth bth) {
		repo.update(bth);
	}

	@Override
	public List<Birth> getAllBirths() {
		return repo.getAllBirths();
	}

	@Override
	public Birth findById(int birthid) {
		return repo.findById(birthid);
	}

	@Override
	public Birth addBirth(String district, String mobile, String emailId, String dob, String gender, String childName,
			String fatherName, String motherName, String address, String state, String placeOfBirth,
			String hospitalName, String town, String religion, String focup, String mocup, String motherMrgYr,
			String motherBirthYr, String certificateType, String status, MultipartFile hospitalImg, Integer userId,
			String reason, Integer paymentId) {
		try {
			Birth bth = repo.save(district, mobile, emailId, dob, gender, childName, fatherName, motherName, address,
					state, placeOfBirth, hospitalName, town, religion, focup, mocup, motherMrgYr, motherBirthYr,
					certificateType, status, hospitalImg, userId, reason, paymentId);
			return bth;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean update(int birthId, String status) {
		try {
			Birth bt = repo.findById(birthId);
			if (bt != null) {
				bt.setStatus(status);
				repo.update(bt);
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Birth findByUserId(int userId) {
		return repo.findByUserId(userId);
	}

	@Override
	public List<Birth> findApprovedBirthsByAdmin() {
		return repo.findApprovedBirthsByAdmin();
	}

}
