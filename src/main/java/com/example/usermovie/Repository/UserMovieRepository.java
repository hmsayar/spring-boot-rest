package com.example.usermovie.Repository;

import com.example.usermovie.Entity.UserMovie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserMovieRepository extends CrudRepository<UserMovie, UserMovie.UserMovieId> {
    void deleteByMovieId(Integer id);
}