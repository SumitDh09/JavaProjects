package LeetcodeProblems;

public class MOVEZEROSm2 {

    public void moveZeroes(int[] nums) {
        int lastNonZeroFoundAt = 0; // Pointer for the position of the last non-zero element
    
            // Iterate through the array
        for (int current = 0; current < nums.length; current++) {
            if (nums[current] != 0) {
                   // Swap current element with the element at lastNonZeroFoundAt
                int temp = nums[lastNonZeroFoundAt];
                nums[lastNonZeroFoundAt] = nums[current];
                nums[current] = temp;
                    
                // Move the lastNonZeroFoundAt pointer to the next position
                lastNonZeroFoundAt++;
                }
            }
        }
    
        public static void main(String[] args) {
            MOVEZEROSm2 mz = new MOVEZEROSm2 ();
            int[] nums = {0, 1, 0, 3, 12};
            mz.moveZeroes(nums);
    
            // Print the result
            for (int num : nums) {
                System.out.print(num + " ");
            }
        }
    }
    