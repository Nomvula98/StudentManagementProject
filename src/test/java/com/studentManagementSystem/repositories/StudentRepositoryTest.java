package com.studentManagementSystem.repositories;

import com.studentManagementSystem.entities.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class StudentRepositoryTest {
   @Autowired
    private StudentRepository studentRepository;

    Student student = new Student();
    @Test
    public void testSavingToStudentTable(){
      student = studentRepository.save(completeStudent());
      assertNotNull(student);
      assertNotNull(student.getEmail());
      assertNotNull(student.getName());
      assertNotNull(student.getSurname());
      assertNotNull(student.getCellNumber());
      assertNotNull(student.getEmail());
    }

    @Test
    public void testUpdateStudent(){
        student = studentRepository.save(completeStudent());
        assertNotNull(student);
        student.setName("Hazel");
        student = studentRepository.save(student);
        assertNotNull(student.getName());
        assertEquals("Hazel", student.getName());
    }

    @Test
    public void testFindByStudentId(){
        List<Student> studentList;
        studentList = studentRepository.findByUserId(completeStudent().getUserId());
        assertNotNull(studentList);
    }


    private Student completeStudent() {
        student.getUserId();
        student.setName("Portia");
        student.setSurname("Mabena");
        student.setUserRole("Student");
        student.setCellNumber("098644444545");
        student.setEmail("portia@gmail.com");
        return student;
    }


}