package com.studentManagementSystem.controller;

import com.studentManagementSystem.entities.AttendanceRegister;
import com.studentManagementSystem.entities.Teacher;
import com.studentManagementSystem.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/register")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @PostMapping("/registerTeacher")
    public String registerTeacher(Teacher teacher){
           return teacherService.registerTeacher(teacher);
    }

    @PutMapping("/updateRegister")
    public String updateRegister(@RequestBody AttendanceRegister attendanceRegister){
        return teacherService.updateRegister(attendanceRegister);
    }


}
