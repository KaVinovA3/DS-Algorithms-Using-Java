package com.techcrack.dsa.tree.learned;

public class AVLPractiseImpl {
    private Node root;
    public static class Node {
        private final int value;
        private int height;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public int getHeight(Node node) {
        if (node == null) {
            return -1;
        }

        return node.height;
    }

    private Node leftRotate(Node p) {
        Node c = p.right;
        Node temp = c.left;

        c.left = p;
        p.right = temp;

        p.height = Math.max(getHeight(p.left), getHeight(p.right)) + 1;
        c.height = Math.max(getHeight(c.left), getHeight(c.right)) + 1;

        return c;
    }

    private Node rightRotate(Node p) {
        Node c = p.left;
        Node temp = c.right;

        c.right = p;
        p.left = temp;

        p.height = Math.max(getHeight(p.left), getHeight(p.right)) + 1;
        c.height = Math.max(getHeight(c.left), getHeight(c.right)) + 1;

        return c;
    }


    private Node rotate(Node node) {
        if (getHeight(node.left) - getHeight(node.right) > 1) {
            if (getHeight(node.left.left) - getHeight(node.left.right) <= 0) {
                node.left = leftRotate(node.left);
            }
            return rightRotate(node);
        } else if (getHeight(node.left) - getHeight(node.right) < -1) {
            if (getHeight(node.right.left) - getHeight(node.right.right) > 0) {
                node.right = rightRotate(node.right);
            }
            return leftRotate(node);
        }
        return node;
    }

    private Node insertNode(Node node, int val) {
        if (node == null) {
            return new Node(val);
        }

        if (node.value > val) {
            node.left = insertNode(node.left, val);
        } else {
            node.right = insertNode(node.right, val);
        }

        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;

        return rotate(node);
//        return node;
    }

    private void insert(int val) {
        this.root = insertNode(root, val);
    }

    public void display() {
        display(this.root, "Root Node: ");
    }

    private void display(Node node, String details) {
        if (node == null) {
            return;
        }
        System.out.println(details + node.value);
        display(node.left, "Left child of " + node.value + " : ");
        display(node.right, "Right child of " + node.value + " : ");
    }

    public static void main(String[] args) {
        AVLPractiseImpl tree = new AVLPractiseImpl();
//        tree.root = new Node(1);

        for(int i=0; i < 1000; i++) {
            tree.insert(i);
        }

        tree.display();

        System.out.println(tree.root.value + " "  + tree.root.height);
        System.out.println(tree.height());
    }


}
