package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class OrderRepository {
<<<<<<< HEAD
    HashMap<String , Order> orderMap = new HashMap<>();
    HashMap<String, DeliveryPartner> partnerMap = new HashMap<>();
    HashMap<String , List<String> > partnerorderMap = new HashMap<>();
=======
    HashMap<String , Order> orderMap;
    HashMap<String, DeliveryPartner> deliveryPartnerHashMap ;
    HashMap<String , String > pairMap ;
    public OrderRepository(){
        this.orderMap = new HashMap<String,Order>();
        this.deliveryPartnerHashMap = new HashMap<String,DeliveryPartner>();
        this.pairMap = new HashMap<String,String>();
    }
>>>>>>> cf1e2647468d769b85cbe2a14aac32d9489d1477

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
<<<<<<< HEAD
        List<String> ans = partnerorderMap.get(partnerId);
        ans.add(orderId);
        partnerorderMap.put(partnerId,ans);
    }

    public Order getOrderById(String orderId) {

        return orderMap.get(orderId);
    }

    public DeliveryPartner getPartnerById(String partnerId) {

        return partnerMap.get(partnerId);
=======

        pairMap.put(orderId , partnerId);
    }

    public Order getOrderById(String orderId) {
        if(orderMap.containsKey(orderId)) return orderMap.get(orderId);
        return null;
    }

    public DeliveryPartner getPartnerById(String partnerId) {
        if(deliveryPartnerHashMap.containsKey(partnerId))
        return deliveryPartnerHashMap.get(partnerId);
        return null;
>>>>>>> cf1e2647468d769b85cbe2a14aac32d9489d1477
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
<<<<<<< HEAD
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
=======
      count = getAllOrders().size() - pairMap.size();
      return count;
>>>>>>> cf1e2647468d769b85cbe2a14aac32d9489d1477
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
