package com.miu.waaproject.controller.orderController;

import com.miu.waaproject.domain.Buyer;
import com.miu.waaproject.domain.ProductOrder;
import com.miu.waaproject.service.BuyerService;
import com.miu.waaproject.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("order/")
public class OrderController {

    OrderService orderService;


    @GetMapping("AllOrders")
    public ResponseEntity<List<ProductOrder>> getAllOrders() {
        List<ProductOrder> Orders = orderService.getAllBuyers();
        if(Orders.size()!=0)
            return new ResponseEntity<>(Orders, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping("Register")
    public ResponseEntity<List<ProductOrder>> addNewOrder(@RequestBody ProductOrder productOrder) {
        List<ProductOrder> orders = orderService.addNewOrder(productOrder);
        if(orders.size()!=0)
            return new ResponseEntity<>(orders, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ProductOrder>> getOrdersByBuyerId(@PathVariable("userId") Long userId) {
        List<ProductOrder> Orders = orderService.getOrdersByBuyerId(userId);
        if(Orders.size()!=0)
            return new ResponseEntity<>(Orders, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    //@
}
