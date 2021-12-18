package com.miu.waaproject.service.impl;

import com.miu.waaproject.domain.Review;
import com.miu.waaproject.exceptions.ResourceNotFoundException;
import com.miu.waaproject.repository.ReviewRepository;
import com.miu.waaproject.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @ProjectName: IntelliJ IDEA
 * @Author: tdessalegn
 * @Date: 12/17/21
 */

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    @Override
    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public boolean deleteReview(long id) {
        Review r = reviewRepository
                .findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Review", "Id", id, "get review by Id"));
        if (r != null) {
            reviewRepository.deleteById(id);
            return true;
        } else return false;
    }

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public Review getReviewById(long id) {
        Review review = reviewRepository
                .findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Review", "Id", id, "get review by Id"));

        return review;
    }
}
