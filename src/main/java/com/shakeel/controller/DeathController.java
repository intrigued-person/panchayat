package com.shakeel.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.shakeel.model.Birth;
import com.shakeel.model.Death;
import com.shakeel.serviceImp.DeathImp;

@RestController
@RequestMapping("/death")
@CrossOrigin("*")
public class DeathController {

	@Autowired
	DeathImp service;

	static final String SUCCESS = "Success";
	static final String FAILURE = "Failure";

	@PostMapping
	public String insertDeath(@RequestParam String district, @RequestParam String state, @RequestParam String address,
			@RequestParam String mobile, @RequestParam String gender, @RequestParam String dname,
			@RequestParam String nominee, @RequestParam String nomineeName, @RequestParam String placeOfBirth,
			@RequestParam String hospitalName, @RequestParam String date, @RequestParam String time,
			@RequestParam MultipartFile deathImg, @RequestParam String status, @RequestParam int userId,
			@RequestParam int paymentId) {
		String msg = "";
		try {
			// LocalDateTime generateDateTime = LocalDateTime.parse(generate,
			// DateTimeFormatter.ISO_LOCAL_DATE_TIME);
			service.addDeath(district, state, address, mobile, gender, dname, nominee, nomineeName, placeOfBirth,
					hospitalName, date, time, deathImg, status, userId, paymentId);
			msg = SUCCESS;
		} catch (Exception e) {
			e.printStackTrace(); // Log the exception for debugging
			msg = FAILURE;
		}
		return msg;
	}

	@GetMapping("/allDeaths")
	public List<Death> getAllDeath() {
		return service.getAllDeaths();

	}

	@GetMapping("/findDeathByUserId/{userId}")
	public Death findByUserId(@PathVariable("userId") int userId) {
		return service.findByUserId(userId);

	}

	@PostMapping("/updateDeathStatus")
	public ResponseEntity<String> updateStatus(@RequestBody Map<String, Object> payload) {
		try {
			int deathId = (Integer) payload.get("deathId");
			String status = (String) payload.get("status");

			boolean result = service.update(deathId, status);
			if (result) {
				return ResponseEntity.ok(SUCCESS);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Approval not found");
			}
		} catch (Exception e) {
			e.printStackTrace(); // Log the exception for debugging
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(FAILURE);
		}
	}

	@GetMapping("/approvedDeath")
	public ResponseEntity<List<Death>> getApprovedApplications() {
		List<Death> birth = service.findApprovedDeathsByAdmin();
		return ResponseEntity.ok(birth);
	}
	
	@GetMapping("/findDeath/{deathId}")
	public Death findDeathbyDeathId(@PathVariable("deathId") int deathId) {
		return service.findById(deathId);
	}


}
