package com.example.usermovie.Service;

import com.example.usermovie.Entity.User;
import com.example.usermovie.Repository.UserRepository;
import com.example.usermovie.Entity.UserMovie;
import com.example.usermovie.Entity.Movie;
import com.example.usermovie.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }
    public User getUserAndRatedMovies(Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        // Now you can access the user's rated movies
        Set<UserMovie> ratedMovies = user.getRatedMovies();
        // For each UserMovie, you can get the corresponding Movie
        for (UserMovie userMovie : ratedMovies) {
            Movie movie = userMovie.getMovie();
            // Do something with the movie
        }
        return user;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
        userRepository.delete(user);
    }
}
