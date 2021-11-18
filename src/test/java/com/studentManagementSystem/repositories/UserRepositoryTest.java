package com.studentManagementSystem.repositories;

import com.studentManagementSystem.entities.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    User user = new User();

    @Test
    public void testSavingToUserTable(){
        user = userRepository.save(completeUser());
        assertNotNull(user);
        assertNotNull(user.getEmail());
        assertNotNull(user.getName());
        assertNotNull(user.getSurname());
        assertNotNull(user.getCellNumber());
        assertNotNull(user.getEmail());
    }

    @Test
    public void testUpdateUser(){
        user = userRepository.save(completeUser());
        assertNotNull(user);
        user.setName("Peter");
        user = userRepository.save(user);
        assertNotNull(user.getName());
        assertEquals("Peter", user.getName());
    }

    @Test
    public void testFindByUserId(){
        List<User> userList;
        userList = userRepository.findByUserId(completeUser().getUserId());
        assertNotNull(userList);
    }

    @Test
    public void testFindByUserRole(){
        List<User> userList;
        userList = userRepository.findByUserRole(completeUser().getUserRole());
        assertNotNull(userList);
    }

    private User completeUser() {
        user.getUserId();
        user.setName("Linda");
        user.setSurname("Mabena");
        user.setUserRole("Student");
        user.setCellNumber("098644444545");
        user.setEmail("portia@gmail.com");
        user.setUserRole("User");
        return user;
    }


}