package com.da.model;

/**
 * Project: recommender
 * Represents a Movie with its unique ID, title, year of release, and genre.
 */
public class Movie {
    private final int id;        // Unique identifier for the movie
    private final String title;  // Title of the movie
    private final int year;      // Year of release
    private final String genre;  // Genre of the movie

    /**
     * Constructor to create a Movie object.
     *
     * @param itemId Unique identifier for the movie.
     * @param title  Title of the movie.
     * @param year   Year of release.
     * @param genre  Genre of the movie.
     */
    public Movie(int itemId, String title, int year, String genre) {
        this.id = itemId;
        this.title = title;
        this.year = year;
        this.genre = genre;
    }

    /**
     * Gets the unique identifier for the movie.
     *
     * @return The ID of the movie.
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the title of the movie.
     *
     * @return The title of the movie.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the genre of the movie.
     *
     * @return The genre of the movie.
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Gets the year of release for the movie.
     *
     * @return The year of release.
     */
    public int getYear() {
        return year;
    }

    /**
     * Provides a string representation of the movie object.
     *
     * @return A string containing the movie's ID, title, year, and genre.
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(id).append(": ").append(title).append(" (").append(year).append(") - ").append(genre);
        return stringBuilder.toString();
    }

}
