package com.vdab.mediashop.repositories;

import com.vdab.mediashop.domain.Users;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(rollbackOn = Exception.class)
    public void saveNewUser(Users newUser) {
        entityManager.persist(newUser);
    }

    public List<Users> getUsers() {
        TypedQuery<Users> users =entityManager.createQuery("select u from Users u",Users.class);
        return users.getResultList();
    }
    @Transactional(rollbackOn = Exception.class)
    public void updateLoginValue(Users loggedInUser) {
        entityManager.merge(loggedInUser);
    }

    public Users findById(Long id) {

        return entityManager.find(Users.class, id);
    }

    @Transactional(rollbackOn = Exception.class)
    public void updateToLoggedOut(Users loggedOutUser) {

        entityManager.merge(loggedOutUser);
    }
}
