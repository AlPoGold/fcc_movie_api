package dev.polina.fcc_movie_api.services;

import com.mongodb.client.result.UpdateResult;
import dev.polina.fcc_movie_api.models.Movie;
import dev.polina.fcc_movie_api.models.Review;
import dev.polina.fcc_movie_api.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    ReviewRepository repository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Review> getAllReviews(){
        return repository.findAll();
    }
    public Review createReview(String imdbId, String reviewBody){
        Review review = repository.save(new Review(reviewBody));

        UpdateResult result = mongoTemplate
                .update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewsIds").value(review.getId()))
                .first();

        // Проверяем, было ли обновление успешным
        if (result.getModifiedCount() == 0) {
            throw new RuntimeException("Movie with imdbId " + imdbId + " not found!");
        }

        return review;
    }
}
