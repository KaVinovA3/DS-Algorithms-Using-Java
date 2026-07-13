package com.techcrack.dsa.linkedList;

class MyLinkedList {
    private int size = 0;
    private ListNode head;
    private ListNode tail;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public int get(int index) {
        ListNode result = getNode(index + 1);

        return result == null ? -1 : result.val;
    }

    private ListNode getNode(int index) {
        if (index > size) return null;

        ListNode cur = head;

        for (int i = 1; i < index; ++i) {
//            System.out.print(cur.val + " -> ");
            cur = cur.next;
        }

//        System.out.println();
        return cur;
    }

    public void addAtHead(int val) {
        ListNode node = new ListNode(val);

        if (head == null) {
            head = node;
            tail = node;
        } else {
            head.prev = node;
            node.next = head;
            head = node;
        }


        size++;
//        System.out.println(size + " add head");
    }

    public void addAtTail(int val) {
        ListNode node = new ListNode(val);
        if (tail == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = tail.next;
        }


        size++;
//        System.out.println(size + " add tail");
    }

    public void addAtIndex(int index, int val) {
//        System.out.println("Add Index via");
        if (index == 0) {
            addAtHead(val);
            return;
        }

        ListNode result = getNode(index);

//        System.out.println(result);

        if (result == null)  {
            if (size == index)
                addAtTail(index);
            return;
        }

//        System.out.println(result.val + "nnnnn");

        ListNode node = new ListNode(val);



        node.prev = result;
        node.next = result.next;
        result.next = node;

        size++;

//        ListNode cur = head;
//
//        while (cur != null) {
//            System.out.print(cur.val + "-> "  );
//            cur = cur.next;
//        }

//        System.out.println(size + " AddAtIndex");
    }

    public void deleteAtIndex(int index) {
        ListNode result = getNode(index + 1 );

        if (result == null) return;

        if (result.prev == null) {
            head = result.next;

            if (head != null)
                head.prev = null;
        } else if (result.next == null) {
            tail = tail.prev;
            result.prev.next = null;
            result.prev = null;
        } else {
            result.prev.next = result.next;
            result.next.prev = result.prev;
            result.prev = null;
            result.next.prev = null;
            result.next = null;
        }

        size--;

//        System.out.println(size + " Delete at index");
    }

    public void print() {
        ListNode cur = head;

        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(1);
        list.print();
        list.addAtTail(3    );
//        list.print();
//        list.addAtTail(3);
//        list.print();
//        list.deleteAtIndex(1);
        list.print();
        list.addAtIndex(1, 2);

        list.print();

    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */