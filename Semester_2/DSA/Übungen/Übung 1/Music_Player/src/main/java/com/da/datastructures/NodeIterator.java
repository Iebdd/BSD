package com.da.datastructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * Project: music-player
 * Author:  John Coed
 *
 * An Iterator to be used with the DoubleLinkedList Class of LinkedListNodes
 */
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

    /**
     * Returns the currently stored node and advances the cursor
     *
     * @return The Node currently stored
     */
    @Override
    public LinkedListNode next() throws NoSuchElementException {
        if(this.currentNode == null) {
            throw new NoSuchElementException();
        }
        LinkedListNode current_item = this.currentNode;
        this.currentNode = (!reverse) ? this.currentNode.getNext() : this.currentNode.getPrev();
        return current_item;
    }

    /**
     * Returns the currently stored node and advances the cursor in reverse
     *
     * @return The Node currently stored
     */
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
