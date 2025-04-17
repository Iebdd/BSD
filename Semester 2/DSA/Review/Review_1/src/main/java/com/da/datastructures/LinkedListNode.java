package com.da.datastructures;

import java.util.Objects;

/*
 * Project: music-player
 * Author:  Koitz-Hristov
 *
 * A node for a doubly linked list, which stores a song and references to the next and previous nodes.
 * Each node is part of a larger linked list that maintains a sequence of songs.
 */
public class LinkedListNode {

    // The value stored in the node (a song).
    private final Song value;

    // References to the next and previous nodes in the linked list.
    private LinkedListNode next;
    private LinkedListNode prev;

    /**
     * Constructor to create a node with a specified value, next node, and previous node.
     *
     * @param value the song stored in the node
     * @param next  the next node in the list
     * @param prev  the previous node in the list
     */
    public LinkedListNode(Song value, LinkedListNode next, LinkedListNode prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }

    /**
     * Constructor to create a node with a specified value. The next and previous nodes are set to null.
     *
     * @param value the song stored in the node
     */
    public LinkedListNode(Song value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }

    /**
     * Returns the song stored in this node.
     *
     * @return the song stored in the node
     */
    public Song getValue() {
        return value;
    }

    /**
     * Returns the next node in the list.
     *
     * @return the next node
     */
    public LinkedListNode getNext() {
        return next;
    }

    /**
     * Sets the next node in the list.
     *
     * @param next the next node to set
     */
    public void setNext(LinkedListNode next) {
        this.next = next;
    }

    /**
     * Returns the previous node in the list.
     *
     * @return the previous node
     */
    public LinkedListNode getPrev() {
        return prev;
    }

    /**
     * Sets the previous node in the list.
     *
     * @param prev the previous node to set
     */
    public void setPrev(LinkedListNode prev) {
        this.prev = prev;
    }

    /**
     * Compares this node to another object for equality.
     * Two nodes are considered equal if they have the same song value, next node, and previous node.
     *
     * @param o the object to compare this node to
     * @return true if the nodes are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkedListNode that = (LinkedListNode) o;// Cast to LinkedListNode.
        // Compare value, next, and prev for equality.
        return Objects.equals(value, that.value) && Objects.equals(next, that.next) && Objects.equals(prev, that.prev);
    }

    /**
     * Returns a hash code for this node.
     * The hash code is calculated based on the song value, next node, and previous node.
     *
     * @return the hash code for this node
     */
    @Override
    public int hashCode() {
        return Objects.hash(value, next, prev);
    }

    /**
     * Returns a string representation of this node.
     * The string includes the string representation of the song stored in the node.
     *
     * @return the string representation of this node
     */
    @Override
    public String toString() {
        return value.toString();
    }
}