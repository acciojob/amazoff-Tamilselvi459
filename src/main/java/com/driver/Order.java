package com.driver;

import java.util.Arrays;
import java.util.List;

public class Order {

    private String id;
    private int deliveryTime;

    public Order(String id, String deliveryTime) {

        // The deliveryTime has to converted from string to int and then stored in the attribute
        //deliveryTime  = HH*60 + MM
        this.id = id;
        this.deliveryTime = convertdeliveryTime(deliveryTime);
    }

    public static int convertdeliveryTime(String deliveryTime) {
        List<String> list = Arrays.asList(deliveryTime.split(":"));
        int HH = Integer.parseInt(list.get(0));
        int MM = Integer.parseInt(list.get(1));
        return HH*60 + MM;
    }
    public static String convertdeliveryTime(int deliveryTime){
        String hh = String.valueOf(deliveryTime/60);
        String mm = String.valueOf(deliveryTime%60);
        if(hh.length()==1) hh = '0'+hh;
        if(mm.length()==1) mm = '0'+mm;

        return hh+":"+mm;
    }
   public void setDeliveryTime(String deliveryTime){
        this.deliveryTime = convertdeliveryTime(deliveryTime);
   }
    public void setId(String id) {
        this.id = id;
    }

    public void setDeliveryTime(int deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getId() {
        return id;
    }

    public int getDeliveryTime() {return deliveryTime;}
}
