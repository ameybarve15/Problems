/**
 * Created by amey on 6/5/18.
 */

// Problem statement: Given a string hello world print character and frequency in sorted character sequence
// o/p : d 1 e 1 h 1 l 3 o 2 r 1 w 1

public class PrintSortedCharacterAndFrequency {
  public static void main(String[] args) {

    String input = "helloworld";
    printSortedCharacterAndFrequency(input);

  }

  private static void printSortedCharacterAndFrequency(String input) {
    if (input == null || input.length() == 0) // base case
      return;

    int alphabets[] = new int[26]; // only small case alphabets

    for (int i=0; i<input.length(); i++) { // iterate over input and store frequency of each character
      int asciiVal = input.charAt(i) - 'a';
      alphabets[asciiVal]++;
    }

    for (int i=0; i<alphabets.length; i++) { // iterate over alphabets array as it stores characters in alphabetical order
      if (alphabets[i] != 0) {
        char ch = (char) (i + 'a'); // convert back from ascii to character
        System.out.println( ch + " " + alphabets[i]);
      }
      alphabets[i] = 0; // set count to 0 ao it will reprint repeated element again.
    }

  }
}
