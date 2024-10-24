package LeetcodeProblems;
import java.util.ArrayList;
import java.util.List;
    public class SubsetsM2 {
        public static void printSubsets(int i, int[] nums, ArrayList<Integer> ans) {
            if (i == nums.length) {
                arr.add(new ArrayList<>(ans));
                return;
            }

            // Exclude the current element
            printSubsets(i + 1, nums, ans);

            // Include the current element
            ans.add(nums[i]);
            printSubsets(i + 1, nums, ans);
            ans.remove(ans.size() - 1);
        }

        static List<List<Integer>> arr;

        public List<List<Integer>> subsets(int[] nums) {
            arr = new ArrayList<>();
            ArrayList<Integer> ans = new ArrayList<>();
            printSubsets(0, nums, ans);
            return arr;
        }

        public static void main(String[] args) {
            int[] nums = {1, 2, 3};
            SubsetsM2 subsetsM2 = new SubsetsM2();
            List<List<Integer>> allSubsets = subsetsM2.subsets(nums);
            System.out.println(allSubsets);
        }
    }
