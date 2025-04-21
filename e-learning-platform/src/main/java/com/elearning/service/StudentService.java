package com.elearning.service;

import com.elearning.model.Student;
import com.elearning.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student registerStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student findStudentById(Integer studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }
	
	public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    public Student updateStudent(Integer studentId, Student studentDetails) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with id " + studentId));
        student.setName(studentDetails.getName());
        student.setEmail(studentDetails.getEmail());
        student.setUsername(studentDetails.getUsername());
        return studentRepository.save(student);
    }

    public void deleteStudent(Integer studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with id " + studentId));
        studentRepository.delete(student);
    }
}