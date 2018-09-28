package com.company;

public class Main {

    public static void main(String[] args) {
        Node root = null;
        BST bst = new BST();
        int arr[] = {15, 10, 20, 8, 12, 16, 25};
        for (int i=0; i<arr.length; i++) {
            root = bst.insert(root, arr[i]);
        }

        bst.inOrder(root);
    }

    private static class Node {
        int data;
        Node left;
        Node right;

        Node(int item) {
            data = item;
            left = null;
            right = null;
        }
    }

    private static class BST {
        Node insert(Node root, int data) {
            if (root == null) {
                root = new Node(data);
                return root;
            }

            if (root.data > data) {
                root.left = insert(root.left, data);
            }
            else {
                root.right = insert(root.right, data);
            }

            return root;
        }

        Node insertI(Node root, int data) {

            if (root == null) {
                return new Node(data);
            }

            Node current = root;
            while (current != null) {
                if (current.data > data) {
                    current = current.left;
                } else {
                    current = current.right;
                }
            }



            return root;

        }

        void inOrder(Node root) {
            if (root == null) {
                return;
            }
            inOrder(root.left);
            System.out.println(root.data);
            inOrder(root.right);
        }
    }

}

