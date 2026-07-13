package com.techcrack.dsa.tree.learned;
import java.util.*;

public class HuffmanCoding {
    public static void generateCodes(Node root, String code, Map<Character, String> map) {
        if (root == null) return;

        // Leaf node → store code
        if (root.left == null && root.right == null) {
            map.put(root.ch, code);
        }

        generateCodes(root.left, code + "0", map);
        generateCodes(root.right, code + "1", map);
    }

    public static String encode(String text, Map<Character, String> map) {
        StringBuilder encoded = new StringBuilder();

        for (char ch : text.toCharArray()) {
            encoded.append(map.get(ch));
        }

        return encoded.toString();
    }

    public static String decode(String encoded, Node root) {
        StringBuilder result = new StringBuilder();
        Node current = root;

        for (int i = 0; i < encoded.length(); i++) {
            char bit = encoded.charAt(i);

            // Move left or right
            if (bit == '0') {
                current = current.left;
            } else {
                current = current.right;
            }

            // If leaf node → append character
            assert current != null;
            if (current.left == null && current.right == null) {
                result.append(current.ch);
                current = root; // reset for next character
            }
        }

        return result.toString();
    }

    public static Node buildTree(Map<Character, Integer> freqMap) {

        PriorityQueue<Node> pq = new PriorityQueue<>(
                Comparator.comparingInt(a -> a.freq)
        );

        // Step 1: Add all characters to heap
        for (char ch : freqMap.keySet()) {
            pq.add(new Node(ch, freqMap.get(ch)));
        }

        // Step 2: Build tree
        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();

            assert right != null;
            Node parent = new Node('-', left.freq + right.freq);
            parent.left = left;
            parent.right = right;

            pq.add(parent);
        }

        return pq.poll(); // root
    }

    public static void printTree(Node root, int level) {
        if (root == null) return;

        // Print right subtree first
        printTree(root.right, level + 1);



        // Print current node
        for (int i = 0; i < level; i++) {
            System.out.print("    ");
        }

        if (root.ch == '-') {
            System.out.println(root.freq);
        } else {
            System.out.println(root.ch + "(" + root.freq + ")");
        }

        // Print left subtree
        printTree(root.left, level + 1);
    }

    public static void main(String[] args) {

        String text = "aaaaabbbbcccdde";

        // Step 1: Count frequency
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : text.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Build tree
        Node root = buildTree(freqMap);

        System.out.println("Huffman Tree:");
        printTree(root, 0);

        // Step 3: Generate codes
        Map<Character, String> codes = new HashMap<>();
        generateCodes(root, "", codes);

        System.out.println("Codes:");
        for (char ch : codes.keySet()) {
            System.out.println(ch + " : " + codes.get(ch));
        }

        // Step 4: Encode
        String encoded = encode(text, codes);
        System.out.println("Encoded: " + encoded);

        System.out.println("Decoded: " + decode(encoded, root));
    }
}
