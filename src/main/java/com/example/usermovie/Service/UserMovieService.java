package com.example.usermovie.Service;

import com.example.usermovie.dto.UserMoviePayload;
import com.example.usermovie.Entity.User;
import com.example.usermovie.Entity.Movie;
import com.example.usermovie.Entity.UserMovie;
import com.example.usermovie.Repository.MovieRepository;
import com.example.usermovie.Repository.UserMovieRepository;
import com.example.usermovie.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.usermovie.exception.ResourceNotFoundException;


import java.util.Optional;

@Service
public class UserMovieService {
    private final UserMovieRepository userMovieRepository;
    private final UserRepository userRepository;
    private final MovieRepository movieRepository;

    @Autowired
    public UserMovieService(UserMovieRepository userMovieRepository, UserRepository userRepository, MovieRepository movieRepository) {
        this.userMovieRepository = userMovieRepository;
        this.userRepository = userRepository;
        this.movieRepository = movieRepository;
    }

    public Optional<UserMovie> getUserMovieById(UserMovie.UserMovieId id) {
        return userMovieRepository.findById(id);
    }


    @Transactional
    public UserMovie createUserMovie(UserMoviePayload payload) {
        Integer userId = payload.getUserId();
        Integer movieId = payload.getMovieId();
        int rate = payload.getRate();

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found"));

        UserMovie.UserMovieId userMovieId = new UserMovie.UserMovieId(userId, movieId);
        UserMovie userMovie = new UserMovie(userMovieId, rate);

        userMovie.setUser(user);
        userMovie.setMovie(movie);

        return userMovieRepository.save(userMovie);
    }

    @Transactional
    public UserMovie updateUserMovie(Integer userId, Integer movieId, UserMoviePayload payload) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found"));

        UserMovie.UserMovieId userMovieId = new UserMovie.UserMovieId(userId, movieId);
        UserMovie userMovie = userMovieRepository.findById(userMovieId)
                .orElseThrow(() -> new ResourceNotFoundException("UserMovie not found"));

        userMovie.setRate(payload.getRate());
        userMovie.setUser(user);
        userMovie.setMovie(movie);

        return userMovieRepository.save(userMovie);
    }

    public void deleteUserMovie(UserMovie.UserMovieId id) {
        userMovieRepository.deleteById(id);
    }
}
