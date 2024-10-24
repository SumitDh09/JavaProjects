package LeetcodeProblems;

public class ReverseWords {
    public static String reverseWords(String s) {
        // Trim leading and trailing spaces
        s = s.trim();
        // Split  string by one / more spaces
        String[] words = s.split("\\s+");
        // Use StringBuilder to build the reverse string
        StringBuilder reversed = new StringBuilder();
        // Iterate over the words array in reverse order
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i != 0) {
                reversed.append(" ");
            }
        }
        return reversed.toString();
    }

    public static void main(String[] args) {
        String input = "  the sky is blue  ";
        String result = reverseWords(input);
        System.out.println(result);
        // Output: "blue is sky the"
    }
}
