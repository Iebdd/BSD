package com.da.model;

/**
 * Project: recommender
 * Enumeration representing possible ratings for a movie, along with their integer values.
 */
public enum Rating {
    HATED_IT(-5),
    DIDNT_LIKE_IT(-3),
    OK(1),
    LIKED_IT(3),
    REALLY_LIKED_IT(5),
    DID_NOT_READ(0);

    private final int value; // Numeric value of the rating

    /**
     * Constructor to associate a numeric value with a rating.
     *
     * @param value The numeric value corresponding to the rating.
     */
    Rating(int value) {
        this.value = value;
    }

    /**
     * Maps an integer value to its corresponding Rating enumeration.
     *
     * @param i The integer value to convert.
     * @return The corresponding Rating enumeration, or DID_NOT_READ if no match is found.
     */
    public static Rating fromInt(int i) {
        return switch (i) {
            case -5 -> HATED_IT;
            case -3 -> DIDNT_LIKE_IT;
            case 1 -> OK;
            case 3 -> LIKED_IT;
            case 5 -> REALLY_LIKED_IT;
            default -> DID_NOT_READ;
        };
    }

    /**
     * Gets the numeric value of the rating.
     *
     * @return The numeric value associated with the rating.
     */
    public int getValue() {
        return value;
    }
}