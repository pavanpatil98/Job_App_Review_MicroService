package com.pavan.reviewmicroservice.repository;



import com.pavan.reviewmicroservice.entity.Review;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review,Long> {
    @Query("Select r from Review r where r.companyId = :companyId")
    public List<Review> findAllByCompanyId(@Param("companyId")Long companyId);


    @Query("Select r from Review r where r.id = :id")
    public Optional<Review> findByCompanyIdAndReviewId(@Param("id")Long id);

    /*@Transactional
    @Modifying
    @Query("Delete from Review r where r.company.id = :companyId and r.id = :id")
    public Optional<Integer> deleteById(@Param("id")Long id,@Param("companyId")Long companyid);*/

    @Transactional
    @Modifying
    @Query("Delete from Review r where r.id = :id")
    public void deleteById(@Param("id")Long reviewId);

   /* @Transactional
    @Modifying
    @Query("Update Review r set r.title = :#{#review.title}, r.description = :#{#review.description},r.rating = :#{#review.rating} where r.id = :id and r.company.id = :companyId")
    public void updateReview(@Param("id")Long id,@Param("companyId")Long companyid, @Param("review")Review review);*/

    @Transactional
    @Modifying
    @Query("Update Review r set r.title = :#{#review.title}, r.description = :#{#review.description},r.rating = :#{#review.rating} where r.id = :id")
    public void updateReview(@Param("id")Long id,@Param("review")Review review);



}
