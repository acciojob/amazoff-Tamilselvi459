package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderrepository ;
    // as


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

    public Integer getOrdersLeftAfterGivenTimeByPartnerId(String time, String partnerId) {
        int a = Order.convertdeliveryTime(time);
        return orderrepository.getOrdersLeftAfterGivenTimeByPartnerId(a,partnerId);
    }

    public String getLastDeliveryTimeByPartnerId(String partnerId) {
        return orderrepository.getLastDeliveryTimeByPartnerId(partnerId);
    }

    public void deletePartnerById(String partnerId) {
        orderrepository.deletePartnerById(partnerId);
    }

    public void deleteOrderById(String orderId) {
        orderrepository.deleteOrderById(orderId);
    }
}
