package com.shakeel.serviceImp;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.shakeel.model.Birth;
import com.shakeel.model.Issues;
import com.shakeel.repos.IssueRepoImp;
import com.shakeel.service.IssueService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class IssueServImp implements IssueService {

	@Autowired
	IssueRepoImp repo;

	@Override
	public void addIssues(String issueType, String description, String location, String status,
			MultipartFile proofImage, Integer userId) throws IOException {
		repo.addIssues(issueType, description, location, status, proofImage, userId);
	}

	@Override
	public void delIssue(int issueId) {
		repo.delete(issueId);
	}

	@Override
	public void updateIssue(Issues iss) {
		repo.update(iss);
	}

	@Override
	public List<Issues> getAllIssues() {
		return repo.getAllIssues();
	}

	@Override
	public Issues findById(int issueid) {
		return repo.findById(issueid);
	}

	@Override
	public boolean update(int issueId, String status) {

		try {
			Issues bt = repo.findById(issueId);
			if (bt != null) {
				bt.setStatus(status);
				repo.update(bt);
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace(); // Add logging to see the exception details
			return false;
		}
	}

	@Override
	public List<Issues> findByUserId(int userId) {
		// TODO Auto-generated method stub
		return repo.findByUserId(userId);
	}

}
