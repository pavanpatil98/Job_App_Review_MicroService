package com.pavan.reviewmicroservice.impl;


import com.pavan.reviewmicroservice.entity.Review;
import com.pavan.reviewmicroservice.repository.ReviewRepository;
import com.pavan.reviewmicroservice.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    ReviewRepository reviewRepository;
    //CompanyRepository companyRepository;
    public ReviewServiceImpl(ReviewRepository reviewRepository/*, CompanyRepository companyRepository*/){
        this.reviewRepository = reviewRepository;
        //this.companyRepository = companyRepository;
    }


    @Override
    public List<Review> findAllReviews(Long companyId) {
        return reviewRepository.findAllByCompanyId(companyId);
    }

    @Override
    public Review findReviewById(Long reviewId) {
        return reviewRepository.findByCompanyIdAndReviewId(reviewId).get();
    }


    /*public boolean addReview(Review review,Long companyId) {
        Optional<Company> company = companyRepository.findById(companyId);
        if(company.isPresent()){
            review.setCompany(company.get());
            reviewRepository.save(review);
            return true;
        }
        return false;
    }*/
    /*@Override
    public boolean addReview(Review review,Long companyId) {

        if(companyId!=null){
            review.setCompanyId(companyId);
            reviewRepository.save(review);
            return true;
        }
        return false;
    }*/

    @Override
    public boolean addReview(Review review,Long companyId) {
        if(companyId!=null){
            review.setCompanyId(companyId);
        }
        if(review!=null){
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    /*@Override
    public Integer removeReview(Long id,Long companyId) {
        Optional<Company> company = companyRepository.findById(companyId);
        return reviewRepository.deleteById(id,companyId).get();
    }*/
    @Override
    public void removeReview(Long reviewId) {
         reviewRepository.deleteById(reviewId);
    }


   /*
    @Override
   public boolean updateReview(Long reviweid,Long companyId, Review review) {

        Optional<Review> creview = reviewRepository.findByCompanyIdAndReviewId(id,companyId);
        if(creview.isPresent()){
            reviewRepository.updateReview(id,companyId,review);
            return true;
        }
        return false;
    }*/
    public boolean updateReview(Long reviewId,Review review) {
        Review updatedReview = reviewRepository.findById(reviewId).orElse(null);
        if(updatedReview!=null){
            updatedReview.setCompanyId(review.getCompanyId());
            updatedReview.setDescription(review.getDescription());
            updatedReview.setRating(review.getRating());
            updatedReview.setTitle(review.getTitle());
            reviewRepository.updateReview(reviewId,updatedReview);
            return true;
        }
        return false;
    }
}
