package LeetcodeProblems;

public class GreatestCommonDivisorofStrings {
    public static void main(String[] args) {
        GreatestCommonDivisorofStrings gcd = new GreatestCommonDivisorofStrings();
        String s1 = "ABCABC";
        String s2 = "ABC";
        System.out.println("GCD of strings: " + gcd.gcdOfStrings(s1, s2));
        // Output: ABC

        s1 = "ABABAB";
        s2 = "ABAB";
        System.out.println("GCD of strings: " + gcd.gcdOfStrings(s1, s2));
        // Output: AB

        s1 = "LEET";
        s2 = "CODE";
        System.out.println("GCD of strings: " + gcd.gcdOfStrings(s1 , s2));
        // Output: (empty string)
    }

    public String gcdOfStrings(String s1, String s2) {
        if (s2.length() > s1.length()) {
            return gcdOfStrings(s2, s1);
        }
        if (s2.equals(s1)) {
            return s1;
        }
        if (s1.startsWith(s2)) {
            // recursive call
            return gcdOfStrings(s1.substring(s2.length()), s2);
//            Recursive call 2-times
        }
        return "";
    }
}
