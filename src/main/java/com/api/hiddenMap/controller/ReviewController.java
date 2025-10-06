package com.api.hiddenMap.controller;

import com.api.hiddenMap.entity.ReviewEntity;
import com.api.hiddenMap.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/review")
@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping()
    public ReviewEntity createReview(@RequestBody ReviewEntity review){
        return  reviewService.createReview(review);
    }

    @PutMapping("/{id}")
    public ReviewEntity editReview(@PathVariable Long id,ReviewEntity review){
        return reviewService.editReview(review,id);
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable Long id){
        reviewService.deleteReview(id);
    }
}
