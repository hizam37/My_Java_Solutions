package com.hizam.rest_service.repository;
import com.hizam.rest_service.entity.MessageMapping;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.logging.Logger;



@ApplicationScoped
public class MessageMappingRepository {

    @Inject
    private EntityManager entityManager;

    @Inject
    private Logger logger;

    public List<MessageMapping> getAll(){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<MessageMapping> criteria = criteriaBuilder.createQuery(MessageMapping.class);
        criteria.from(MessageMapping.class);
        return entityManager.createQuery(criteria).getResultList();
    }

    public MessageMapping getById(long id){
        logger.info("Get message mapping by id: " + id);
        return entityManager.find(MessageMapping.class, id);
    }


}
