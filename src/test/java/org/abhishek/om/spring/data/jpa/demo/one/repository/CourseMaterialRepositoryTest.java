package org.abhishek.om.spring.data.jpa.demo.one.repository;

import org.abhishek.om.spring.data.jpa.demo.one.entity.Course;
import org.abhishek.om.spring.data.jpa.demo.one.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial_with_Course() {
        Course course = Course.builder()
                .title("Java")
                .credit(10)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.google.com/javacourse")
                .course(course)
                .build();

        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void printCourseMaterials() {
        List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll();
        System.out.println("courseMaterials = " + courseMaterials);
    }

    @Test
    public void saveCourseMaterial_without_Course() {
        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.google.com/course2")
                .build();
        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void delete_CourseMaterial() {
        courseMaterialRepository.deleteById(1L);
    }

}
