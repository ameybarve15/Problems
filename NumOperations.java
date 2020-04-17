/*
The time traveller
John has just made time travelling possible. Using his time machine, he can travel in both future and past. The only limitation of the machine is that the destination year should always be a power of 2. Now you are given the current year and you need to find the minimum number of steps required to travel from current year to destination year using the following 2 methods.
If the current year(let's say a) is even, then you can change it to a/2 but if it is odd then apply (a-1)/2.
You can also double the value i.e apply a*2.
Input
The 1st line will contain t(1<=t<=10), the number of test cases.
Each test case will contain 2 numbers a(1<=a<=107 ) and b(1<=b<=107 ) defining the source and destination years respectively.
Output
A single line containing the minimum number of steps required to do time travel.
Sample test cases

Input
1
2 16

Output
3

Explanation
Applying the second operation 3 times will make current year equal to destination year.
 */
public class NumOperations {

    public static void main(String[] args) {
        int i = NumberOfOperations(2, 16, 0);
        System.out.println("Number of Operations = " + i);
    }

    public static int NumberOfOperations(int src, int destination, int operations) {
        if (src == destination) return operations;
        if (src < destination) {
            if (src % 2 == 0) {
                return NumberOfOperations(src*2, destination, operations+1);
            } else {
                return NumberOfOperations((src-1)/2, destination, operations+1);
            }
        } else {
            if (src % 2 == 0) {
                return NumberOfOperations(src/2, destination, operations+1);
            } else {
                return NumberOfOperations((src-1)/2, destination, operations+1);
            }
        }
    }
}
