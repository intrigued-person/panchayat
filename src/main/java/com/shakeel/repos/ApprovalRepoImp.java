package com.shakeel.repos;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.shakeel.model.Approval;
import com.shakeel.model.Payment;
import com.shakeel.model.User;
import com.shakeel.repo.ApprovalRepo;
import org.hibernate.query.Query;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;

@Repository
public class ApprovalRepoImp implements ApprovalRepo {

	@Autowired
	EntityManager em;

	@Override
	public void delete(int appId) {
		Approval ap = em.find(Approval.class, appId);
		if (ap != null) {
			em.remove(ap);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Approval> getAllApprovals() {
		return em.createQuery("from Approval").getResultList();
	}

	@Override
	public void update(Approval app) {
		em.merge(app);
	}

//	@SuppressWarnings("unchecked")
//	@Override
//	public Approval findById(int appId) {
//		Query<Approval> q = (Query<Approval>) em.createQuery("from Approval where appId = ?1");
//		q.setParameter(1, appId);
//		return (Approval) q.getSingleResult();
//	}

	@Override
	public Approval findById(int appId) {
		try {
			Query<Approval> q = (Query<Approval>) em.createQuery("from Approval where appId = :appId");
			q.setParameter("appId", appId);
			return q.getSingleResult();
		} catch (NoResultException e) {
			return null; // Handle case where no result is found
		}
	}

	@Override
	public void save(String mobileNo, String appName, String gender, String doorNo, String streetName, String city,
			String aadhar, String gst, String tradeloc, String validity, String type, String property, String status,
			LocalDateTime generate, MultipartFile appImage, MultipartFile addressProof, MultipartFile propertyTax,
			MultipartFile noc, int userId, int paymentId) {

		User reg = em.find(User.class, userId);
		Payment pay = em.find(Payment.class, paymentId);

		try {
			Approval app = new Approval();
			app.setMobileNo(mobileNo);
			app.setAppName(appName);
			app.setGender(gender);
			app.setDoorNo(doorNo);
			app.setStreetName(streetName);
			app.setCity(city);
			app.setAadhar(aadhar);
			app.setGst(gst);
			app.setTradeloc(tradeloc);
			app.setValidity(validity);
			app.setType(type);
			app.setProperty(property);
			// applied
			app.setStatus(status);
			app.setGenerate(generate.now());
			app.setUser(reg);
			app.setPayment(pay);
			app.setAppImage(appImage.getBytes());
			app.setPropertyTax(propertyTax.getBytes());
			app.setAddressProof(addressProof.getBytes());
			app.setNoc(noc.getBytes());

			em.persist(app);

		} catch (Exception e) {
			System.out.println("Error while applying");
		}

	}

	@Override
	public Approval findByUserId(int userId) {
		try {
			Query<Approval> query = (Query<Approval>) em
					.createQuery("from Approval where user.userId = ?1", Approval.class).setParameter(1, userId);
			return query.getSingleResult();

		} catch (Exception e) {
			return null;
		}

	}

}
