package com.elearning.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Teacher {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer teacher_id;
	private Integer user_id;
    private String name;
    private String domain_of_expertise;
    private int years_of_experience;
    private String email;

    public Integer getTeacherId() {
        return teacher_id;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacher_id = teacherId;
    }
	
	public Integer getUserId() {
        return user_id;
    }
	
	public void setUserId(Integer userId) {
        this.user_id = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDomainOfExpertise() {
        return domain_of_expertise;
    }

    public void setDomainOfExpertise(String domainOfExpertise) {
        this.domain_of_expertise = domainOfExpertise;
    }

    public int getYearsOfExperience() {
        return years_of_experience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.years_of_experience = yearsOfExperience;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}