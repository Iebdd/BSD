package com.da.search;

import com.da.maze.Maze;

import java.util.List;

import com.da.maze.Cell;

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
    public List<Cell> solve(Cell start, Cell end) {
        return null;
    }


    private boolean followPath() {
        return false;
    }
}
