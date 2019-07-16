/*
Given a sorted array arr[] and a number x, write a function that counts the occurrences of x in arr[]. (O(Log(N)))

1 2 3 4 5 6 7 7 8 8 9 9 9 10

0 1 2 3 4 5 6 7 8 9 10 11 12

target : 8, o/p : 2
target : 1, o/p : 1
target : 9, o/p : 3
 */

public class GetOccurenceInSorted {
  public static void main(String[] args) {
    int arr[] = {1, 2, 3, 4, 5, 6, 7, 7, 8, 8, 9, 9, 9, 10};
    System.out.println(getOccurenceInSorted(arr, 1));
    System.out.println(getOccurenceInSorted(arr, 8));
    System.out.println(getOccurenceInSorted(arr, 9));
    System.out.println(getOccurenceInSorted(arr, 10));
    System.out.println(getOccurenceInSorted(arr, 11));
  }

  public static int getOccurenceInSorted(int arr[], int target) {
    int count = 0;
    int low = 0;
    int high = arr.length - 1;
    while(low <= high) {
      int middle = (low + high) / 2;

      if (target > arr[middle]) {
         low = middle+1 ;
      } else if (target < arr[middle]) {
        high = middle-1 ;
      }
      else if (arr[middle] == target) {
        for(int i=low; i<=middle; i++) {
          if(arr[i] == target) {
            count++;
          }
        }
        for(int j=middle+1; j<=high; j++) {
          if(arr[j] == target) {
            count++;
          }
        }
        return count;
      }
    }
    return count;
  }
}
