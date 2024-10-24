package LeetcodeProblems;

//Two pointers approach
public class MinimumStringLength {
    public static void main(String[] args) {
        MinimumStringLength solution = new MinimumStringLength();
        String s1 = "ABFCACDB";
        String s2 = "ACBBD";

        System.out.println("Minimum length of \"" + s1 + "\": " + solution.minLength(s1)); // Output: 2
        System.out.println("Minimum length of \"" + s2 + "\": " + solution.minLength(s2)); // Output: 5
    }

    public int minLength(String s) {
        char str[] = s.toCharArray(); //N
        int n = str.length;
        int w = 0;
        for (int r = 0; r < n; r++) { //N
            if (w == 0) {
                str[w] = str[r];
                w++;
                continue;
            }
            if (str[r] == 'B' && str[w - 1] == 'A') {
                w--;
            } else if (str[r] == 'D' && str[w - 1] == 'C') {
                w--;
            } else {
                str[w] = str[r];
                w++;
            }
        }
        return w;
    }
}

