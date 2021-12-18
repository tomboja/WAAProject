package com.miu.waaproject.service;

import com.miu.waaproject.domain.Review;

import java.util.List;

/**
 * @ProjectName: IntelliJ IDEA
 * @Author: tdessalegn
 * @Date: 12/17/21
 */

public interface ReviewService {
    public Review saveReview(Review review);
    public boolean deleteReview(long id);
    public List<Review> getAllReviews();
    public Review getReviewById(long id);
}
