package com.da.musicplayer;

import com.da.datastructures.Song;
import com.da.playlist.MyPlaylist;
import com.da.util.TestPlaylistImplemention;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * MusicPlayerApplication simulates a basic MP3 player with functionality to add, remove,
 * and play songs from a playlist. It allows the user to interact with the playlist
 * and control song playback through a command-line interface.
 */
public class MusicPlayerApplication {
    private final SimpleMP3Player player;
    private final MyPlaylist playlist;

    /**
     * Initializes the MusicPlayerApplication with a SimpleMP3Player and an empty MyPlaylist.
     */
    public MusicPlayerApplication() {
        player = new SimpleMP3Player();
        playlist = new MyPlaylist();
    }

    /**
     * Main entry point for the application. If no arguments are provided, the music player runs interactively.
     * If arguments are provided, test cases are run.
     *
     * @param args the command-line arguments for the program.
     */
    public static void main(String[] args) {
        if (args.length > 0) {
            for (int i = 1; i < 21; i++) {
                TestPlaylistImplemention test = new TestPlaylistImplemention();
                test.test("testdata/input/testcase" + i + ".in");
            }

        } else {
            MusicPlayerApplication app = new MusicPlayerApplication();
            app.run();
        }
    }

    /**
     * Runs the main application, providing the user with various commands to control the music player.
     * The loop listens for user input and performs the corresponding action.
     */
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nOptions MP3 music player: play, stop, add, remove, next, prev, show " +
                    "playlist, play song by name, exit");
            String command = scanner.nextLine().toLowerCase();
            StringBuilder stringBuilder = new StringBuilder();
            String filePath;
            File file;
            String fileName;
            Song song;
            switch (command) {
                case "play":
                    stringBuilder.append(playCurrentSong());
                    break;
                case "stop":
                    stringBuilder.append(stopCurrentSong());
                    break;
                case "add":
                    stringBuilder.append(add(scanner));
                    break;
                case "remove":
                    stringBuilder.append(remove(scanner));
                    break;
                case "next":
                    stringBuilder.append(playNextSong());
                    break;
                case "prev":
                    stringBuilder.append(playPreviousSong());
                    break;
                case "show playlist":
                    stringBuilder.append("Content of the playlist in order:\n").append(playlist);
                    break;
                case "play song by name":
                    stringBuilder.append(playSongByName(scanner));
                    break;
                case "exit":
                    System.exit(0);
                    break;
                default:
                    stringBuilder.append("Invalid command.");
            }
            System.out.println(stringBuilder);
        }
    }

    /**
     * Plays the current song from the playlist.
     * If no song is selected, a message is shown indicating that no song is available to play.
     *
     * @return a StringBuilder with the result of the play action.
     */
    private StringBuilder playCurrentSong() {
        StringBuilder stringBuilder = new StringBuilder();
        Song currentSong = playlist.getCurrentSong();
        if (currentSong != null) {
            try {
                player.play(currentSong);
                stringBuilder.append("Playing song ").append(playlist.getCurrentSong());
            } catch (Exception e) {
                e.printStackTrace();
                stringBuilder.append("The MP3 Player is currently unavailable ");
            }
        } else {
            if (playlist.isEmpty()) {
                stringBuilder.append("Could not play song as playlist is empty ");
            } else {
                stringBuilder.append("Could not play song as it is not available ");
            }
        }

        return stringBuilder;
    }

    /**
     * Stops the current song if it is playing. If no song is playing, a message is displayed.
     *
     * @return a StringBuilder with the result of the stop action.
     */
    private StringBuilder stopCurrentSong() {
        StringBuilder stringBuilder = new StringBuilder();
        Song currentSong = playlist.getCurrentSong();
        if (currentSong != null) {
            player.stop();
            stringBuilder.append("Stopped song: ").append(currentSong);
        } else {
            stringBuilder.append("Nothing to stop, no song is currently playing.");
        }
        return stringBuilder;
    }

    /**
     * Adds a song to the playlist. The user is prompted to provide the song's file path.
     * The file must be an MP3 file, and its existence is checked before adding it.
     *
     * @param scanner the scanner used to capture user input.
     * @return a StringBuilder containing feedback on the song addition.
     */
    private StringBuilder add(Scanner scanner) {
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println("Enter song file path:");

        String filePath = scanner.nextLine();
        File file = new File(filePath);
        if (file.exists() && !file.isDirectory()) {
            Path path = Paths.get(filePath);
            try {
                String mimeType = Files.probeContentType(path);
                if ("audio/mpeg".equals(mimeType)) {
                    String fileName = file.getName();
                    Song song = new Song(fileName, filePath);

                    playlist.addSong(song);
                    stringBuilder.append("Song ").append(song).append(" added");
                } else {
                    stringBuilder.append("Only MP3 files can be added to the playlist");
                }
            } catch (IOException e) {
                e.printStackTrace();
                stringBuilder.append("An error occured while reading the file extension");
            }
        } else {
            stringBuilder.append("File ").append(filePath).append(" does not exist or is a directory");
        }
        return stringBuilder;
    }

    /**
     * Removes a song from the playlist by its name. If the song is currently playing,
     * it is stopped and the next available song is played.
     *
     * @param scanner the scanner used to capture user input.
     * @return a StringBuilder containing feedback on the song removal.
     */
    private StringBuilder remove(Scanner scanner) {
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println("Enter song name to remove:");
        String removeName = scanner.nextLine();
        Song currentSong = playlist.getCurrentSong();
        if (playlist.removeSongByName(removeName)) {
            stringBuilder.append("Song ").append(removeName).append(" removed\n");
            if (currentSong.getName().equals(removeName)) {
                player.stop();
                stringBuilder.append(playCurrentSong());
            }
        } else {
            stringBuilder.append("Song ").append(removeName).append(" could not be removed as it was not contained in" +
                    " the playlist or the playlist was empty\n");
        }
        return stringBuilder;
    }

    /**
     * Plays the next song in the playlist and updates the current song. If no next song exists,
     * a message is displayed indicating that switching to the next song is not possible.
     *
     * @return a StringBuilder containing feedback on playing the next song.
     */
    private StringBuilder playNextSong() {
        StringBuilder stringBuilder = new StringBuilder();
        Song nextSong = playlist.getNextSong();
        if (nextSong == null) {
            stringBuilder.append("Switching to next song not possible\n");
        } else {
            stringBuilder.append("Switching to next song ").append(nextSong).append("\n");
        }

        return stringBuilder.append(playCurrentSong());
    }

    /**
     * Plays the previous song in the playlist and updates the current song. If no previous song exists,
     * a message is displayed indicating that switching to the previous song is not possible.
     *
     * @return a StringBuilder containing feedback on playing the previous song.
     */
    private StringBuilder playPreviousSong() {
        StringBuilder stringBuilder = new StringBuilder();
        Song prevSong = playlist.getPreviousSong();
        if (prevSong == null) {
            stringBuilder.append("Switching to previous song not possible \n");
        } else {
            stringBuilder.append("Switching to previous song ").append(prevSong).append("\n");
        }

        return stringBuilder.append(playCurrentSong());
    }

    /**
     * Plays a song from the playlist by its name. If the song is found, it is set as the current song
     * and played. If the song is not found, a message is displayed indicating that the song is not available.
     *
     * @param scanner the scanner used to capture user input.
     * @return a StringBuilder containing feedback on the song selection.
     */
    private StringBuilder playSongByName(Scanner scanner) {
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println("Enter song name:");
        String fileName = scanner.nextLine();
        Song song = playlist.selectSongByName(fileName);
        if (song != null) {
            return playCurrentSong();
        } else {
            stringBuilder.append("Song ").append(fileName).append(" not available.");
            return stringBuilder;
        }
    }
}
