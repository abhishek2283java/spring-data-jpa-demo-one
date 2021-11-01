package org.abhishek.om.spring.data.jpa.demo.one.repository;

import org.abhishek.om.spring.data.jpa.demo.one.entity.Guardian;
import org.abhishek.om.spring.data.jpa.demo.one.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .firstName("John")
                .lastName("Doe")
                .emailId("john@gmail.com")
                //.guardianName("Peter")
                //.guardianEmail("peter@gmail.com")
                //.guardianMobile("9999988888")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudents() {
        List<Student> studentList = studentRepository.findAll();
        System.out.println(studentList);
    }

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .name("Abhishek")
                .email("abhishek@gmail.com")
                .mobile("123456789")
                .build();

        Student student = Student.builder()
                .firstName("Abhikriti")
                .lastName("Choudhary")
                .emailId("abhikriti@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudentsByFirstName() {
        List<Student> studentList = studentRepository.findByFirstName("Abhikriti");
        System.out.println(studentList);
    }

    @Test
    public void printAllStudentsByFirstNameContaining() {
        List<Student> studentList = studentRepository.findByFirstNameContaining("abhi");
        System.out.println(studentList);
    }

    @Test
    public void printAllStudentsByGuardianName() {
        List<Student> studentList = studentRepository.findByGuardianName("Abhishek");
        System.out.println(studentList);
    }

    @Test
    public void printStudentsByFirstNameAndLastName() {
        Student student= studentRepository.findByFirstNameAndLastName("Abhikriti", "Choudhary");
        System.out.println(student);
    }

    @Test
    public void printStudentsByFirstNameAndLastNameIgnoreCase() {
        Student student= studentRepository.findByFirstNameAndLastName("abhikriti", "choudhary");
        System.out.println(student);
    }

    @Test
    public void printStudentByEmailAddress() {
        Student student= studentRepository.getStudentByEmailId("abhikriti@gmail.com");
        System.out.println(student);
    }

    @Test
    public void printStudentFirstNameByEmailAddress() {
        String firstName = studentRepository.getStudentFirstNameByEmailId("abhikriti@gmail.com");
        System.out.println(firstName);
    }

    @Test
    public void printStudentGuardianNameByEmailAddress() {
        String guardianName = studentRepository.getStudentGuardianNameByEmailId("abhikriti@gmail.com");
        System.out.println(guardianName);
    }

    @Test
    public void printStudentGuardianNameByEmailAddressNative() {
        String guardianName = studentRepository.getStudentFirstNameByEmailIdNative("abhikriti@gmail.com");
        System.out.println(guardianName);
    }

    @Test
    public void printStudentGuardianNameByEmailAddress_Native_NamedParam() {
        String guardianName = studentRepository.getStudentFirstNameByEmailIdNativeNamedParameter("abhikriti@gmail.com");
        System.out.println(guardianName);
    }

    @Test
    public void update_Student_FirstName_By_EmailAddress_Native_NamedParam() {
        int updateInt = studentRepository.update_StudentFirstName_ByEmailIdNativeNamedParameter("AbhikritiC", "abhikriti@gmail.com");
        System.out.println("updateInt = " + updateInt);
    }

}