import org.junit.Assert;

/**
 * Given an array of elements, it is said to have a dominator (i.e. a majority element) if more
 * than half of its entries are the same. Given an array, design an efficient algorithm to tell
 * whether the array has a majority element, and, if so, to find that element.
 **/

// dominator : if given element is repeating more than the half the number of total elements in an array
// (Majority element)

public class Dominator {
  public static void main(String[] args) {
    Assert.assertEquals(3, getDominator(new int[]{3, 4, 3, 2, 3, -1, 3, 3}));
    Assert.assertEquals(3, getDominator(new int[] {3, 4, 3, 2, 3, -1, 3, 6}));
    Assert.assertEquals(3, getDominator(new int[] {2, 4, -1, 6, 3, 3, 3, 3}));
    Assert.assertEquals(3, getDominator(new int[] {3, 4, 3, 2, 3, -1, 6, 3}));
    Assert.assertEquals(3, getDominator(new int[] {3, 4, 3, 3, -1, 6, 3, 8}));
    Assert.assertEquals(-1, getDominator(new int[] {}));
    Assert.assertEquals(3, getDominator(new int[] {3}));
    Assert.assertEquals(Integer.MAX_VALUE, getDominator(new int[] {Integer.MAX_VALUE, 3, Integer.MAX_VALUE}));
  }

  public static int getDominator(int arr[]) {
    if (arr == null || arr.length == 0) {
      return -1;
    }
    if (arr.length == 1) return arr[0];

    int counter = 1;
    int element = arr[0];

    for (int i = 1; i<arr.length; i++) {
      if (element == arr[i]) {
        counter++;
      } else {
        if (counter <= 0) {
          element = arr[i];
        }
        counter--;
      }
    }
    return element;
  }
}
