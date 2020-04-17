/*
given an integer, you need to insert a digit '5' to get a largest possible number. (ex: 93 ->953, -76 -> -576)
 */

// Recursively check for each index of the input number if the digit is smaller than 5 then append 5
// to its next digit and also append remainder of the number string, if the digit is greater than 5 then
// recursively call findGreatestIntegerUsingDigit5 with subsequent digit index

public class findGreatestIntegerUsingDigit5 {
    public static void findGreatestIntegerUsingDigit5(String number, int index) {
        if (index >= number.length()) {
            number = number + 5;
            System.out.println(number);
            return ;
        }
        char c = number.charAt(index);
        if (c - '0' < 5) {
            number = number.substring(0, index) + "5" + number.substring(index);
            System.out.println(number);
            return;
        } else {
            findGreatestIntegerUsingDigit5(number, index+1);
        }
    }

    public static void main(String[] args) {
        String number = "-76";
        if (number != null && number.charAt(0) == '-') {
            System.out.println(number.substring(0,1)+"5"+number.substring(1));
            return;
        }
        findGreatestIntegerUsingDigit5(number, 0);
    }
}
