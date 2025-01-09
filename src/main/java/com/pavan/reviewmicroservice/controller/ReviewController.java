package com.pavan.reviewmicroservice.controller;



import com.pavan.reviewmicroservice.entity.Review;
import com.pavan.reviewmicroservice.impl.ReviewServiceImpl;
import com.pavan.reviewmicroservice.messaging.RabbitMqProducer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {


    private ReviewServiceImpl reviewService;
    private RabbitMqProducer rabbitMqProducer;

    public ReviewController(ReviewServiceImpl reviewService,RabbitMqProducer rabbitMqProducer) {
        this.reviewService = reviewService;
        this.rabbitMqProducer = rabbitMqProducer;
    }

    @GetMapping
    public ResponseEntity<List<Review>> getReviews(@RequestParam Long companyId) {
        System.out.println(companyId+"-----------------------");
        List<Review> reviews = reviewService.findAllReviews(companyId);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getOneReviews(@PathVariable("id") Long id) {
        Review review = reviewService.findReviewById(id);
        return new ResponseEntity<>(review, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Review> addReview(@RequestBody Review review,@RequestParam Long companyId) {
        boolean result = reviewService.addReview(review,companyId);
        rabbitMqProducer.sendMessage(review);
        return result ?  new ResponseEntity<>(review, HttpStatus.CREATED) :  new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> removeReview(@PathVariable("id") Long id) {
        reviewService.removeReview(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateReview(@PathVariable("id") Long id, @RequestBody Review review) {
        boolean result = reviewService.updateReview(id,review);
        return result ? new ResponseEntity<>("updated review", HttpStatus.OK):new ResponseEntity<>("failed", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/averageRating")
    public Double getAverageRating(@RequestParam Long companyId){
        List<Review> reviews = reviewService.findAllReviews(companyId);
        return reviews.stream().mapToDouble(Review::getRating).average().orElse(0.0);
    }


}
