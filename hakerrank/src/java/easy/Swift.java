package easy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Software like Swype and SwiftKey lets smartphone users enter text by dragging their finger over the on-screen keyboard,
 * rather than tapping on each letter.
 * You'll be given a string of characters representing the letters the user has dragged their finger over.
 * For example, if the user wants "rest", the string of input characters might be "resdft" or "resert".
 * Assumptions about the input strings:
 * QWERTY keyboard
 * Lowercase a-z only, no whitespace or punctuation
 * The first and last characters of the input string will always match the first and last characters of the desired output word
 * Don't assume users take the most efficient path between letters
 * Every letter of the output word will appear in the input string
 */
public class Swift {


    public static void main(String[] args) {

        guessWord("qwertyuytresdftyuioknn"); //output: queen question (doesnt include shorter than 5 letters words)
        guessWord("gijakjthoijerjidsdfnokg"); //output: gaeing garring gathering gating geeing gieing going goring (doesnt include shorter than 5 letters words)
    }

    private static void guessWord(String swype) {
        List<String> possibleWords = readFile(swype);
        List<String> test = new ArrayList<>();
        test.add("queen");
        List<String> result = filterWords(possibleWords, swype);
        System.out.println(result.toString());
    }

    private static List<String> filterWords(List<String> possibleWords, String swype) {
        List<String> filtered = possibleWords.stream()
                .filter(word -> checkIfWordFitsSwype(swype, word))
                .collect(toList());
        return filtered;
    }

    private static boolean checkIfWordFitsSwype(String swype, String word) {
        int wIndex = 0;
        int counter = 0;
        for (int swIndex = 0; swIndex < swype.length(); swIndex++) {
            if (wIndex < word.length()-1 && word.charAt(wIndex) == word.charAt(wIndex + 1)) {
                counter++;
                wIndex++;
                continue;
            }
            if (swype.charAt(swIndex) == word.charAt(wIndex)) {
                counter++;
                wIndex++;
                if (counter == word.length()) return true;
            }
        }
        return false;
    }

    private static List<String> readFile(String swype) {
        List<String> possibleWords = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get("/home/aga/IdeaProjects/Learning/hakerrank/src/resources/dictionary.txt"))) {
            possibleWords = stream.filter(line -> line.startsWith(String.valueOf(swype.charAt(0)))
                    && line.endsWith(String.valueOf(swype.charAt(swype.length() - 1)))
                    && line.length() < swype.length())
                    .collect(toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return possibleWords;
    }
}
