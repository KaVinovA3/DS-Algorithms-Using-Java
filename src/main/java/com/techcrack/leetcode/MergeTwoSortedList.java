package com.techcrack.leetcode;


public class MergeTwoSortedList {
    ListNode head=null;
    ListNode lastIndex=null;
    public void insertNode(int val){
        ListNode ln=new ListNode(val);
        if(head==null){
            head=ln;
            lastIndex=head;
        }
        else{
            lastIndex.next=ln;
            lastIndex=lastIndex.next;
        }
    }
    public void printList(ListNode dup){
        System.out.print("[");
        while(dup!=null){
            if(dup.next==null)
                System.out.print(dup.val);
            else
                System.out.print(dup.val+" ");
            dup=dup.next;
        }
        System.out.print("]");
    }
    public ListNode mergeList(ListNode list1,ListNode list2){
        if(list1!=null&&list2!=null){
            if(list1.val<=list2.val){
                list1.next=mergeList(list1.next,list2);
                System.out.println(list1.val);
                return list1;
            }
            else{
                list2.next=mergeList(list1,list2.next);
                System.out.println(list2.val);
                return list2;
            }
        }
        if(list1==null)
            return list2;
        return list1;
    }
    public static void main(String []args){
        MergeTwoSortedList mtsl=new MergeTwoSortedList();
        mtsl.insertNode(1);
        mtsl.insertNode(2);
        mtsl.insertNode(4);
        mtsl.printList(mtsl.head);
        MergeTwoSortedList mt=new MergeTwoSortedList();
        mt.insertNode(1);
        mt.insertNode(3);
        mt.insertNode(4);
        mt.printList(mt.head);
        ListNode ln=mt.mergeList(mtsl.head,mt.head);
        mt.printList(ln);
    } 
}
