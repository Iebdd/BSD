package com.da.datastructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * project: Playlist for a simple music player
 * Author: John Coed
 * A limited implementation of a Double Linked List. It is iterable and supports
 * random removal in linear time as well as adding or removing the last or first
 * element in constant time
 */
public class DoubleLinkedList implements Iterable<LinkedListNode>{
    private LinkedListNode first;
    private LinkedListNode last;

    /**
     * Decides whether the datastructure is empty.
     *
     * @return true if the List is empty, false if not
     */
    public boolean isEmpty() {
        return (this.first == null && this.last == null);
    }

    /**
     * Removes the first element in the list. Also removes the reference to the last
     * if the List only contained one element
     *
     * @return The next element in the list or null if it is now empty
     */
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

    /**
     * Removes the last element in the list. Also removes the reference to the first
     * if the List only contained one element
     *
     * @return The previous element in the list or null if it is now empty
     */
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

    /**
     * Removes all references in the list by removing both pivot points
     *
     */
    public void clear() {
        this.first = null;
        this.last = null;
    }

    /**
     * Retrieves the first element of the list
     *
     * @return The first element of the list
     */
    public LinkedListNode getFirst() {
        return this.first;
    }

    /**
     * Retrieves the last element of the list
     *
     * @return The last element of the list
     */
    public LinkedListNode getLast() {
        return this.last;
    }

    /**
     * Adds the passed song to the end of the list
     *
     * @param new_song The Song to be added
     */
    public void add(Song new_song) {
        LinkedListNode new_element = new LinkedListNode(new_song);
        if(isEmpty()) {
            addToEmpty(new_element);

        } else if(isSingleElement()) {
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

    /**
     * Adds the passed song to the front of the list
     *
     * @param new_song The Song to be added
     */
    public void addFirst(Song new_song) {
        LinkedListNode new_element = new LinkedListNode(new_song);
        if (isEmpty()) {
            addToEmpty(new_element);
        } else if (isSingleElement()) {
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

    /**
     * Adds the first element to the empty list
     *
     * @param new_element The element to add to the list
     */
    private void addToEmpty(LinkedListNode new_element) {
        this.first = new_element;
        this.last = new_element;
    }

    /**
     * Finds an element of the list by its object reference
     *
     * @param song The song to be found
     * @return The Song if it was found, null if not
     */
    public LinkedListNode findBySong(Song song){
        for(LinkedListNode node : this) {
            if(node.getValue() == song) {
                return node;
            }
        }
        return null;
    }
    
    /**
     * Retrieves and returns the next song after the one currently playing
     *
     * @param current_song The song currently playing
     * @return The song following the current one, the first one if there is
     *         none playing or null if the playlist is empty
     */
    public Song getNextSong(Song current_song) {
        if(current_song == null) {
            if (this.first != null) {
                return this.first.getValue();
            } else {
                return null;
            }
        }
        LinkedListNode current_node = findBySong(current_song);
        if(current_node == null) {
            return null;
        } else if(current_node.getNext() == null) {
            return this.first.getValue();
        }
        return current_node.getNext().getValue();
    }
    
    /**
     * Retrieves and returns the previous song before the one currently playing
     *
     * @param current_song The song currently playing
     * @return The song preceding the current one or the last if there is none playing
     */
    public Song getPreviousSong(Song current_song) {
        if (current_song == null) {
            if(this.last != null) {
                return this.last.getValue();
            } else {
                return null;
            }
        }
        LinkedListNode current_node = findBySong(current_song);
        if(current_node == null) {
            return null;
        } else if (current_node.getPrev() == null) {
            return this.last.getValue();
        }
        return current_node.getPrev().getValue();
    }
    

    
    /**
     * Decides if the List only has one element
     *
     * @return true if the first and last element are the same, false if not
     */
    private boolean isSingleElement() {
        return (this.first == this.last);
    }
    
    /**
     * Returns the amount of nodes currently in the list
     *
     * @return The amount of nodes as an integer
     */
    public int size() {
        int list_size = 0;
        if(this.first == null) {
            return list_size;
        }
        for(LinkedListNode unused : this) {
            list_size++;
        }
        return list_size;
    }
    
   /**
     * Finds an element of the list by its song name
     *
     * @param song_name The name of the song to be found
     * @return The Node if it was found or null if not
     */
    public LinkedListNode findByName(String song_name) {
        for (LinkedListNode node : this) {
            if(node.getValue().getName().equals(song_name)) {
                return node;
            }
        }
        return null;
    }
    
    /**
     * Removes a song from the playlist by its name.
     *
     * @param songName The name of the song to remove.
     * @return true if the song was successfully removed, false if the song was not found.
     */
    public boolean removeByName(String song_name) {
        LinkedListNode node = findByName(song_name);
        if(node == null) {
            return false;
        }
        if(isSingleElement()){
            this.first = null;
            this.last = null;
        } else if(node == this.first) {
            LinkedListNode next = node.getNext();
            this.first = next;
            this.first.setPrev(null);            
        } else if (node == this.last) {
            LinkedListNode prev = node.getPrev();
            this.last = prev;
            this.last.setNext(null);
        } else {
            node.getPrev().setNext(node.getNext()); //Assigns the found node's next node as the previous node's next one
            node.getNext().setPrev(node.getPrev()); //Assigns the found node's previous node as the next node's previous one
        }
        return true;
    }


    /**
     * Returns an Iterable, iterating over the Linked List
     *
     * @return The Iterator of the List
     */
    @Override
    public Iterator<LinkedListNode> iterator() {
        return new NodeIterator(this.first);
    }

    /**
     * Returns an Iterable, iterating over the Linked List with an option to reverse the direction
     *
     * @return The Iterator of the List
     */
    public Iterator<LinkedListNode> iterator(boolean reverse) {
        return (reverse) ? new NodeIterator(this.last, reverse) : new NodeIterator(this.first, reverse);
    }
}
