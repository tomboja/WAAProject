package com.miu.waaproject.service.Impl;

import com.miu.waaproject.domain.*;
import com.miu.waaproject.repository.ShoppingCartRepository;
import com.miu.waaproject.service.ShoppingCartService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Service
public class ShoppingCartImpl implements ShoppingCartService {
    @Autowired
    ShoppingCartRepository shoppingCartRepository;

    @Override
    public ShoppingCart addToCart(ShoppingCart shoppingCart, Buyer buyer, ProductOrder productOrder) {
//        Seller seller= product.getSeller();
//        ProductOrder productOrder = new ProductOrder();
//        productOrder.getProducts().add(product);
//        productOrder.setBuyer(buyer);
//        productOrder.setSeller(seller);
//        ShoppingCart shoppingCart = buyer.getShoppingCart();
//        shoppingCart.setOrder(productOrder);
//        return shoppingCartRepository.save(shoppingCart);
        shoppingCart.setOwner(buyer);
        shoppingCart.setOrder(productOrder);


        return shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public ShoppingCart removeProduct(ShoppingCart shoppingCart, Product product) {

       ProductOrder productOrder = shoppingCart.getOrder();
       List<Product> currentProduct = productOrder.getProducts();
       currentProduct.remove(product);
       productOrder.setProducts(currentProduct);
       shoppingCart.setOrder(productOrder);

        return shoppingCart;
    }

//    public ShoppingCart removeProduct(Buyer buyer, Product product) {
//        ShoppingCart shoppingCart = buyer.getShoppingCart();
//        ProductOrder productOrder = shoppingCart.getOrder();
//        productOrder.getProducts().remove(product);
//        shoppingCart.setOrder(productOrder);
//        return shoppingCart;
//
//    }
    @Override
    public ProductOrder getProductOrders(Buyer buyer) {
        ShoppingCart shoppingCart = buyer.getShoppingCart();
        ProductOrder productOrder = shoppingCart.getOrder();
        return productOrder;
    }
//    @Override
//    public List<ProductOrder> getProductOrders(Long id) {
//        return null;
//    }
}
