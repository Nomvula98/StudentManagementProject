package com.studentManagementSystem.repositories;

import com.studentManagementSystem.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
 List<User> findByUserRole(String userRole);
 List<User> findByUserId(Long userId);

}
