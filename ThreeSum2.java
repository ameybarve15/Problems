import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.
 */

public class ThreeSum2 {
  public static void main(String[] args) {
//    int arr[] = {3,2,1,7,9,0,-4,6};
    int arr[] = {0, 0, 0};
    int target = 0;
    List<List<Integer>> threeSumArray = getThreeSumArray(arr, target);
    for (int i=0; i<threeSumArray.size(); i++) {
      List<Integer> list = threeSumArray.get(i);
      for (int j=0; j<list.size(); j++) {
        System.out.println(list.get(j));
      }
    }
  }

  public static List<List<Integer>> getThreeSumArray(int[] arr, int target) {
    List<List<Integer>> result = new ArrayList<>();
    int n = arr.length;
    if (arr == null || n < 3) return result;
    Arrays.sort(arr);

    for (int i=0; i<n-2; i++) {
      int low = i+1;
      int high = n-1;
      while (low < high) {
        int sum = arr[i] + arr[low] + arr[high];
        // This check is for uniqueness (i != low && low != high && high != i)
        if (sum == target) {
          List<Integer> list = new ArrayList();
          list.add(arr[i]);
          list.add(arr[low]);
          list.add(arr[high]);
          if (!result.contains(list)) { // to prevent duplicate lists
            result.add(list);
          }
          high--; // This is needed when we met the condition.
          low++;
        } else if (sum > target) {
          high--;
        } else {
          low++;
        }
      }
    }
    return result;
  }
}
