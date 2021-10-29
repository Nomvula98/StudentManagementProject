package com.studentManagementSystem.services;

import com.studentManagementSystem.entities.AttendanceRegister;
import com.studentManagementSystem.entities.Student;
import com.studentManagementSystem.entities.Teacher;
import com.studentManagementSystem.repositories.AttendanceRegisterRepository;
import com.studentManagementSystem.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

@Service
public class TeacherService {
    @Autowired
    TeacherRepository teacherRepository;
    @Autowired
    AttendanceRegisterRepository attendanceRegisterRepo;
    List<Teacher> teacherList =  new ArrayList<>();
    public String registerTeacher(Teacher teacher)
    {

        teacherList = teacherRepository.findByTeacherId(teacher.getTeacherId());
        try {
            if (isNull(teacher)) {
                return "Enter your details";
            }
            else if(!teacherList.isEmpty()){
                return "Teacher already in class";
            }
             else {
                teacherRepository.save(teacher);
            }
        }catch (Exception e){
            e.getMessage();
        }
        return "Teacher registered, continue to mark register";
    }

    public String updateRegister(AttendanceRegister attendanceRegister){

       attendanceRegisterRepo.save(attendanceRegister);
        return "Register is updated";
    }
}
