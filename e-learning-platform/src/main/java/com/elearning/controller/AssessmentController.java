package com.elearning.controller;

import com.elearning.model.Assessment;
import com.elearning.service.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/assessments")
public class AssessmentController {

    @Autowired
    private AssessmentService assessmentService;

    @PostMapping
    public ResponseEntity<Assessment> createAssessment(@RequestBody Assessment assessment) {
        Assessment created = assessmentService.createAssessment(assessment);
        return ResponseEntity.ok(created);
    }

    @GetMapping
    public ResponseEntity<List<Assessment>> getAllAssessments() {
        return ResponseEntity.ok(assessmentService.getAllAssessments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Assessment> getAssessmentById(@PathVariable Integer id) {
        return ResponseEntity.ok(assessmentService.getAssessmentById(id));
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<Assessment>> getAssessmentsByCourseId(@PathVariable Integer courseId) {
        return ResponseEntity.ok(assessmentService.getAssessmentsByCourseId(courseId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAssessment(@PathVariable Integer id) {
        assessmentService.deleteAssessment(id);
        return ResponseEntity.noContent().build();
    }
}

