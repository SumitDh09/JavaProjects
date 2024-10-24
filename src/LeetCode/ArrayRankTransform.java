package LeetcodeProblems;

import java.util.*;

class RankTransform {
    public int[] arrayRankTransform(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }

        // Create a copy of the original array
        int[] sortedArr = Arrays.copyOf(arr, arr.length);

        // Sort the copy
        Arrays.sort(sortedArr);

        // Use a HashMap to store the rank of each unique element
        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;

        // Assign ranks to unique elements
        for (int num : sortedArr) {
            rankMap.putIfAbsent(num, rank++);
        }

        // Replace each element in the original array with its rank
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = rankMap.get(arr[i]);
        }

        return result;
    }
}

class ArrayRankTransform {
    public static void main(String[] args) {
        RankTransform solution = new RankTransform();

        // Test case 1
        int[] arr1 = {40, 10, 20, 30};
        System.out.println("Input: " + Arrays.toString(arr1));
        System.out.println("Output: " + Arrays.toString(solution.arrayRankTransform(arr1)));

        // Test case 2
        int[] arr2 = {100, 100, 100};
        System.out.println("Input: " + Arrays.toString(arr2));
        System.out.println("Output: " + Arrays.toString(solution.arrayRankTransform(arr2)));

        // Test case 3
        int[] arr3 = {37, 12, 28, 9, 100, 56, 80, 5, 12};
        System.out.println("Input: " + Arrays.toString(arr3));
        System.out.println("Output: " + Arrays.toString(solution.arrayRankTransform(arr3)));

        // Test case 4: Empty array
        int[] arr4 = {};
        System.out.println("Input: " + Arrays.toString(arr4));
        System.out.println("Output: " + Arrays.toString(solution.arrayRankTransform(arr4)));

        // Test case 5: Null array
        System.out.println("Input: null");
        System.out.println("Output: " + Arrays.toString(solution.arrayRankTransform(null)));
    }
}

