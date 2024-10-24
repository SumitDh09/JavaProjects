package LeetcodeProblems;

import java.util.*;

public class KidsWithCandies {
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        // Find the maximum number of candies any kid currently has

        int maxCandies = Arrays.stream(candies).max().orElse(0);

        // Create a list to store the result

        List<Boolean> result = new ArrayList<>();

        // Check for each kid if they can have the greatest number of candies

        for (int candy : candies) {
            result.add(candy + extraCandies >= maxCandies);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] candies = {2, 3, 5, 1, 3};
        int extraCandies = 3;
        List<Boolean> result = kidsWithCandies(candies, extraCandies);
        System.out.println(result);

        // Output: [true, true, true, false, true]
    }
}
