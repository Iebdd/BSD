package com.da.util;

import java.util.Deque;
import java.util.Iterator;

public class GraphIterator implements Iterator<GraphNode> {
    private Deque<GraphNode> queue;

    public GraphIterator(GraphNode root) {
        buildQueue(root);
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    @Override
    public GraphNode next() {
        return queue.remove();
    }

    private void buildQueue(GraphNode root) {
        addNode(root);
        System.out.println(queue);
    }

    private void addNode(GraphNode new_node) {
        if(!queue.contains(new_node)) {
            this.queue.add(new_node);
        } else {
            return;
        }
        if(new_node.getChildren().isEmpty()) {
            return;
        }
        for(GraphNode node : new_node.getChildren()) {
            addNode(node);
        }
    }
}
