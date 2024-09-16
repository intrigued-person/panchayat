package com.shakeel.service;

import java.util.List;

import com.shakeel.model.Approval;
import com.shakeel.model.Tax;

public interface TaxService {

	public void addTax(Tax tx);

	public void delTax(int taxId);

	public void updateTax(Tax tx);

	public List<Tax> getAllTaxes();

	public Tax findById(int taxId);

	public Tax findByUserId(int userId);

	public boolean updateTax(int taxId, String status);

}
