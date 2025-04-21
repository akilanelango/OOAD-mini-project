package com.elearning.service;

import com.elearning.model.Course;
import com.elearning.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course findCourseById(Integer courseId) {
        return courseRepository.findById(courseId).orElse(null);
    }

    public List<Course> findAllCourses() {
        return courseRepository.findAll();
    }

    public Course updateCourse(Integer courseId, Course courseDetails) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found with id " + courseId));
        course.setTitle(courseDetails.getTitle());
        course.setYearOffered(courseDetails.getYearOffered());
        course.setDomain(courseDetails.getDomain());
        course.setUserId(courseDetails.getUserId());
        return courseRepository.save(course);
    }

    public void deleteCourse(Integer courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found with id " + courseId));
        courseRepository.delete(course);
    }
}