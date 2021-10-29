package com.studentManagementSystem.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name= "subject")
public class Subject implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long subjectCode;
    @Column(name = "subject_name", nullable = false)
    private String subjectName;
    @ManyToMany(mappedBy = "subjects")
    private List<Teacher> teachers = new ArrayList<>();
    @ManyToMany(mappedBy = "subjects")
    private List<Student> students = new ArrayList<>();

    public Subject() {
    }

    public Subject(Long subjectCode, String subjectName, List<Teacher> teachers, List<Student> students) {
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.teachers = teachers;
        this.students = students;
    }

    public Long getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(Long subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return Objects.equals(subjectCode, subject.subjectCode) && Objects.equals(subjectName, subject.subjectName) && Objects.equals(teachers, subject.teachers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectCode, subjectName, teachers);
    }
}
