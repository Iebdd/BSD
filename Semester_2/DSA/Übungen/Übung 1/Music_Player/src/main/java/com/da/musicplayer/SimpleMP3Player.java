package com.da.musicplayer;

import com.da.datastructures.Song;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Project: music-player
 * Author:  Koitz-Hristov
 * <p>
 * A simple MP3 player that plays a song in a separate thread.
 * This class provides methods to play and stop MP3 files.
 */
public class SimpleMP3Player {
    private Player player;

    // Thread to play the song
    private Thread playerThread;

    public boolean play(Song song) {
        // Stop any currently playing song before starting a new one
        stop();

        File mp3File = new File(song.getPath());
        if (!mp3File.exists() || !mp3File.isFile()) {
            System.err.println("Error: File not found or invalid file path - " + song);
            return false;
        }

        try {
            FileInputStream fileInputStream = new FileInputStream(mp3File);
            player = new Player(fileInputStream);

            // Play the MP3 file in a separate thread
            playerThread = new Thread(() -> {
                try {
                    // Play the MP3 in this thread
                    player.play();
                } catch (JavaLayerException e) {
                    e.printStackTrace();
                }
            });

            // Start the playback thread
            playerThread.start();
        } catch (JavaLayerException | IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * Stops the currently playing song.
     * If no song is playing, this method does nothing.
     *
     * @return true if the song was stopped successfully, false otherwise
     */
    public boolean stop() {
        if (player != null) {
            // Stop the player
            player.close();
        } else {
            return false;
        }

        // Stop the thread if it's still running
        if (playerThread != null && playerThread.isAlive()) {
            // Interrupt the playback thread
            playerThread.interrupt();
        }
        return true;
    }
}
