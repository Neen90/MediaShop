package com.vdab.mediashop.repositories;

import com.vdab.mediashop.domain.Game;
import com.vdab.mediashop.domain.LP;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class LPRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<LP> getAllLps() {
        TypedQuery<LP> lps = entityManager.createQuery("select l from LP l",LP.class);
        return lps.getResultList();

    }
}
