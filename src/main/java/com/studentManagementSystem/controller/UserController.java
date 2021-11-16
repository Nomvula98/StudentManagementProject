package com.studentManagementSystem.controller;
import com.studentManagementSystem.entities.AttendanceRegister;
import com.studentManagementSystem.entities.Subject;
import com.studentManagementSystem.entities.Student;
import com.studentManagementSystem.entities.Teacher;
import com.studentManagementSystem.services.StudentService;
import com.studentManagementSystem.services.SubjectService;
import com.studentManagementSystem.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller for users
 **/
@RestController
@RequestMapping(value = "/api/v1")
public class UserController {
    @Autowired
    StudentService studentService;
    @Autowired
    SubjectService subjectService;
    @Autowired
    TeacherService teacherService;
    List<Student> studentList = new ArrayList<>();
    List<Subject> subjectList = new ArrayList<>();

    /**
     * End-point for Submitting student details to be stored in database
     *
     * @param role represents the role of the current user
     * @param student represents the student details
     * @return a string confirming successful submission or not
     * @throws Exception if user doesn't have the rights to perform the action
     **/
    @PostMapping("/student/submitStudentDetails")
    public String submitDetails(@RequestParam String role, @RequestBody Student student) throws Exception {
        return studentService.submitStudentDetails(role, student);
    }

    /**
     * End-point for Retrieving all students details that are stored in database
     *
     * @param role represents the role of the current user
     * @return a List of students
     * @throws Exception if user doesn't have the rights to perform the action
     **/
    @GetMapping("/student/retrieveAllStudents")
    public List<Student> retrieveAllStudents(@RequestParam String role) throws Exception {
        studentList = studentService.retrieveAllStudents(role);
        return studentList;
    }
        /**
         * End-point for Updating student details of the corresponding id passed in URL
         * @param role represents the role of the current user
         * @param studentId identifies the student details to be updated
         * @param student represents the updated student's details to save
         * @return a String confirming successful update
         * @throws Exception if user doesn't have the rights to perform the action
         **/
        @PutMapping("/student/update/{studentId}")
        public String updateDetails (@RequestParam String role, @PathVariable Long studentId, @RequestBody Student
        student) throws Exception {

            return studentService.updateStudentDetails(role, studentId, student);
        }

        /**
         * End-point for Deleting student details of the corresponding id passed in URL
         * @param role represents the role of the current user
         * @param studentId identifies the student details to be deleted
         * @return a String confirming successful delete
         * @throws Exception if user doesn't have the rights to perform the action
         **/
        @DeleteMapping("/student/delete/{studentId}")
        public String deleteDetails (@RequestParam String role, @PathVariable Long studentId) throws Exception {
            return studentService.deleteStudent(role, studentId);
        }

        /**
         * End-point for registering a subject and store in database
         * @param role represents the role of the current user
         * @param subject represents the subject details
         * @return a string confirming successful submission or not
         * @throws Exception if user doesn't have the rights to perform the action
         **/
        @PostMapping("/subject/registerSubject")
        public String registerSubject (String role, @RequestBody Subject subject) throws Exception {
            return subjectService.registerSubject(role, subject);
        }

        /**
         * End-point for Retrieving all subjects that are stored in database
         * @param role represents the role of the current user
         * @return a List of subjects
         * @throws Exception if user doesn't have the rights to perform the action
         **/
        @GetMapping("/subject/retrieveAllSubjects")
        public List<Subject> retrieveAllSubjects (String role) throws Exception {
            subjectList = subjectService.retrieveAllSubjects(role);
            return subjectList;
        }

        /**
         * End-point for Updating subject details of the corresponding code passed in URL
         * @param role represents the role of the current user
         * @param subjectCode identifies the subject details to be updated
         * @param subject represents subject details
         * @return a String confirming successful update
         * @throws Exception if user doesn't have the rights to perform the action
         **/
        @PutMapping("/subject/update/{subjectCode}")
        public String updateSubjectDetails (@RequestParam String role,
                                            @PathVariable Long subjectCode,
                                            @RequestBody Subject subject) throws Exception {
            return subjectService.updateSubjectInfo(role, subjectCode, subject);
        }

        /**
         * End-point for Deleting subject of the corresponding code passed in URL
         * @param role represents the role of the current user
         * @param subjectCode identifies the subject details to be deleted
         * @return a String confirming successful delete
         * @throws Exception if user doesn't have the rights to perform the action
         **/
        @DeleteMapping("/subject/delete/{subjectCode}")
        public String deregisterSubject (@RequestParam String role, @PathVariable Long subjectCode) throws Exception {
            return subjectService.deleteSubject(role, subjectCode);
        }

        /**
         * End-point for registering the teacher that will be in the current class
         * @param role represents the role of the current user
         * @param teacher represents the teacher's details
         * @return a String confirming successful registration
         * @throws Exception if user doesn't have the rights to perform the action
         **/
        @PostMapping("/register/registerTeacher")
        public String registerTeacher (@RequestParam String role, Teacher teacher) throws Exception {
            return teacherService.registerTeacher(role, teacher);
        }

        /**
         * End-point for registering the teacher that will be in the current class
         * @param role represents the role of the current user
         * @param attendanceRegister represents the updated attendance register with updated attendance status for students
         * @return a String confirming successful update
         * @throws Exception if user doesn't have the rights to perform the action
         **/
        @PutMapping("/register/updateRegister")
        public String updateRegister (@RequestParam String role, @RequestBody AttendanceRegister attendanceRegister) throws
        Exception {
            return teacherService.updateRegister(role, attendanceRegister);
        }

    }

