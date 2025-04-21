package com.elearning.service;

import com.elearning.model.Submission;
import com.elearning.repository.SubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubmissionService {

    @Autowired
    private SubmissionRepository submissionRepository;

    public Submission addSubmission(Submission submission) {
        return submissionRepository.save(submission);
    }

    public Submission findSubmissionById(Integer submissionId) {
        return submissionRepository.findById(submissionId).orElse(null);
    }

    public List<Submission> findAllSubmissions() {
        return submissionRepository.findAll();
    }

	public Submission updateSubmission(Integer submissionId, Submission submissionDetails) {
    // Fetch the existing submission from the database (assume a repository or DAO is available)
    Submission existingSubmission = submissionRepository.findById(submissionId)
        .orElseThrow(() -> new RuntimeException("Submission not found with id " + submissionId));
    
    // Update fields
    existingSubmission.setAssessmentId(submissionDetails.getAssessmentId());
    existingSubmission.setStudentId(submissionDetails.getStudentId());
    existingSubmission.setMarksObtained(submissionDetails.getMarksObtained());
    existingSubmission.setCourseId(submissionDetails.getCourseId());
    existingSubmission.setGrade(submissionDetails.getGrade());
    
    // Save and return the updated submission
    return submissionRepository.save(existingSubmission);
}

	
    public void deleteSubmission(Integer submissionId) {
        Submission submission = submissionRepository.findById(submissionId)
                .orElseThrow(() -> new RuntimeException("Submission not found with id " + submissionId));
        submissionRepository.delete(submission);
    }
}