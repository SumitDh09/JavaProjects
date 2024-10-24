package LeetcodeProblems;

public class heightOrder {
    public static int countMismatches(int[] heights, int[] expected) {
        int mismatchCount = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]) {
                mismatchCount++;
            }
        }
        return mismatchCount;
    }

    public static void main(String[] args) {
        int[] heights = {175, 160, 180, 165, 170};
        int[] expected = {160, 165, 170, 175, 180};
        int result = countMismatches(heights, expected);
        System.out.println("Number of indices with mismatch: " + result);
    }
}

