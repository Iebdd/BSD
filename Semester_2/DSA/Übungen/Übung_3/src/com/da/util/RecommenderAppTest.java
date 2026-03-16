package com.da.util;

import com.da.engine.RecommenderApp;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Project: recommender
 * Author:  Koitz-Hristov
 * RecommenderAppTest provides functionality to test the RecommenderApp
 * by simulating user commands and capturing their output.
 */
public class RecommenderAppTest {
    Set<String> keywords = new HashSet<>();
    private final RecommenderApp app;

    /**
     * Constructor to initialize RecommenderAppTest with a RecommenderApp instance.
     *
     * @param app The RecommenderApp instance to test.
     */
    public RecommenderAppTest(RecommenderApp app) {
        this.app = app;
        keywords.add("showUsers");
        keywords.add("showMovies");
        keywords.add("showAllRatings");
        keywords.add("showUserRatings");
        keywords.add("showMovieRatings");
        keywords.add("addMovie");
        keywords.add("addUser");
        keywords.add("deleteUser");
        keywords.add("addRating");
        keywords.add("changeRating");
        keywords.add("deleteRating");
        keywords.add("getRecommendation");
    }

    /**
     * Parses a test case and executes the commands in the RecommenderApp, capturing the output.
     *
     * @param input  List of commands to execute.
     * @param result StringBuilder to store the test results.
     * @throws IllegalArgumentException if an unknown command is encountered.
     */
    private void parseRecommenderTestCase(List<String> input, StringBuilder result)
            throws IllegalArgumentException {

        // Redirect system input, output, and error streams
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream customOut = new PrintStream(outContent);
        System.setOut(customOut);
        System.setErr(customOut);
        ByteArrayInputStream inStream;

        for (int i = 0; i < input.size(); i++) {
            String line = input.get(i);
            outContent.reset();
            result.append("\nCommand: ").append(line).append("\n");
            if (line.contains("showUsers")) {
                result.append(app.showUsers());
            } else if (line.contains("showMovies")) {
                result.append(app.showMovies());
            } else if (line.contains("showAllRatings")) {
                result.append(app.showAllRatings());
            } else if (line.contains("showUserRatings")) {
                StringBuilder newLine = new StringBuilder();
                i = findNextKeyword(input, ++i, newLine);
                inStream = new ByteArrayInputStream(newLine.toString().getBytes());
                System.setIn(inStream);

                String outputShowUserRatings = app.showUserRatings();
                result.append(outContent);
                result.append(outputShowUserRatings);
            } else if (line.contains("showMovieRatings")) {
                StringBuilder newLine = new StringBuilder();
                i = findNextKeyword(input, ++i, newLine);
                inStream = new ByteArrayInputStream(newLine.toString().getBytes());
                System.setIn(inStream);

                String outputShowMovieRatings = app.showMovieRatings();
                result.append(outContent);
                result.append(outputShowMovieRatings);
            } else if (line.contains("addMovie")) {
                StringBuilder newLine = new StringBuilder();
                i = findNextKeyword(input, ++i, newLine);
                inStream = new ByteArrayInputStream(newLine.toString().getBytes());
                System.setIn(inStream);

                app.addMovie();
                result.append(outContent);
            } else if (line.contains("addUser")) {
                line = input.get(++i);
                inStream = new ByteArrayInputStream(line.getBytes());
                System.setIn(inStream);

                app.addUser();
                result.append(outContent);
            } else if (line.contains("deleteUser")) {
                StringBuilder newLine = new StringBuilder();
                i = findNextKeyword(input, ++i, newLine);
                inStream = new ByteArrayInputStream(newLine.toString().getBytes());
                System.setIn(inStream);

                app.deleteUser();
                result.append(outContent);
            } else if (line.contains("addRating")) {
                StringBuilder newLine = new StringBuilder();
                i = findNextKeyword(input, ++i, newLine);
                inStream = new ByteArrayInputStream(newLine.toString().getBytes());
                System.setIn(inStream);

                app.addRating();
                result.append(outContent);
            } else if (line.contains("changeRating")) {
                StringBuilder newLine = new StringBuilder();
                i = findNextKeyword(input, ++i, newLine);
                inStream = new ByteArrayInputStream(newLine.toString().getBytes());
                System.setIn(inStream);

                app.changeRating();
                result.append(outContent);
            } else if (line.contains("deleteRating")) {
                StringBuilder newLine = new StringBuilder();
                i = findNextKeyword(input, ++i, newLine);
                inStream = new ByteArrayInputStream(newLine.toString().getBytes());
                System.setIn(inStream);

                app.deleteRating();
                result.append(outContent);
            } else if (line.contains("getRecommendation")) {
                StringBuilder newLine = new StringBuilder();
                i = findNextKeyword(input, ++i, newLine);
                inStream = new ByteArrayInputStream(newLine.toString().getBytes());
                System.setIn(inStream);

                String outputRecommendationsRatings = app.getRecommendation();
                result.append(outContent);
                result.append(outputRecommendationsRatings);
            } else {
                throw new IllegalArgumentException("Unknown method " + line + ".");
            }

        }

        // Restore original input/output streams
        System.setIn(System.in);
        System.setOut(originalOut);
        System.setErr(originalOut);
    }

    /**
     * Finds the next keyword in the input list and constructs a string of commands until a keyword is found.
     *
     * @param list   List of input commands.
     * @param offset Starting index.
     * @param string StringBuilder to store the collected commands.
     * @return The index of the next keyword.
     */
    public int findNextKeyword(List<String> list, int offset, StringBuilder string) {
        while (offset < list.size() && !keywords.contains(list.get(offset))) {
            string.append(list.get(offset++)).append("\n");
        }
        if (offset - 1 >= 0)
            return offset - 1;
        else
            return 0;
    }

    /**
     * Executes the test case from the specified file path.
     *
     * @param filepath Path to the test input file.
     */
    public void test(String filepath) {
        System.out.println("#####TESTING#####");
        IOHandler ioHandler = new IOHandler();
        List<String> input = ioHandler.readInputFile(filepath);
        System.out.println("Input File: " + filepath);

        StringBuilder result = new StringBuilder();

        try {
            parseRecommenderTestCase(input, result);
        } catch (IllegalArgumentException | ArithmeticException runtimeException) {
            runtimeException.printStackTrace();
            result.append(runtimeException.getMessage());
        } finally {
            System.out.println("Result:\n" + result);
            ioHandler.printResultToOutputFile(result.toString(), filepath);
        }
    }

}
