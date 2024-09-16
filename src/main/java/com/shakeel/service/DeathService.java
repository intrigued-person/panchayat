package com.shakeel.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.shakeel.model.Birth;
import com.shakeel.model.Death;

public interface DeathService {

	public void addDeath(String district, String state, String address, String mobile, String gender, String dname,
			String nominee, String nomineeName, String placeOfBirth, String hospitalName, String date, String time,
			MultipartFile deathImg, String status, LocalDateTime generate, int userId, int paymentId);

	public void delDeath(int deathId);

	public void updateDeath(Death dth);

	public List<Death> getAllDeaths();

	public Death findById(int deathId);

	public boolean update(int deathId, String status);

	public Death findByUserId(int userId);
}
