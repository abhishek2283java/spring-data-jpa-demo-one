package org.abhishek.om.spring.data.jpa.demo.one.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Table(name = "tbl_course")
public class Course {

    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    private Long courseId;
    private String title;
    private Integer credit;

    @OneToOne(
            mappedBy = "course",
            optional = true
    )
    private CourseMaterial courseMaterial;

    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "tbl_course_student_map",
            joinColumns = @JoinColumn(
                    name = "course_id",
                    referencedColumnName = "courseId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "student_id",
                    referencedColumnName = "studentId"
            )
    )
    private List<Student> students;

    public void addStudent(Student student) {
        if(this.getStudents() == null) {
            List<Student> students = new ArrayList<Student>();
            this.setStudents(students);
        }
        this.getStudents().add(student);
    }

}
