package com.vdab.mediashop.repositories;

import com.vdab.mediashop.domain.OrderLine;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class OrderRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(rollbackOn = Exception.class)
    public void saveNewOrderLine(OrderLine newOrderLine) {
        entityManager.merge(newOrderLine);
    }
}
