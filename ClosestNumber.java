/*
Find closest number in the sorted array
Idea is if we are checking in upper half that is by setting low = middle+ 1, then also check its next element is
smallest than target then get closest amongst the two.
If we are checking in lower half that is by setting high = middle - 1, then also check its previous element is
greater than target then get closest amongst the two.
Time complexity : log2n
 */
public class ClosestNumber {
    public static void main(String[] args) {
        int arr[] = {10,20,30,40,50,60,70,80,80,90,100};
        int target = 31;

        System.out.println(findClosestNumber(arr, target));
    }

    static int findClosestNumber(int arr[], int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int length = arr.length;

        if (target < arr[0]) {
            return arr[0];
        }

        if (target > arr[length-1]) {
            return arr[length-1];
        }

        int low = 0, high = length - 1;
        while (low < high) {
            int middle = (low + high) / 2;
            if (target == arr[middle]) {
                return arr[middle];
            } else if (target > arr[middle]) {
                if (middle < length-1 && target < arr[middle + 1]) {
                    return closest(arr[middle], arr[middle+1], target);
                }
                low = middle + 1;
            } else if (target < arr[middle]) {
                if (middle > 0 && target > arr[middle-1] ) {
                    return closest(arr[middle-1], arr[middle], target);
                }
                high = middle - 1;
            }
        }
        return -1;
    }

    static int closest(int n1, int n2, int target) {
        if (target - n1 > n2 - target) {
            return n2;
        } else {
            return n1;
        }
    }
}
