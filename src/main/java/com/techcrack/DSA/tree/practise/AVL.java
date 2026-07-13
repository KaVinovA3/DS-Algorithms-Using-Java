package com.techcrack.dsa.tree.practise;

import static com.techcrack.dsa.tree.learned.AVLKunal.Node;

public class AVL {
    private int getHeight(Node node) {
        return node == null ? -1 : node.height;
    }

    private int getHeightParent(Node node) {
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    private Node rightRotate(Node parent) {
        Node child = parent.left;
        Node temp2 = child.right;

        child.right = parent;
        parent.left = temp2;

        parent.height = getHeightParent(parent);
        child.height = getHeightParent(child);

        return child;
    }

    private Node leftRotate(Node parent) {
        Node child = parent.right;
        Node temp2 = child.left;

        child.left = parent;
        parent.right = temp2;

        parent.height = getHeightParent(parent);
        child.height = getHeightParent(child);

        return child;
    }

    private Node rotate(Node node) {
        if (getHeight(node.left) - getHeight(node.right) > 1) {
            if (getHeight(node.left.left) < getHeight(node.left.right)) {
                node.left = leftRotate(node.left);
            }

            return rightRotate(node);
        }

        if (getHeight(node.left) - getHeight(node.right) < -1) {
            if (getHeight(node.right.left) > getHeight(node.right.right)) {
                node.right = rightRotate(node.right);
            }
            return leftRotate(node);
        }

        return node;
    }

    private void viewTree(Node node, String indent) {
        if (node == null) return;

        viewTree(node.left, indent + "|\t\t");
        System.out.println(indent +"|-------" + node.getValue());
        viewTree(node.right, indent + "|\t\t");
    }

    public Node insertNode(Node node, int val) {
        if (node == null) return new Node(val);

        if (node.getValue() > val)
            node.left = insertNode(node.left, val);
        else
            node.right = insertNode(node.right, val);

        node.height = getHeightParent(node);

        return rotate(node);
    }

    public static void main(String[] args) {
        Node head = null;
        var avl = new AVL();

        for (int i = 0; i < 100; ++i) {
            head = avl.insertNode(head, i);
        }

        System.out.println(head.getValue() + " Height of : " + head.height);

        avl.viewTree(head, "");
        
        Math.abs(1L);
    }
}
