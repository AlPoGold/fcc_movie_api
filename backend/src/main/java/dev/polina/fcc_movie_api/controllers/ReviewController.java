package dev.polina.fcc_movie_api.controllers;

import dev.polina.fcc_movie_api.models.Review;
import dev.polina.fcc_movie_api.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    @Autowired
    private ReviewService service;

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload){
        return new ResponseEntity<>(
                service.createReview(
                        payload.get("imdbId"),
                        payload.get("reviewBody")),
                HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews(){
        return new ResponseEntity<>(service.getAllReviews(), HttpStatus.OK);
    }

}
