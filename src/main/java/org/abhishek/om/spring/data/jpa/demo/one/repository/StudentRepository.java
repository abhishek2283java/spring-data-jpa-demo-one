package org.abhishek.om.spring.data.jpa.demo.one.repository;

import org.abhishek.om.spring.data.jpa.demo.one.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    public List<Student> findByFirstName(String firstName);

    public List<Student> findByFirstNameContaining(String firstName);

    public List<Student> findByLastNameNotNull();

    public List<Student> findByGuardianName(String guardianName);

    public Student findByFirstNameAndLastName(String firstName, String lastName);

    //JPQL
    //This returns the entire Student record
    @Query("Select s from Student s where s.emailId = ?1")
    public Student getStudentByEmailId(String emailId);

    //JPQL
    //Now we want to fetch Student's first name by emailId
    @Query("Select s.firstName from Student s where s.emailId = ?1")
    public String getStudentFirstNameByEmailId(String emailId);

    //JPQL
    //Now we want to fetch Student's guardian name by emailId
    @Query("Select s.guardian.name from Student s where s.emailId = ?1")
    public String getStudentGuardianNameByEmailId(String emailId);

    //Native Query
    @Query(
            value = "SELECT s.guardian_name from tbl_student s where s.email_address = ?1",
            nativeQuery = true
    )
    public String getStudentFirstNameByEmailIdNative(String emailId);

    //Native Query (Named Parameter)
    @Query(
            value = "SELECT s.guardian_name from tbl_student s where s.email_address = :emailaddress",
            nativeQuery = true
    )
    public String getStudentFirstNameByEmailIdNativeNamedParameter(@Param("emailaddress") String emailId);

    //Native Query for Update
    @Modifying
    @Transactional
    @Query(
            value = "UPDATE tbl_student s SET s.first_name = :firstname where s.email_address = :emailaddress",
            nativeQuery = true
    )
    public int update_StudentFirstName_ByEmailIdNativeNamedParameter(@Param("firstname") String firstName, @Param("emailaddress") String emailId);
    //a successful update will return int as 1 in answer
}
