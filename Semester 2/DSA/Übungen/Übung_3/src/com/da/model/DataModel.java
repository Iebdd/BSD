package com.da.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Project: recommender
 * DataModel class serves as the main data storage for movies, users, and their ratings.
 * It provides methods to access and manipulate this data.
 */
public class DataModel {
    private Map<Integer, Movie> movies; // Map of movie ID to Movie objects
    private Map<Integer, User> users;  // Map of user ID to User objects
    private List<List<Integer>> user_movie; // Maps a user review to each movie

    /**
     * Constructor to initialize the DataModel with empty data structures.
     */
    public DataModel() {
        this.movies = new HashMap<>();
        this.users = new HashMap<>();
        this.user_movie = new ArrayList<>();
    }

    /**
     * Gets the map of movies.
     *
     * @return A map containing movie ID as the key and Movie objects as the value.
     */
    public Map<Integer, Movie> getMovies() {
        return movies;
    }

    /**
     * Gets the map of users.
     *
     * @return A map containing user ID as the key and User objects as the value.
     */
    public Map<Integer, User> getUsers() {
        return users;
    }

    public int getRatingByUserAndMovie(int user_id, int movie_id) {
        try {
            return this.user_movie.get(user_id).get(movie_id);  // Returns the rating for a given user and a given movie
        } catch (IndexOutOfBoundsException e) {                 // (Accesses the user array at the first index and the movie at the second)
            return 0;
        }
    }

    public void addRating(int user_id, int movie_id, Rating rating) {
        System.out.println(this.user_movie.get(user_id));
    }

    /**
     * Returns the user instance with the specified user name.
     * This method searches through the collection of users stored in the data model and compares
     * each user's name with the provided search name. If a match is found, the corresponding user
     * instance is returned. If no user with the specified name exists, null is returned.
     *
     * @param searchName the name of the user to search for; must not be null
     * @return the user instance with the specified name, or null if no such user is found
     */
    public User returnUserByName(String searchName) {
        for (User user : users.values()) {
            if (user.getName().equals(searchName)) {
                return user;
            }
        }
        return null;
    }

}
