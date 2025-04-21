package com.elearning.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Submission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer submission_id;
	private Integer assessment_id;
    private Integer student_id;
	private Integer marks_obtained;
    private Integer course_id;
    private String grade;

    public Integer getSubmissionId() {
        return submission_id;
    }

    public void setSubmissionId(Integer submissionId) {
        this.submission_id = submissionId;
    }
	
	public Integer getAssessmentId() {
        return assessment_id;
    }
	
	public void setAssessmentId(Integer assessmentId) {
        this.assessment_id = assessmentId;
    }

    public Integer getStudentId() {
        return student_id;
    }

    public void setStudentId(Integer studentId) {
        this.student_id = studentId;
    }
	
	public Integer getMarksObtained() {
        return marks_obtained;
    }
	
	public void setMarksObtained(Integer marksObtained) {
        this.marks_obtained = marksObtained;
    }

    public Integer getCourseId() {
        return course_id;
    }

    public void setCourseId(Integer courseId) {
        this.course_id = courseId;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}