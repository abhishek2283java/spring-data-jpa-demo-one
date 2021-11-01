package org.abhishek.om.spring.data.jpa.demo.one.util;

import org.abhishek.om.spring.data.jpa.demo.one.entity.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseUtil {
    public static List<Course> getTwoCoursesAsList() {
        Course courseOne = Course.builder()
                .title("Java")
                .credit(8)
                .build();

        Course courseTwo = Course.builder()
                .title("Python")
                .credit(7)
                .build();

        List<Course> courses = new ArrayList<>();
        courses.add(courseOne);
        courses.add(courseTwo);

        return courses;
    }

    public static Course getCourse(String title, Integer credit) {
        Course course = Course.builder()
                .title(title)
                .credit(credit)
                .build();
        return course;
    }
}
