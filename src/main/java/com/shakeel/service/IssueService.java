package com.shakeel.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.shakeel.model.Approval;
import com.shakeel.model.Issues;

public interface IssueService {

	public void addIssues(String issueType, String description, String location, String status, MultipartFile proofImage, Integer userId)
			throws IOException;

	public void delIssue(int issueId);

	public void updateIssue(Issues iss);

	public List<Issues> getAllIssues();

	public Issues findById(int issueid);

	public boolean update(int issueId, String status);
	
	public Issues findByUserId(int userId);


}
