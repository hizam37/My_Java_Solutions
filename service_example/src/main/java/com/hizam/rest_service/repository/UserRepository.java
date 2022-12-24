package com.hizam.rest_service.repository;
import com.hizam.rest_service.entity.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.logging.Logger;


@ApplicationScoped
public class UserRepository {

    @Inject
    private Logger logger;

    @Inject
    private EntityManager entityManager;

    public User getById(long id){
        logger.info("Get User by id: " + id);
        return entityManager.find(User.class, id);
    }

    public List<User> getAll() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteria = criteriaBuilder.createQuery(User.class);
        criteria.from(User.class);
        return entityManager.createQuery(criteria).getResultList();
    }
}

