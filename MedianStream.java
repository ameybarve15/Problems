import java.util.Comparator;
import java.util.PriorityQueue;

//find median in a stream of integers
//
//        Method 1 : Insertion sort.
//        Insertion sort while inserting an element sorts the array and places incoming element at the correct sorted position.
//        Time complexity of sorting n elements is O(n2)
//
//        Method 2 : Self balancing BST (like AVL, RB)
//        Construct a BST with elements on left subtree less than that of root of BST and elements on right subtree greater than of root of BST.
//        Root of BST shhould give a median.
//        Self balancing BST is costly and also sorts all elements of the stream so far. Since we do not want all elements sorted and only want median use heap
//        approach.
//
//        Method 3 : Heaps
//        Maintain a max heap on the left hand side of the eventual median and maintain a min heap on the right hand side of the eventual median.
//        After processing an incoming element from a stream , total number of elements in heaps differ at most by 1.
//        If both heaps have same size then average value of their roots represent median.
//        else median is the element from heaps whose size is greater than other
//        Time complexity (O(nLog2n))
//
//        max heap on left
//        min heap on right

public class MedianStream {
    public static void main(String[] args) {
        int arr[] = {1, 6, 7, 5, 4, 8, 9, 2, 3}; // 1 2 3 4 5 6 7 8 9
        PriorityQueue<Integer> minHeap = new PriorityQueue();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(arr.length, new Comparator<Integer>() {
            @Override
            public int compare(Integer t1, Integer t2) {
                return t2 - t1;
            }
        });

        int first = arr[0];
        int second = arr[1];

        if (first < second) {
            maxHeap.add(second);
            System.out.println("Median = " + maxHeap.peek());
        } else {
            minHeap.add(first);
            System.out.println("Median = " + minHeap.peek());
        }

        for (int i = 2; i < arr.length; i++) {

            if (maxHeap.peek() < arr[i]) {
                maxHeap.add(arr[i]);
            }
            if (maxHeap.size() - minHeap.size() > 1) {
                minHeap.add(maxHeap.poll());
            }

            if (maxHeap.size() == minHeap.size()) {
                System.out.println("Median = " + (maxHeap.peek() + minHeap.peek()) / 2);
            } else if (maxHeap.size() < minHeap.size()) {
                System.out.println("Median = " + minHeap.peek());
            } else {
                System.out.println("Median = " + maxHeap.peek());
            }
        }

    }
}
