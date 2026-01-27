package com.da.search;

import com.da.maze.Maze;

import java.util.List;

/*
 * Project: maze
 * Author:
 * TODO
 */public class DummyClass extends MazeSolver{
    /**
     * Constructs a SearchAlgorithm for a given maze.
     * Initializes the path list to store the solution path.
     *
     * @param maze The maze to be solved by this search algorithm.
     */
    public DummyClass(Maze maze) {
        super(maze);
    }

    @Override
    public List<int[]> solve(int startRow, int startCol, int goalRow, int goalCol) {
        return null;
    }
}
