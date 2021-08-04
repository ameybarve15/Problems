import java.util.*;

/*
Write a function diff(arrA, arrB) that accepts two arrays and returns a new array that contains all values that are not
contained in both input arrays. The order of numbers in the result array does not matter.

Examples
a = [1, 2, 3, 4]
b = [3, 4, 5, 6]

diff(a, b) # => [1, 2, 5, 6]

Note: we don't care if numbers are out of order or repeated; for example, these two arrays are equivalent since they are
 re-arrangements of the same values:

a = [1, 2, 1]
b = [2, 1, 2]

diff(a, b) # => []
 */
public class Difference_Arrays {
    public static void main(String[] args) {
        int a[] = {1,2,3,4};
        int b[] = {3,4,5,6};

        Integer[] diff = diff(a, b);
        System.out.println(Arrays.toString(diff));
    }

    private static Integer[] diff(int[] a, int[] b) {
        Set<Integer> set1 = new HashSet<>();
        for(int i = 0; i < a.length; i++) {
            if (set1.add(a[i]));
        }

        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < b.length; i++) {
                set2.add(b[i]);
        }

        List<Integer> resultList = new ArrayList<>();
        for (int i : set1) {
            if (!set2.contains(i)) {
                resultList.add(i);
            }
        }

        for (int i : set2) {
            if (!set1.contains(i)) {
                resultList.add(i);
            }
        }

        Integer result[] = new Integer[resultList.size()];
        return resultList.toArray(result);
    }
}
