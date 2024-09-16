package com.shakeel.repos;

import java.io.IOException;
import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.shakeel.model.Approval;
import com.shakeel.model.Birth;
import com.shakeel.model.Issues;
import com.shakeel.model.User;
import com.shakeel.repo.IssueRepo;

import jakarta.persistence.EntityManager;

@Repository
public class IssueRepoImp implements IssueRepo {

	@Autowired
	EntityManager em;

	@Override
	public void addIssues(String issueType, String description, String location, String status,
			MultipartFile proofImage, Integer userId) throws IOException {

		User reg = em.find(User.class, userId);

		Issues is = new Issues();
		is.setIssueType(issueType);
		is.setDescription(description);
		is.setLocation(location);
		is.setStatus(status);
		is.setProofImage(proofImage.getBytes());
		is.setUser(reg);
		em.persist(is);

	}

	@Override
	public void delete(int issueId) {
		Issues bt = em.find(Issues.class, issueId);
		if (bt != null) {
			em.remove(bt);
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Issues> getAllIssues() {
		return em.createQuery("from Issues").getResultList();
	}

	@Override
	public void update(Issues iss) {
		em.merge(iss);

	}

	@Override
	public Issues findById(int issueId) {
		Query<Issues> q = (Query<Issues>) em.createQuery("from Issues where issueId = ?1");
		q.setParameter(1, issueId);
		return (Issues) q.getSingleResult();
	}

	@Override
	public Issues findByUserId(int userId) {
		try {
			Query<Issues> query = (Query<Issues>) em.createQuery("from Issues where user.userId = ?1", Issues.class)
					.setParameter(1, userId);
			return query.getSingleResult();

		} catch (Exception e) {
			return null;
		}

	}

}
