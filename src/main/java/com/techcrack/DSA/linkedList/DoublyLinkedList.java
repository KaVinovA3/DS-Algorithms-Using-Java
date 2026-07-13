package com.techcrack.dsa.linkedList;

//public class DoublyLinkedList {
//    public LinkedListDLL convertArrayToDLL(int[] arr) {
//        LinkedListDLL head = new LinkedListDLL(-1, null);
//        LinkedListDLL cur = head;
//
//        for (int val : arr) {
//            cur.next = new LinkedListDLL(val, cur);
//            cur = cur.next;
//        }
//
//        head.next.prev = null;
//
//        return head.next;
//    }
//
//    public int getVal(LinkedListDLL node) {
//        return node == null ? -1 : node.val;
//    }
//
//    public void traverseDLL(LinkedListDLL head) {
//        LinkedListDLL cur = head;
//
//        while (cur != null) {
//            System.out.println(getVal(cur.prev) +  " " + cur.val + " " + getVal(cur.next));
//            cur = cur.next;
//        }
//    }
//
//    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4, 5, 6};
//
//        DoublyLinkedList dll = new DoublyLinkedList();
//
//        LinkedListDLL head = dll.convertArrayToDLL(arr);
//
//        dll.traverseDLL(head);
//    }
//}


public class DoublyLinkedList {
    private ListNode left, right;
    private int size;

    DoublyLinkedList() {
        this.left = new ListNode(0, 0);
        this.right = new ListNode(0, 0);
        this.left.next = this.right;
        this.right.prev = this.left;
        this.size = 0;
    }

    public int length() {
        return size;
    }

    public void pushRight(ListNode node) {
        ListNode prev = this.right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.right;
        this.right.prev = node;
        size++;
    }

    public void pop(ListNode node) {
        ListNode prev = node.prev, next = node.next;
        prev.next = next;
        next.prev = prev;
        node.prev = null;
        node.next = null;
        size--;
    }

    public ListNode popLeft() {
        ListNode node = this.left.next;
        pop(node);
        return node;
    }
}