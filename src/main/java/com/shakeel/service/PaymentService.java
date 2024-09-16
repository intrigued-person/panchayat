package com.shakeel.service;

import java.util.List;

import com.shakeel.model.Approval;
import com.shakeel.model.Payment;

public interface PaymentService {
	
	public void addPayment(Payment pay);

	public void delPayment(int payId);

	public void updatePayment(Payment pay);

	public List<Payment> getAllPayments();

	public Payment findById(int payId);

	public Payment findByUserId(int userId);

}
