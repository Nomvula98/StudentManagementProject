package com.studentManagementSystem.repositories;


import com.studentManagementSystem.entities.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
public class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;

    Teacher teacher = new Teacher();
    @Test
    public void testSavingToTeacherTable(){
        teacher = teacherRepository.save(completeTeacher());
        assertNotNull(teacher);
        assertNotNull(teacher.getEmail());
        assertNotNull(teacher.getName());
        assertNotNull(teacher.getSurname());
        assertNotNull(teacher.getCellNumber());
        assertNotNull(teacher.getEmail());
    }

    @Test
    public void testUpdateTeacher(){
        teacher = teacherRepository.save(completeTeacher());
        assertNotNull(teacher);
        teacher.setName("Hazel");
        teacher = teacherRepository.save(teacher);
        assertNotNull(teacher.getName());
        assertEquals("Hazel", teacher.getName());
    }

    @Test
    public void testFindByTeacherId(){
        List<Teacher> teacherList;
        teacherList = teacherRepository.findByUserId(completeTeacher().getUserId());
        assertNotNull(teacherList);
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