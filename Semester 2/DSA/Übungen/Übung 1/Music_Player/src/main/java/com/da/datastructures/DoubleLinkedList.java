package com.da.datastructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleLinkedList implements Iterable<LinkedListNode>{
    private LinkedListNode first;
    private LinkedListNode last;

    public boolean isEmpty() {
        return (this.first == null && this.last == null);
    }

    public LinkedListNode remove() throws NoSuchElementException {
        if(this.first == this.last) {
            this.first = null;
            this.last = null;
            return null;
        }
        LinkedListNode new_first = this.first.getNext();
        new_first.setPrev(null);
        this.first = new_first;
        return this.first;
    }

    public LinkedListNode removeLast() throws NoSuchElementException {
        if (this.first == this.last) {
            this.first = null;
            this.last = null;
            return null;
        }
        LinkedListNode new_last = this.last.getPrev();
        new_last.setNext(null);
        this.last = new_last;
        return this.last;
    }

    public void clear() {
        this.first = null;
        this.last = null;
    }

    public LinkedListNode getFirst() {
        return this.first;
    }

    public LinkedListNode getLast() {
        return this.last;
    }

    public void add(Song new_song) {
        LinkedListNode new_element = new LinkedListNode(new_song);
        if(isEmpty()) {
            addToEmpty(new_element);

        } else if(this.first == this.last) {
            this.first.setNext(new_element);
            this.last = new_element;
            this.last.setPrev(this.first);
        } else {
            LinkedListNode old_last = this.last;
            this.last = new_element;
            old_last.setNext(this.last);
            this.last.setPrev(old_last);
        }
    }

    public void addFirst(Song new_song) {
        LinkedListNode new_element = new LinkedListNode(new_song);
        if (isEmpty()) {
            addToEmpty(new_element);
        } else if (this.first == this.last) {
            this.first.setPrev(new_element);
            this.first = new_element;
            this.first.setNext(this.last);
            this.first.setPrev(null);
        } else {
            LinkedListNode old_first = this.first;
            this.first = new_element;
            old_first.setPrev(this.first);
            this.first.setNext(old_first);
        }
    }

    public LinkedListNode findBySong(Song current_song){
        for(LinkedListNode node : this) {
            if(node.getValue() == current_song) {
                return node;
            }
        }
        return null;
    }

    public Song getNextSong(Song current_song) {
        if(current_song == null) {
            return this.first.getValue();
        }
        LinkedListNode current_node = findBySong(current_song);
        if(current_node == null) {
            return null;
        } else if(current_node.getNext() == null) {
            return this.first.getValue();
        }
        return current_node.getNext().getValue();
    }

    public Song getPreviousSong(Song current_song) {
        if (current_song == null) {
            return this.last.getValue();
        }
        LinkedListNode current_node = findBySong(current_song);
        if(current_node == null) {
            return null;
        } else if (current_node.getPrev() == null) {
            return this.last.getValue();
        }
        return current_node.getPrev().getValue();
    }

    public void printAll() {
        for (LinkedListNode node : this) {
            System.out.printf("%s%n", node.getValue());
        }
    }

    private void addToEmpty(LinkedListNode new_element) {
        this.first = new_element;
        this.last = new_element;
    }

    public int size() {
        int list_size = 0;
        if(this.first == null) {
            return list_size;
        }
        for(LinkedListNode node : this) {
            list_size++;
        }
        return list_size;
    }

    public LinkedListNode findByName(String song_name) {
        for (LinkedListNode node : this) {
            if(node.getValue().getName().equals(song_name)) {
                return node;
            }
        }
        return null;
    }

    public boolean removeByName(String song_name) {
        LinkedListNode node = findByName(song_name);
        if(node == null) {
            return false;
        }
        LinkedListNode next = node.getNext();
        LinkedListNode prev = node.getPrev();
        next.setNext(prev);
        prev.setPrev(next);
        return true;
    }


    /**
     * Constructor to create a node with a specified value. The next and previous nodes are set to null.
     *
     * @param value the song stored in the node
     */
    @Override
    public Iterator<LinkedListNode> iterator() {
        return new NodeIterator(this.first);
    }

    /**
     * Constructor to create a node with a specified value. The next and previous nodes are set to null.
     *
     * @param value the song stored in the node
     */
    public Iterator<LinkedListNode> iterator(boolean reverse) {
        return (reverse) ? new NodeIterator(this.last, reverse) : new NodeIterator(this.first, reverse);
    }
}
