package com.thomblweed.jpatensteps.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import com.thomblweed.jpatensteps.entity.User;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class UserDOAService {
    
    @PersistenceContext
    private EntityManager entityManager;

    public long insert(User user) {
        entityManager.persist(user);
        return user.getId();
    }
}