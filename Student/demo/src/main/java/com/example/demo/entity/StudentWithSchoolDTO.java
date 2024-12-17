package com.example.demo.entity;

public class StudentWithSchoolDTO {

    private Student student;
    private SchoolDTO school;

    // Constructors, getters, and setters
    public StudentWithSchoolDTO(Student student, SchoolDTO school) {
        this.student = student;
        this.school = school;
    }

    // Getters and Setters
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public SchoolDTO getSchool() {
        return school;
    }

    public void setSchool(SchoolDTO school) {
        this.school = school;
    }
}
