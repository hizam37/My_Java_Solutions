package com.hizam.rest_service.registrator;

import com.hizam.rest_service.entity.User;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.logging.Logger;


@Stateless
public class UserRegistrator {

    @Inject
    private Logger logger;

    @Inject
    private EntityManager entityManager;


    public User create(User item) {
        logger.info("Created message mapping: " + item);
        entityManager.persist(item);
        return item;
    }

    public User update(User item) {
        logger.info("Updated message mapping: " + item);
        entityManager.merge(item);
        return item;
    }
    public User delete(long id) {
        User item = entityManager.find(User.class,id);
        if(item!=null)
        {
            logger.info("Deleted User by id: " + id);
            entityManager.remove(item);
        }
            logger.info("User does not exist");
        return item;
    }
}