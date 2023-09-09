package com.anjali.spring.spring.data.jpa.repository;

import com.anjali.spring.spring.data.jpa.entity.Guardian;
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
//                .guardianMobile("999999999")
//                .guardianEmail("jake@gmail.com")
//                .guardianName("jake")
                .build();
        studentRepository.save(student);
    }
    @Test
    public void saveStudentWithGuardianTest(){
        Guardian guardian = Guardian.builder()
                .email("king@gmail.com")
                .mobile("1234567890")
                .name("king james")
                .build();
        Student student = Student.builder()
                .guardian(guardian)
                .emailId("benny@gmail.com")
                .firstName("ben")
                .lastName("kenny")
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