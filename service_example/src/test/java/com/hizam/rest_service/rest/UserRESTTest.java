package com.hizam.rest_service.rest;


import com.hizam.rest_service.entity.Message;
import com.hizam.rest_service.entity.MessageMapping;
import com.hizam.rest_service.entity.User;
import com.hizam.rest_service.registrator.UserRegistrator;
import com.hizam.rest_service.repository.MessageRepository;
import com.hizam.rest_service.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


class UserRESTTest {


    @InjectMocks
    UserREST userREST;

    @Mock
    private EntityManager entityManager;

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserRegistrator userRegistrator;

    @BeforeEach
    void Mockactivator() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testgetAllUsers() {
        List<User> userList = new ArrayList<>();
        User user = new User();
        user.setUserType("user");
        userList.add(user);
        when(userRepository.getAll()).thenReturn(userList);
        userList = userREST.getAllUsers();
        assertNotNull(userList.listIterator().next().getUserType());
    }

    @Test
    void testgetUserById() {
        User user= new User();
        when(userRepository.getById(1)).thenReturn(user);
        User user1 = userREST.getUserById(1);
        assertNotNull(user1);
    }

    @Test
    void testcreateuser() {
        User user = new User();
        when(userRegistrator.create(user)).thenReturn(user);
        User user1 = userREST.createuser(user);
        assertNotNull(user1);
    }

    @Test
    void testupdateuser() {
        User user = new User();
        when(userRegistrator.update(user)).thenReturn(user);
        User user1 = userRegistrator.update(user);
        assertNotNull(user1);
    }

    @Test
    void deleteUserById() {
        User user = new User();
        User item = entityManager.find(User.class,user.getId());
        when(userRegistrator.delete(user.getId())).thenReturn(item);
        User user1 = userRegistrator.delete(user.getId());
        assertNull(user1);
    }
}