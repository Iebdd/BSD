package com.da.datastructures;

import java.util.ListIterator;

public class ListNodeIterator implements ListIterator<LinkedListNode> {
    private LinkedListNode nextNode;
    private LinkedListNode lastNode;
    private LinkedListNode lastElementReturned;
}
