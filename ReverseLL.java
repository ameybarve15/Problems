/**
 * Created by amey on 6/11/18.
 */
// Reverse a SLL recursively

public class ReverseLL {
  static class LNode {
    LNode link;
    int data;
  };
  public static void main(String[] args) {
    LNode head = new LNode();
    head.data = 1;

    LNode second = new LNode();
    head.link = second;
    second.data = 2;


    LNode third = new LNode();
    second.link = third;
    third.data = 3;


    LNode fourth = new LNode();
    third.link = fourth;
    fourth.data = 4;

    fourth.link = null;

    printLL(head);


    LNode rhead = reverse(head, null);

    System.out.println("LL Reversed");

    printLL(rhead);
  }

  private static void printLL(LNode head) {
    LNode temp = head;
    while (temp != null) {
      System.out.println(temp.data);
      temp = temp.link;
    }
  }

  private static LNode reverse(LNode current, LNode previous) {

    if (current == null) return null; // no node

    if (current.link == null) { // single node return head as current node only changing its previous to null
      current.link = previous;
      return current;
    }

    LNode next = current.link; // recursive way to change link to previous.

    current.link = previous;

    return reverse(next, current);

  }
}
