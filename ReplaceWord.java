public class ReplaceWord {
    public static void main(String[] args) {
        String sentence = "I love programming and programming is fun!";
        String wordToReplace = "programming";
        String replacementWord = "coding";

        // Call the replaceWord method
        String modifiedSentence = replaceWord(sentence, wordToReplace, replacementWord);

        // Output the modified sentence
        System.out.println("Modified Sentence: " + modifiedSentence);
    }

    public static String replaceWord(String sentence, String wordToReplace, String replacementWord) {
        // Use the replaceAll method to replace the word in the sentence
        return sentence.replaceAll("\\b" + wordToReplace + "\\b", replacementWord);
    }
}
