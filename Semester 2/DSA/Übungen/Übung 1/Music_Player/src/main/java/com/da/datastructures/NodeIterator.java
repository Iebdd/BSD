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
        LinkedListNode next;
        if (!reverse) {
            next = this.currentNode.getNext();
        } else {
            next = this.currentNode.getPrev();
        }
        if (next != null) {
            currentNode = next;
            return next;
        } else {
            throw new NoSuchElementException();
        }
    }

    public LinkedListNode prev() throws NoSuchElementException {
        LinkedListNode prev;
        if (!reverse) {
            prev = this.currentNode.getPrev();
        } else {
            prev = this.currentNode.getNext();
        }
        if (prev != null) {
            currentNode = prev;
            return prev;
        } else {
            throw new NoSuchElementException();
        }
    }

    /**
     * Returns whether the node has a successor
     *
     * @return true if it does, false if not
     */
    @Override
    public boolean hasNext() {
        if (!reverse) {
            return (this.currentNode.getNext() != null); 
        } else {
            return (this.currentNode.getPrev() != null);
        }
    }

    /**
     * Returns whether the node has a predecessor
     *
     * @return true if it does, false if not
     */
    public boolean hasPrev() {
        return (this.currentNode.getPrev() != null);
    }



}
