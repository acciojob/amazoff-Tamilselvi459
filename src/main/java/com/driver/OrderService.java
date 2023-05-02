package com.driver;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    OrderRepository orderrepository  = new OrderRepository();


    public void addOrder(Order order) {
        orderrepository.addOrder(order);
    }

    public void addPartner(String partnerId) {
        orderrepository.addPartner(partnerId);
    }

    public void addOrderPartnerPair(String orderId, String partnerId) {
        orderrepository.addOrderPartnerPair(orderId , partnerId);
    }

    public Order getOrderById(String orderId) {
       return orderrepository.getOrderById(orderId);
    }

    public DeliveryPartner getPartnerById(String partnerId) {
        return orderrepository.getPartnerById(partnerId);
    }

    public Integer getOrderCountByPartner(String partnerId) {
        return orderrepository.getOrderCountByPartner(partnerId);
    }

    public List<String> getOrdersByPartnerId(String partnerId) {
        return orderrepository.getOrdersByPartnerId(partnerId);
    }

    public List<String> getAllOrders() {
        return orderrepository.getAllOrders();
    }

    public Integer getCountOfUnassignedOrders() {
        return orderrepository.getCountOfUnassignedOrders();
    }
}
