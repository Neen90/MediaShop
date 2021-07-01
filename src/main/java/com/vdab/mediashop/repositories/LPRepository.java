package com.vdab.mediashop.repositories;

import com.vdab.mediashop.domain.Game;
import com.vdab.mediashop.domain.LP;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository

public class
LPRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<LP> getAllLps() {
        TypedQuery<LP> lps = entityManager.createQuery("select l from LP l",LP.class);
        return lps.getResultList();

    }
    @Transactional(rollbackOn = Exception.class)
    public void saveLp(LP newLP) {

        entityManager.persist(newLP);
    }
    public LP findLPById(long id) {

        return entityManager.find(LP.class, id);
    }

    @Transactional(rollbackOn = Exception.class)
    public void updateLP(LP lp) {

        entityManager.merge(lp);
    }
    @Transactional(rollbackOn = Exception.class)
    public void deleteLP(long id) {
        LP lp =findLPById(id);
        entityManager.remove(lp);
    }
}
