package com.studentManagementSystem.repositories;


import com.studentManagementSystem.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    List<Teacher> findByTeacherId(Long teacherId);
}
