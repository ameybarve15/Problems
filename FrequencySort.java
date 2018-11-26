import java.util.*;

/**
 * Given a string, sort it in decreasing order based on the frequency of characters.
 *
 * Example 1:
 *
 * Input:
 * "tree"
 *
 * Output:
 * "eert"
 *
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 */

public class FrequencySort {
  public static void main(String[] args) {
    System.out.println(frequencySort2("abcdaccc"));
  }

  public static String frequencySort2(String s) {

    int length = s.length();
    if (s == null || length == 0) {
      return new StringBuilder().toString();
    }

    Map<Character, Integer> map = new HashMap<>();
    // O(n) Time complexity + O(n) space complexity
    for (int i = 0; i< length; i++) {
      char ch = s.charAt(i);
      if (map.containsKey(ch)) {
        map.put(ch, map.get(ch) + 1);
      } else {
        map.put(ch, 1);
      }
    }

    // create a minimum heap by creating instance of PriorityQueue
    // and placing the items in the queue by decreasing order of character frequency.
    // and add all entries to this queue (O(nlogn))
    PriorityQueue<Map.Entry<Character, Integer>> queue = new
        PriorityQueue<>(Collections.reverseOrder(Map.Entry.comparingByValue()));
    queue.addAll(map.entrySet());

    StringBuilder result = new StringBuilder();

    // Iterate over the queue and fetch character in decreasing value of its frequency
    // Append character as many times as its frequency count.

    while (!queue.isEmpty()) {
      Map.Entry<Character, Integer> poll = queue.poll();
      for (int j=0; j<poll.getValue(); j++) {
        result.append(poll.getKey());
      }
    }
    return result.toString();
  }
}
