import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
Merge K sorted lists
 */

public class MergeKLists {
    static class ListNode {
        ListNode next;
        int value;

        ListNode(int data) {
            value = data;
            next = null;
        }
    }
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2);
        listNode1.next = new ListNode(5);

        ListNode listNode2 = new ListNode(4);
        listNode2.next = new ListNode(6);
        listNode2.next.next = new ListNode(7);

        ListNode listNode3 = new ListNode(1);
        listNode3.next = new ListNode(3);
        listNode3.next.next = new ListNode(4);
        listNode3.next.next.next = new ListNode(5);

        List list = new ArrayList();
        list.add(listNode1);
        list.add(listNode2);
        list.add(listNode3);

        ListNode listNode = mergeKLists(list);
        printList(listNode);
    }

    static void printList(ListNode node) {
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }

    static ListNode mergeKLists(List<ListNode> lists) {
        ListNode head = null;
        ListNode temp = null;
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            public int compare(ListNode o1, ListNode o2) {
                return Integer.compare(o1.value, o2.value);
            }
        }); // priority Q of
        // size equal
        // to number of lists
        for (ListNode list:lists) {
            priorityQueue.add(list);
        }
        while (!priorityQueue.isEmpty()) {
            ListNode poll = priorityQueue.poll();
            if (poll.next != null) {
                priorityQueue.add(poll.next);
            }
            if (head == null) {
                head = poll;
                temp = head;
            } else {
                temp.next = poll;
                temp = temp.next;
            }
        }
        return head;
    }
}
