import static java.lang.Math.abs;

/**
 * Created by amey on 6/6/18.
 */

// Problem statement: Reverse a integer
// i/p : 1111 o/p : 1111
// i/p : 100 o/p : 1
// i/p : MAX.INT o/p : 7463847412

public class ReverseInteger {
  public static void main(String args[]) {
    reverseInteger(1111);
    reverseInteger(100);
    reverseInteger(Integer.MAX_VALUE);
  }

  private static void reverseInteger(int input) {

    int absInput = abs(input);
    long reverse = 0; // this is purposefully set to long data type to handle overflow case
    while (absInput > 0) {
      reverse = (reverse * 10) + (absInput % 10);
      absInput = absInput / 10;
    }

    if (input < 0) {
      reverse = reverse * -1;
    }

    System.out.println("reverse of " + input + " is " + reverse);
  }
}
