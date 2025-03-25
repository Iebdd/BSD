package com.da.playlist;

import com.da.datastructures.DoubleLinkedList;
import com.da.datastructures.Song;

import java.util.LinkedList;

/**
 * The MyPlaylist class represents a music playlist which can hold a list of songs.
 * The playlist supports operations such as adding, removing, and selecting songs,
 * as well as navigating to the next and previous songs in the playlist.
 */
public class MyPlaylist {
    private final DoubleLinkedList playlist;
    private Song current_song;


    public MyPlaylist() {
        playlist = new DoubleLinkedList();
    }

    /**
     * Adds a new song to the playlist.
     *
     * @param song The song to add to the playlist.
     */
    public void addSong(Song song) {
        playlist.add(song);
        playlist.printAll();
    }

    /**
     * Removes a song from the playlist by its name.
     *
     * @param songName The name of the song to remove.
     * @return true if the song was successfully removed, false if the song was not found.
     */
    public boolean removeSongByName(String songName) {
        if(current_song.getName().equals(songName)) {
            current_song = playlist.getNextSong(this.current_song);
        }
        return playlist.removeByName(songName);
    }


    /**
     * Returns the next song in the playlist and makes it the current song. If there is no next song,
     * it loops back to the first song.
     *
     * @return the next song in the playlist, or null if the playlist is empty.
     */
    public Song getNextSong() {
        this.current_song = playlist.getNextSong(this.current_song);
        return this.current_song;
    }

    /**
     * Returns the previous song in the playlist and makes it the current song. If there is no previous song, it loops
     * back to the last song.
     *
     * @return the previous song in the playlist, or null if the playlist is empty.
     */
    public Song getPreviousSong() {
        this.current_song = playlist.getPreviousSong(this.current_song);
        return this.current_song;
    }

    /**
     * Returns the current song that is playing in the playlist.
     *
     * @return the current song, or null if the playlist is empty.
     */
    public Song getCurrentSong() {
        return this.current_song;
    }

    /**
     * Selects a song by its name and sets it as the current song.
     *
     * @param songName the name of the song to select.
     * @return the selected song, or null if the song was not found.
     */
    public Song selectSongByName(String songName) {
        this.current_song = playlist.findByName(songName).getValue();
        return this.current_song;
    }

    /**
     * Checks whether the playlist is empty or not.
     *
     * @return true if the playlist is empty, false otherwise.
     */
    public boolean isEmpty() {
        //TODO
        return false;
    }

    /**
     * Returns a string representation of the playlist, showing the current song and all songs in the list.
     *
     * @return a string representing the playlist, or a message indicating the playlist is empty.
     */
    @Override
    public String toString() {
        if(playlist.isEmpty()) {
            return "Playlist is empty. Add some with the 'add' command!";
        }
        
    }


}
