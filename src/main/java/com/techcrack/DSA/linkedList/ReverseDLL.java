package com.techcrack.dsa.linkedList;

class ReverseDLL {
    public LinkedListDLL reverseDLL(LinkedListDLL head) {
        LinkedListDLL cur = head;
        LinkedListDLL next = null;

        while (cur != null) {
            next = cur.next;
            cur.next = cur.prev;
            cur.prev = next;

            cur = next;
        }


        return next;
    }
}
