package com.techcrack.dsa.linkedList;

public class LinkedListDLL {
    public int val;
    public LinkedListDLL prev;
    public LinkedListDLL next;

    public LinkedListDLL(int val, LinkedListDLL prev) {
        this.val = val;
        this.prev = prev;
    }

    public LinkedListDLL(int val, LinkedListDLL prev, LinkedListDLL next) {
        this(val, prev);
        this.next = next;
    }
}