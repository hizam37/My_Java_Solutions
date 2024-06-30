package com.hizam.rest_service.registrator;
import com.hizam.rest_service.entity.MessageMapping;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.logging.Logger;


@Stateless
public class MessageMappingRegistrator {

    @Inject
    private Logger logger;

    @Inject
    private EntityManager entityManager;

    public MessageMapping create(MessageMapping item) {
        logger.info("Created message mapping: " + item);
        entityManager.persist(item);
        return item;
    }

    public MessageMapping update(MessageMapping item) {
        logger.info("Updated message mapping: " + item);
        Query query = entityManager.createQuery("update MessageMapping set to_id = :to_id, from_id = :from_id,message_id=:message_id where id = :id");
        query.setParameter("to_id",item.getTo_id());
        query.setParameter("from_id", item.getFrom_id() );
        query.setParameter("message_id", item.getMessage_id());
        query.setParameter("id", item.getId());
        query.executeUpdate();
        return item;
    }
    public MessageMapping delete(long id) {
        logger.info("Deleted messagemapping by id: " + id);
        MessageMapping item = entityManager.find(MessageMapping.class,id);
        entityManager.remove(item);
        return null;
    }
}
