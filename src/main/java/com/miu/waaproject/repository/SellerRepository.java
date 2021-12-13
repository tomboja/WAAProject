package com.miu.waaproject.repository;

import com.miu.waaproject.domain.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ProjectName: IntelliJ IDEA
 * @Author: tdessalegn
 * @Date: 12/11/21
 */

public interface SellerRepository extends JpaRepository<Seller, Long> {
    Seller findByEmail(String seller_id);
}
