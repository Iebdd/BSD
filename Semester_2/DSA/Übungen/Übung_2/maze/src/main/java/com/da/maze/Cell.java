package com.da.maze;

/**
 * Project: maze
 * Author:  Koitz-Hristov
 * Represents a single cell in a maze.
 * Each cell has a position (row and column) and a flag indicating if it is a wall.
 */
public class Cell {
    // Row and column of the cell in the maze grid
    private int row, col;
    // Indicates whether this cell is a wall (true) or a walkable path (false)
    private boolean isWall;

    /**
     * Constructor to initialize a cell with its position and type.
     *
     * @param row    The row index of the cell.
     * @param col    The column index of the cell.
     * @param isWall Whether the cell is a wall (true) or not (false).
     */
    public Cell(int row, int col, boolean isWall) {
        this.row = row;
        this.col = col;
        this.isWall = isWall;
    }

    /**
     * Gets the row index of the cell.
     *
     * @return The row index.
     */
    public int getRow() {
        return row;
    }

    /**
     * Gets the column index of the cell.
     *
     * @return The column index.
     */
    public int getCol() {
        return col;
    }

    /**
     * Checks if the cell is a wall.
     *
     * @return True if the cell is a wall, false otherwise.
     */
    public boolean isWall() {
        return isWall;
    }

    /**
     * Sets whether the cell is a wall or not.
     *
     * @param isWall True to make the cell a wall, false for a walkable cell.
     */
    public void setWall(boolean isWall) {
        this.isWall = isWall;
    }

    /**
     * Returns a string representation of the cell.
     * If the cell is a wall, it returns "#". Otherwise, it returns ".".
     *
     * @return "#" for a wall, "." for a walkable cell.
     */
    @Override
    public String toString() {
        return isWall ? "#" : ".";
    }

    /**
     * Compares this cell with another object for equality.
     * Two cells are equal if they have the same row, column, and wall status.
     *
     * @param obj The object to compare with.
     * @return True if the cells are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cell that = (Cell) obj;
        return this.row == that.row &&
                this.col == that.col && this.isWall == that.isWall;
    }
}
