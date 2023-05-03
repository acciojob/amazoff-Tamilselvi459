package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    OrderRepository orderrepository = new OrderRepository();
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
        List<String> ans = orderrepository.getOrdersByPartnerId(partnerId);
        int t = Order.convertTime(time);
        Integer count = 0;
        for(String name : ans){
          int dtime = orderrepository.getOrderById(name).getDeliveryTime();
          if(t<dtime) count++;
        }
        return count;

    }

    public String getLastDeliveryTimeByPartnerId(String partnerId) {
        List<String> ans = orderrepository.getOrdersByPartnerId(partnerId);
        int max = 0;
        for(String name : ans){
            int dtime = orderrepository.getOrderById(name).getDeliveryTime();
            if(dtime>max) max = dtime;
        }
        return Order.convertTime(max);
    }

    public void deletePartnerById(String partnerId) {
        orderrepository.deletePartnerById(partnerId);
    }

    public void deleteOrderById(String orderId) {
        orderrepository.deleteOrderById(orderId);
    }
}
