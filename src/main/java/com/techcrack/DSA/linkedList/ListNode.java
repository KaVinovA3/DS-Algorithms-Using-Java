package com.techcrack.dsa.linkedList;

class ListNode {
    public int val, freq;
    public ListNode next;
    public ListNode prev;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, int freq) {
        this(val);
        this.freq = freq;
    }

    public ListNode(int val, ListNode next) {
        this(val, null, next);
    }

    public ListNode(int val, ListNode prev, ListNode next) {
        this(val);

        this.prev = prev;
        this.next = next;
    }
}