package com.miu.waaproject.repository;

import com.miu.waaproject.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ProjectName: IntelliJ IDEA
 * @Author: tdessalegn
 * @Date: 12/11/21
 */

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
