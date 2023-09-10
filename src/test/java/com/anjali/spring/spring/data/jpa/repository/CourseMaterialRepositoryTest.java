package com.anjali.spring.spring.data.jpa.repository;

import com.anjali.spring.spring.data.jpa.entity.Course;
import com.anjali.spring.spring.data.jpa.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private  CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterialTest(){
        Course course = Course.builder()
                .title("DSA")
                .credit(6)
                .build();
        CourseMaterial cm = CourseMaterial.builder()
                .url("www.google.com")
                .course(course)
                .build();
        courseMaterialRepository.save(cm);
    }
    @Test
    public void printAllCourseMaterials(){
        List<CourseMaterial> materialList = courseMaterialRepository.findAll();
        System.out.println(materialList);
    }

}