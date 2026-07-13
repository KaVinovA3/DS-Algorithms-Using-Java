package com.techcrack.dsa.tree.tuf.problems;

import java.util.*;

public class BurnTree {
    public int timeToBurnTree(TreeNode root, int start) {
        Map<TreeNode, TreeNode> parents = new HashMap<>();

        var targetNode = putParentAndFindTarget(parents, root, null, start);

        Queue<TreeNode> queue = new ArrayDeque<>();
        Set<TreeNode> isVisited = new HashSet<>();

        queue.offer(targetNode);
        int seconds = -1;

        while (! queue.isEmpty()) {
            int size = queue.size();

            for (int i = 1; i <= size; ++i) {
                var node = queue.poll();

                isVisited.add(node);
                TreeNode parent = parents.get(node);

                if (node.left != null && !isVisited.contains(node.left)) queue.offer(node.left);
                if (node.right != null && !isVisited.contains(node.right)) queue.offer(node.right);
                if (parent != null && !isVisited.contains(parent)) queue.offer(parent);
            }

            seconds++;
        }

        return seconds;
    }

    public TreeNode putParentAndFindTarget(Map<TreeNode, TreeNode> parents, TreeNode node, TreeNode parent, int target) {
        if (node == null) return null;

        parents.put(node, parent);

        var left = putParentAndFindTarget(parents, node.left, node, target);
        var right = putParentAndFindTarget(parents, node.right, node, target);

        if (left != null) return left;
        else if (right != null) return right;
        else if (target == node.data) return node;

        return null;
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.left.left = new TreeNode(4);
        head.left.left.right = new TreeNode(7);

        head.right = new TreeNode(3);
        head.right.left = new TreeNode(5);
        head.right.right = new TreeNode(6);

        System.out.println(new BurnTree().timeToBurnTree(head, 1));
    }
}
