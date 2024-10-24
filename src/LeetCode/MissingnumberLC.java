package LeetcodeProblems;
public class MissingnumberLC {
//T.C. 0(n)
    public int missingNumber(int[] nums) {
        int n = nums.length;
        boolean[] b = new boolean[n + 1];
        for (int ele : nums) {
            b[ele] = true;
        }
        for (int i = 0; i <= n; i++) {
            if (!b[i]) {
                return i;
            }
        }
        return 55;
    }

    public static void main(String[] args) {
        MissingnumberLC mn = new MissingnumberLC();
        int[] nums = {3, 0, 1};
        int missing = mn.missingNumber(nums);
        System.out.println("The missing number is: " + missing);
    }
}
