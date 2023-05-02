package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class OrderRepository {
    HashMap<String , Order> orderMap = new HashMap<>();
    HashMap<String, DeliveryPartner> deliveryPartnerHashMap = new HashMap<>();
    HashMap<String , String > pairMap = new HashMap<>();

    public void addOrder(Order order) {
        orderMap.put(order.getId(), order);
    }

    public void addPartner(String partnerId) {
        DeliveryPartner partner = new DeliveryPartner(partnerId);
        deliveryPartnerHashMap.put(partnerId,partner);
    }

    public void addOrderPartnerPair(String orderId, String partnerId) {
        pairMap.put(orderId , partnerId);
    }

    public Order getOrderById(String orderId) {
        return orderMap.get(orderId);
    }

    public DeliveryPartner getPartnerById(String partnerId) {
        return deliveryPartnerHashMap.get(partnerId);
    }

    public Integer getOrderCountByPartner(String partnerId) {
        Integer count = 0;
       for(String id : pairMap.keySet()){
            if(pairMap.get(id).equals(partnerId)) count++;
       }
       return count;
    }

    public List<String> getOrdersByPartnerId(String partnerId) {
        List<String> ans = new ArrayList<>();
        for(String id : pairMap.keySet()){
            if(pairMap.get(id).equals(partnerId)) ans.add(id);
        }
          return ans;
    }

    public List<String> getAllOrders() {
        List<String> ans = new ArrayList<>();
        for(String id : orderMap.keySet()){
            ans.add(id);
        }
        return ans;
    }

    public Integer getCountOfUnassignedOrders() {
        Integer count = 0;
      for(String id : orderMap.keySet()){
          if(!pairMap.containsKey(id))  count++;
      }
      return count;
    }
}
