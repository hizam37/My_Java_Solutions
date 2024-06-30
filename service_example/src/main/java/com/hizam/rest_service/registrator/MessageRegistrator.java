package com.hizam.rest_service.registrator;

import com.hizam.rest_service.entity.Message;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.logging.Logger;


@Stateless
public class MessageRegistrator {

    @Inject
    private Logger logger;

    @Inject
    private EntityManager entityManager;

    public Message create(Message item) {
        logger.info("Created message mapping: " + item);
            entityManager.persist(item);
            return item;
    }

    public Message update(Message item) {
        logger.info("Updated message mapping: " + item);
        entityManager.merge(item);
        return item;
    }
    public Message delete(long id) {
        logger.info("Deleted message by id: " + id);
        Message item = entityManager.find(Message.class,id);
        entityManager.remove(entityManager.merge(item));
        return item;
    }
}