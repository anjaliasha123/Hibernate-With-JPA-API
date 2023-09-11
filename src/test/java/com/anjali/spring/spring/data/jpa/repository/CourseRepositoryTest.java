package com.anjali.spring.spring.data.jpa.repository;

import com.anjali.spring.spring.data.jpa.entity.Course;
import com.anjali.spring.spring.data.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;
    @Test
    public void findAllCourses(){
        List<Course> courses = courseRepository.findAll();
        System.out.println(courses);
    }
    @Test
    public void saveCourseWithTeacherObject(){
        Teacher teacher = Teacher.builder()
                .firstName("Priyanka")
                .lastName("chopra")
                .build();
        Course course = Course.builder()
                .title("python")
                .credit(10)
                .teacher(teacher)
                .build();
        courseRepository.save(course);
    }
}