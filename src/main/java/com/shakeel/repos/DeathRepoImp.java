package com.shakeel.repos;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.shakeel.model.Birth;
import com.shakeel.model.Death;
import com.shakeel.model.Payment;
import com.shakeel.model.User;
import com.shakeel.repo.DeathRepo;

import jakarta.persistence.EntityManager;

@Repository
public class DeathRepoImp implements DeathRepo {

	@Autowired
	EntityManager em;

	@Override
	public void delete(int deathId) {
		Death dt = em.find(Death.class, deathId);
		if (dt != null) {
			em.remove(dt);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Death> getAllDeaths() {
		return em.createQuery("from Death").getResultList();
	}

	@Override
	public void update(Death dth) {
		em.merge(dth);
	}

	@Override
	public Death findById(int deathId) {
		Query<Death> q = (Query<Death>) em.createQuery("from Death where deathId = ?1");
		q.setParameter(1, deathId);
		return (Death) q.getSingleResult();

	}

	@Override
	public void save(String district, String state, String address, String mobile, String gender, String dname,
			String nominee, String nomineeName, String placeOfBirth, String hospitalName, String date, String time,
			MultipartFile deathImg, String status, LocalDateTime generate, int userId, int paymentId) {

		User reg = em.find(User.class, userId);
		Payment pay = em.find(Payment.class, paymentId);

		try {
			Death death = new Death(); // Create a new Death object

			// Set values for the Death object
			death.setDistrict(district);
			death.setState(state);
			death.setAddress(address);
			death.setMobile(mobile);
			death.setGender(gender);
			death.setDname(dname); // Assuming dname refers to the name of the deceased
			death.setNominee(nominee);
			death.setNomineeName(nomineeName);
			death.setPlaceOfBirth(placeOfBirth);
			death.setHospitalName(hospitalName);
			death.setDate(date); // Assuming date is in the appropriate format
			death.setTime(time); // Assuming time is in the appropriate format
			death.setDeathImg(deathImg.getBytes()); // Convert MultipartFile to byte array
			death.setStatus(status);
			death.setGenerate(generate);
			death.setUser(reg); // Set User
			death.setPayment(pay); // Set Payment

			// Persist the Death object
			em.persist(death);

		} catch (Exception e) {
			System.out.println("Death Not added");
			e.printStackTrace(); // Print the stack trace for debugging
		}
	}

	@Override
	public Death findByUserId(int userId) {
		try {
			Query<Death> query = (Query<Death>) em.createQuery("from Death where user.userId = ?1", Death.class)
					.setParameter(1, userId);
			return query.getSingleResult();

		} catch (Exception e) {
			return null;
		}
	}

}
