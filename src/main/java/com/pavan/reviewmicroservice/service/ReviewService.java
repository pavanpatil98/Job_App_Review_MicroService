package com.pavan.reviewmicroservice.service;

import com.pavan.reviewmicroservice.entity.Review;

import java.util.List;

public interface ReviewService {
    public List<Review> findAllReviews(Long companyId);
    public Review findReviewById(Long reviewId);
    public boolean addReview(Review Review,Long companyId);
    public void removeReview(Long reviewId);
    public boolean updateReview(Long reviewId,Review Review);
}
