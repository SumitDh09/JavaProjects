package LeetcodeProblems;

public class SeparateBlackAndWhitBalls {
    public static void main(String[] args) {
        SeparateBlackAndWhitBalls obj = new SeparateBlackAndWhitBalls();
        String s = "110100110"; // Example input
        long result = obj.minimumSteps(s);
        System.out.println("Minimum steps to separate black and white balls: " + result);
    }

    public long minimumSteps(String s) {
        int n = s.length();
        int last = 0;
        long swapCount = 0;
        for (int cur = 0; cur < n; cur++) {
            if (s.charAt(cur) == '0') {
                swapCount += (cur - last); // imagine swapping
                last++;
            }
        }
        return swapCount;
    }
}
