package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class OrderRepository {
    HashMap<String , Order> orderMap;
    HashMap<String, DeliveryPartner> deliveryPartnerHashMap ;
    HashMap<String , String > pairMap ;
    public OrderRepository(){
        this.orderMap = new HashMap<String,Order>();
        this.deliveryPartnerHashMap = new HashMap<String,DeliveryPartner>();
        this.pairMap = new HashMap<String,String>();
    }

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

    public void deletePartnerById(String partnerId) {
        deliveryPartnerHashMap.remove(partnerId);
       List<String> ans =  getOrdersByPartnerId(partnerId);
       for(String name : ans){
           pairMap.remove(name);
       }
    }

    public void deleteOrderById(String orderId) {
        orderMap.remove(orderId);
        pairMap.remove(orderId);
    }
}
