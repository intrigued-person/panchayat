package com.shakeel.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.shakeel.model.Approval;
import com.shakeel.serviceImp.ApprovalImp;

@RestController
@RequestMapping("/approve")
@CrossOrigin("*")
public class ApprovalController {

	@Autowired
	ApprovalImp service;

	static final String SUCCESS = "Success";
	static final String FAILURE = "Failure";

	@PostMapping
	public String insertApproval(@RequestParam String mobileNo, @RequestParam String appName,
			@RequestParam String gender, @RequestParam String doorNo, @RequestParam String streetName,
			@RequestParam String city, @RequestParam String aadhar, @RequestParam String gst,
			@RequestParam String tradeloc, @RequestParam String validity, @RequestParam String type,
			@RequestParam String property, @RequestParam String status, @RequestParam LocalDateTime generate,
			@RequestParam MultipartFile appImage, @RequestParam MultipartFile addressProof,
			@RequestParam MultipartFile propertyTax, @RequestParam MultipartFile noc, @RequestParam int userId,
			@RequestParam int paymentId) {
		String msg = "";
		try {
			service.addApproval(mobileNo, appName, gender, doorNo, streetName, city, aadhar, gst, tradeloc, validity,
					type, property, status, generate, appImage, addressProof, propertyTax, noc, userId, paymentId);
			msg = SUCCESS;
		} catch (Exception e) {
			msg = FAILURE;
		}
		return msg;

	}

	@GetMapping("/allApprovals")
	public List<Approval> getAll() {
		return service.getAllApprovals();
	}

//	@PostMapping("/updateStatus")
//	public ResponseEntity<?> updateStatus(@RequestParam int appId, @RequestParam String status) {
//		try {
//			service.updateApplication(appId, status);
//			return ResponseEntity.ok("Success");
//		} catch (Exception e) {
//			return ResponseEntity.badRequest().body("Failed");
//		}
//	}
	@PostMapping("/updateStatus")
	public ResponseEntity<String> updateStatus(@RequestBody Map<String, Object> payload) {
		try {
			int appId = (Integer) payload.get("appId");
			String status = (String) payload.get("status");

			boolean result = service.updateApplication(appId, status);
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

	@GetMapping("/findApprovalByUserId/{userId}")
	public Approval findByUserId(@PathVariable("userId") int userId) {
		return service.findByUserId(userId);

	}

//teams
	@PutMapping("/updateApprove")
	public String updateApproveForm(Approval app) {
		String msg = "";
		try {
			service.updateApproval(app);
			msg = SUCCESS;
		} catch (Exception e) {
			msg = FAILURE;
		}
		return msg;
	}

}
