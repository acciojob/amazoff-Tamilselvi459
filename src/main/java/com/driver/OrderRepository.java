package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class OrderRepository {


    HashMap<String , Order> orderMap ;
    HashMap<String, DeliveryPartner> partnerMap ;
    HashMap<String , List<String> > partnerorderMap;
    public int pass;

    public OrderRepository(){
        orderMap = new HashMap<>();
        partnerMap = new HashMap<>() ;
        partnerorderMap  = new HashMap<>();
        pass = 0;

    }


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
         pass++;
        partnerorderMap.put(partnerId,ans);
    }

    public Order getOrderById(String orderId) {

        return orderMap.get(orderId);
    }
    public DeliveryPartner getPartnerById(String partnerId) {
        if(partnerId!=null){
            if(partnerMap.containsKey(partnerId)) return partnerMap.get(partnerId);
        }
        return null;




    }
    public Integer getOrderCountByPartner(String partnerId) {

        if(partnerorderMap.containsKey(partnerId))
            return partnerorderMap.get(partnerId).size();
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
//       for(String id : orderMap.keySet()){
//           boolean flag = true;
//           for(String pid : partnerorderMap.keySet()){
//               List<String> list = partnerorderMap.get(pid);
//               if(list.contains(id)) {
//                   flag = false;
//                   break;
//               }
//           }
//           if(flag) count++;
//       }
        count = orderMap.size() - pass;
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
            if(time<orderMap.get(id).getDeliveryTime()) {
                time = orderMap.get(id).getDeliveryTime();
            }
        }
        t = Order.convertdeliveryTime(time);
        return t;
    }
    public void deletePartnerById(String partnerId){
        if(partnerorderMap.containsKey(partnerId)){
            partnerorderMap.remove(partnerId);
        }
        if(partnerMap.containsKey(partnerId)) partnerMap.remove(partnerId);
    }

//    public void deletePartnerById(String partnerId) {
//     if(partnerId!=null)
//        {
//         if (partnerorderMap.containsKey(partnerId)) {
//             List<String> ans = partnerorderMap.get(partnerId);
//             partnerorderMap.remove(partnerId);
//             for (String id : ans) {
//                 orderMap.remove(id);
//             }
//         }
//         if (partnerMap.containsKey(partnerId)) partnerMap.remove(partnerId);
//     }
//
//    }

    public void deleteOrderById(String orderId) {

            orderMap.remove(orderId);
            String ides = null;
            List<String> ans = new ArrayList<>();
            for (String id : partnerorderMap.keySet()) {
                ans = partnerorderMap.get(id);
                if (ans.contains(orderId)) {
                    ides = id;
                    ans.remove(orderId);
                    pass--;
                }
            }
            if (ides != null) partnerorderMap.put(ides, ans);

    }



}
