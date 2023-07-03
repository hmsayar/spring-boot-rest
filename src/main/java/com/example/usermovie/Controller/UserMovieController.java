package com.example.usermovie.Controller;

import com.example.usermovie.Entity.UserMovie;
import com.example.usermovie.dto.UserMoviePayload;
import com.example.usermovie.Service.UserMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usermovies")
public class UserMovieController {
    @Autowired
    private UserMovieService userMovieService;


    @GetMapping("/user/{userId}/movie/{movieId}")
    public UserMovie getUserMovieById(@PathVariable Integer userId, @PathVariable Integer movieId) {
        return userMovieService.getUserMovieById(new UserMovie.UserMovieId(userId, movieId)).orElseThrow(() -> new RuntimeException("UserMovie not found"));
    }

    @PostMapping("/")
    public UserMovie createUserMovie(@RequestBody UserMoviePayload payload) {
        return userMovieService.createUserMovie(payload);
    }

    @PutMapping("/user/{userId}/movie/{movieId}")
    public UserMovie updateUserMovie(@PathVariable Integer userId,
                                     @PathVariable Integer movieId,
                                     @RequestBody UserMoviePayload payload) {
        return userMovieService.updateUserMovie(userId, movieId, payload);
    }

    @DeleteMapping("/user/{userId}/movie/{movieId}")
    public void deleteUserMovie(@PathVariable Integer userId, @PathVariable Integer movieId) {
        userMovieService.deleteUserMovie(new UserMovie.UserMovieId(userId, movieId));
    }
}
