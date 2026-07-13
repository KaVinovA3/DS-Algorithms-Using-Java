package com.techcrack.dsa.linkedList;

public class AddOneToLL {
    private int addOneToLL(ListNode node) {
        if (node == null) return 1;

        int carry = addOneToLL(node.next);
        int cur = node.val + carry;
        node.val = cur % 10;

        return cur / 10;
    }

    public ListNode addOne1(ListNode head) {
        var carry = addOneToLL(head);

        if (carry == 0) return head;

        return new ListNode(carry, head);
    }

    public ListNode reverseLL(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }

    public ListNode addOne(ListNode head) {
        ListNode newHead = reverseLL(head);

        int carry = 1;
        ListNode cur = newHead;

        while (cur != null) {
            int val = cur.val + carry;
            cur.val = val % 10;
            carry = val / 10;
            cur = cur.next;
        }

        reverseLL(newHead);

        return carry == 0 ? head : new ListNode(carry, head);
    }
}
