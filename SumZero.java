/*
Given an integer n, return any array containing n unique integers such that they add up to 0.
Input: n = 5
Output: [-7,-1,1,3,4]
Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].

Input: n = 3
Output: [-1,0,1]
 */

public class SumZero {
    public static void main(String[] args) {
        int n = 5;
        int[] ints = sumZero(n);
        for (int x : ints) {
            System.out.println(x);
        }
    }
    public static int[] sumZero(int n) {
        int[] result = new int[n];
        if (n == 1) {
            result[0] = 0;
            return result;
        }
        boolean isEven;
        if (n % 2 == 0) {
            isEven = true;
        } else {
            isEven = false;
        }
        int i = 0;
        int index = 0;
        while (i < n/2) {
            int number = i+1; // since we do not want 0 to be repeated
            int negativeNumber = -number;
            result[index] = number;
            index = index+ 1;
            result[index] = negativeNumber;
            index = index+ 1;
            i = i+1;
        }
        if (!isEven) {
            result[n-1] = 0;
        }
        return result;
    }
}
