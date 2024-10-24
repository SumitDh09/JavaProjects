package LeetcodeProblems;

import java.util.ArrayList;
import java.util.List;

public class MinimumTimeDiffM2 {
    private int findMinDifference;

    public int findMinDifference() {
        // Your existing implementation remains unchanged
        // ...

        // For testing purposes, let's print the result here
        return findMinDifference; // This line seems incorrect; we need to return an actual value
    }

    private int convertToMinutes(String time) {
        // Your existing implementation remains unchanged
        // ...
        return 0;
    }

    public static void main(String[] args) {
        // Example usage
        List<String> timePoints = new ArrayList<>();
        timePoints.add("23:59");
        timePoints.add("00:00");
        timePoints.add("12:34");

        MinimumTimeDiffM2 solution = new MinimumTimeDiffM2();
        int result = solution.findMinDifference();
        System.out.println("Minimum time difference: " + result + " minutes");
    }
}
