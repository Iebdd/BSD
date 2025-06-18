package com.da.util;


import com.da.model.DataModel;
import com.da.model.Movie;
import com.da.model.Rating;
import com.da.model.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Project: recommender
 * DataLoader is responsible for loading movie, user, and ratings data
 * into the DataModel from specified file paths.
 */
public class DataLoader {

    DataModel dataModel;

    /**
     * Constructor to initialize the DataLoader with a DataModel.
     *
     * @param dataModel The data model to populate with loaded data.
     */
    public DataLoader(DataModel dataModel) {
        this.dataModel = dataModel;
    }

    /**
     * Loads data from the provided file paths for movies, users, and ratings.
     *
     * @param moviesFilePath  Path to the movies data file.
     * @param usersFilePath   Path to the users data file.
     * @param ratingsFilePath Path to the ratings data file.
     */
    public void loadData(String moviesFilePath, String usersFilePath, String ratingsFilePath) {

        // Load Movies data
        loadMovies(moviesFilePath);

        // Load Users data
        loadUsers(usersFilePath);

        //Load Ratings data
        loadRatings(ratingsFilePath);

    }

    private void loadRatings(String filePath) {
        BufferedReader ratingsReader = null;
        try {
            ratingsReader = new BufferedReader(new FileReader(filePath));
            //Skip column header
            String line = ratingsReader.readLine();
            String[] columns = line.split(",");
            this.dataModel.addRating(Integer.parseInt(columns[0]), Integer.parseInt(columns[1]), Rating.fromInt(Integer.parseInt(columns[2])));
        } catch(IOException e) {
            
        } catch(NumberFormatException e) {

        }
    }

    /**
     * Loads movies data from the specified file path and populates the DataModel.
     *
     * @param filePath Path to the movies data file.
     */
    private void loadMovies(String filePath) {
        BufferedReader movieReader = null;
        try {
            movieReader = new BufferedReader(new FileReader(filePath));
            // First line is column header
            String line = movieReader.readLine();
            while ((line = movieReader.readLine()) != null) {
                String[] columns = line.split(",");
                int movieId = Integer.parseInt(columns[0]);
                String title = columns[1];
                int year = Integer.parseInt(columns[2]);
                String genre = columns[3];

                Movie movie = new Movie(movieId, title, year, genre);
                if (!dataModel.getMovies().containsKey(movieId))
                    dataModel.getMovies().put(movieId, movie);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeReader(movieReader);
        }
    }

    /**
     * Loads users data from the specified file path and populates the DataModel.
     *
     * @param filePath Path to the users data file.
     */
    private void loadUsers(String filePath) {
        BufferedReader userReader = null;
        try {
            userReader = new BufferedReader(new FileReader(filePath));
            // First line is the column header
            String line = userReader.readLine();
            while ((line = userReader.readLine()) != null) {
                String[] columns = line.split(",");
                int userId = Integer.parseInt(columns[0]);
                String name = columns[1];

                User user = new User(userId, name);
                if (!dataModel.getUsers().containsKey(userId))
                    dataModel.getUsers().put(userId, user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeReader(userReader);
        }
    }

    /**
     * Safely closes a BufferedReader.
     *
     * @param reader The BufferedReader to close.
     */
    private void closeReader(BufferedReader reader) {
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
