package org.abhishek.om.spring.data.jpa.demo.one.repository;

import org.abhishek.om.spring.data.jpa.demo.one.entity.Course;
import org.abhishek.om.spring.data.jpa.demo.one.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    CourseRepository courseRepository;

    @Test
    public void getCourses() {
        List<Course> courses = courseRepository.findAll();
        System.out.println("courses = " + courses);
    }

    @Test
    public void createCourse() {
        Course course = Course.builder()
                .title("AI")
                .credit(6)
                .build();
        courseRepository.save(course);
    }

    @Test
    public void getCourses_Using_Pagination() {
        Pageable pageWithTwoRecords = PageRequest.of(1, 3);

        Page<Course> all = courseRepository.findAll(pageWithTwoRecords);

        System.out.println("Total Elements = " + all.getTotalElements());
        System.out.println("Total Number of Pages = " + all.getTotalPages());
        //List<Course> courseList = courseRepository.findAll(pageWithTwoRecords).getContent();
        List<Course> courseList = all.getContent();
        System.out.println("courses = " + courseList);
    }

    @Test
    public void getCourses_Using_Pagination_And_Sorting() {
        Pageable pageWithThreeRecords_Sorted = PageRequest.of(
                                            0,
                                             3,
                                                  Sort.by("title").descending()
                                        );

        Page<Course> all = courseRepository.findAll(pageWithThreeRecords_Sorted);

        System.out.println("Total Elements = " + all.getTotalElements());
        System.out.println("Total Number of Pages = " + all.getTotalPages());
        //List<Course> courseList = courseRepository.findAll(pageWithTwoRecords).getContent();
        List<Course> courseList = all.getContent();
        System.out.println("courses = " + courseList);
    }

    @Test
    public void create_Course_and_Students_for_Many_To_Many_Mapping() {
        Course course = Course.builder()
                .title("AI Adv")
                .credit(8)
                .build();

        Student studentOne = Student.builder()
                                .firstName("Abhishek")
                                .lastName("Singh")
                                .emailId("abhishek@gmail.com")
                                .build();

        Student studentTwo = Student.builder()
                .firstName("Abhishek")
                .lastName("Mishra")
                .emailId("abhishekmishra@gmail.com")
                .build();

        course.addStudent(studentOne);
        course.addStudent(studentTwo);

        courseRepository.save(course);
    }
}