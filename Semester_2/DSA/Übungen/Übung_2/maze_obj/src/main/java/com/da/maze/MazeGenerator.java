package com.da.maze;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


/**
 * This class generates a maze based on the dimensions supplied to the constructor.
 */
public class MazeGenerator {

    // generated maze
    private final Maze maze;
    private Random rand = new Random();

    private final List<Cell> path;
   
    private enum Dim {
        Row(0),
        Col(1);

        private final int dim;

        private Dim(int dim) {
            this.dim = dim;
        }

        public int toNum() {
            return this.dim;
        }
    }

    public enum Trav {
        Up(-1, 0),
        Down(1, 0),
        Left(0, -1),
        Right(0, 1);

        private final int row;
        private final int col;

        private Trav(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public int getCol() {
            return this.col;
        }

        public int getRow() {
            return this.row;
        }
    }
    
    /**
     * Constructor that start the maze generation based on the dimensions.
     * @param rows number of rows
     * @param cols number of columns
     */
     public MazeGenerator(int rows, int cols){
        this.maze = new Maze(rows,  cols);
        this.path = new ArrayList<>();
        while(!findRandomPath()) {
            this.path.clear();
        }
        while(!condensePath()){break;}
        generateWalls();
        this.maze.path = this.path;
     }

    /**
     * Return the generated maze
     * @return the generated maze
     */
    public Maze getMaze() {
        return maze;
    }

    private boolean condensePath() {
        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        for(int outer_index = 0; outer_index < this.path.size(); outer_index++) {
            Cell current = this.path.get(outer_index);
            for(int[] direction : directions) {
                Cell offset_cell = this.maze.getCell(current.getRow() + direction[0], current.getCol() + direction[1]);
                System.out.printf("Row: %d - Col: %d%n", offset_cell.getRow(), offset_cell.getCol());
                for(int inner_index = this.path.size() - 1; inner_index > outer_index; inner_index--) {
                    if(this.path.get(inner_index) == offset_cell) {
                        System.out.printf("Next: %d/%d%n", this.path.get(inner_index + 1).getRow(), this.path.get(inner_index + 1).getCol());
                        System.out.printf("From: %d%n", outer_index + 1);
                        this.path.subList(outer_index + 1, inner_index).clear();
                        System.out.printf("To: %d%n", inner_index);
                        System.out.printf("Offset: %d/%d%n", offset_cell.getRow(), offset_cell.getCol());
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Checks if a cell to be moved to has already been visited before
     * 
     * @param cur_cell  The cell to be started from
     * @param direction The offset to be applied
     * 
     * @return  True when the cell has been visited, false if not
     */
    private boolean contains(int[] cur_cell, Trav direction) {
        return path.contains(maze.getCell(cur_cell[Dim.Row.toNum()] + direction.row, cur_cell[Dim.Col.toNum()] + direction.col));
    }

    private boolean generateDeadEnds(Cell start) {
        boolean onPath = false;
    }


    /**
     * Navigates randomly from the upper left to the lower right corner, saving the path taken
     * 
     * @return  true if creation was successful, false if not
     */
    private boolean findRandomPath() {
        Cell start = maze.getStart();
        Cell end = maze.getEnd();
        int[] cur_cell = new int[]{start.getRow(), start.getCol()};
        this.path.add(maze.getCellByArray(cur_cell));
        List<Trav> updown = new ArrayList<Trav>(){          //Pre-generate the whitelists
            {
                addAll(Arrays.asList(Trav.Up, Trav.Down));
            }
        };
        List<Trav> leftright = new ArrayList<Trav>(){
            {
                addAll(Arrays.asList(Trav.Left, Trav.Right));
            }
        };
        while(cur_cell[Dim.Row.toNum()] != end.getRow() || cur_cell[Dim.Col.toNum()] != end.getCol()) {
            List<Trav> moves = new ArrayList<>();
            Trav next = null;
            if(cur_cell[Dim.Row.toNum()] > 0) {     //  Only add as a possible next direction if the position is not at an edge
                if(!contains(cur_cell, Trav.Up)) {  //  and the next cell has not already been visited
                    moves.add(Trav.Up);
                }
            }
            if(cur_cell[Dim.Row.toNum()] < maze.getRows() - 1) {
                if(!contains(cur_cell, Trav.Down)) {
                    moves.add(Trav.Down);
                }
            }
            if(cur_cell[Dim.Col.toNum()] > 0) {
               if(!contains(cur_cell, Trav.Left)) {
                    moves.add(Trav.Left);
               }
            }
            if(cur_cell[Dim.Col.toNum()] < maze.getCols() - 1) {
                if(!contains(cur_cell, Trav.Right)) {
                    moves.add(Trav.Right);
                }
            }
            if(moves.isEmpty()) {
                return false;               //Restart if something fails somehow
            }
            if(moves.containsAll(updown) && !(moves.contains(Trav.Left) || moves.contains(Trav.Right))) {
                next = Trav.Down;           //Stop the algorithm from making bad life choices (Going up, when the only other option is down)
            } else if(moves.containsAll(leftright) && !(moves.contains(Trav.Up) || moves.contains(Trav.Down))) {
                next = Trav.Right;                                                       //(Or going left when the only other option is right)
            } else {
                next = moves.get(this.rand.nextInt(moves.size()));
            }
            cur_cell[Dim.Row.toNum()] += next.row;
            cur_cell[Dim.Col.toNum()] += next.col;
            this.path.add(maze.getCellByArray(cur_cell));
        }
        return true;
    }

    private void generateWalls() {
        Random rand = new Random();
        for(int outer_index = 0; outer_index < this.maze.getRows(); outer_index++) {
            for(int inner_index = 0; inner_index < this.maze.getCols(); inner_index++) {
                if(!this.path.contains(this.maze.getCell(outer_index, inner_index))) {
                    if(rand.nextInt(10) <= 10) {    //Adjust the frequency of walls
                        this.maze.getCell(outer_index, inner_index).setWall(true);
                    }
                }
            }
        }
    }

}
