package com.elearning.service;

import com.elearning.model.Assessment;
import com.elearning.repository.AssessmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssessmentService {

    @Autowired
    private AssessmentRepository assessmentRepository;

    public Assessment createAssessment(Assessment assessment) {
        return assessmentRepository.save(assessment);
    }

    public List<Assessment> getAllAssessments() {
        return assessmentRepository.findAll();
    }

    public Assessment getAssessmentById(Integer id) {
        return assessmentRepository.findById(id).orElse(null);
    }

    public List<Assessment> getAssessmentsByCourseId(Integer courseId) {
        return assessmentRepository.findByCourseId(courseId);
    }

    public void deleteAssessment(Integer id) {
        assessmentRepository.deleteById(id);
    }
}

