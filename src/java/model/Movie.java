/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;

/**
 *
 * @author leeng
 */
public class Movie {

    private int movieId;
    private String movieName;
    private String description;
    private int duration;
    private int rated;
    private int publishedYear;
    private String country;
    private String imagePath;
    private String videoPath;

    private List<Category> categories;

    public Movie() {
    }

    public Movie(int movieId, String movieName, String description, int duration, int rated, int publishedYear, String country, String imagePath, String videoPath, List<Category> categories) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.description = description;
        this.duration = duration;
        this.rated = rated;
        this.publishedYear = publishedYear;
        this.country = country;
        this.imagePath = imagePath;
        this.videoPath = videoPath;
        this.categories = categories;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getRated() {
        return rated;
    }

    public void setRated(int rated) {
        this.rated = rated;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    @Override
    public String toString() {
        return "Movie{" + "movieId=" + movieId + ", movieName=" + movieName + ", description=" + description + ", duration=" + duration + ", rated=" + rated + ", publishedYear=" + publishedYear + ", country=" + country + ", imagePath=" + imagePath + ", videoPath=" + videoPath + ", categories=" + categories + '}';
    }

}
