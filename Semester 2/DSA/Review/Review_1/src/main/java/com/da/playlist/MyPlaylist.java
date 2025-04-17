package com.da.playlist;

import com.da.datastructures.LinkedListNode;
import com.da.datastructures.Song;

/*
 * Project: music-player
 * Author:  Ulz-Samuel
 *
 * Represents a music playlist
 * Implements operations like adding, removing and selecting songs by name and navigating to the next and previous song
 */

/**
 * The MyPlaylist class represents a music playlist which can hold a list of songs.
 * The playlist supports operations such as adding, removing, and selecting songs,
 * as well as navigating to the next and previous songs in the playlist.
 */
public class MyPlaylist {

    private LinkedListNode head;
    private LinkedListNode tail;
    private LinkedListNode current;

    public MyPlaylist() {
        head = null;
        tail = null;
        current = null;
    }

    /**
     * Adds a new song to the playlist.
     *
     * @param song The song to add to the playlist.
     */
    public void addSong(Song song) {
        LinkedListNode newNode = new LinkedListNode(song);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            current = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
    }

    /**
     * Removes a song from the playlist by its name.
     *
     * @param songName The name of the song to remove.
     * @return true if the song was successfully removed, false if the song was not found.
     */
    public boolean removeSongByName(String songName) {
        LinkedListNode iterator = head;

        while (iterator != null) {
            if (iterator.getValue().getName().equals(songName)) {
                if (iterator.getPrev() == null) {
                    head = iterator.getNext();
                } else {
                    iterator.getPrev().setNext(iterator.getNext());
                }
                if (iterator.getNext() == null) {
                    tail = iterator.getPrev();
                } else {
                    iterator.getNext().setPrev(iterator.getPrev());
                }
                if (current.equals(iterator)) {
                    current = (iterator.getNext() == null) ? head : iterator.getNext();
                }
                return true;
            }
            iterator = iterator.getNext();
        }
        return false;
    }


    /**
     * Returns the next song in the playlist and makes it the current song. If there is no next song,
     * it loops back to the first song.
     *
     * @return the next song in the playlist, or null if the playlist is empty.
     */
    public Song getNextSong() {
        if (isEmpty()) {
            return null;
        } else if (current.getNext() == null) {
            current = head;
            System.out.println("No more songs in your playlist, playing first song!\n");
        } else {
            current = current.getNext();
        }
        return current.getValue();
    }

    /**
     * Returns the previous song in the playlist and makes it the current song. If there is no previous song, it loops
     * back to the last song.
     *
     * @return the previous song in the playlist, or null if the playlist is empty.
     */
    public Song getPreviousSong() {
        if (isEmpty()) {
            return null;
        } else if (current.getPrev() == null) {
            current = tail;
            System.out.println("No more songs in your playlist, playing last song!\n");
        } else {
            current = current.getPrev();
        }
        return current.getValue();
    }

    /**
     * Returns the current song that is playing in the playlist.
     *
     * @return the current song, or null if the playlist is empty.
     */
    public Song getCurrentSong() {
        return (isEmpty()) ? null : current.getValue();
    }

    /**
     * Selects a song by its name and sets it as the current song.
     *
     * @param songName the name of the song to select.
     * @return the selected song, or null if the song was not found.
     */
    public Song selectSongByName(String songName) {
        LinkedListNode iterator = head;

        while (iterator != null) {
            if (iterator.getValue().getName().equals(songName)) {
                current = iterator;
                return current.getValue();
            }
            iterator = iterator.getNext();
        }
        return null;
    }

    /**
     * Checks whether the playlist is empty or not.
     *
     * @return true if the playlist is empty, false otherwise.
     */
    public boolean isEmpty() {
        return (head == null) ? true : false;
    }

    /**
     * Returns a string representation of the playlist, showing the current song and all songs in the list.
     *
     * @return a string representing the playlist, or a message indicating the playlist is empty.
     */
    @Override
    public String toString() {
        StringBuilder playlist = new StringBuilder();
        LinkedListNode iterator = head;
        int counter = 1;

        if (!isEmpty()) {
            playlist.append("Current Song: ").append(current.getValue().getName()).append(", Song Filepath: ").append(current.getValue().getPath()).append("\n");

            while (iterator != null) {
                playlist.append("Song ").append(counter).append(": ").append(iterator.getValue().getName()).append(", Song Filepath: ").append(iterator.getValue().getPath());
                if (iterator == current) {
                    playlist.append(" --current song");
                }

                playlist.append("\n");
                iterator = iterator.getNext();
                counter++;
            }
        } else {
            playlist.append("Your playlist is empty, add some songs first!");
        }
        return playlist.toString();
    }
}