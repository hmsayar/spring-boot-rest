package com.example.usermovie.Entity;

import jakarta.persistence.*;


@Table(name = "movies")
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Integer releaseDate;


    public Movie() {
    }

    public Movie(String name, String description, Integer releaseDate) {
        this.name = name;
        this.description = description;
        this.releaseDate = releaseDate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getReleaseDate() {
        return releaseDate;
    }

}