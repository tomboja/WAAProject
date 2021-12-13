package com.miu.waaproject.service;

import com.miu.waaproject.domain.Buyer;
import com.miu.waaproject.domain.Product;
import com.miu.waaproject.domain.ProductOrder;
import com.miu.waaproject.domain.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {
    ShoppingCart addToCart(ShoppingCart shoppingCart, Buyer buyer, ProductOrder productOrder);//
    public ShoppingCart removeProduct(ShoppingCart shoppingCart, Product product);//
    ProductOrder getProductOrders(Buyer buyer);

}
