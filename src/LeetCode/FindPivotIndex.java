package LeetcodeProblems;

public class FindPivotIndex {
    public static void main(String[] args) {
        FindPivotIndex pi = new FindPivotIndex();
        int[] nums = {1, 7, 3, 6, 5, 6};
        int result = pi.pivotIndex(nums);
        System.out.println("Pivot index: " + result);
    }
//Leetcode 724(Method-2)
/*Given an array of integers nums, calculate the pivot index of this array.
The pivot index is the index where the sum of all the numbers strictly to
the left of the index is equal to the sum of all the numbers strictly to the index's right.
If the index is on the left edge of the array, then the left sum is 0 because
there are no elements to the left. This also applies to the right edge of the array.
Return the leftmost pivot index. If no such index exists, return -1.*/

    public int pivotIndex(int[] a) {
        // Calculate the total sum of the array
        int totalSum = 0;
        for (int num : a) {
            totalSum += num;
        }

        // Initialize left sum
        int leftSum = 0;

        // Iterate through the array
        for (int i = 0; i < a.length; i++) {
            // Check if left sum equals right sum
            if (leftSum == totalSum - leftSum - a[i]) {
                return i; // Found pivot index
            }

            // Update left sum for next iteration
            leftSum += a[i];
        }

        // No pivot index found
        return -1;
    }
}

