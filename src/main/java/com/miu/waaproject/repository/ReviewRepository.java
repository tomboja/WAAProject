package com.miu.waaproject.repository;

import com.miu.waaproject.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @ProjectName: IntelliJ IDEA
 * @Author: tdessalegn
 * @Date: 12/11/21
 */

public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query("select r from Review r where r.approved=false ")
    List<Review> findByApproved();

    @Query("select r from Review r where r.product_id = :productId")
    List<Review> findByProductId(long productId);
}
