package com.hizam.rest_service.rest;

import com.hizam.rest_service.entity.Message;
import com.hizam.rest_service.entity.MessageMapping;
import com.hizam.rest_service.entity.User;
import com.hizam.rest_service.registrator.MessageMappingRegistrator;
import com.hizam.rest_service.repository.MessageMappingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class MessageMappingRESTTest {

    @InjectMocks
    MessageMappingREST messageMappingREST;

    @Mock
    private Logger logger;
    @Mock
    private MessageMappingRegistrator registrator;

    @Mock
    private MessageMappingRepository repository;

    @Mock
    private EntityManager entityManager;

    @BeforeEach
    void Mockactivator() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    void testgetAll() {
        List<MessageMapping> messageMappingList = new ArrayList<>();
        MessageMapping messageMapping = new MessageMapping();
        Message message = new Message();
        message.setId(1);
        messageMapping.setMessage_id(message);
        messageMappingList.add(messageMapping);
        when(repository.getAll()).thenReturn(messageMappingList);
        messageMappingList = messageMappingREST.getAll();
        assertNotNull(messageMappingList.listIterator().next().getMessage_id());
    }

    @Test
    void testgetmappingById() {
        MessageMapping messageMapping = new MessageMapping();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Message message = new Message();
        User user = new User();
        user.setId(1);
        User users = new User();
        users.setId(2);
        message.setId(1);
        message.setBody("sdfsd");
        message.setTime(timestamp);
        messageMapping.setMessage_id(message);
        messageMapping.setId(1);
        messageMapping.setFrom_id(user);
        messageMapping.setTo_id(users);
        when(repository.getById(1)).thenReturn(messageMapping);
        MessageMapping messagve1 = messageMappingREST.getmappingById(1);
        assertNotNull(messagve1);
    }

    @Test
    void testcreateMapping() {
        MessageMapping messageMapping = new MessageMapping();
        Message message = new Message();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        message.setTime(timestamp);
        messageMapping.setMessage_id(message);
        when(registrator.create(messageMapping)).thenReturn(messageMapping);
        MessageMapping message1 = messageMappingREST.createMapping(messageMapping);
        assertNotNull(message1.getMessage_id());
    }

    @Test
    void testupdateMapping() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Message message = new Message();
        User user = new User();
        message.setId(1);
        message.setBody("Hello EVA");
        message.setTime(timestamp);
        MessageMapping item = new MessageMapping();
        item.setMessage_id(message);
        user.setId(1);
        item.setTo_id(user);
        when(registrator.update(item)).thenReturn(item);
        MessageMapping messageMapping = messageMappingREST.updateMapping(item);
        assertNotNull(messageMapping);
    }

    @Test
    void testdeleteMappingById() {
        MessageMapping message = new MessageMapping();
        MessageMapping item = entityManager.find(MessageMapping.class,message.getId());
        when(registrator.delete(message.getId())).thenReturn(item);
        MessageMapping messageMapping = messageMappingREST.deleteMappingById(1);
        assertNull(messageMapping);
    }
}