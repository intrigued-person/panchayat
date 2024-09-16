package com.shakeel.repo;

import java.util.List;

import com.shakeel.model.Approval;
import com.shakeel.model.Payment;

public interface PaymentRepo {
	
	public void save(Payment pay);

	public void delete(int payId);

	public List<Payment> getAllPayments();

	public void update(Payment pay);
	
	public Payment findById(int payId);
	
	public Payment findByUserId(int userId);

}
