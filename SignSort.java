/** Given an array of unsorted negative and positive integers, sort the array so that negative
    * numbers stand at the front and positive at the back. Note that this should be a stable sort.
    *
    * For example, given A = [1, -2, 4, -3, -2, 5] return [-2, -3, -2, 1, 4, 5].
*/

// Approach:
//  keep 2 pointers 1 at the beginning 1 at the end
//  first pointer increement until you get element greater than 0, 2nd pointer until you get element less than 0
//  swap these 2 positions
//  keep doing this until these 2 pointers cross

// Space complexity O(1) constant
// Time complexity O(n)

public class SignSort {
  public static void main(String[] args) {
    int[] input = {-1, 1, -2, 2, -3, 3};
    int[] output = signSort(input);
    for (int i=0; i<output.length; i++) {
      System.out.println(output[i]);
    }
  }

  public static int[] signSort(int arr[]) {
    if (arr.length < 2) return arr;
    int low = 0, high = arr.length - 1;
    while (low < high) {
      while (arr[low] < 0 && low < arr.length - 1) {
        low++;
      }
      while (arr[high] > 0 && high > 0) {
        high--;
      }

      if (low < high) {
        // swap
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
      }
    }
    return arr;
  }
}
