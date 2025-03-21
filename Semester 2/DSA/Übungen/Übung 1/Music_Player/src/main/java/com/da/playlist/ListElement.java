package com.da.playlist;

import com.da.datastructures.Song;

public class ListElement {
    private ListElement prev_element;
    private ListElement next_element;
    private Song song;

    public ListElement(ListElement prev_element, ListElement next_element, Song song) {
        this.prev_element = prev_element;
        this.next_element = next_element;
        this.song = song;
    }

    public ListElement getPrevElement() {
        return prev_element;
    }

    public void setPrevElement(ListElement prev_element) {
        this.prev_element = prev_element;
    }

    public ListElement getNextElement() {
        return next_element;
    }

    public void setNextElement(ListElement next_element) {
        this.next_element = next_element;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }
}
