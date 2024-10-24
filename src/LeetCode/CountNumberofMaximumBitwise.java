package LeetcodeProblems;

class CountNumberofMaximumBitwise {
//    Leetcode - 2044
//    Given an integer array nums, find the maximum possible bitwise OR of a subset of
//    nums and return the number of different non-empty subsets with the maximum bitwise OR.
//    An array an is a subset of an array b if a can be obtained from b by deleting some (possibly zero) elements of b.
//    Two subsets are considered different if the indices of the elements chosen are different.
//    The bitwise OR of an array an is equal to a[0] OR a[1] OR ... OR a[a.length - 1] (0-indexed).


    public static void main(String[] args) {
        CountNumberofMaximumBitwise solution = new CountNumberofMaximumBitwise();
        int[] nums = {3, 1, 2};
        System.out.println("Number of maximum bitwise OR subsets: " + solution.countMaxOrSubsets(nums));
    }

    public int countMaxOrSubsets(int[] nums) {
        // target OR
        int targetOr = 0;
        for (int num : nums) {
            targetOr |= num;
        }
        // state: index, targetOr = 7
        Integer dp[][] = new Integer[nums.length][targetOr + 1];
        return recur(0, nums, 0, targetOr, dp);
    }

    // tc: n * targetOr
    // sc: n * targetOr
    public int recur(int index, int nums[], int curOr, int targetOr, Integer dp[][]) {
        // base case
        if (index == nums.length) {
            return (curOr == targetOr) ? 1 : 0;
        }
        // check if already solved
        if (dp[index][curOr] != null) {
            return dp[index][curOr];
        }
        // O(2^n)
        // pick
        int pickCount = recur(index + 1, nums, curOr | nums[index], targetOr, dp);
        // no pick
        int noPickCount = recur(index + 1, nums, curOr, targetOr, dp);
        return dp[index][curOr] = pickCount + noPickCount;
    }
}
