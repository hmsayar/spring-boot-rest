package com.example.usermovie.Entity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.Set;

@Table(name = "users")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;

    @Column(unique = true, nullable = false, length = 100)
    private String email;

    @Column(unique = true, nullable = false, length = 100)
    private String name;


    @OneToMany(mappedBy = "user", cascade= CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<UserMovie> ratedMovies;

    public Set<UserMovie> getRatedMovies() {
        return ratedMovies;
    }

    public User() {}

    public User(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }



}