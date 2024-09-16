package com.shakeel.repo;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.shakeel.model.Approval;
import com.shakeel.model.Birth;
import com.shakeel.model.Issues;

public interface IssueRepo {

	public void addIssues(String issueType, String description, String location, String status, MultipartFile proofImage, Integer userId)
			throws IOException;

	public void delete(int issueId);

	public List<Issues> getAllIssues();

	public void update(Issues iss);

	public Issues findById(int issueId);
	
	public Issues findByUserId(int userId);
}
