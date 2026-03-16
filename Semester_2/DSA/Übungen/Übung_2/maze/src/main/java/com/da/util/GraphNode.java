package com.da.util;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
    private GraphNode parent;
    private final List<GraphNode> children;
    private final String value;

    public GraphNode(String value) {
        this.value = value;
        this.children = new ArrayList<>();
    };

    public GraphNode(String value, GraphNode parent) {
        this.value = value;
        this.parent = parent;
        this.children = new ArrayList<>();
    }

    public GraphNode getParent() {
        return parent;
    }

    public List<GraphNode> getChildren() {
        return children;
    }

    public String getValue() {
        return value;
    }

    public void setParent(GraphNode parent) {
        this.parent = parent;
    }

    public void addChild(GraphNode child) {
        this.children.add(child);
    }

    public void addChild(String value) {
        this.children.add(new GraphNode(value));
    }

    public boolean isParent(GraphNode node) {
        return this.parent == node;
    }
}
