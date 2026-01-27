package com.da.datastructures;

import java.util.Objects;

/*
 * Project: music-player
 * Author:  Koitz-Hristov
 *
 * Represents a song with a name and file path.
 * Provides functionality to access the song's name and path,
 * as well as to compare and print song details.
 */
public class Song {

    // Fields to store the name and file path of the song.
    private final String name;
    private final String path;

    /**
     * Constructs a new Song object with the specified name and file path.
     *
     * @param name the name of the song
     * @param path the file path of the song
     */
    public Song(String name, String path) {
        this.name = name;
        this.path = path;
    }

    /**
     * Gets the name of the song.
     *
     * @return the name of the song
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the file path of the song.
     *
     * @return the file path of the song
     */
    public String getPath() {
        return path;
    }

    /**
     * Returns a string representation of the song object.
     * The string includes the name and file path of the song.
     *
     * @return a string representation of the song
     */
    @Override
    public String toString() {
        // Using StringBuilder for efficiency in string concatenation.
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Song Name: ").append(this.name).append(", Song Filepath: ").append(this.path);
        return stringBuilder.toString();
    }

    /**
     * Compares this song to another object for equality.
     * Two songs are considered equal if their name and file path are the same.
     *
     * @param o the object to compare this song to
     * @return true if the songs are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o; // Cast the object to Song.
        // Compare both the name and path for equality.
        return Objects.equals(name, song.name) && Objects.equals(path, song.path);
    }

    /**
     * Returns a hash code for the song.
     * The hash code is computed based on the song's name and path.
     *
     * @return the hash code for this song
     */
    @Override
    public int hashCode() {
        // Combining the hash codes of the name and path fields.
        return Objects.hash(name, path);
    }
}
