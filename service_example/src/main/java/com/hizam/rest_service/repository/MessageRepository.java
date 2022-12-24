package com.hizam.rest_service.repository;

import com.hizam.rest_service.entity.Message;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.logging.Logger;



@ApplicationScoped
public class MessageRepository {

    @Inject
    private Logger logger;

    @Inject
    private EntityManager entityManager;

    public Message getById(long id){
        logger.info("Get message by id: " + id);
        return entityManager.find(Message.class, id);
    }

    public List<Message> getAll(){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Message> criteria = criteriaBuilder.createQuery(Message.class);
        criteria.from(Message.class);
        return entityManager.createQuery(criteria).getResultList();
    }
}
