package com.da.playlist;

import com.da.datastructures.DoubleLinkedList;
import com.da.datastructures.LinkedListNode;
import com.da.datastructures.Song;


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
        if(playlist.isEmpty()) {
            this.current_song = song;
        }
        playlist.add(song);
    }

    /**
     * Removes a song from the playlist by its name.
     *
     * @param songName The name of the song to remove.
     * @return true if the song was successfully removed, false if the song was not found.
     */
    public boolean removeSongByName(String songName) {
        if(playlist.isEmpty()) {
            return false;
        }
        if(current_song.getName().equals(songName)) {
            current_song = playlist.getNextSong(this.current_song);
        }
        boolean found = playlist.removeByName(songName);
        if (playlist.isEmpty()) {
            this.current_song = null;
        }
        return found;
    }


    /**
     * Returns the next song in the playlist and makes it the current song. If there is no next song,
     * it loops back to the first song.
     *
     * @return the next song in the playlist, or null if the playlist is empty.
     */
    public Song getNextSong() {
        if(this.current_song == null) {
            return null;
        }
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
        if(this.current_song == null) {
            return null;
        }
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
        LinkedListNode new_node = playlist.findByName(songName);
        if(new_node == null) {
            return null;
        }
        this.current_song = new_node.getValue();
        return this.current_song;
    }

    /**
     * Checks whether the playlist is empty or not.
     *
     * @return true if the playlist is empty, false otherwise.
     */
    public boolean isEmpty() {
        return playlist.isEmpty();
    }

    /**
     * Returns the longest string of either the name or the path, depending on the passed argument
     *
     * @param values Which values to check. 0 for the names and 1 for the paths
     * @return An integer representing the length of the longest string found
     */
    private int longestString(int values) {
        int longest = 0;
        if(values == 0) {
            for(LinkedListNode node : this.playlist) {
                if (node.getValue().getName().length() > longest) {
                    longest = node.getValue().getName().length();
                }
            }
        } else if (values == 1) {
            for (LinkedListNode node : this.playlist) {
                if(node.getValue().getPath().length() > longest) {
                    longest = node.getValue().getPath().length();
                }
            }
        }
        return longest;
    }

    /**
     * Returns padding spaces to account for increasing number size
     *
     * @param number The current ordinal of the playlist item
     * @return A String containing spaces depending on its order
     */
    private String numberSpaces(int number) {
        if (number < 10) {
            return "  ";
        } else if (number < 100) {
            return " ";
        } else {
            return "";
        }
    }

    /**
     * Returns a string representation of the playlist, showing the current song and all songs in the list.
     *
     * @return a string representing the playlist, or a message indicating the playlist is empty.
     */
    @Override
    public String toString() {
        int order = 1;
        int longest_name = longestString(0);
        int longest_path = longestString(1);
        StringBuilder string = new StringBuilder();
        if(playlist.isEmpty()) {
            return "Playlist is empty. Add some with the 'add' command!";
        }
        string.append(String.format(" %s %n", "_".repeat(16 + longest_name + longest_path)));
        string.append(String.format("|  Nr. | %sName%s |%sPath%s|%n", " ".repeat(longest_name/2), " ".repeat(longest_name/2), " ".repeat(longest_path/2), " ".repeat(longest_path/2 )));

        for(LinkedListNode node : this.playlist) {
            string.append(String.format("|  %d%s |  %-" + (longest_name + 1) + "s  | %-" + (longest_path + 1) + "s |%n", order, numberSpaces(order),
                                                                                                node.getValue().getName(), node.getValue().getPath()));
            order++;
        }
        string.append(String.format("|%s|%n", "_".repeat(16 + longest_name + longest_path)));
        return string.toString();
    }


}
