package LeetcodeProblems;

import java.util.Arrays;
//Leetcode

public class SentenceSimilarity {
    public static boolean areSentencesSimilar(String sentence1, String sentence2) {
        // Split the sentences into words
        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");

        // If the sentences are identical, they are similar
        if (sentence1.equals(sentence2)) {
            return true;
        }

        // If one sentence is empty, they are similar (we can insert the non-empty sentence)
        if (words1.length == 0 || words2.length == 0) {
            return true;
        }

        // Ensure words1 is the shorter or equal length array
        if (words1.length > words2.length) {
            String[] temp = words1;
            words1 = words2;
            words2 = temp;
        }

        int i = 0, j = 0;

        // Check prefix
        while (i < words1.length && words1[i].equals(words2[i])) {
            i++;
        }

        // Check suffix
        while (j < words1.length - i &&
                words1[words1.length - 1 - j].equals(words2[words2.length - 1 - j])) {
            j++;
        }

        // If all words in the shorter sentence match, the sentences are similar
        return i + j == words1.length;
    }

    public static void main(String[] args) {
        // Test cases
        String[][] testCases = {
                {"My name is Haley", "My Haley"},
                {"of", "A lot of people"},
                {"Eating right now", "Eating"},
                {"Luky", "Lucccky"},
                {"Hello World", "Hello World"}
        };

        for (String[] testCase : testCases) {
            boolean result = areSentencesSimilar(testCase[0], testCase[1]);
            System.out.println("Sentence 1: \"" + testCase[0] + "\"");
            System.out.println("Sentence 2: \"" + testCase[1] + "\"");
            System.out.println("Are they similar? " + result);
            System.out.println();
        }
    }
}