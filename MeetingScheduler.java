import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by amey on 7/12/18.
 */

// Design a meeting scheduler
// Meeting - with its attributes
// Schedule - BST


public class MeetingScheduler {
  public static void main(String[] args) {

    ArrayList<Meeting> list = new ArrayList<>();
    list.add(new Meeting("Meeting1", "Meeting1 Description", new Date(2018, 8, 12, 8, 30), new Date(2018, 8, 12, 9, 30), Room.R1, null));
    list.add(new Meeting("Meeting2", "Meeting2 Description", new Date(2018, 8, 12, 9, 31), new Date(2018, 8, 12, 10, 30), Room.R1, null));
    list.add(new Meeting("Meeting3", "Meeting3 Description", new Date(2018, 8, 12, 10, 31), new Date(2018, 8, 12, 11, 30), Room.R1, null));
    list.add(new Meeting("Meeting4", "Meeting4 Description", new Date(2018, 8, 12, 8, 30), new Date(2018, 8, 12, 9, 30), Room.R1, null));

    BSTree tree = addMeetings(list);

    tree.inOrderHelper();
  }

  private static class BSTree {

    private static class BSTNode {
      Date startTime;
      BSTNode leftChild;
      BSTNode rightChild;
      Date endTime;

      public BSTNode(Meeting item) {
        startTime = item.startTime;
        leftChild = rightChild = null;
        endTime = item.endTime;
      }
    }

    BSTNode root;

    public BSTree() {
      root = null;
    }


    private BSTNode insert(BSTNode node, Meeting data)
    {
      if (node == null)
        node = new BSTNode(data);
      else
      {
        if (data.startTime.after(node.startTime ) && data.endTime.before(node.endTime))
          return null;
        else if (data.startTime.before(node.startTime))
          node.leftChild = insert(node.leftChild, data);
        else if (data.startTime.after(node.endTime))
          node.rightChild = insert(node.rightChild, data);
      }
      return node;
    }

    void add(Meeting item) {

      root = insert(root, item);

    }

    void inOrderHelper() {
      inOrder(root);
    }

    void inOrder(BSTNode node) {

      if (node == null) return;

      inOrder(node.leftChild);

      System.out.println(node.startTime);

      inOrder(node.rightChild);

    }

  }

  private static BSTree addMeetings(ArrayList<Meeting> list) {
    BSTree tree = new BSTree();

    for (int i=0; i<list.size(); i++) {

      Meeting meeting = list.get(i);

      tree.add(meeting);

    }

    return tree;
  }

  enum Room {
    R1,
    R2,
    R3,
    R4
  }

  private class Attendees {

  }

  private static class Meeting {

    public String meetingTitle;
    public String meetingDescription;
    public Date startTime;
    public Date endTime;

    public Room room;
    public List<Attendees> attendeesList;

    public Meeting(String meetingTitle, String meetingDescription, Date startTime, Date endTime, Room room,
                   List<Attendees> attendeesList) {
      this.meetingTitle = meetingTitle;
      this.meetingDescription = meetingDescription;
      this.startTime = startTime;
      this.room = room;
      this.attendeesList = attendeesList;
      this.endTime = endTime;
    }
  }
}
