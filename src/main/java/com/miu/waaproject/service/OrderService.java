package com.miu.waaproject.service;

import com.miu.waaproject.domain.ProductOrder;

import java.util.List;

public interface OrderService {

    List<ProductOrder> getAllBuyers();
    List<ProductOrder> addNewOrder(ProductOrder productOrder);

    List<ProductOrder> getOrdersByBuyerId(Long userId);
}
