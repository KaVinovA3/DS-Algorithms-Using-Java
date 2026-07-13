package com.techcrack.dsa.linkedList;


class SortListWith123 {
    public ListNode sortList(ListNode head) {
        ListNode[] nodes = new ListNode[3];

        ListNode zero = new ListNode(-1, null);
        ListNode one = new ListNode(-1, null);
        ListNode two = new ListNode(-1, null);

        nodes[0] = zero;
        nodes[1] = one;
        nodes[2] = two;

        ListNode cur = head;

        while (cur != null) {
            nodes[cur.val].next = cur;
            nodes[cur.val] = nodes[cur.val].next;

            cur = cur.next;
        }

        nodes[1].next = two.next;
        nodes[0].next = one.next;
        nodes[2].next = null;

        return zero.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(1);

        var res = new SortListWith123().sortList(head);

        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}