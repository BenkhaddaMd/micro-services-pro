package com.example.demo.service;

import com.example.demo.entity.SchoolDTO;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    private final RestTemplate restTemplate;

    private static final String SCHOOL_SERVICE_URL = "http://school-service/api/schools/";

    public StudentService(StudentRepository studentRepository, RestTemplate restTemplate) {
        this.studentRepository = studentRepository;
        this.restTemplate = restTemplate;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(String id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        String schoolId = student.getSchoolId();

        String url = SCHOOL_SERVICE_URL + schoolId;

        System.out.println(url);

        SchoolDTO schoolDTO = restTemplate.getForObject(url, SchoolDTO.class);
        student.setSchool(schoolDTO);
        return student;
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(String id) {
        studentRepository.deleteById(id);
    }
}