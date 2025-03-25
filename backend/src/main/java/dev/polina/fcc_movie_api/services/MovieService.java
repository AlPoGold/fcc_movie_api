package dev.polina.fcc_movie_api.services;

import dev.polina.fcc_movie_api.models.Movie;
import dev.polina.fcc_movie_api.repositories.MovieRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;
    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovieById(String imdbId){
        return movieRepository.findMovieByImdbId(imdbId);
    }
}
