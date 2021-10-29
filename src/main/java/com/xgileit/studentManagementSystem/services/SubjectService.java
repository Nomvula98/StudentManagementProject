package com.studentManagementSystem.services;


import com.studentManagementSystem.entities.Subject;
import com.studentManagementSystem.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

@Service
public class SubjectService {
    @Autowired
    SubjectRepository subjectRepository;
    List<Subject> subjectList = new ArrayList<>();

    /**
     * Service for registering a subject and store in database after validating the request and check for nulls
     * @param subject represents the subject details
     * @return a string confirming successful submission or not
     *
     **/
    public String registerSubject(Subject subject)
    {
        subjectList = subjectRepository.findBySubjectCode(subject.getSubjectCode());
        try {
            if (isNull(subject)) {
                return "Enter subject details";
            }
            else if(!subjectList.isEmpty()){
                return "Subject already exists";
            }
                else if (subject.getSubjectCode() == null || subject.getSubjectName() == null){
                return "There's a missing mandatory field";
            } else {
                subjectRepository.save(subject);

            }
        }catch (Exception e){
            e.getMessage();
        }
        return "Successfully saved Subject";
    }

    /**
     * Service for retrieving all subjects that are stored in database
     *
     * @return a List of subjects
     *
     **/
    public List<Subject> retrieveAllSubjects()
    {
        try {
            subjectList = subjectRepository.findAll();
        }catch (ArrayIndexOutOfBoundsException E){
            E.getMessage();
        }catch (Exception Ex){
            Ex.getMessage();
        }
        return subjectList;
    }

    /**
     * Service for updating subject details and store in database after checking if subject is registered
     * @param subjectCode identifies the subject in database
     * @param subject represents the subject details
     * @return a string confirming successful update or not
     *
     **/
    public String updateSubjectInfo(Long subjectCode, Subject subject)
    {
        subjectList = subjectRepository.findBySubjectCode(subjectCode);
        if (subjectList.isEmpty()) {
            return "Subject is not registered";
        }
        else{
            subjectRepository.delete(subjectList.get(0));
            subjectRepository.save(subject);
            return "Successfully updated Subject";
        }
    }

    /**
     * Service for deleting subject details and store in database after checking if subject is registered
     * @param subjectCode identifies the subject in database
     *
     * @return a string confirming successful delete
     *
     **/
    public String deleteSubject(Long subjectCode) {
        subjectList = subjectRepository.findBySubjectCode(subjectCode);
        if (subjectList.isEmpty()) {
            return "Subject is not registered";
        } else {
            subjectRepository.delete(subjectList.get(0));
            return "Successfully deleted subject";
        }
    }
}
