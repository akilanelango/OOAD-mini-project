package com.elearning.service;

import com.elearning.model.Teacher;
import com.elearning.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public Teacher addTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Teacher findTeacherById(Integer teacherId) {
        return teacherRepository.findById(teacherId).orElse(null);
    }

    public List<Teacher> findAllTeachers() {
        return teacherRepository.findAll();
    }

    public Teacher updateTeacher(Integer teacherId, Teacher teacherDetails) {
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new RuntimeException("Teacher not found with id " + teacherId));
        teacher.setName(teacherDetails.getName());
        teacher.setDomainOfExpertise(teacherDetails.getDomainOfExpertise());
        teacher.setYearsOfExperience(teacherDetails.getYearsOfExperience());
        teacher.setEmail(teacherDetails.getEmail());
        return teacherRepository.save(teacher);
    }

    public void deleteTeacher(Integer teacherId) {
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new RuntimeException("Teacher not found with id " + teacherId));
        teacherRepository.delete(teacher);
    }
}