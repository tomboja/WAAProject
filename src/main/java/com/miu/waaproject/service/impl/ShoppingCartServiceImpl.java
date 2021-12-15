package com.miu.waaproject.service.impl;

import com.miu.waaproject.domain.*;
import com.miu.waaproject.repository.BuyerRepository;
import com.miu.waaproject.repository.ProductRepository;
import com.miu.waaproject.repository.SellerRepository;
import com.miu.waaproject.repository.ShoppingCartRepository;
import com.miu.waaproject.service.ShoppingCartService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Transactional
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    ShoppingCartRepository shoppingCartRepository;
    @Autowired
    BuyerRepository buyerRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    SellerRepository sellerRepository;

    @Override
    public ShoppingCart addToCart(Long buyerId, Long productId) {

            Buyer buyer= buyerRepository.findById(buyerId).orElseThrow(null);
            ShoppingCart shoppingCart = buyer.getShoppingCart();

        if(shoppingCart.getOrder() == null) {
            ProductOrder productOrder = new ProductOrder();
            productOrder.setProducts(new ArrayList<>());
            shoppingCart.setOrder(productOrder);
        }

            Product product = productRepository.findById(productId).orElseThrow(null);
            String sellerId = product.getSeller_id();// needs clarification
            Seller seller = sellerRepository.findByEmail(sellerId);
            ProductOrder productOrder = shoppingCart.getOrder();
            List<Product> newProduct = new ArrayList<>();
            for(Product product1: productOrder.getProducts()){
                newProduct.add(product1);
            }
            newProduct.add(product);
            productOrder.setProducts(newProduct);
            productOrder.setBuyer_email(buyer.getEmail());
            shoppingCart.setOrder(productOrder);

        return shoppingCartRepository.save(shoppingCart);

    }

    @Override
    public ShoppingCart removeFromCart(Long bId, Long pId) {
        Buyer buyer = buyerRepository.findById(bId).orElseThrow(null);
        Product product = productRepository.findById(pId).orElseThrow(null);
        ShoppingCart shoppingCart=buyer.getShoppingCart();
        ProductOrder productOrder = shoppingCart.getOrder();
        productOrder.getProducts().remove(product);
        shoppingCart.setOrder(productOrder);

        return shoppingCart;
    }

    @Override
    public ProductOrder getProductOrders(Long buyerId) {
        Buyer buyer = buyerRepository.findById(buyerId).orElseThrow(null);
        ShoppingCart shoppingCart = buyer.getShoppingCart();
        ProductOrder productOrder = shoppingCart.getOrder();
        System.out.println(productOrder.getProducts());
        return productOrder;
    }

}
