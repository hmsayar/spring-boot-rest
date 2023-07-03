package com.example.usermovie.Service;

import com.example.usermovie.Entity.Movie;
import com.example.usermovie.Repository.MovieRepository;
import com.example.usermovie.Repository.UserMovieRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserMovieRepository userMovieRepository;

    public Page<Movie> getAllMovies(Pageable pageable) {
        return movieRepository.findAll(pageable);
    }
    public Optional<Movie> getMovieById(Integer id){
        return movieRepository.findById(id);
    }

    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie updateMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Transactional
    public void deleteMovie(Integer id) {
        userMovieRepository.deleteByMovieId(id);
        movieRepository.deleteById(id);
    }
}
