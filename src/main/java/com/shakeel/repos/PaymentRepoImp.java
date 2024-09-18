package com.shakeel.repos;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shakeel.model.Approval;
import com.shakeel.model.Payment;
import com.shakeel.repo.PaymentRepo;

import jakarta.persistence.EntityManager;

@Repository
public class PaymentRepoImp implements PaymentRepo {

	@Autowired
	EntityManager em;

	@Override
	public Payment save(Payment pay) {
		em.persist(pay);
		return pay;
	}

	@Override
	public void delete(int payId) {
		Payment py = em.find(Payment.class, payId);
		if (py != null) {
			em.remove(py);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Payment> getAllPayments() {
		return em.createQuery("from Payment").getResultList();
	}

	@Override
	public void update(Payment pay) {
		em.merge(pay);
	}

	@Override
	public Payment findById(int payId) {
		Query<Payment> q = (Query<Payment>) em.createQuery("from Approval where paymentId = ?1");
		q.setParameter(1, payId);
		return (Payment) q.getSingleResult();

	}

	@Override
	public Payment findByUserId(int userId) {
		try {
			Query<Payment> query = (Query<Payment>) em.createQuery("from Payment where user.userId = ?1", Payment.class)
					.setParameter(1, userId);
			return query.getSingleResult();

		} catch (Exception e) {
			return null;
		}

	}

}
