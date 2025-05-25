package com.da.util;

import java.util.Iterator;

import com.da.maze.Cell;

public class Graph implements Iterable<GraphNode> {
    private final GraphNode root;

    public Graph(String value) {
        this.root = new GraphNode(value);
    }

    public Graph(Cell[][] cells) {
        System.out.println(cells.length);
        this.root = null;
    }
    
    @Override 
    public Iterator<GraphNode> iterator() {
        return new GraphIterator(root);
    }

    public void addNode(String value, String parent_value) {
        GraphNode parent_node = findByValue(parent_value);
        parent_node.addChild(value);
    }


    public GraphNode findByValue(String value) {
        for(GraphNode node : this) {
            if(node.getValue().equals(value)) {
                return node;
            }
        }
        return null;
    }



}
