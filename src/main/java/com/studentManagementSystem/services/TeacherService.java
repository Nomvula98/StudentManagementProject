package com.studentManagementSystem.services;

import com.studentManagementSystem.constants.AppConstants;
import com.studentManagementSystem.entities.AttendanceRegister;
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

    /***
     * Service for registering a teacher who is handling the current class
     * @param role represents the role of the current user
     * @param teacher represents the teacher's details
     * @return a String confirming successful registration
     * @throws Exception if user doesn't have the rights to perform the action
     */
    public String registerTeacher(String role, Teacher teacher) throws Exception {
        if(role.equalsIgnoreCase(AppConstants.TEACHER)) {
            teacherList = teacherRepository.findByUserId(teacher.getUserId());
            try {
                if (isNull(teacher)) {
                    return "Enter your details";
                } else if (!teacherList.isEmpty()) {
                    return "Teacher already in class";
                } else {
                    teacherRepository.save(teacher);
                }
            } catch (Exception e) {
                e.getMessage();
            }
            return "Teacher registered, continue to mark register for students";
        }else {
            throw new Exception("You do not have the rights to register teacher");
        }
    }

    /***
     * Service for updating the register (mainly attendanceStatus) for student and teacher who will be in class
     * @param role represents the role of the current user
     * @param attendanceRegister represents the updated attendance register with updated attendance status for students
     * @return a String confirming successful update
     * @throws Exception if user doesn't have the rights to perform the action
     */

    public String updateRegister(String role, AttendanceRegister attendanceRegister) throws Exception {
        if(role.equalsIgnoreCase(AppConstants.TEACHER)) {
            attendanceRegisterRepo.save(attendanceRegister);
            return "Register is updated";
        }else {
            throw new Exception("You do not have the rights to update class attendance register");
        }
    }
}
