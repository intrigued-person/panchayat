package com.shakeel.serviceImp;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.shakeel.model.Birth;
import com.shakeel.model.Death;
import com.shakeel.repos.DeathRepoImp;
import com.shakeel.service.DeathService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DeathImp implements DeathService {

	@Autowired
	DeathRepoImp repo;

	@Override
	public void delDeath(int deathId) {
		repo.delete(deathId);
	}

	@Override
	public void updateDeath(Death dth) {
		repo.update(dth);
	}

	@Override
	public List<Death> getAllDeaths() {
		return repo.getAllDeaths();
	}

	@Override
	public Death findById(int deathId) {
		return repo.findById(deathId);
	}

	@Override
	public void addDeath(String district, String state, String address, String mobile, String gender, String dname,
			String nominee, String nomineeName, String placeOfBirth, String hospitalName, String date, String time,
			MultipartFile deathImg, String status, LocalDateTime generate, int userId, int paymentId) {
		repo.save(district, state, address, mobile, gender, dname, nominee, nomineeName, placeOfBirth, hospitalName,
				date, time, deathImg, status, generate, userId, paymentId);

	}

	@Override
	public boolean update(int deathId, String status) {
		try {
			Death bt = repo.findById(deathId);
			if (bt != null) {
				bt.setStatus(status);
				repo.update(bt);
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace(); // Add logging to see the exception details
			return false;
		}
	}

	@Override
	public Death findByUserId(int userId) {
		return repo.findByUserId(userId);
	}

}
