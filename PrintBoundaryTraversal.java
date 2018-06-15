/**
 * Created by amey on 6/15/18.
 */

//Given a binary tree, print boundary nodes of the binary tree Anti-Clockwise starting from the root.

public class PrintBoundaryTraversal {

  private static class BNode {
    BNode leftChild;
    int data;
    BNode rightChild;

    public BNode(int data) {
      this.data = data;
      this.leftChild = null;
      this.rightChild = null;
    }
  }

  public static void main(String[] args) {
    BNode root = new BNode(1);
    root.leftChild = new BNode(2);
    root.rightChild = new BNode(3);

    root.leftChild.leftChild = new BNode(4);
    root.leftChild.rightChild = new BNode(5);

    printBoundaryTraversal(root);

  }

  private static void printBoundaryTraversal(BNode root) {
    // 1 printLeftBoundary from top to bottom

    printLeftBoundary(root);

    // 2 printLeaves of both left and right subtree

    printLeaves(root);

    // 3 printRightBoundary from bottom to top

    printRightBoundary(root.rightChild);
  }

  private static void printRightBoundary(BNode root) {
    if (root != null) {
      if (root.rightChild != null) {

        printRightBoundary(root.rightChild);
        System.out.println(root.data);
      }
    }
  }


  private static void printLeaves(BNode root) {
    if (root != null) {
      printLeaves(root.leftChild);

      if (root.leftChild == null && root.rightChild == null) {
        System.out.println(root.data);
      }

      printLeaves(root.rightChild);
    }
  }

  private static void printLeftBoundary(BNode root) {

    if (root != null) {
      if (root.leftChild != null) {
        System.out.println(root.data);

        printLeftBoundary(root.leftChild);
      }
    }

  }
}
