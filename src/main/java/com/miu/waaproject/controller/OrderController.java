package com.miu.waaproject.controller;

import com.miu.waaproject.domain.Buyer;
import com.miu.waaproject.domain.ProductOrder;
import com.miu.waaproject.enums.Order_Status;
import com.miu.waaproject.service.BuyerService;
import com.miu.waaproject.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/order")
public class OrderController {
    @Autowired
    private OrderService orderService;


    @GetMapping
    public ResponseEntity<List<ProductOrder>> getAllOrders() {
        List<ProductOrder> Orders = orderService.getAllOrders();
        return Orders.size()!=0? new ResponseEntity<>(Orders, HttpStatus.OK): new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<ProductOrder> addNewOrder(@RequestBody ProductOrder productOrder) {
        ProductOrder order = orderService.addNewOrder(productOrder);
        return order!=null? new ResponseEntity<>(order, HttpStatus.OK): new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    @GetMapping("/{orderId}")
    public ResponseEntity<Order_Status> getOrderStatus(@PathVariable("orderId") Long orderId){
        Order_Status currentOrder = orderService.getOrderStatus(orderId);
        return currentOrder!=null? new ResponseEntity<>(orderService.getOrderStatus(orderId), HttpStatus.OK):
                new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/orderStatus/{orderId}/seller")
    public ResponseEntity<Order_Status> setOrderStatusBySeller(@PathVariable("orderId") Long orderId){

        Order_Status currentOrder = orderService.updateOrderStatusBySeller(orderId);

        return currentOrder!=null? new ResponseEntity<>(orderService.updateOrderStatusBySeller(orderId), HttpStatus.OK):
                new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/orderStatus/{orderId}/buyer")
    public ResponseEntity<Order_Status> setOrderStatusByBuyer(@PathVariable("orderId") Long orderId){

        Order_Status currentOrder = orderService.updateOrderStatusByBuyer(orderId);

        return currentOrder!=null? new ResponseEntity<>(orderService.updateOrderStatusByBuyer(orderId), HttpStatus.OK):
                new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

}
