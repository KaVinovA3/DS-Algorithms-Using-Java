package com.techcrack.dsa.linkedList;


//Definition for singly Linked List
class ListNodeChild {
    int val;
    ListNodeChild next;
    ListNodeChild child;

    ListNodeChild() {
        val = 0;
        next = null;
        child = null;
    }

    ListNodeChild(int data1) {
        val = data1;
        next = null;
        child = null;
    }

    ListNodeChild(int data1, ListNodeChild next1, ListNodeChild next2) {
        val = data1;
        next = next1;
        child = next2;
    }
}

class FlattenLL {
    public ListNodeChild mergeLL(ListNodeChild left, ListNodeChild right) {
        ListNodeChild dummy = new ListNodeChild(-1);
        ListNodeChild cur = dummy;

        while (left != null && right != null) {
            if (left.val > right.val) {
                cur.child = right;
                right = right.child;
            } else {
                cur.child = left;
                left = left.child;
            }

            cur.next = null;
            cur = cur.child;
        }

        cur.child = left == null ? right : left;

        return dummy.child;
    }
    public ListNodeChild flattenLinkedList(ListNodeChild head) {
        if (head == null || head.next == null) return head;

        head.next = flattenLinkedList(head.next);

        return mergeLL(head, head.next);
    }
}

