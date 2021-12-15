package com.miu.waaproject.service;

import com.miu.waaproject.domain.Buyer;
import com.miu.waaproject.domain.Product;
import com.miu.waaproject.domain.ProductOrder;
import com.miu.waaproject.domain.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {
    ShoppingCart addToCart(Long buyerId, Long productId);//
    public ShoppingCart removeFromCart(Long buyerId, Long productId);//
    ProductOrder getProductOrders(Long buyerId);

}
