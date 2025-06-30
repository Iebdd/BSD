package com.da.engine;

import com.da.model.DataModel;
import com.da.model.User;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Project: recommender
 * RecommendationEngine class provides methods to recommend movies to users
 * based on various strategies.
 */
public class RecommendationEngine {

    private final DataModel dataModel;

    /**
     * Constructor to initialize the RecommendationEngine with a DataModel.
     *
     * @param dataModel The data model containing user data, user ratings, and movie data.
     */
    public RecommendationEngine(DataModel dataModel) {
        this.dataModel = dataModel;
    }

    /**
     * Generates a sorted list of recommended movies for a user
     *
     * @param user The user for whom recommendations are to be generated.
     * @return A map with the ratings as the key and the ids as the value
     */
    public Map<Integer, Integer> recommendMovie(User user) {
        Map<Integer, Integer> recommendations = new HashMap<>();
        List<Integer> movie_recs = new ArrayList<>(Collections.nCopies(this.dataModel.getN0Movies() + 1, 0));
        List<Integer> movie_ids = new ArrayList<>(this.dataModel.getMovieIds());
        for(int movie_id : movie_ids) {
            List<Integer> user_ids = new ArrayList<>(this.dataModel.getReviewIds(movie_id));    // Only get the users with reviews for a given movie
            int score = 0;
            for(int user_id : user_ids) {   //Score each movie based on the algorithm
                score += this.dataModel.getUserReview(user_id, movie_id) * this.dataModel.getLikeness(user.getUserId(), user_id);
            }
            movie_recs.set(movie_id, score);    //Store the score in the index of the movie
        }
        for(int movie_id : movie_ids) {     //Filter for movies the user hasn't seen yet
            if(this.dataModel.getUserReview(user.getUserId(), movie_id) == 0) {
                recommendations.put(movie_recs.get(movie_id), movie_id);
            }
        }
        return recommendations;
    }

}
