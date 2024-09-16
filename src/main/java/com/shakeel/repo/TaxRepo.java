package com.shakeel.repo;

import java.util.List;

import com.shakeel.model.Approval;
import com.shakeel.model.Tax;

public interface TaxRepo {

	public void save(Tax tx);

	public void delete(int taxId);

	public List<Tax> getAllTaxes();

	public void update(Tax tx);

	public Tax findById(int taxId);

	public Tax findByUserId(int userId);

	

}
