package com.da.search;

import com.da.maze.Maze;
import com.da.maze.MazeGenerator;
import com.da.util.IOHandler;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Project: maze
 * Author:  Koitz-Hristov
 *
 * Use the MazeApp class to run the maze solving application.
 * This class handles input reading, maze generation, maze solving using a search algorithm,
 * and displays the solution path.
 *
 * The program can either generate a new maze or read from an input file.
 * It supports reading maze test cases, parsing them, and solving the maze using a search
 * algorithm.
 */
public class MazeApp {

    /**
     * The entry point of the maze-solving application.
     * This method controls the flow of the program, either generating a maze or reading an input file.
     * It initializes the maze, prints it, and attempts to solve it using the DFS/BFS algorithm.
     *
     * The program accepts different command-line arguments:
     * - No arguments: It solves all available test cases (1 to 20).
     * - One argument: The argument should be the path to a specific test case input file.
     * - Two arguments: The arguments should be the dimensions (rows and columns) of a new maze to generate.
     *
     * @param args Command-line arguments. Based on the number of arguments, the program either:
     *             1. Solves all test cases.
     *             2. Solves a maze from a specific input file.
     *             3. Generates a maze with given dimensions and solves it.
     */
    public static void main(String[] args) {
        Maze maze = null;
        String solutionPath = new String();
        //all test cases
        switch (args.length) {
            case 0 ->                 {
                    IOHandler handler = new IOHandler();
                    for (int i = 1; i < 21; i++) {
                        maze = parseMazeTestCase(handler.readInputFile("testdata/input/testcase" + i + ".in"));
                        System.out.println("testdata/input/testcase" + i + ".in");
                        System.out.println(maze.toString());
                        solutionPath= solve(maze, maze.getStart()[0], maze.getStart()[1], maze.getEnd()[0],
                                maze.getEnd()[1]);
                        handler.printResultToOutputFile(solutionPath,"testdata/input/testcase" + i + ".in");
                    }                      }
            case 1 ->                 {
                    IOHandler handler = new IOHandler();
                    maze = parseMazeTestCase(handler.readInputFile(args[0]));
                    System.out.println(maze.toString());
                    solutionPath=solve(maze, maze.getStart()[0], maze.getStart()[1], maze.getEnd()[0],
                            maze.getEnd()[1]);
                    handler.printResultToOutputFile(solutionPath,args[0]);
                }
            case 2 -> {
                int row = 0, col = 0;
                // Validate and parse the row and column values
                try {
                    row = Integer.parseInt(args[0]);
                    col = Integer.parseInt(args[1]);
                } catch (NumberFormatException e) {
                    System.err.println("Error: Invalid row or column values. Both should be integers.");
                    System.exit(42);
                }   // Ensure that row and column values are positive
                if (row <= 0 || col <= 0) {
                    System.err.println("Error: Both row and column values must be positive.");
                    return;
                }   // Generate a new maze with dimensions row X col
                MazeGenerator generator = new MazeGenerator(row, col);
                maze = generator.getMaze();
                System.out.println(maze.toString());
                solve(maze, maze.getStart()[0], maze.getStart()[1], maze.getEnd()[0],
                        maze.getEnd()[1]);
            }
            default -> {
                System.err.println("Incorrect number or type of parameter");
                System.exit(42);
            }
        }
        System.out.println("--");

    }

    /**
     * Solves the maze using a search algorithm.
     * This method attempts to find a path from the start point to the end point in the maze.
     * It prints the solution path if found, otherwise indicates that no solution exists.
     *
     * @param maze The maze to be solved.
     * @param startRow The starting row of the maze.
     * @param startCol The starting column of the maze.
     * @param endRow The target row of the maze.
     * @param endCol The target column of the maze.
     */
    public static String solve(Maze maze, int startRow, int startCol, int endRow, int endCol) {
        try {
            //TODO call your searchAlgorithm
            DummyClass searchAlgorithm = new DummyClass(maze);
            List<int[]> solution = searchAlgorithm.solve(startRow, startCol, endRow, endCol);

            if (solution == null) {
                System.out.println("No solution found!");
            } else {
                System.out.println("Solution path:");
                for (int[] cell : solution) {
                    System.out.println("(" + cell[0] + ", " + cell[1] + ")");
                }
                System.out.println(searchAlgorithm.returnSolutionPathAsString());
                return searchAlgorithm.returnSolutionPathAsString();
            }
        } catch (IllegalStateException e) {
            // Handle specific errors that indicate an invalid state, such as uninitialized maze or path
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            // Catch any other unexpected exceptions
            System.err.println("Unexpected error occurred: " + e.getMessage());
        }
        return new String();
    }

    /**
     * Parses a maze test case from the provided input data.
     * This method extracts the maze dimensions, start/end positions, and wall locations
     * from a list of strings representing the maze layout. It constructs a Maze object
     * based on the parsed data.
     *
     * @param input The list of strings representing the maze data.
     * @return A Maze object initialized with the parsed data.
     * @throws IllegalArgumentException If the input data is invalid (e.g., missing or malformed values).
     * @throws RuntimeException If an unexpected error occurs during parsing.
     */
    private static Maze parseMazeTestCase(List<String> input) throws IllegalArgumentException {

        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input data is empty or invalid.");
        }

        // Parse dimensions from the first line
        String firstLine = input.remove(0);
        String[] lines = firstLine.split(",");
        int rows, cols;
        try {
            rows = Integer.parseInt(lines[0]);
            cols = Integer.parseInt(lines[1]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid maze dimensions provided in input.");
        }

        // Ensure the maze has valid dimensions
        if (rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException("Maze dimensions must be greater than zero.");
        }

        Maze maze = new Maze(rows, cols);

        int rowCounter = 0;
        for (String line : input) {
            // Handle special "Start" line
            if (line.contains("Start")) {
                String regex = "\\d+";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(line);

                int[] start = new int[2];
                int[] end = new int[2];

                // Extract coordinates for start and end positions
                if (matcher.find()) {
                    start[0] = Integer.parseInt(matcher.group());
                }
                if (matcher.find()) {
                    start[1] = Integer.parseInt(matcher.group());
                }
                if (matcher.find()) {
                    end[0] = Integer.parseInt(matcher.group());
                }
                if (matcher.find()) {
                    end[1] = Integer.parseInt(matcher.group());
                }

                maze.setEnd(end);
                maze.setStart(start);
            }
            // Process maze grid lines
            else if (!line.isEmpty()) {
                line = line.replaceAll("\\s+", "");
                for (int i = 0; i < line.length(); i++) {
                    char character = line.charAt(i);
                    if (character == '#') {
                        maze.setWall(rowCounter, i);
                    }
                }
            }
            rowCounter++;
        }

        return maze;
    }
}

