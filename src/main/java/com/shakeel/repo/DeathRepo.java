package com.shakeel.repo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.shakeel.model.Birth;
import com.shakeel.model.Death;

public interface DeathRepo {

	public void save(String district, String state, String address, String mobile, String gender, String dname,
			String nominee, String nomineeName, String placeOfBirth, String hospitalName, String date, String time,
			MultipartFile deathImg, String status, int userId, int paymentId);

	public void delete(int deathId);

	public List<Death> getAllDeaths();

	public void update(Death dth);

	public Death findById(int deathId);

	public Death findByUserId(int userId);

	List<Death> findApprovedDeathsByAdmin();

}
