package com.studentManagementSystem.controller;

import com.studentManagementSystem.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for a student to de-register
 **/
@RestController
@RequestMapping(value = "/api/v1/admin")
public class StudentController {

    @Autowired
    StudentService studentService;
    /**
     * End-point for Deleting student details of the corresponding id passed in URL
     * @param studentId identifies the student details to be deleted
     * @return a String confirming successful delete
     **/
    @DeleteMapping("/student/deregister/{studentId}")
    public String deregisterStudent(@PathVariable Long studentId){
        return studentService.deleteStudent(studentId);
    }
}
