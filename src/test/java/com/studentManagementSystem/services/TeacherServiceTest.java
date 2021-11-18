package com.studentManagementSystem.services;

import com.studentManagementSystem.entities.AttendanceRegister;
import com.studentManagementSystem.entities.Teacher;
import com.studentManagementSystem.repositories.AttendanceRegisterRepository;
import com.studentManagementSystem.repositories.TeacherRepository;
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
class TeacherServiceTest {
    @MockBean
    TeacherRepository teacherRepository;
    @MockBean
    AttendanceRegisterRepository attendanceRegisterRepository;
    @Autowired
    TeacherService teacherService;

    AttendanceRegister attendanceRegister = new AttendanceRegister();
    Teacher teacher=new Teacher();

    @Test
    public void testSubmitStudentDetails() throws Exception {
        String role = "Teacher";
        teacher.getUserId();
        teacher.setName("Portia");
        teacher.setSurname("Mabena");
        teacher.setUserRole("Student");
        teacher.setCellNumber("098644444545");
        teacher.setEmail("portia@gmail.com");
        when(teacherRepository.save(teacher)).thenReturn((teacher));
        teacherService.registerTeacher(role, teacher);
    }

    @Test
    public void testUpdateAttendanceRegister() throws Exception {
        String role = "Teacher";
       AttendanceRegister attendanceRegister = completeRegister().get(0);
        when(attendanceRegisterRepository.findByRegisterId(attendanceRegister.getRegisterId())).thenReturn(completeRegister());
        when(attendanceRegisterRepository.save(completeRegister().get(0))).thenReturn((completeRegister().get(0)));
        teacherService.updateRegister(role, attendanceRegister);
    }

    private List<AttendanceRegister> completeRegister(){
        List<AttendanceRegister> attendanceRegisterList = new ArrayList<>();
       attendanceRegister.setRegisterId(5L);
       attendanceRegister.setAttendanceStatus("Present");
       attendanceRegister.setStudentName("omvula");
       attendanceRegister.setTeacherName("Clementia");
       attendanceRegister.setStudentSurname("Skosaana");
       attendanceRegister.setStudentId(1L);
       attendanceRegister.setTeacherId(3L);
        attendanceRegisterList.add(attendanceRegister);
        return attendanceRegisterList;
    }
}