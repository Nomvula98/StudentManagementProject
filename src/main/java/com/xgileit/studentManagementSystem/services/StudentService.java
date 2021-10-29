package com.studentManagementSystem.services;

import com.studentManagementSystem.entities.Student;
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
    public String submitStudentDetails(Student student)
    {

        studentList = studentRepository.findByStudentId(student.getStudentId());
       try {
           if (isNull(student)) {
               return "Enter student details";
           }
           else if(!studentList.isEmpty()){
               return "Student already exists";
           }
           else
               if (student.getName() == null || student.getSurname() == null || student.getCellNumber() == null) {
               return "There's a missing mandatory field";
           } else {
           studentRepository.save(student);

           }
       }catch (Exception e){
           e.getMessage();
       }
           return "Successfully saved Student";

    }

    /**
     * Service for retrieving all students that are stored in database
     *
     * @return a List of students
     *
     **/
    public List<Student> retrieveAllStudents()
    {
        try {
            studentList = studentRepository.findAll();
        }catch (ArrayIndexOutOfBoundsException E){
            E.getMessage();
        }catch (Exception Ex){
            Ex.getMessage();
        }
        return studentList;
    }

    /**
     * Service for updating student details and store in database after checking if student is registered
     * @param studentId identifies the student in database
     * @param student represents the student details
     * @return a string confirming successful update or not
     *
     **/
    public String updateStudentDetails(Long studentId, Student student)
    {
        studentList = studentRepository.findByStudentId(studentId);
        if (studentList.isEmpty()) {
            return "Student is not registered";
        }
        else{
            studentRepository.delete(studentList.get(0));
            studentRepository.save(student);
            return "Successfully updated Student";
        }

    }

    /**
     * Service for deleting student details and store in database after checking if student is registered
     * @param studentId identifies the student in database
     *
     * @return a string confirming successful delete
     *
     **/
    public String deleteStudent(Long studentId)
    {
        studentList = studentRepository.findByStudentId(studentId);
        if (studentList.isEmpty()) {
            return "Student is not registered";
        }
        else{
            studentRepository.delete(studentList.get(0));
            return "Successfully de-registered Student";
        }

    }
}
