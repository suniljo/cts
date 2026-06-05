package com.cognizant.restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.restaurant.dao.RestaurantOrderDAO;
import com.cognizant.restaurant.dto.OrderResponseDTO;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantOrderDAO orderDAO;

    public OrderResponseDTO getOrder(String orderId) {
        return orderDAO.getOrderByOrderId(orderId);
    }
}
