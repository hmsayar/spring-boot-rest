package com.example.usermovie.dto;

public class UserMoviePayload {
    private Integer userId;
    private Integer movieId;
    private int rate;
    //private String review;

    public Integer getUserId() {
        return userId;
    }

    //public String getReview() {
      //  return review;
    //}

    //public void setReview(String review) {
      //  this.review = review;
    //}

    public void setRate(int rate) {
        this.rate = rate;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public int getRate() {
        return rate;
    }

    public Integer getMovieId() {
        return movieId;
    }

}