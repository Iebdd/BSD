package com.da.datastructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class NodeIterator implements Iterator<LinkedListNode> {
    private LinkedListNode currentNode;
    private boolean reverse = false;


    public NodeIterator(LinkedListNode node) {
        currentNode = node;
    }

    public NodeIterator(LinkedListNode node, boolean reverse) {
        currentNode = node;
        this.reverse = reverse;
    }

    @Override
    public LinkedListNode next() throws NoSuchElementException {
        if(this.currentNode == null) {
            throw new NoSuchElementException();
        }
        LinkedListNode current_item = this.currentNode;
        this.currentNode = (!reverse) ? this.currentNode.getNext() : this.currentNode.getPrev();
        return current_item;
    }

    public LinkedListNode prev() throws NoSuchElementException {
        if(this.currentNode == null) {
            throw new NoSuchElementException();
        }
        LinkedListNode current_item = this.currentNode;
        this.currentNode = (!reverse) ? this.currentNode.getPrev() : this.currentNode.getNext();
        return current_item;
    }

    /**
     * Returns whether the node has a successor
     *
     * @return true if it does, false if not
     */
    @Override
    public boolean hasNext() {
        return this.currentNode != null;
    }


}
