package com.studentManagementSystem.services;

import com.studentManagementSystem.entities.Student;
import com.studentManagementSystem.repositories.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StudentServiceTest {
    @MockBean
    StudentRepository studentRepository;
    @Autowired
    StudentService studentService;
    Student student=new Student();
    @Test
    public void testSubmitStudentDetails() throws Exception {
        String role = "Admin";
        student.getUserId();
        student.setName("Portia");
        student.setSurname("Mabena");
        student.setUserRole("Student");
        student.setCellNumber("098644444545");
        student.setEmail("portia@gmail.com");
        when(studentRepository.save(student)).thenReturn((student));
        studentService.submitStudentDetails(role, student);
    }

    @Test
    public void testUpdateStudentDetails() throws Exception {
        String role = "Admin";
        Student student = completeStudent().get(0);
        when(studentRepository.findByUserId(student.getUserId())).thenReturn(completeStudent());
        when(studentRepository.save(completeStudent().get(0))).thenReturn((completeStudent().get(0)));
        studentService.updateStudentDetails(role, completeStudent().get(0).getUserId(), completeStudent().get(0));
    }

    @Test
    public void testViewDetails() throws Exception {
        String role = "Admin";
        List<Student> studentList = studentService.retrieveAllStudents(role);
        assertThat(studentList).isNotNull();
    }

    @Test
    public void testDeleteDetails() throws Exception {
        String role = "Admin";
        List<Student> studentList = studentService.retrieveAllStudents(role);
        assertThat(studentList).isNotNull();
    }

    private List<Student> completeStudent() {
        List<Student> studentList = new ArrayList<>();
        student.setUserId(2L);
        student.setName("Portia");
        student.setSurname("Mabena");
        student.setUserRole("Student");
        student.setCellNumber("098644444545");
        student.setEmail("portia@gmail.com");
        studentList.add(student);
        return studentList;
    }
}