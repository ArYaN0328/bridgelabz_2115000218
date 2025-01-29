import java.util.Scanner;

public class LongestWordFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();
        scanner.close();

        String longestWord = findLongestWord(sentence);
        System.out.println("The longest word is: " + longestWord);
    }

    private static String findLongestWord(String sentence) {
        String[] words = sentence.split("\\s+"); // Splits sentence by spaces
        String longestWord = "";
        
        for (String word : words) {
            // Remove punctuation and compare length
            String cleanWord = word.replaceAll("[^a-zA-Z]", ""); 
            if (cleanWord.length() > longestWord.length()) {
                longestWord = cleanWord;
            }
        }
        return longestWord;
    }
}
