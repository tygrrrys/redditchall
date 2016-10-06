package easy;

import java.util.Arrays;

/**
 You'll be given two words or sets of words separated by a question mark. Your task is to replace the question mark with information about the validity of the anagram. Example:
 "Clint Eastwood" ? "Old West Action"
 "parliament" ? "partial man"
 Output Description

 You should replace the question mark with some marker about the validity of the anagram proposed. Example:
 "Clint Eastwood" is an anagram of "Old West Action"
 "parliament" is NOT an anagram of "partial man"

 */
public class Anaagram {

    public static void main(String[] args) {
        System.out.println(isItAnaagram("\"Clint Eastwood\" ? \"Old West Action\""));
    }

    private static String isItAnaagram(String input) {
        String [] words = input.split(" \\? ");
        String first = words[0];
        String second = words[1];
        return sortedWord(first).equals(sortedWord(second)) ? "anaagram" : "different words";
    }

    private static String sortedWord(String input) {
        input = input.replace(" ", "").toLowerCase();
        char[] chars = input.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
