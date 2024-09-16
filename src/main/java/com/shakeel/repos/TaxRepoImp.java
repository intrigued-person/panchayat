package com.shakeel.repos;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shakeel.model.Approval;
import com.shakeel.model.Tax;
import com.shakeel.repo.TaxRepo;

import jakarta.persistence.EntityManager;

@Repository
public class TaxRepoImp implements TaxRepo {

	@Autowired
	EntityManager em;

	@Override
	public void save(Tax tx) {
		em.persist(tx);
	}

	@Override
	public void delete(int taxId) {
		Tax tx = em.find(Tax.class, taxId);
		if (tx != null) {
			em.remove(tx);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tax> getAllTaxes() {
		return em.createQuery("from Tax").getResultList();
	}

	@Override
	public void update(Tax tx) {
		em.merge(tx);
	}

	@Override
	public Tax findById(int taxId) {
		Query<Tax> q = (Query<Tax>) em.createQuery("from Tax where id = ?1");
		q.setParameter(1, taxId);
		return (Tax) q.getSingleResult();

	}

	@Override
	public Tax findByUserId(int userId) {
		try {
			Query<Tax> query = (Query<Tax>) em.createQuery("from Tax where user.userId = ?1", Tax.class).setParameter(1,
					userId);
			return query.getSingleResult();

		} catch (Exception e) {
			return null;
		}

	}

}
