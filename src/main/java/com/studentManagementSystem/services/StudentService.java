package com.studentManagementSystem.services;

import com.studentManagementSystem.entities.Student;
import com.studentManagementSystem.constants.AppConstants;
import com.studentManagementSystem.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

@Service
public class StudentService {
   @Autowired
   StudentRepository studentRepository;

    List<Student> studentList = new ArrayList<>();

    /**
     * Service for registering a student and store in database after validating the request and check for nulls
     * @param student represents the student details
     * @return a string confirming successful submission or not
     *
     **/
    public String submitStudentDetails(String role, Student student) throws Exception {
        if(role.equalsIgnoreCase(AppConstants.ADMIN)) {
            studentList = studentRepository.findByUserId(student.getUserId());
            try {
                if (isNull(student)) {
                    return "Enter student details";
                } else if (!studentList.isEmpty()) {
                    return "Student already exists";
                } else if (student.getName() == null || student.getSurname() == null || student.getCellNumber() == null) {
                    return "There's a missing mandatory field";
                } else {
                    studentRepository.save(student);

                }
            } catch (Exception e) {
                e.getMessage();
            }
            return "Successfully saved Student";
        }else {
            throw new Exception("You do not have the rights to add student");
        }

    }

    /**
     * Service for retrieving all students that are stored in database
     *
     * @return a List of students
     *
     **/
    public List<Student> retrieveAllStudents(String role) throws Exception {
        if (role.equalsIgnoreCase(AppConstants.ADMIN)) {
            try {
                studentList = studentRepository.findAll();
            } catch (ArrayIndexOutOfBoundsException E) {
                E.getMessage();
            } catch (Exception Ex) {
                Ex.getMessage();
            }
            return studentList;
        }
        else {
            throw new Exception("You do not have the rights to retrieve all students");
        }
    }

    /**
     * Service for updating student details and store in database after checking if student is registered
     * @param studentId identifies the student in database
     * @param student represents the student details
     * @return a string confirming successful update or not
     *
     **/
    public String updateStudentDetails(String role, Long studentId, Student student) throws Exception {
        if (role.equalsIgnoreCase(AppConstants.ADMIN) || role.equalsIgnoreCase(AppConstants.STUDENT)) {
            studentList = studentRepository.findByUserId(studentId);
            if (studentList.isEmpty()) {
                return "Student is not registered";
            } else {
                studentRepository.save(student);
                return "Successfully updated Student";
            }
        }
        else {
            throw new Exception("You do not have the rights to update student details");
        }

    }

    /**
     * Service for deleting student details and store in database after checking if student is registered
     * @param studentId identifies the student in database
     *
     * @return a string confirming successful delete
     *
     **/
    public String deleteStudent(String role, Long studentId) throws Exception {
        if (role.equalsIgnoreCase(AppConstants.ADMIN) || role.equalsIgnoreCase(AppConstants.STUDENT)) {
            studentList = studentRepository.findByUserId(studentId);
            if (studentList.isEmpty()) {
                return "Student is not registered";
            } else {
                studentRepository.delete(studentList.get(0));
                return "Successfully de-registered Student";
            }
        }
        else {
            throw new Exception("You do not have the rights to de-register student");
        }

    }
}
