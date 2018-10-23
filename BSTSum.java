import java.util.HashSet;
import java.util.Set;

// Problem : Given a BST of integers and a target value s, return two nodes summing to s.

// Explanation : Traversing in-order traversal on BST gives a sorted stream of integers.
// Either use 2 pointer approach 1 at the beginning and other at the end to find out 2 numbers adding up to a sum.
// Use HashSet to store the elements as traversed and check while iterating over if difference between
// target and current node's value is present in the HashSet.

public class BSTSum {
    public static void main(String[] args) {

        BNode root = new BNode(40);
        root.leftChild = new BNode(30);
        root.rightChild = new BNode(50);
        root.leftChild.leftChild = new BNode(10);
        root.leftChild.rightChild = new BNode(20);

        findSum(root, 70);
        set.clear();
        findSum(root, 80);
        set.clear();
        findSum(root, 90);
        set.clear();
        findSum(root, 100);
        set.clear();
        findSum(root, 60);
        set.clear();
    }

    static Set<Integer> set = new HashSet<>();

    public static void findSum(BNode root, int target) {
        if (root == null) return;

        findSum(root.leftChild, target);
        findSumHelper(root, target);
        findSum(root.rightChild, target);
    }

    public static void findSumHelper(BNode node, int target) {
        int value = (target - node.value);

        if (!set.contains(target-node.value)) {
            set.add(node.value);
        } else {
            System.out.println("Sum of " + node.value + " and " + value + " is  = " + target);
            return;
        }
    }

    private static class BNode {
        int value;
        BNode leftChild;
        BNode rightChild;

        BNode(int data) {
            value = data;
            leftChild = null;
            rightChild = null;
        }
    }
}
