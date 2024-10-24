package LeetcodeProblems;

import java.util.ArrayList;
import java.util.List;

public class LC448 {
    public static void main(String[] args) {
        LC448 solution = new LC448();
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> result = solution.findDisappearedNumbers(nums);
        System.out.println("LC448(Find the disappeared number) : " + result);
    }

    public void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        int i = 0;
        while (i < n) {
            int ele = nums[i];
            // ele should be at ele-1 index
            if (nums[i] == i + 1 || nums[i] == nums[ele - 1]) i++;
            else {
                swap(i, ele - 1, nums);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (i = 0; i < n; i++) {
            if (nums[i] != i + 1)
                ans.add(i + 1);
        }
        return ans;
    }

}

