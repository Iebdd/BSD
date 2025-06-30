package com.da.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Project: recommender
 * DataModel class serves as the main data storage for movies, users, and their ratings.
 * It provides methods to access and manipulate this data.
 */
public class DataModel {
    private final Map<Integer, Movie> movies; // Map of movie ID to Movie objects
    private final Map<Integer, User> users;  // Map of user ID to User objects
    private final Map<String, Integer> user_names; //Map of user names to user_ids;
    private final Map<String, List<Integer>> movie_names; //Map of movie names to movie_ids;
    private final ArrayList<ArrayList<Rating>> user_movie; // Maps a user review to each movie
    private final ArrayList<List<Integer>> likeness; // Maps the rating likeness of two users
            // The last two cannot be the more generic List, since it doesn't provide ensureCapacity
    /**
     * Constructor to initialize the DataModel with empty data structures.
     */
    public DataModel() {
        this.movies = new HashMap<>();
        this.users = new HashMap<>();
        this.user_movie = new ArrayList<>();
        this.user_names = new HashMap<>();
        this.movie_names = new HashMap<>();
        this.likeness = new ArrayList<>(new ArrayList<>());
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

    /**
     * Returns the map of all users and their ids
     * 
     * @return The map of all users and ids
     */
    public Map<String, Integer> getUserNamesMap() {
        return this.user_names;
    }

    /**
     * Returns the map of all movies and their ids
     * 
     * @return  The map of all users and ids
     */
    public Map<String, List<Integer>> getMovieNamesMap() {
        return this.movie_names;
    }

    /**
     * Adds or changes a rating within the rating array
     * 
     * @param user_id   // The user to add the rating for
     * @param movie_id  // The movie to add the rating for
     * @param rating    // The rating in question
     * @param init      // True if called during initial setup, false otherwise
     */
    public void addRating(int user_id, int movie_id, Rating rating, boolean init) {
        while(this.user_movie.size() - 1 < user_id) {    // Fill the user_movie array with elements until the required index
                this.user_movie.add(new ArrayList<>(Collections.nCopies(this.movies.size() + 1, Rating.fromInt(0))));
        }
        try {
            this.user_movie.get(user_id);                // Or add into an unitialised hole within
        } catch (IndexOutOfBoundsException e) {
            this.user_movie.set(user_id, new ArrayList<>(Collections.nCopies(this.movies.size() + 1, Rating.fromInt(0))));
        }
        try {
            this.user_movie.get(user_id).get(movie_id);  // Check if the movie to be filled is within the initial input amount
        } catch (IndexOutOfBoundsException e) {          // and fill it if it is not
            this.user_movie.get(user_id).ensureCapacity(movie_id + 1);
            while(this.user_movie.get(user_id).size() - 1 < movie_id) {
                this.user_movie.get(user_id).add(Rating.fromInt(0));
            }
        }
        this.user_movie.get(user_id).set(movie_id, rating);
        if(!init) {
            setAllLikeness();
        }
    }

    /**
     * Deletes a rating from the rating array (Set it to 0)
     * 
     * @param user_id   // The user who made the rating
     * @param movie_id  // The movie the rating was made for
     */
    public void deleteRating(int user_id, int movie_id) {
        this.user_movie.get(user_id).set(movie_id, Rating.fromInt(0));
        setAllLikeness();
    }

    /**
     * Returns all ratings given by users in the system
     * 
     * @return  A String containing all ratings
     */
    public String printAllRatings() {
        StringBuilder ratings = new StringBuilder();
        ArrayList<Integer> user_ids = new ArrayList<>(this.users.keySet());  
        ArrayList<Integer> movie_ids = new ArrayList<>(this.movies.keySet());
        Collections.sort(user_ids);
        Collections.sort(movie_ids); //Convert to ArrayList and sort to guarantee ordering
        for(int user_id : user_ids) {
            for(int movie_id : movie_ids) {
                if(this.user_movie.get(user_id).get(movie_id).getValue() != 0) {
                    ratings.append(String.format(
                        "%d: %s -> %d: %s%n", 
                        user_id, 
                        this.users.get(user_id).getName(), 
                        movie_id, 
                        Rating.fromInt(this.user_movie.get(user_id).get(movie_id).getValue())));
                }
            }
        }
        return ratings.toString();
    }

    /**
     * Return all ratings for a given user
     * 
     * @param user_name The user for which to return ratings for
     * 
     * @return  A String containing all of a user's ratings
     */
    public String printUserRatings(String user_name) {
        StringBuilder ratings = new StringBuilder();
        int user_id;
        try {
            user_id = this.user_names.get(user_name);
        } catch (NullPointerException e) {
            return String.format("User name: %s not found.", user_name);
        }
        ratings.append(String.format("Ratings of user %d: %s%n", user_id, user_name));
        for(int movie_id = 1; movie_id < this.user_movie.get(user_id).size(); movie_id++) {
            Movie movie = this.movies.get(movie_id);
            if(this.user_movie.get(user_id).get(movie_id) != null && this.user_movie.get(user_id).get(movie_id).getValue() != 0) {
                ratings.append(String.format(
                    "%d: %s (%s) - %s: %s%n", 
                    movie_id,
                    movie.getTitle(),
                    movie.getYear(),
                    movie.getGenre(),
                    Rating.fromInt(this.user_movie.get(user_id).get(movie_id).getValue())));
            }
        }
        return ratings.toString();
    }

    /**
     * Returns all ratings for a given
     * 
     * @param movie The movie in question
     * 
     * @return  A String containing all the movie's ratings
     */
    public String printMovieRatings(Movie movie) {
        if(movie.getId() > this.movies.size()) {
            return "Movie could not be found. Please enter the exact title, year and genre separated by commas";
        }
        StringBuilder ratings = new StringBuilder();
        ratings.append(String.format(
            "Ratings for movie %d: %s (%d) - %s%n", 
            movie.getId(), 
            movie.getTitle(), 
            movie.getYear(), 
            movie.getGenre()));
        for(int user_id : this.users.keySet()) {
            if(this.user_movie.get(user_id).get(movie.getId()) != null && this.user_movie.get(user_id).get(movie.getId()).getValue() != 0) {
                ratings.append(String.format(
                    "%s -> %s%n", 
                    this.users.get(user_id).getName(), 
                    Rating.fromInt(this.user_movie.get(user_id).get(movie.getId()).getValue())));
            }
        }
        return ratings.toString();
    }

    /**
     * Sets the capacity of the ratings array so it has to only be adjusted once
     * 
     * @param capacity  The capacity of the ratings array
     */
    public void setRatingCapacity(int capacity) {
        this.user_movie.ensureCapacity(capacity + 1);   // One more because ids start at 1 but the index starts at 0
    }

    /**
     * Returns the user instance with the specified user name.
     * This method resolves a name in the user_name map to find the corresponding user_id and
     * uses that to find the User object for this user in the users map. Returns null if no
     * user with that name exists.
     *
     * @param searchName the name of the user to search for
     * @return the user instance with the specified name, or null if no such user is found
     */
    public User returnUserByName(String searchName) {
        return this.users.get(this.user_names.get(searchName.toLowerCase()));
    }

    public Movie returnMovieByInfo(String title, int year, String genre) {
        List<Integer> movie_ids = this.movie_names.get(title);
        if(movie_ids == null) {
            return null;
        } else if (movie_ids.size() == 1) {
            return this.movies.get(movie_ids.get(0));
        } else {
            for(int movie_id : movie_ids) {
                Movie movie = this.movies.get(movie_id);
                if(movie.getYear() == year && movie.getGenre().equals(genre)) {
                    return movie;
                }
            }
        }
        return null;
    }

    /**
     * Finds a Movie object based on the title, year and genre
     * 
     * @param title The title of the movie
     * @param year  The year the movie was released
     * @param genre The genre of the movie
     * 
     * @return  A Movie object if the movie was found and null otherwise
     */
    public Movie findMovie(String title, int year, String genre) {
        if(this.movie_names.get(title.toLowerCase()) != null) {
            for(Integer movie_id : this.movie_names.get(title)) {
                if(this.movies.get(movie_id).getYear() == year && this.movies.get(movie_id).getGenre().equals(genre)) {
                    return this.movies.get(movie_id);
                }
            }
        }
        return null;
    }

    /**
     * Checks whether a given movie exists within the system (Same as findMovie but returning a boolean)
     * 
     * @param title The title of the movie
     * @param year  The year the movie was released
     * @param genre The genre of the movie
     * 
     * @return  True if the movie exists, false if not
     */
    public boolean isPresent(String title, int year, String genre) {
        if(this.movie_names.get(title.toLowerCase()) != null) {
            for(Integer movie_id : this.movie_names.get(title.toLowerCase())) {
                if(this.movies.get(movie_id).getYear() == year && this.movies.get(movie_id).getGenre().equals(genre)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Adds a user to the system if it doesn't exist yet
     * 
     * @param name  The name of the new user
     * 
     * @return  Returns a String informing about the action
     */
    public String addUser(String name) {
        if(this.user_names.get(name) != null) {
            return String.format("User already exists with id: %d%n", this.user_names.get(name));
        }
        User new_user = new User(findEmptyUser(), name);
        this.users.put(new_user.getUserId(), new_user);
        this.user_names.put(name.toLowerCase(), new_user.getUserId());
        if(new_user.getUserId() == this.users.size()) {
            this.user_movie.add(new ArrayList<>(Collections.nCopies(this.movies.size() + 1, Rating.fromInt(0))));
            this.likeness.add(new ArrayList<>(Collections.nCopies(this.users.size() + 1, 0)));
        } else {
            this.user_movie.set(new_user.getUserId(), new ArrayList<>(Collections.nCopies(this.movies.size() + 1, Rating.fromInt(0))));
            this.likeness.set(new_user.getUserId(), new ArrayList<>(Collections.nCopies(this.users.size() + 1, 0)));
        }
        return String.format("Created new user: %s with id: %d%n", name, new_user.getUserId());
    }

    /**
     * Deletes a user from the system. Also disassociates the user from the ratings array
     * 
     * @param name  The name of the user to be deleted
     * 
     * @return  Returns a String informing about the action
     */
    public String deleteUser(String name) {
        User user = this.users.get(this.user_names.get(name.toLowerCase()));
        if(user == null) {
            return String.format("User: %s could not be found%n", name);
        }
        this.users.remove(user.getUserId());
        this.user_names.remove(user.getName());
        return String.format("User: %s with id: %d deleted%n", name, user.getUserId());
    }

    /**
     * Adds a movie to the database
     * 
     * @param movie A Movie object containing the movie
     * 
     * @return  Returns a String informing about the action
     */
    public String addMovie(Movie movie) {
        if(movie.getId() != this.movies.size() + 1) {
            return String.format(
                "Movie %d: %s - (%d) - %s already exists in the library.", 
                movie.getId(), 
                movie.getTitle(), 
                movie.getYear(), 
                movie.getGenre());
        }
        System.out.println(this.movies.get(87));
        this.movies.put(movie.getId(), movie);
        System.out.println(this.movies.size());
        if(this.movie_names.get(movie.getTitle().toLowerCase()) != null) {
            this.movie_names.get(movie.getTitle().toLowerCase()).add(movie.getId());
        } else {
            this.movie_names.put(movie.getTitle().toLowerCase(), new ArrayList<>(Arrays.asList(movie.getId())));
        }
        for(int user_id : this.users.keySet()) {
            this.user_movie.get(user_id).add(Rating.fromInt(0));
        }
        return String.format(
            "Movie %d: %s (%d) - %s added to library.", 
            movie.getId(), 
            movie.getTitle(), 
            movie.getYear(), 
            movie.getGenre());
    }

    /**
     * Initialises the likeness array
     */
    public void initRecs() {
        this.likeness.ensureCapacity(this.users.size());
        ArrayList<Integer> user_ids = new ArrayList<>(this.users.keySet());
        Collections.sort(user_ids);
        for(int index = 0; index < user_ids.get(user_ids.size() - 1) + 1; index++) {
            this.likeness.add(new ArrayList<>(Collections.nCopies(user_ids.get(user_ids.size() - 1) + 1, 0)));
        }
        setAllLikeness();
    }

    /**
     * Calculates all adjacencies of users based on their likeness
     */
    private void setAllLikeness() {
        ArrayList<Integer> user_ids = new ArrayList<>(this.users.keySet());
        Collections.sort(user_ids);
       for(int outer_index : user_ids) {
          for(int inner_index : user_ids) {
            setLikeness(outer_index, inner_index);
          }  
        }
    }

    /**
     * Calculates two specific user's likeness
     * 
     * @param outer_index   The first user
     * @param inner_index   The second user
     */
    private void setLikeness(int outer_index, int inner_index) {
        List<Rating> outer_ratings = this.user_movie.get(outer_index);
        List<Rating> inner_ratings = this.user_movie.get(inner_index);
        int user_likeness = 0;
        for(int movie_id : this.movies.keySet()) {
            int outer_rating = outer_ratings.get(movie_id).getValue();
            int inner_rating = inner_ratings.get(movie_id).getValue();
            if(outer_rating == 0 || inner_rating == 0) {
                continue;
            }
            user_likeness += (outer_rating * inner_rating);
        }   // Set both directions so the order of ids is irrelevant
        this.likeness.get(outer_index).set(inner_index, user_likeness);
        this.likeness.get(inner_index).set(outer_index, user_likeness);
    }

    /**
     * Finds an empty id for a new user
     * 
     * @return  Returns the index of the new user id
     */
    private int findEmptyUser() {
        Set<Integer> user_ids = this.users.keySet();
        for(int index = 1; index < user_ids.size() + 1; index++) {
            if(!user_ids.contains(index)) {
                return index;
            }
        }
        return this.users.size() + 1;
    }

    /**
     * Returns all movie ids in the system
     * 
     * @return  A List containing all movie ids
     */
    public List<Integer> getMovieIds() {
        return new ArrayList<>(this.movies.keySet());
    }

    /**
     * Returns the amount of movies in the system
     * 
     * @return  An integer of the amount of movies
     */
    public int getN0Movies() {
        return this.movies.size();
    }

    /**
     * Returns the amount of users in the system
     * 
     * @return  An integer of the amount of users
     */
    public int getN0Users() {
        return this.users.size();
    }

    /**
     * Returns a specific user's id
     * 
     * @param name The name of the user
     * 
     * @return  The id of the user if found or -1 if not
     */
    public int getUserId(String name) {
        try {
            return this.user_names.get(name.toLowerCase());
        } catch (NullPointerException e) {
            return -1;
        }
    }

    /**
     * Returns a movie object by its id
     * 
     * @param movie_id  The id of the movie to be returned
     * 
     * @return  A movie object if successful, null if not
     */
    public Movie getMovieById(int movie_id) {
        return this.movies.get(movie_id);
    }

    /**
     * Returns all user ids which have reviewed a given movie
     * 
     * @param movie_id  The movie to be searched for
     * 
     * @return  Returns a Linked List with all user_ids that have reviewed this movie
     */
    public Deque<Integer> getReviewIds(int movie_id) {
        Deque<Integer> user_ids = new LinkedList<>();
        for(int user_id : this.users.keySet()) {
            if(this.user_movie.get(user_id).get(movie_id).getValue() != 0) {
                user_ids.add(user_id);
            }
        }
        return user_ids;
    }

    /**
     * Returns the likeness of two users
     * 
     * @param first_user_id The first user
     * @param second_user_id The second user
     * 
     * @return  An integer value showing the likeness of the users
     */
    public int getLikeness(int first_user_id, int second_user_id) {
        if(this.users.keySet().contains(first_user_id) && this.users.keySet().contains(second_user_id)) {
            return this.likeness.get(first_user_id).get(second_user_id);
        } else {
            return -1;
        }
    }

    /**
     * Returns the review score of a user for a movie
     * 
     * @param user_id   The user in question
     * @param movie_id  The movie in question
     * 
     * @return  An integer of the review score
     */
    public int getUserReview(int user_id, int movie_id) {
        if(this.users.keySet().contains(user_id) && this.movies.keySet().contains(movie_id)) {
            return this.user_movie.get(user_id).get(movie_id).getValue();
        } else {
            return -99;
        }
    }

}
