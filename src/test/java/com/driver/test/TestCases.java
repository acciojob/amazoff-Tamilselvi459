package com.driver.test;

import com.driver.*;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = Application.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestCases {

//    OrderController ordercontroller;
//    OrderRepository orderrepositry;
//    OrderService orderservice;
//
//    @BeforeEach
//    public void setup(){
//        orderrepositry = new OrderRepository();
//
//        orderservice = new OrderService(orderrepositry);
//        ordercontroller = new OrderController(orderservice);
//
//    }
//
//    @Test
//    public void expecttoadd(){
//        Order order = new Order("1234" , "12:34");
//        ordercontroller.addOrder(order);
//        ResponseEntity<List<String>> ans = ordercontroller.getAllOrders();
//        assertEquals(1,ans.getBody().size());
//        assertEquals("1234" , ans.getBody().get(0));
//
//    }
//    @Test
//    public void expectaddpartner(){
//        DeliveryPartner dp = new DeliveryPartner("100");
//
//        ResponseEntity<String> ans = ordercontroller.addPartner("100");
//        assertEquals("New delivery partner added successfully" , ans.getBody());
//        assertEquals(HttpStatus.CREATED , ans.getStatusCode());
//    }
//
//    @Test
//    public void expectorderpartnerpair(){
//        ordercontroller.addOrder(new Order("15" , "34:21"));
//        ordercontroller.addPartner("1");
//        ordercontroller.addOrderPartnerPair("15" , "1");
//        ResponseEntity<List<String>> ans = ordercontroller.getOrdersByPartnerId("1");
//        assertEquals("15" , ans.getBody().get(0));
//        assertEquals(HttpStatus.CREATED , ans.getStatusCode());
//    }
//
}