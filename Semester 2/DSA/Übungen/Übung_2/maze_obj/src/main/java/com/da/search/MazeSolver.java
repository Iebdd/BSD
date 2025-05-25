package com.da.search;

import com.da.maze.Maze;

import java.util.ArrayList;
import java.util.List;

import com.da.maze.Cell;

/*
 * Project: maze
 * Author:  Koitz-Hristov
 *
 * Abstract base class for search algorithms used in maze solving.
 * This class contains the structure for solving mazes and printing the solution path.
 * Concrete implementations of search algorithms (e.g., DFS, BFS) should extend this class.
 */
public abstract class MazeSolver {

    // The maze to be solved.
    protected Maze maze;

    // List of coordinates representing the solution path.
    protected List<int[]> path;

    /**
     * Constructs a SearchAlgorithm for a given maze.
     * Initializes the path list to store the solution path.
     *
     * @param maze The maze to be solved by this search algorithm.
     */
    public MazeSolver(Maze maze) {
        this.maze = maze;
        this.path = new ArrayList<>();
    }

    /**
     * Solves the maze from a given start point to a goal point.
     * The specific solving method depends on the concrete implementation of the search algorithm.
     *
     * @param startRow The starting row position of the maze.
     * @param startCol The starting column position of the maze.
     * @param goalRow The target row position of the maze.
     * @param goalCol The target column position of the maze.
     * @return A list of coordinates representing the solution path.
     */
    public abstract List<Cell> solve(Cell start, Cell end);

    /**
     * Constructs a string representation of the maze with the solution path marked.
     * If the maze or path is not initialized, an IllegalStateException is thrown.
     * If the path contains invalid coordinates, an IllegalStateException is thrown.
     * The solution path is marked by the index of each step in the path.
     *
     * @return A string representing the maze with the solution path.
     * @throws IllegalStateException if maze or path is not initialized or if the path contains invalid coordinates.
     */
    public String returnSolutionPathAsString() {
        if (maze == null || path == null) {
            throw new IllegalStateException("Maze or path is not initialized.");
        }

        String[][] grid = new String[maze.getRows()][maze.getCols()];
        StringBuilder sb = new StringBuilder();

        // Initialize grid with default maze representation
        for (int i = 0; i < maze.getRows(); i++) {
            for (int j = 0; j < maze.getCols(); j++) {
                grid[i][j] = maze.getCell(i,j).toString();
            }
        }

        // Mark the solution path
        for(int i = 0; i < path.size();i++){
            int[] step = path.get(i);
            if (step[0] < 0 || step[0] >= maze.getRows() || step[1] < 0 || step[1] >= maze.getCols()) {
                throw new IllegalStateException("Path contains invalid coordinates.");
            }
            grid[step[0]][step[1]] = String.valueOf(i);
        }

        // Build the output string
        for (int i = 0; i < maze.getRows(); i++) {
            for (int j = 0; j < maze.getCols(); j++) {
                sb.append(grid[i][j]).append("\t");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
