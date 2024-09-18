package com.shakeel.controller;

import java.util.List;

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
import com.shakeel.model.Payment;
import com.shakeel.serviceImp.PaymentImp;

@RestController
@RequestMapping("/payment")
@CrossOrigin("*")
public class PaymentController {

	@Autowired
	PaymentImp service;

	@GetMapping("/findPaymentByUserId/{userId}")
	public Payment findByUserId(@PathVariable("userId") int userId) {
		return service.findByUserId(userId);

	}

//	@PostMapping
//	public String addPay(@RequestBody Payment pay) {
//		String msg = "";
//		try {
//			service.addPayment(pay);
//			msg = "payment success";
//		} catch (Exception e) {
//			msg = "fail to pay";
//		}
//		return msg;
//
//	}

	@PostMapping
	public ResponseEntity<Payment> addPays(@RequestBody Payment pay) {
		try {
			Payment response = service.addPayment(pay);
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

	@GetMapping("/allPays")
	public List<Payment> getAllPays() {
		return service.getAllPayments();
	}

}
