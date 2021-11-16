package com.studentManagementSystem.services;

import com.studentManagementSystem.entities.Student;
import com.studentManagementSystem.repositories.StudentRepository;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {
    @MockBean
    StudentRepository studentRepository;
@Test
    public void testSubmitStudentDetails() throws Exception {
        StudentService studentService = new StudentService();
        String role = "Admin";
        Student student = new Student();
        student.setName("Nunu");
        student.setSurname("Smith");
        student.setUserRole("Student");
        student.setCellNumber("0986589076");
        student.setEmail("nom@gmail.com");


        String response = studentService.submitStudentDetails(role, student);
        assertEquals("Successfully saved Student", response);



    }

}