/**
 * Created by amey on 6/6/18.
 */

// Problem statement: Given a string sequence print first non repeating character
// i/p : abcd o/p : a
// i/p : abcdacb o/p : d
// i/p : aaaaa o/p : nothing or return


public class PrintFirstNonRepeatingCharacter {
  public static void main(String args[]) {
    String input = "abcdacb";
    printFirstNonRepeatingCharacter(input);

    printFirstNonRepeatingCharacter("aaaaaaaaaaaa");

    printFirstNonRepeatingCharacter("abb");

  }

  private static void printFirstNonRepeatingCharacter(String input) {
    if ( input == null || input.length() == 0 ) {
      return;
    }

    int alphabets[] = new int[26];
    for (int i=0; i<input.length(); i++) {
      int ascii = input.charAt(i) - 'a';
      alphabets[ascii]++;
    }

    for (int i=0; i<input.length(); i++) {
      char ch = (char) (i + 'a');
      if (alphabets[i] == 1) {
        System.out.println("First non-repeating character is " + ch);
        break;
      }
    }

  }
}
