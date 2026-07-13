package com.techcrack.dsa.linkedList;


import java.util.HashMap;
import java.util.Map;

public class LFUCache {
    private int capacity;
    private int lfuCount;
    private Map<Integer, ListNode> nodeMap;
    private Map<Integer, DoublyLinkedList> listMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.lfuCount = 0;
        this.nodeMap = new HashMap<>();
        this.listMap = new HashMap<>();
    }

    private void counter(ListNode node) {
        int count = node.freq;
        listMap.get(count).pop(node);

        if (count == lfuCount && listMap.get(count).length() == 0) {
            lfuCount++;
        }

        node.freq++;
        listMap.putIfAbsent(node.freq, new DoublyLinkedList());
        listMap.get(node.freq).pushRight(node);
    }

    public int get(int key) {
        if (!nodeMap.containsKey(key)) {
            return -1;
        }
        ListNode node = nodeMap.get(key);
        counter(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }

        if (nodeMap.containsKey(key)) {
            ListNode node = nodeMap.get(key);
            node.val = value;
            counter(node);
            return;
        }

        if (nodeMap.size() == capacity) {
            ListNode toRemove = listMap.get(lfuCount).popLeft();
//            nodeMap.remove(toRemove.key);
        }

        ListNode node = new ListNode(key, value);
        nodeMap.put(key, node);
        listMap.putIfAbsent(1, new DoublyLinkedList());
        listMap.get(1).pushRight(node);
        lfuCount = 1;
    }
}