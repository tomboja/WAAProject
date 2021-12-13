package com.miu.waaproject.service;

import com.miu.waaproject.domain.ProductOrder;
import com.miu.waaproject.enums.Order_Status;

import java.io.FileNotFoundException;
import java.util.List;

public interface OrderService {

    List<ProductOrder> getAllOrders();

    List<ProductOrder> getOrdersByBuyerId(Long userId);

    ProductOrder addNewOrder(ProductOrder productOrder);

    Order_Status getOrderStatus(Long orderId);

    Order_Status updateOrderStatusByBuyer(Long orderId);

    Order_Status updateOrderStatusBySeller(Long orderId);

}
