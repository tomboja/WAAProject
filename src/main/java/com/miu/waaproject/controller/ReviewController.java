package com.miu.waaproject.controller;

import com.miu.waaproject.domain.Review;
import com.miu.waaproject.service.impl.ReviewServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ProjectName: IntelliJ IDEA
 * @Author: tdessalegn
 * @Date: 12/17/21
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reviews")
public class ReviewController {
    private final ReviewServiceImpl reviewService;

    @PostMapping
    public ResponseEntity<Review> saveReview(@RequestBody Review review) {
        Review r = reviewService.saveReview(review);
        return r != null ?
                new ResponseEntity<>(r, HttpStatus.CREATED) :
                new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable("id") long id) {
        Review review = reviewService.getReviewById(id);

        return review != null
                ? new ResponseEntity<>(review, HttpStatus.OK)
                : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping()
    public ResponseEntity<List<Review>> getPReviewsList() {
        return new ResponseEntity<>(reviewService.getAllReviews(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteReview(@PathVariable("id") long id) {
        boolean deleted = reviewService.deleteReview(id);

        return deleted ? new ResponseEntity<>(null, HttpStatus.OK)
                : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
