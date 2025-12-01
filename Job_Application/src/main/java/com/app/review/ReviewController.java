package com.app.review;

import com.app.company.Company;
import org.hibernate.engine.transaction.jta.platform.internal.ResinJtaPlatform;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company/{companyId}")
public class ReviewController {
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReview(@PathVariable Long companyId) {
        return new ResponseEntity<>(reviewService.getAllReview(companyId), HttpStatus.OK);
    }


    @PostMapping("/reviews")
    public ResponseEntity<String> addReview (
            @PathVariable Long companyId,
            @RequestBody Review review
    ) {
        boolean status = reviewService.addReview(companyId, review);
        if(status)
            return new ResponseEntity<>("Review Added Successfully", HttpStatus.OK);
        return  new ResponseEntity<>("Review Not Saved", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReviewByID(@PathVariable Long companyId,
                                                @PathVariable Long reviewId)
    {
        return new ResponseEntity<>(reviewService.getReviewById(companyId, reviewId), HttpStatus.OK);
    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReview(
            @PathVariable Long companyId,
            @PathVariable Long reviewId,
            @RequestBody Review review
    ) {
        boolean status = reviewService.updateReview(companyId,reviewId, review);
        if(status)
            return new ResponseEntity<>("Review with id : "+reviewId+" for Company with id: " +companyId+ " updated successfully", HttpStatus.OK );
        return new ResponseEntity<>("Review Not Updated", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(
            @PathVariable Long companyId,
            @PathVariable Long reviewId
    )
    {
        boolean status = reviewService.deleteReview(companyId, reviewId);
        if(status)
            return new ResponseEntity<>("Review Deleted Successfully", HttpStatus.OK);
        return new ResponseEntity<>("Review Not Found", HttpStatus.NOT_FOUND);
    }




}
