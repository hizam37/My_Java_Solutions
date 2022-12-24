package com.hizam.rest_service.rest;

import com.hizam.rest_service.entity.Message;
import com.hizam.rest_service.entity.User;
import com.hizam.rest_service.registrator.MessageRegistrator;
import com.hizam.rest_service.repository.MessageRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import java.util.ArrayList;
import java.util.List;
import org.mockito.MockitoAnnotations;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class MessageRESTTest {


    @InjectMocks
    MessageREST messageREST;

    @Mock
    private EntityManager entityManager;
    @Mock
    private MessageRepository messageRepository;

    @Mock
    private MessageRegistrator messageRegistrator;

    @BeforeEach
    void Mockactivator() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    void testgetlistall()
    {
        List<Message> messageList = new ArrayList<>();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Message message = new Message();
        message.setBody("Hello world");
        message.setId(1);
        message.setTime(timestamp);
        messageList.add(message);
        when(messageRepository.getAll()).thenReturn(messageList);
        messageList = messageREST.getListAll();
    }


    @Test
    void testgetmessagebyid() {
        Message message = new Message();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        message.setBody("SA");
        message.setTime(timestamp);
        when(messageRepository.getById(1)).thenReturn(message);
        Message message1 = messageREST.getMessageById(1);
        assertNotNull(message1);
        assertEquals("SA",message1.getBody());
        assertEquals(timestamp,message1.getTime());
    }




    @Test
    void testupdatemessage()
    {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Message message = new Message();
        message.setBody("Hello EVA");
        message.setTime(timestamp);
        when(messageRegistrator.update(message)).thenReturn(message);
        Message message1 = messageREST.updateMessage(message);
        assertNotNull(message1);
        assertEquals("Hello EVA",message1.getBody());
        assertEquals(timestamp,message1.getTime());
    }

    @Test
    void testdeletemessagebyid()
    {
        Message message = new Message();
        message.setBody("asdfas");
        message.setId(2);
        Message item = entityManager.find(Message.class,message.getId());
        when(messageRegistrator.delete(message.getId())).thenReturn(item);
        Message message1 = messageREST.deleteMessageById(message.getId());
        assertNull(message1);
    }
}


