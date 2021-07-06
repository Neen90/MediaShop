package com.vdab.mediashop.services;

import com.vdab.mediashop.domain.OrderLine;
import com.vdab.mediashop.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public void saveNewOrderLine(OrderLine newOrderLine) {
        orderRepository.saveNewOrderLine(newOrderLine);
    }
}
