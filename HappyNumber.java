import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    static Set<Integer> set = new HashSet<>();
    public static void main(String[] args) {

        System.out.println(isHappy(19)); // true

        System.out.println(isHappy(20));  // false
    }

    static boolean isHappy(int number) {
        if (number == 0) return false;

        int sum = 0;
        while (number > 0) {
            int remainder = number % 10	;
            sum = sum + (remainder * remainder);
            number = number / 10;
        }
        if (sum == 1) {
            return true;
        } else {
            if (set.contains(sum)) {
                return false;
            }
            else {
                set.add(sum);
            }
            return isHappy(sum);
        }
   }
}
