import java.util.*;

/*
 We have a group chat system where users can message in group. Each message has an id which is higher than earlier message.
When a message is read by a user, it is assumed every message before that message in that group has also been read by that user
We want to display under each message, how many users have read this message.
Expose a method, that can be called to update the current message which a user has read.
Expose another method, that takes a message ID and tells you how many users have read it.


Group - G1
Users - U1, U2, U3, U4
Message timeline - M1, M2, M4, M5, M6, M10, M11, M12, M13
Events
updateMessageRead(U2, M4)
updateMessageRead(U3, M6)
Output
getReadCount(M2)  → 2
getReadCount(M5)  → 1


Solution:
1. Maintain a queue per user which will hold messages in the sequence.
Say : q1-> M1, M2, M4, M5, M6, M7, M11, M12, M13
      q2-> M1, M2, M4, M5, M6, M7, M11, M12, M13
      q3-> M1, M2, M4, M5, M6, M7, M11, M12, M13
      q4-> M1, M2, M4, M5, M6, M7, M11, M12, M13
and a Map data structure to hold username vs messages Map<String, Queue<String>>

2.
a. updateMessageRead(U2, M4)
Get the queue for user name U2 from our map and then pop all the messages from the queue until M4.
Hence q2 would look like : q2-> M5, M6, M10, M11, M12, M13
b. updateMessageRead(U3, M6)
Get the queue for user name U3 from our map and then pop all the messages from the queue until M6.
Hence q3 would look like : q2-> M10, M11, M12, M13

3. getReadCount(M2)
Iterate over all the user queues in sequence and compare input message M2 with the top message of each queue. If input message id is smaller than top message id then message has been read for that user and hence increment the count.

 */

public class GroupChatSystem {

  private Map<String, Queue<String> > userVsMessages;
  public GroupChatSystem(Map<String, Queue<String> > input) {
    userVsMessages = input;
  }

  public void updateMessageRead(String userId, String messageId) {
    Queue<String> messages = userVsMessages.get(userId);
    while (messageId.compareTo(messages.element()) > 0) {
      messages.remove();
    }
  }

  public int getReadCount(String messageId) {
    int count = 0;
    Iterator<Map.Entry<String, Queue<String>>> iterator = userVsMessages.entrySet().iterator();
    while (iterator.hasNext()) {
      Map.Entry<String, Queue<String>> next = iterator.next();
      Queue<String> value = next.getValue();
      if (value.element().compareTo(messageId) > 0) {
        count++;
      }
    }
    return count;
  }

  public static void main(String[] args) {

    Collection<String> collect = new ArrayList<String>();
    collect.add("M1");
    collect.add("M2");
    collect.add("M4");
    collect.add("M5");
    collect.add("M6");
    collect.add("M7");
    collect.add("M8");
    collect.add("M12");
    collect.add("M13");

    Map<String, Queue<String>> userVsMessages = new HashMap<>();
    LinkedList<String> l1 = new LinkedList<>();
    l1.addAll(Collections.unmodifiableCollection(collect));

    LinkedList<String> l2 = new LinkedList<>();
    l2.addAll(Collections.unmodifiableCollection(collect));

    LinkedList<String> l3 = new LinkedList<>();
    l3.addAll(Collections.unmodifiableCollection(collect));

    LinkedList<String> l4 = new LinkedList<>();
    l4.addAll(Collections.unmodifiableCollection(collect));

    userVsMessages.put("U1", l1);
    userVsMessages.put("U2", l2);
    userVsMessages.put("U3", l3);
    userVsMessages.put("U4", l4);

    GroupChatSystem groupChatSystem = new GroupChatSystem(userVsMessages);
    groupChatSystem.updateMessageRead("U2", "M4");
    groupChatSystem.updateMessageRead("U3", "M6");

    System.out.println(groupChatSystem.getReadCount("M2"));
    System.out.println(groupChatSystem.getReadCount("M5"));
    System.out.println(groupChatSystem.getReadCount("M7"));
    System.out.println(groupChatSystem.getReadCount("M8"));
  }
}
