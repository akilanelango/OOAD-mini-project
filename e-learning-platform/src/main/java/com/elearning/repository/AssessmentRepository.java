package com.elearning.repository;

import com.elearning.model.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssessmentRepository extends JpaRepository<Assessment, Integer> {
    List<Assessment> findByCourseId(Integer courseId);
}

