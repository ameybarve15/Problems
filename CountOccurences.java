// Given a sorted array arr[] and a number x, write a function that counts the occurrences of x in arr[]. (O(Log(N)))

public class CountOccurences {
  public static int binarySearch(int[] arr, int target){
    int low = 0;
    int high = arr.length;
    while (low < high) {
      int middle = (low + high) / 2;

      if (arr[middle] == target) {
        return middle;
      } else if (target < arr[middle]) {
        high = middle - 1;
      } else if (target > arr[middle]) {
        low = middle + 1;
      }
    }
    return -1;
  }

  public static int countOccurences(int[] arr, int target) {
    int count = 0;
    int index = binarySearch(arr, target); // get index of target element using binary search in 0(Logn)

    if (index == -1) return count; // if element is not found its count is 0;

    count = 1; // since element is found count is 1;

    // count number of its occurences to the left until start of array
    int left = index - 1;
    while (left > 0 && arr[left] == target) {
      left--;
      count++;
    }

    // count number of its ccurences to the right until size of array
    int right = index + 1;
    while (right < arr.length && arr[right] == target) {
      right++;
      count++;
    }

    // Total complexity = 0(Logn + count)

    return count;
  }

  public static void main(String[] args) {

    int arr[] = {2,4,5,5,5,6,6,6,8,9};
    int target = 5;

    System.out.println(countOccurences(arr, target));
  }
}
