package com.da.maze;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * This class generates a maze based on the dimensions supplied to the constructor.
 */
public class MazeGenerator {

    // generated maze
    private final Maze maze;
   
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

    private enum Trav {
        Up(0, -1),
        Down(0, 1),
        Left(-1, 0),
        Right(1, 0);

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
    
    private enum Edge {
        Top(0),
        Bot(1),
        Left(2),
        Right(3);

        private final int num;

        private Edge(int num) {
            this.num = num;
        }

        public int toNum() {
            return this.num;
        }
    }
    
    /**
     * Constructor that start the maze generation based on the dimensions.
     * @param rows number of rows
     * @param cols number of columns
     */
     public MazeGenerator(int rows, int cols){
        this.maze = new Maze(rows,  cols);

        while(!findRandomPath()) {}
     }

    /**
     * Return the generated maze
     * @return the generated maze
     */
    public Maze getMaze() {
        return maze;
    }

    private void resetEdges(boolean[] edges) {
        for(int index = 0; index < edges.length; index++) {
            edges[index] = true;
        }
    }


    private boolean findRandomPath() {
        List<Cell> visited = new ArrayList<>();
        int[] cur_cell = new int[]{maze.getStart()[0], maze.getStart()[1]};
        int[] end = maze.getEnd();
        boolean[] edges = new boolean[]{true, false, true, false};  //Top, Bottom, Left, Right
        Random rand = new Random();

        System.out.println("End: " + end[Dim.Row.toNum()] + "/" + end[Dim.Col.toNum()]);
        while(cur_cell[Dim.Row.toNum()] != end[Dim.Row.toNum()] && cur_cell[Dim.Col.toNum()] != end[Dim.Col.toNum()]) {
            boolean valid = false;
            System.out.println("                                     Current: " + cur_cell[0] + "/" + cur_cell[1]);
            Trav next = null;
            List<Trav> possibilities = new ArrayList<>();
            if(cur_cell[Dim.Row.toNum()] > 0) {
                edges[Edge.Top.toNum()] = false;
            } 
            if(cur_cell[Dim.Col.toNum()] > 0) {
                 edges[Edge.Left.toNum()]= false;
            }
            if(cur_cell[Dim.Col.toNum()] < this.maze.getCols() - 1) {
                edges[Edge.Right.toNum()] = false;
            }
            if(cur_cell[Dim.Row.toNum()] < this.maze.getRows() - 1) {
                edges[Edge.Bot.toNum()] = false;
            }

            if(!edges[Edge.Left.toNum()]) {
                possibilities.add(Trav.Left);
            } 
            if(!edges[Edge.Top.toNum()]) {
                possibilities.add(Trav.Up);
            }

            if(!edges[Edge.Right.toNum()]) {
                possibilities.add(Trav.Right);
            } 
            if (!edges[Edge.Bot.toNum()]) {
                possibilities.add(Trav.Down);
            }
            visited.add(maze.getCellByArray(cur_cell));
            System.out.println(possibilities + "\n");
            for(Trav pos : possibilities) {
                switch(pos) {
                    case Up -> System.out.printf("Up: %d/%d%n", cur_cell[0] + pos.col, cur_cell[1] + pos.row);
                    case Down -> System.out.printf("Down: %d/%d%n", cur_cell[0] + pos.col, cur_cell[1] + pos.row);
                    case Left -> System.out.printf("Left: %d/%d%n", cur_cell[0] + pos.col, cur_cell[1] + pos.row);
                    case Right -> System.out.printf("Right: %d/%d%n", cur_cell[0] + pos.col, cur_cell[1] + pos.row);
                }
            }
            System.out.print("\n");
            while(!valid && !possibilities.isEmpty()) {
                next = possibilities.get(rand.nextInt(possibilities.size()));
                System.out.printf("Next: %s - %d/%d%n", next, next.getCol(), next.getRow());
                for(Cell cell : visited) {
                    System.out.println(next);
                    System.out.printf("Next: %b/%b%n", cell.getCol() == (cur_cell[0] + next.getCol()), cell.getRow() == (cur_cell[1] + next.getRow()));
                    System.out.printf("Old: %d / %d%n", cell.getRow(), cell.getCol());
                    System.out.printf("Col: %d / %d%n", cur_cell[0] + next.getRow(), cur_cell[1] + next.getCol());
                    if(cell.getCol() == (cur_cell[1] + next.getCol()) && cell.getRow() == (cur_cell[0] + next.getRow())) {
                        System.out.println("Duplicate");
                        possibilities.remove(next);
                        next = null;
                        break;
                    }
                }
                if(next != null) {
                    valid = true;
                }
            }
            if(next == null) {
                return false;
            }
            cur_cell[0] += next.getCol();
            cur_cell[1] += next.getRow();
            resetEdges(edges);
            if(cur_cell[0] < 0 || cur_cell[1] < 0) {
                System.out.printf("Row: %d, Col: %d%n", cur_cell[0], cur_cell[1]);
                break;
            }
        }
        System.out.println(visited);
        for(Cell cell : visited) {
            System.out.printf("%d/%d - ", cell.getRow(), cell.getCol());
        }
        System.out.printf("%n");
        System.out.printf("Start: %d/%d%n", maze.getStart()[0], maze.getStart()[1]);
        return true;
    }

}
