package com.da.maze;

import java.util.List;

/**
 * Project: maze
 * Author:  Koitz-Hristov
 * Represents a maze grid with cells that can be walls or free paths.
 * Provides methods for maze manipulation, neighbor discovery, and printing.
 */
public class Maze {
    // 2D grid of cells representing the maze
    private Cell[][] grid;
    // Dimensions of the maze
    private int rows, cols;
    // Start and end positions in the maze
    private Cell start, end;

    public List<Cell> path;


    /**
     * Constructs a maze with the given dimensions, initializing all cells as free paths.
     *
     * @param rows Number of rows in the maze.
     * @param cols Number of columns in the maze.
     */
    public Maze(int rows, int cols) {
        if (rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException("Maze dimensions must be greater than zero.");
        }

        this.rows = rows;
        this.cols = cols;
        grid = new Cell[rows][cols];

        // Initialize grid with free cells by default
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = new Cell(i, j, false);
            }
        }

        // Default start and end positions
        start = getCell(0, 0);
        end = getCell(rows - 1, cols - 1);
    }

    /**
     * Returns a string representation of the maze grid.
     * Includes rows, columns, and the start and end positions.
     *
     * @return The string representation of the maze.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(rows).append(",").append(cols).append("\n");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sb.append(grid[i][j]).append(" ");
            }
            sb.append("\n");
        }

        sb.append("Start: ").append(start.getRow()).append(",").append(start.getCol()).append("; ");
        sb.append("End: ").append(end.getRow()).append(",").append(end.getCol()).append("\n");
        return sb.toString();
    }


    /**
     * Retrieves the cell at the specified row and column.
     *
     * @param row The row index.
     * @param col The column index.
     * @return The cell at the given position, or null if out of bounds.
     */
    public Cell getCell(int row, int col) {
        if (row < 0 || col < 0 || row >= rows || col >= cols) {
            // Out of bounds
            return null; 
        }
        return grid[row][col];
    }

    /**
     * Retrieves the cell at the specified row and column.
     *
     * @param cell The row and col index
     * @return The cell at the given position, or null if out of bounds.
     */
    public Cell getCellByArray(int[] cell) {
        if(cell.length != 2) {
            //Incorrect dimensions
            return null;
        } else if(cell[0] < 0 || cell[1] < 0 || cell[0] >= this.rows || cell[1] >= cols) {
            //Out of bounds
            return null;
        }
        return grid[cell[0]][cell[1]];
    }


    /**
     * Sets a specific cell in the maze as a wall.
     *
     * @param row The row index of the cell.
     * @param col The column index of the cell.
     */
    public void setWall(int row, int col) {
        if (row >= 0 && row < rows && col >= 0 && col < cols) {
            grid[row][col].setWall(true);
        }
    }

    /**
     * Gets the number of rows in the maze.
     *
     * @return The number of rows.
     */
    public int getRows() {
        return rows;
    }

    /**
     * Gets the number of columns in the maze.
     *
     * @return The number of columns.
     */
    public int getCols() {
        return cols;
    }


    /**
     * Gets the start position of the maze.
     *
     * @return The start position as an array [row, col].
     */
    public Cell getStart() {
        return start;
    }

    /**
     * Sets the start position of the maze.
     *
     * @param start The new start position as an array [row, col].
     */
    public void setStart(Cell start) {
        this.start = start;
    }

    /**
     * Sets the end position of the maze.
     *
     * @param end The new end position as an array [row, col].
     */
    public void setStart(int[] start) {
        Cell start_cell = getCell(start[0], start[1]);
        if(start_cell != null) {
            this.start = start_cell;
        }
    }

    /**
     * Gets the end position of the maze.
     *
     * @return The end position as an array [row, col].
     */
    public Cell getEnd() {
        return end;
    }

    /**
     * Sets the end position of the maze.
     *
     * @param end The new end position as an array [row, col].
     */
    public void setEnd(Cell end) {
        this.end = end;
    }

    /**
     * Sets the end position of the maze.
     *
     * @param end The new end position as an array [row, col].
     */
    public void setEnd(int[] end) {
        Cell end_cell = getCell(end[0], end[1]);
        if(end_cell != null) {
            this.end = end_cell;
        }
    }
}
