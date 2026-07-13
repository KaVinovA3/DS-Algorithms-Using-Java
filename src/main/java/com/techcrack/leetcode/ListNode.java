package com.techcrack.leetcode;

public class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val=val;
    }
    ListNode(){}

    public ListNode(int val, ListNode head) {
        this.next = head;
        this.val = val;
    }
}