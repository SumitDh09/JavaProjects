package LeetcodeProblems;

public class PivotIndex {

//Leetcode 724
/*Given an array of integers nums, calculate the pivot index of this array.
The pivot index is the index where the sum of all the numbers strictly to
the left of the index is equal to the sum of all the numbers strictly to the index's right.
If the index is on the left edge of the array, then the left sum is 0 because
there are no elements to the left. This also applies to the right edge of the array.
Return the leftmost pivot index. If no such index exists, return -1.*/

    public static void main(String[] args) {
        PivotIndex pi = new PivotIndex();
        int[] nums = {1, 7, 3, 6, 5, 6};
        int result = pi.pivotIndex(nums);
        System.out.println("The pivot index is: " + result);
    }

    public int pivotIndex(int[] arr) {
        int[] pre = new int[arr.length];
        int sum = arr[0];
        pre[0] = 0;

        for (int i = 1; i < arr.length; i++) {
            sum += arr[i];
            pre[i] = pre[i - 1] + arr[i - 1];
        }
        for (int i = 0; i < arr.length; i++) {
            if (pre[i] == sum - arr[i] - pre[i]) {
                return i;
            }
        }
        return -1;
    }
}
