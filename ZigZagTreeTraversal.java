//Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right,
// then right to left for the next level and alternate between).
//
//        For example: Given binary tree {3,9,20,#,#,15,7},
//
//        3
//        / \
//        9  20
//        /  \
//        15   7
//        return its zigzag level order traversal as: [ [3], [20,9], [15,7] ]

import java.util.LinkedList;
import java.util.Queue;

public class ZigZagTreeTraversal {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.leftChild = new TreeNode(9);
        node.rightChild = new TreeNode(20);
        node.rightChild.leftChild = new TreeNode(15);
        node.rightChild.rightChild = new TreeNode(7);

        zigZagTreeTraversal(node);
    }

    public static void zigZagTreeTraversal(TreeNode node) {
        if (node == null) return;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(node);
        // Based on this flag enque if it is true enque nodes from right else from left
        // toggle value of rightFirst after every level
        boolean rightFirst = true;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i=0; i<size; i++) {

                TreeNode out = queue.poll();
                System.out.println(out.value);

            if (rightFirst) {
                if (out.rightChild != null) {
                    queue.add(out.rightChild);
                }
                if (out.leftChild != null) {
                    queue.add(out.leftChild);
                }
            } else {
                if (out.leftChild != null) {
                    queue.add(out.leftChild);
                }
                if (out.rightChild != null) {
                    queue.add(out.rightChild);
                }
            }
            rightFirst = !rightFirst;
        }
    }
}

    private static class TreeNode {
        final int value;
        TreeNode leftChild;
        TreeNode rightChild;

        TreeNode(int data) {
            value = data;
            leftChild = null;
            rightChild = null;
        }
    }
}
