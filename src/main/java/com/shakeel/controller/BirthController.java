package com.shakeel.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.shakeel.model.Birth;
import com.shakeel.serviceImp.BirthImp;

@RestController
@RequestMapping("/birth")
@CrossOrigin("*")
public class BirthController {

	@Autowired
	BirthImp service;

	static final String SUCCESS = "Success";
	static final String FAILURE = "Failure";

	@PostMapping
	public ResponseEntity<Birth> insertBirth(@RequestParam String district, @RequestParam String mobile,
			@RequestParam String emailId, @RequestParam String dob, @RequestParam String gender,
			@RequestParam String childName, @RequestParam String fatherName, @RequestParam String motherName,
			@RequestParam String address, @RequestParam String state, @RequestParam String placeOfBirth,
			@RequestParam String hospitalName, @RequestParam String town, @RequestParam String religion,
			@RequestParam String focup, @RequestParam String mocup, @RequestParam String motherMrgYr,
			@RequestParam String motherBirthYr, @RequestParam String certificateType, @RequestParam String status,
			@RequestParam MultipartFile hospitalImg, @RequestParam Integer userId, @RequestParam String reason,
			@RequestParam Integer paymentId) {

		try {

			Birth response = service.addBirth(district, mobile, emailId, dob, gender, childName, fatherName, motherName,
					address, state, placeOfBirth, hospitalName, town, religion, focup, mocup, motherMrgYr,
					motherBirthYr, certificateType, status, hospitalImg, userId, reason, paymentId);

			if (response != null) {
				return ResponseEntity.status(HttpStatus.CREATED).body(response);
			} else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}

		} catch (Exception e) {
			e.printStackTrace(); // Log the exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PostMapping("/updateBirthStatus")
	public ResponseEntity<String> updateStatus(@RequestBody Map<String, Object> payload) {
		try {
			int birthId = (Integer) payload.get("birthId");
			String status = (String) payload.get("status");

			boolean result = service.update(birthId, status);
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

	@GetMapping("/allBirths")
	public List<Birth> getAll() {
		return service.getAllBirths();
	}

	@GetMapping("/findBirthByUserId/{userId}")
	public Birth findByUserId(@PathVariable("userId") int userId) {
		return service.findByUserId(userId);

	}

	@DeleteMapping("/delete/{birthId}")
	public ResponseEntity<String> deleteBirth(@PathVariable("birthId") int birthId) {
		try {
			service.delBirth(birthId);
			return ResponseEntity.ok("Birth record deleted successfully");
		} catch (Exception e) {
			e.printStackTrace(); // Log the exception
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete birth record");
		}
	}

	@GetMapping("/approvedBirth")
	public ResponseEntity<List<Birth>> getApprovedApplications() {
		List<Birth> birth = service.findApprovedBirthsByAdmin();
		return ResponseEntity.ok(birth);
	}

	@GetMapping("/findBirth/{birthId}")
	public Birth findBirthbyBirthId(@PathVariable("birthId") int birthId) {
		return service.findById(birthId);
	}

}
