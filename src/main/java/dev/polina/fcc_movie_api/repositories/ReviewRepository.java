package dev.polina.fcc_movie_api.repositories;

import dev.polina.fcc_movie_api.models.Review;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReviewRepository extends MongoRepository<Review, String> {
}
