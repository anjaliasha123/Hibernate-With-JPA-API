package com.anjali.spring.spring.data.jpa.repository;

import com.anjali.spring.spring.data.jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudentTest(){
        Student student = Student.builder()
                .emailId("anju@gmail.com")
                .firstName("anju")
                .lastName("jake")
                .guardianEmail("jake@gmail.com")
                .guardianMobile("999999999")
                .guardianName("jake")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void getAllStudents(){
        List<Student> list = new ArrayList<>();
        list = studentRepository.findAll();
        System.out.println(list);
    }

}