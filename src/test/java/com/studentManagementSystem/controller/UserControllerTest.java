package com.studentManagementSystem.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.studentManagementSystem.entities.AttendanceRegister;
import com.studentManagementSystem.entities.Student;
import com.studentManagementSystem.entities.Teacher;
import org.junit.Test;
import com.studentManagementSystem.entities.Subject;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    MockMvc mvc;
    Student student = new Student();
    Subject subject = new Subject();
    Teacher teacher = new Teacher();
    AttendanceRegister register = new AttendanceRegister();
    ObjectMapper objectMapper = new ObjectMapper();

  @Test
  public void test_submitDetails_As_Admin() throws Exception {
      /**
       *  Happy test for submitting student details
       **/
      mvc.perform(post("/api/v1/student/submitStudentDetails")
                      .contentType(MediaType.APPLICATION_JSON)
                      .param("role","admin" )
                      .content(objectMapper.writeValueAsString(completeStudent())))
              .andExpect(status().isOk());

      /**
       *  Failure test for submitting student details with incorrect request method
       **/
      mvc.perform(get("/api/v1/student/submitStudentDetails")
                      .contentType(MediaType.APPLICATION_JSON)
                      .param("role","admin" )
                      .content(objectMapper.writeValueAsString(completeStudent())))
              .andExpect(status().isMethodNotAllowed());

      /**
       *  Failure test for submitting student details with incorrect URL
       **/
      mvc.perform(post("/api/v1/student/")
                      .contentType(MediaType.APPLICATION_JSON)
                      .param("role","admin" )
                      .content(objectMapper.writeValueAsString(completeStudent())))
              .andExpect(status().isNotFound());
  }

    /**
     *  Test for submitting student details when user is not authorized
     **/
    @Test(expected = Exception.class)
    public void test_submitDetails_As_Student() throws Exception {
        mvc.perform(post("/api/v1/student/submitStudentDetails")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("role","student" )
                        .content(objectMapper.writeValueAsString(completeStudent())));
    }

    @Test
    public void test_retrieveAllStudents_As_Admin() throws Exception {
        /**
         *  Happy test for retrieving all students
         **/
        mvc.perform(get("/api/v1/student/retrieveAllStudents")
                        .param("role","admin" ))
                .andExpect(status().isOk());

        /**
         *  Failure test for retrieving all students with incorrect request method
         **/
        mvc.perform(put("/api/v1/student/retrieveAllStudents")
                        .param("role","admin" ))
                .andExpect(status().isMethodNotAllowed());

        /**
         *  Failure test for retrieving all students with incorrect URL
         **/
        mvc.perform(post("/api/v1/student/")
                        .param("role","admin" ))
                .andExpect(status().isNotFound());
    }
    /**
     *  Test for retrieving all students when user is not authorized
     **/
    @Test(expected = Exception.class)
    public void test_retrieveAllStudents_As_Student() throws Exception {
        mvc.perform(get("/api/v1/student/retrieveAllStudents")
                .param("role", "student"));
    }

    @Test
    public void test_updateStudentDetails_As_Admin_or_Student() throws Exception {
        /**
         *  Happy test for updating student details as admin
         **/
        mvc.perform(put("/api/v1/student/update/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("role","admin" )
                        .content(objectMapper.writeValueAsString(completeStudent())))
                .andExpect(status().isOk());

        /**
         *  Happy test for updating student details as student
         **/
        mvc.perform(put("/api/v1/student/update/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("role","student" )
                        .content(objectMapper.writeValueAsString(completeStudent())))
                .andExpect(status().isOk());

        /**
         *  Failure test for updating student details with incorrect request method
         **/
        mvc.perform(get("/api/v1/student/update/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("role","admin" )
                        .content(objectMapper.writeValueAsString(completeStudent())))
                .andExpect(status().isMethodNotAllowed());

        /**
         *  Failure test for updating student details with incorrect URL
         **/
        mvc.perform(put("/api/v1/student/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("role","admin" )
                        .content(objectMapper.writeValueAsString(completeStudent())))
                .andExpect(status().isNotFound());

    }

    @Test
    public void test_deleteStudent_As_Admin_or_Student() throws Exception {
        /**
         *  Happy test for deleting student details as admin
         **/
        mvc.perform(delete("/api/v1/student/delete/1")
                        .param("role","admin" ))
                .andExpect(status().isOk());

        /**
         *  Happy test for deleting student details as student
         **/
        mvc.perform(delete("/api/v1/student/delete/1")
                        .param("role","student" ))
                .andExpect(status().isOk());

        /**
         *  Failure test for deleting student details with incorrect request method
         **/
        mvc.perform(get("/api/v1/student/delete/1")
                        .param("role","admin" ))
                .andExpect(status().isMethodNotAllowed());

        /**
         *  Failure test for deleting student details with incorrect URL
         **/
        mvc.perform(delete("/api/v1/student/")
                        .param("role","admin" ))
                .andExpect(status().isNotFound());
    }


    @Test
    public void test_submitSubjectDetails_As_Admin() throws Exception {
        /**
         *  Happy test for submitting subject details
         **/
        mvc.perform(post("/api/v1/subject/registerSubject")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("role","admin" )
                        .content(objectMapper.writeValueAsString(completeSubject())))
                .andExpect(status().isOk());

        /**
         *  Failure test for submitting subject details with incorrect request method
         **/
        mvc.perform(get("/api/v1/subject/registerSubject")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("role","admin" )
                        .content(objectMapper.writeValueAsString(completeSubject())))
                .andExpect(status().isMethodNotAllowed());

        /**
         *  Failure test for submitting subject details with incorrect URL
         **/
        mvc.perform(post("/api/v1/subject/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("role","admin" )
                        .content(objectMapper.writeValueAsString(completeSubject())))
                .andExpect(status().isNotFound());
    }

    /**
     *  Test for submitting subject details when user is not authorized
     **/
    @Test(expected = Exception.class)
    public void test_submitSubjectDetails_As_Student() throws Exception {
        mvc.perform(post("/api/v1/subject/registerSubject")
                .contentType(MediaType.APPLICATION_JSON)
                .param("role","student" )
                .content(objectMapper.writeValueAsString(completeSubject())));
    }

    @Test
    public void test_retrieveAllSubjects_As_Admin() throws Exception {
        /**
         *  Happy test for retrieving all subjects
         **/
        mvc.perform(get("/api/v1/student/retrieveAllStudents")
                        .param("role","admin" ))
                .andExpect(status().isOk());

        /**
         *  Failure test for retrieving all subjects with incorrect request method
         **/
        mvc.perform(put("/api/v1/subject/retrieveAllSubjects")
                        .param("role","admin" ))
                .andExpect(status().isMethodNotAllowed());

        /**
         *  Failure test for retrieving all subjects with incorrect URL
         **/
        mvc.perform(post("/api/v1/subject/")
                        .param("role","admin" ))
                .andExpect(status().isNotFound());
    }
    /**
     *  Test for retrieving all subjects when user is not authorized
     **/
    @Test(expected = Exception.class)
    public void test_retrieveAllSubjects_As_Student() throws Exception {
        mvc.perform(get("/api/v1/subject/retrieveAllSubjects")
                .param("role", "student"));
    }

    @Test
    public void test_updateSubjectDetails_As_Admin() throws Exception {
        /**
         *  Happy test for updating subject details as admin
         **/
        mvc.perform(put("/api/v1/subject/update/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("role","admin" )
                        .content(objectMapper.writeValueAsString(completeSubject())))
                .andExpect(status().isOk());

        /**
         *  Failure test for updating subject details with incorrect request method
         **/
        mvc.perform(get("/api/v1/subject/update/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("role","admin" )
                        .content(objectMapper.writeValueAsString(completeSubject())))
                .andExpect(status().isMethodNotAllowed());

        /**
         *  Failure test for updating subject details with incorrect URL
         **/
        mvc.perform(put("/api/v1/subject/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("role","admin" )
                        .content(objectMapper.writeValueAsString(completeSubject())))
                .andExpect(status().isNotFound());
    }

    /**
     * Test for updating subject details as student
     *  @throws Exception
     **/
    @Test(expected = Exception.class)
    public void test_updateSubjects_As_Student() throws Exception {
        mvc.perform(put("/api/v1/subject/update/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("role","student" )
                        .content(objectMapper.writeValueAsString(completeSubject())));
    }

    @Test
    public void test_deleteSubject_As_Admin() throws Exception {
        /**
         *  Happy test for deleting subject details as admin
         **/
        mvc.perform(delete("/api/v1/subject/delete/1")
                        .param("role","admin" ))
                .andExpect(status().isOk());

        /**
         *  Failure test for deleting subject details with incorrect request method
         **/
        mvc.perform(get("/api/v1/subject/delete/1")
                        .param("role","admin" ))
                .andExpect(status().isMethodNotAllowed());

        /**
         *  Failure test for deleting subject details with incorrect URL
         **/
        mvc.perform(delete("/api/v1/subject/")
                        .param("role","admin" ))
                .andExpect(status().isNotFound());
    }

    /**
     *  Test for deleting subject details as student
     * @throws Exception
     **/
    @Test(expected = Exception.class)
    public void test_deleteSubject_As_Student() throws Exception {
        mvc.perform(delete("/api/v1/subject/delete/1")
                .param("role","student" ));
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

  private Subject completeSubject(){
        List<Student> studentList = new ArrayList<>();
        studentList.add(completeStudent());
        subject.getSubjectCode();
        subject.setSubjectName("Programming");
        subject.setStudents(studentList);
        return subject;
  }

    private Teacher completeTeacher(){
        teacher.getUserId();
        teacher.setName("Emma");
        teacher.setSurname("Livie");
        teacher.setUserRole("Teacher");
        teacher.setCellNumber("09876545678");
        teacher.setEmail("livie@gmail.com");
        return teacher;
    }


}