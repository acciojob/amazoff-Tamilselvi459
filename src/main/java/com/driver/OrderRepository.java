package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class OrderRepository {

    HashMap<String , Order> orderMap = new HashMap<>();
    HashMap<String, DeliveryPartner> partnerMap = new HashMap<>();
    HashMap<String , List<String> > partnerorderMap = new HashMap<>();


    public void addOrder(Order order) {

        orderMap.put(order.getId(), order);
    }

    public void addPartner(String partnerId) {
        DeliveryPartner partner = new DeliveryPartner(partnerId);
        List<String> ans = new ArrayList<>();
        partnerMap.put(partnerId,partner);
        partnerorderMap.put(partnerId ,ans );
    }

    public void addOrderPartnerPair(String orderId, String partnerId) {

        List<String> ans = partnerorderMap.get(partnerId);
        ans.add(orderId);
        partnerorderMap.put(partnerId,ans);
    }

    public Order getOrderById(String orderId) {

        return orderMap.get(orderId);
    }
    public DeliveryPartner getPartnerById(String partnerId) {
        return partnerMap.get(partnerId);
    }
    public Integer getOrderCountByPartner(String partnerId) {

        if(partnerorderMap.containsKey(partnerId))  return partnerorderMap.get(partnerId).size();
        return 0;
    }

    public List<String> getOrdersByPartnerId(String partnerId) {

            return partnerorderMap.get(partnerId);
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
           boolean flag = false;
           for(String partnerid : partnerorderMap.keySet()){
               List<String> ans = partnerorderMap.get(partnerid);
               if(ans.contains(id))
               {
                   flag = true;
                   break;
               }
           }
           if(flag==false) count++;

           }
       return count;
       }

    public Integer getOrdersLeftAfterGivenTimeByPartnerId(int a, String partnerId) {
        Integer count = 0;

        List<String> ans = partnerorderMap.get(partnerId);
        for(String id : ans){
            if(orderMap.get(id).getDeliveryTime()>a) count++;
        }
        return count;
    }

    public String getLastDeliveryTimeByPartnerId(String partnerId) {
        String t = "";
        int time = 0;
        List<String> ans = partnerorderMap.get(partnerId);
        for(String id : ans){
            if(time>orderMap.get(id).getDeliveryTime()) {
                time = orderMap.get(id).getDeliveryTime();
            }
        }
        t = Order.convertdeliveryTime(time);
        return t;
    }

    public void deletePartnerById(String partnerId) {
        partnerorderMap.remove(partnerId);
    }

    public void deleteOrderById(String orderId) {
        orderMap.remove(orderId);
        for(String id : partnerorderMap.keySet()){
            List<String> ans = partnerorderMap.get(id);
            if(ans.contains(orderId)) ans.remove(orderId);
        }
    }



}
