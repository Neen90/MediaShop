package com.vdab.mediashop.repositories;

import org.apache.catalina.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class UserRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(rollbackOn = Exception.class)
    public void saveNewUser(User newUser) {
        entityManager.persist(newUser);

    }
}
