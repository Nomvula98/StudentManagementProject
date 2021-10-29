package com.studentManagementSystem.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="Attendance_Register")
public class AttendanceRegister implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long registerId;
    @Column(name= "student_name")
    private String studentName;
    @Column(name= "student_surname")
    private String studentSurname;
    @Column(name= "student_id")
    private Long studentId;
    @Column(name= "teacher_name")
    private String teacherName;
    @Column(name= "teacher_surname")
    private String teacherSurname;
    @Column(name= "teacher_id")
    private Long teacherId;
    private String attendanceStatus;
    private Date date;
    private String subjectCode;

    public AttendanceRegister(String studentName, String studentSurname, Long studentId, String teacherName, String teacherSurname, Long teacherId, String attendanceStatus, Date date,String subjectCode) {
        this.studentName = studentName;
        this.studentSurname = studentSurname;
        this.studentId = studentId;
        this.teacherName = teacherName;
        this.teacherSurname = teacherSurname;
        this.teacherId = teacherId;
        this.attendanceStatus = attendanceStatus;
        this.date = date;
        this.subjectCode=subjectCode;
    }

    public AttendanceRegister() {
    }

    public Long getRegisterId() {
        return registerId;
    }

    public void setRegisterId(Long registerId) {
        this.registerId = registerId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentSurname() {
        return studentSurname;
    }

    public void setStudentSurname(String studentSurname) {
        this.studentSurname = studentSurname;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherSurname() {
        return teacherSurname;
    }

    public void setTeacherSurname(String teacherSurname) {
        this.teacherSurname = teacherSurname;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public String getAttendanceStatus() {
        return attendanceStatus;
    }

    public void setAttendanceStatus(String attendanceStatus) {
        this.attendanceStatus = attendanceStatus;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttendanceRegister that = (AttendanceRegister) o;
        return Objects.equals(registerId, that.registerId) && Objects.equals(studentName, that.studentName) && Objects.equals(studentSurname, that.studentSurname) && Objects.equals(studentId, that.studentId) && Objects.equals(teacherName, that.teacherName) && Objects.equals(teacherSurname, that.teacherSurname) && Objects.equals(teacherId, that.teacherId) && Objects.equals(attendanceStatus, that.attendanceStatus) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registerId, studentName, studentSurname, studentId, teacherName, teacherSurname, teacherId, attendanceStatus, date);
    }
}
