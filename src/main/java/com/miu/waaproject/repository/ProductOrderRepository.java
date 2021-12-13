package com.miu.waaproject.repository;

import com.miu.waaproject.domain.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @ProjectName: IntelliJ IDEA
 * @Author: tdessalegn
 * @Date: 12/11/21
 */

public interface ProductOrderRepository extends JpaRepository<ProductOrder, Long> {
    @Query(value = "select p FROM ProductOrder p WHERE p.buyer.id=: buyerId ")
    List<ProductOrder> getOrdersByBuyerId(@Param("buyerId") Long buyerId);
}
