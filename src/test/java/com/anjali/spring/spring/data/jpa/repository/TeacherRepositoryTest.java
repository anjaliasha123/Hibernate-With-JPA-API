package com.anjali.spring.spring.data.jpa.repository;

import com.anjali.spring.spring.data.jpa.entity.Course;
import com.anjali.spring.spring.data.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;
    @Test
    public void saveTeacherTest(){
        Course courseOs = Course.builder()
                .title("OS")
                .credit(4)
                .build();
        Course courseDba = Course.builder()
                .title("DBA")
                .credit(4)
                .build();
        Teacher teacher = Teacher.builder()
                .firstName("jenny")
                .lastName("thomas")
                .courses(List.of(courseOs, courseDba))
                .build();
        teacherRepository.save(teacher);
    }

}