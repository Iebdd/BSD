package com.da.util;

import com.da.datastructures.Song;
import com.da.playlist.MyPlaylist;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Project: music-player
 * Author:  Koitz-Hristov
 * <p>
 * Class that handles executes a specific test case.
 */
public class TestPlaylistImplemention {

    /**
     * Parses the stack test case line by line, calls the corresponding <code>SinglyLinkedList</code> method and
     * handles the output.
     *
     * @param input    the stack test case as a list with each element representing one line of the input test file
     * @param playlist the instance of the playlist class
     * @param result   the result of the test case execution
     * @throws IllegalArgumentException in case of an unknown command within the test case file
     */
    private static void parsePlaylistTestCase(List<String> input, MyPlaylist playlist, StringBuilder result)
            throws IllegalArgumentException {

        for (String line : input) {

            //get character between parentheses
            String strWithinBrackets = "";
            Matcher characterMatcher = Pattern.compile("\\((.*?)\\)").matcher(line);
            while (characterMatcher.find()) {
                strWithinBrackets = characterMatcher.group(1);
            }
            result.append("Command: ").append(line).append("\n");
            //parse method name and call corresponding MyStack method
            if (line.contains("addSong") && !strWithinBrackets.isEmpty()) {
                //create Song instance
                String[] groups = strWithinBrackets.split(",");
                Song song = new Song(groups[0], groups[1]);
                playlist.addSong(song);
            } else if (line.contains("removeSongByName") && !strWithinBrackets.isEmpty()) {
                playlist.removeSongByName(strWithinBrackets);
            } else if (line.contains("selectSongyByName") && !strWithinBrackets.isEmpty()) {
                playlist.selectSongByName(strWithinBrackets);
            } else if (line.contains("getPreviousSong")) {
                result.append(playlist.getPreviousSong()).append("\n");
            } else if (line.contains("getNextSong")) {
                result.append(playlist.getNextSong()).append("\n");
            } else if (line.contains("getCurrentSong")) {
                result.append(playlist.getCurrentSong()).append("\n");
            } else if (line.contains("toString")) {
                result.append(playlist.toString()).append("\n");
            } else {
                throw new IllegalArgumentException("Unknown method " + line + ".");
            }

        }
    }

    public void test(String filepath) {

        System.out.println("#####TESTING#####");
        // read input
        IOHandler ioHandler = new IOHandler();
        List<String> input = ioHandler.readInputFile(filepath);
        System.out.println("Input File: " + filepath);

        // create a playlist instance and result
        MyPlaylist playlist = new MyPlaylist();
        StringBuilder result = new StringBuilder();

        try {
            parsePlaylistTestCase(input, playlist, result);
        } catch (IllegalArgumentException | ArithmeticException runtimeException) {
            runtimeException.printStackTrace();
            result.append(runtimeException.getMessage());
        } finally {
            System.out.println("Result:\n" + result);
            ioHandler.printResultToOutputFile(result.toString(), filepath);
        }

    }

}
