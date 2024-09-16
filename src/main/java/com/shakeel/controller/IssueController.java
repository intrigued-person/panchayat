package com.shakeel.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.shakeel.model.Birth;
import com.shakeel.model.Issues;
import com.shakeel.serviceImp.IssueServImp;

@RestController
@CrossOrigin("*")
public class IssueController {

	@Autowired
	IssueServImp service;

	static final String SUCCESS = "Success";
	static final String FAILURE = "Failure";

	@PostMapping("/add")
	public String addIssues(@RequestParam String issueType, @RequestParam String description,
			@RequestParam String location, @RequestParam String status, @RequestParam MultipartFile proofImage,
			@RequestParam Integer userId) {
		String msg = "";
		try {
			service.addIssues(issueType, description, location, status, proofImage, userId);
			msg = "added";
		} catch (Exception e) {
			msg = "failed";
		}
		return msg;

	}

	@GetMapping("/allIssues")
	public List<Issues> getAllIssues() {
		return service.getAllIssues();

	}

	@PostMapping("/updateIssueStatus")
	public ResponseEntity<String> updateStatus(@RequestBody Map<String, Object> payload) {
		try {
			int issueId = (Integer) payload.get("issueId");
			String status = (String) payload.get("status");

			boolean result = service.update(issueId, status);
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

	@GetMapping("/findIssueByUserId/{userId}")
	public Issues findByUserId(@PathVariable("userId") int userId) {
		return service.findByUserId(userId);

	}

}
