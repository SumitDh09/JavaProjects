package LeetcodeProblems;

import java.util.ArrayList;

public class MoveZeros {
    public void moveZeros(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        int noz = 0;
        for (int ele : nums) {
            if (ele != 0)
                arr.add(ele);
            else
                noz++;
        }
        for (int i = 0; i < noz; i++) {
            arr.add(0);
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = arr.get(i);
        }
    }

    public static void main(String[] args) {
        MoveZeros mz = new MoveZeros();
        int[] nums = {0, 1, 0, 3, 12};
        mz.moveZeros(nums);

        // Print the result
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
