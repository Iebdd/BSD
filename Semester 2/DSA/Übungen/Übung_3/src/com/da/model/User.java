package com.da.model;

/**
 * Project: recommender
 * Represents a User with a unique ID, name, and their movie ratings.
 */
public class User {

    private final int userId;              // Unique identifier for the user
    private final String name;             // Name of the user

    /**
     * Constructor to create a User object.
     *
     * @param userId Unique identifier for the user.
     * @param name   Name of the user.
     */
    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    /**
     * Gets the unique identifier for the user.
     *
     * @return The user's ID.
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Gets the name of the user.
     *
     * @return The name of the user.
     */
    public String getName() {
        return name;
    }

    /**
     * Provides a string representation of the user object.
     *
     * @return A string containing the user's ID and name.
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(userId).append(": ").append(name);
        return stringBuilder.toString();
    }

}
