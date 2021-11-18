package com.studentManagementSystem.services;

import com.studentManagementSystem.entities.Student;
import com.studentManagementSystem.entities.Subject;
import com.studentManagementSystem.repositories.SubjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SubjectServiceTest {
    @MockBean
    SubjectRepository subjectRepository;
    @Autowired
    SubjectService subjectService;
    Subject subject = new Subject();

    @Test
    public void testRegisterSubject() throws Exception {
        String role = "Admin";
        subject.getSubjectCode();
        subject.setSubjectName("Programming");
        when(subjectRepository.save(subject)).thenReturn((subject));
        subjectService.registerSubject(role, subject);
    }

    @Test
    public void testUpdateSubjectDetails() throws Exception {
        String role = "Admin";
        Subject subject = completeSubject().get(0);
        when(subjectRepository.findBySubjectCode(subject.getSubjectCode())).thenReturn(completeSubject());
        when(subjectRepository.save(completeSubject().get(0))).thenReturn((completeSubject().get(0)));
        subjectService.updateSubjectInfo(role, completeStudent().get(0).getUserId(), completeSubject().get(0));
    }

    @Test
    public void testViewSubjectDetails() throws Exception {
        String role = "Admin";
        List<Subject> subjectList = subjectService.retrieveAllSubjects(role);
        assertThat(subjectList).isNotNull();
    }

    @Test
    public void testDeleteDetails() throws Exception {
        String role = "Admin";
        List<Subject> subjectList = subjectService.retrieveAllSubjects(role);
        assertThat(subjectList).isNotNull();
    }
    private List<Student> completeStudent() {
        List<Student> studentList = new ArrayList<>();
        Student student= new Student();
        student.setUserId(2L);
        student.setName("Portia");
        student.setSurname("Mabena");
        student.setUserRole("Student");
        student.setCellNumber("098644444545");
        student.setEmail("portia@gmail.com");
        studentList.add(student);
        return studentList;
    }
    private List<Subject> completeSubject() {
        List<Subject> list = new ArrayList<>();
        subject.setSubjectName("Programming");
        subject.setStudents(completeStudent());
        list.add(subject);
        return list;
    }
}