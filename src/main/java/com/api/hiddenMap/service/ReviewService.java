package com.api.hiddenMap.service;

import com.api.hiddenMap.entity.ReviewEntity;
import com.api.hiddenMap.repository.ReviewRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepositry reviewRepositry;

    public  ReviewEntity createReview(ReviewEntity review){
        return reviewRepositry.save(review);
    }

    public ReviewEntity editReview(ReviewEntity review,Long id){
        ReviewEntity update = reviewRepositry.findById(id).orElse(null);
        update.setComment(review.getComment());
        update.setRating(review.getRating());
        return  reviewRepositry.save(update);
    }

    public void deleteReview(Long id){
        reviewRepositry.deleteById(id);
    }
}
