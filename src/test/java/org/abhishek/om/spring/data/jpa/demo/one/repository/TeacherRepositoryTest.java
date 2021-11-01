package org.abhishek.om.spring.data.jpa.demo.one.repository;

import org.abhishek.om.spring.data.jpa.demo.one.entity.Course;
import org.abhishek.om.spring.data.jpa.demo.one.entity.Teacher;
import org.abhishek.om.spring.data.jpa.demo.one.util.CourseUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    TeacherRepository teacherRepository;

    @Test
    public void saveTeacher_with_2_course() {

        Course courseOne = Course.builder()
                .title("Java")
                .credit(8)
                .build();

        Course courseTwo = Course.builder()
                .title("Python")
                .credit(7)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Kirti")
                .lastName("Shree")
                .courses(List.of(courseOne, courseTwo))
                .build();

        teacherRepository.save(teacher);
    }

}