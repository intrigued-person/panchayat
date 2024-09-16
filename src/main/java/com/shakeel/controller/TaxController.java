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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shakeel.model.Issues;
import com.shakeel.model.Tax;
import com.shakeel.serviceImp.TaxImp;

@RestController
@RequestMapping("/tax")
@CrossOrigin("*")
public class TaxController {

	@Autowired
	TaxImp service;

	static final String SUCCESS = "Success";
	static final String FAILURE = "Failure";

	@GetMapping("/findTaxByUserId/{userId}")
	public Tax findByUserId(@PathVariable("userId") int userId) {
		return service.findByUserId(userId);

	}

	@PostMapping
	public String insertTax(@RequestBody Tax tx) {
		String msg = "";
		try {
			service.addTax(tx);
			msg = "tax added";
		} catch (Exception e) {
			msg = "failed to add tax";
		}
		return msg;
	}

	@GetMapping("/allTaxes")
	public List<Tax> getAllTaxes() {
		return service.getAllTaxes();
	}

	@PostMapping("/updateTaxStatus")
	public ResponseEntity<String> updateStatus(@RequestBody Map<String, Object> payload) {
		try {
			int taxId = (Integer) payload.get("id");
			String status = (String) payload.get("status");

			boolean result = service.updateTax(taxId, status);
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

}
