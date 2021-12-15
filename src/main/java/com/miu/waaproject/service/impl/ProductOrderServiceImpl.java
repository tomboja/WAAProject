package com.miu.waaproject.service.impl;

import com.miu.waaproject.domain.Buyer;
import com.miu.waaproject.domain.ProductOrder;
import com.miu.waaproject.enums.Order_Status;
import com.miu.waaproject.repository.BuyerRepository;
import com.miu.waaproject.repository.ProductOrderRepository;
import com.miu.waaproject.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ProductOrderServiceImpl implements OrderService {

    private final ProductOrderRepository productOrderRepository;
    private final BuyerRepository buyerRepository;

        @Override
        public List<ProductOrder> getAllOrders() {
            List<ProductOrder> orders = productOrderRepository.findAll();
            return orders;
        }

        @Override
        public ProductOrder addNewOrder(ProductOrder productOrder) {
            ProductOrder currentOrder = new ProductOrder();
            currentOrder.setId(productOrder.getId());
            currentOrder.setBuyer_email(productOrder.getBuyer_email());
            currentOrder.setProducts(productOrder.getProducts());
            currentOrder.setStatus(productOrder.getStatus());


            return productOrderRepository.save(currentOrder);

        }

        @Override
        public Order_Status getOrderStatus(Long orderId) {
            ProductOrder currentOrder = productOrderRepository.findById(orderId).orElseThrow(null);
            return currentOrder.getStatus();
        }

        @Override
        public Order_Status updateOrderStatusByBuyer(Long orderId) {
            ProductOrder productOrder = productOrderRepository.findById(orderId).orElseThrow(null);
            if(productOrder.getStatus().equals(Order_Status.RECEIVED))
                productOrder.setStatus(Order_Status.CANCELLED);

            return productOrder.getStatus();
        }

        @Override
        public Order_Status updateOrderStatusBySeller(Long orderId) {
            ProductOrder productOrder = productOrderRepository.findById(orderId).orElseThrow(null);
            if(productOrder==null)
                return null;
            if(productOrder.getStatus().equals(Order_Status.RECEIVED))
                productOrder.setStatus(Order_Status.SHIPPED);

            if(productOrder.getStatus().equals(Order_Status.SHIPPED))
                productOrder.setStatus(Order_Status.ON_THE_WAY);

            if(productOrder.getStatus().equals(Order_Status.ON_THE_WAY))
                productOrder.setStatus(Order_Status.DELIVERED);

            return productOrder.getStatus();

        }


        @Override
        public ProductOrder getOrdersByBuyerId(Long buyerId) {
            Buyer buyer = buyerRepository.getById(buyerId);
            ProductOrder productOrders = buyer.getShoppingCart().getOrder();

            return productOrders;
        }

    }
