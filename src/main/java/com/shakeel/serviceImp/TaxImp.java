package com.shakeel.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shakeel.model.Approval;
import com.shakeel.model.Tax;
import com.shakeel.repos.TaxRepoImp;
import com.shakeel.service.TaxService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TaxImp implements TaxService {

	@Autowired
	TaxRepoImp repo;

	@Override
	public void addTax(Tax tx) {
		repo.save(tx);
	}

	@Override
	public void delTax(int taxId) {
		repo.delete(taxId);
	}

	@Override
	public void updateTax(Tax tx) {
		repo.update(tx);
	}

	@Override
	public List<Tax> getAllTaxes() {
		return repo.getAllTaxes();
	}

	@Override
	public Tax findById(int taxId) {
		return repo.findById(taxId);
	}

	@Override
	public Tax findByUserId(int userId) {
		// TODO Auto-generated method stub
		return repo.findByUserId(userId);
	}

	@Override
	public boolean updateTax(int taxId, String status) {
		try {
			Tax app = repo.findById(taxId);
			if (app != null) {
				app.setStatus(status);
				repo.update(app);
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace(); // Add logging to see the exception details
			return false;
		}
	}

}
