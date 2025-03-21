package dev.polina.fcc_movie_api.repositories;

import dev.polina.fcc_movie_api.models.Movie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {

    Optional<Movie> findMovieByImdbId(String imdbId);
}
