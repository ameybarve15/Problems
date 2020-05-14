import java.util.*;

/*
In a warehouse, there is a row of barcodes, where the i-th barcode is barcodes[i].

Rearrange the barcodes so that no two adjacent barcodes are equal.  You may return any answer, and it is guaranteed an answer exists.

Example 1:

Input: [1,1,1,2,2,2]
Output: [2,1,2,1,2,1]
Example 2:

Input: [1,1,1,1,2,2,3,3]
Output: [1,3,1,3,2,1,2,1]

 */
public class DistantBarCodes {

    public static void main(String[] args) {
        int arr[] = {1,1,1,1,2,2,3,3};
        int[] ints = rearrangeBarcodes(arr);
        for (int x : ints) {
            System.out.println(x);
        }
    }

    public static int[] rearrangeBarcodes(int[] barcodes) {
        int result[] = new int[barcodes.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < barcodes.length; i++) {
            if (map.containsKey(barcodes[i])) {
                map.put(barcodes[i], map.get(barcodes[i])+1);
            } else {
                map.put(barcodes[i], 1);
            }
        }

        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue =
                new PriorityQueue<>(Collections.reverseOrder(Map.Entry.comparingByValue()));
        priorityQueue.addAll(map.entrySet());

        int index = 0;
        // process 2 elements from priority Queue at a time based on frequency count which ensures that 2 consecutive
        // elements can never be same.
        while (priorityQueue.size() >= 2) {
            Map.Entry<Integer, Integer> entry1 = priorityQueue.poll();
            result[index] = entry1.getKey();
            index++;
            Map.Entry<Integer, Integer> entry2 = priorityQueue.poll();
            result[index] = entry2.getKey();
            index++;

            int value1 = entry1.getValue();
            value1 = value1 - 1;
            if (value1 > 0) {
                entry1.setValue(value1);
                priorityQueue.add(entry1);
            }

            int value2 = entry2.getValue();
            value2 = value2 - 1;
            if (value2 > 0) {
                entry2.setValue(value2);
                priorityQueue.add(entry2);
            }
        }

        // Add remaining elements from priority queue if any
        if (!priorityQueue.isEmpty()) {
            Map.Entry<Integer, Integer> entry = priorityQueue.poll();
            result[index] = entry.getKey();
        }
        return result;
    }
}
