package com.studentManagementSystem.repositories;

import com.studentManagementSystem.entities.AttendanceRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AttendanceRegisterRepository extends JpaRepository<AttendanceRegister, Long> {
    List<AttendanceRegister> findByRegisterId(Long id);
}
