package LeetcodeProblems;

import java.util.Arrays;
import java.util.Comparator;

class Some {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String elements[] = new String[n];
        for (int i = 0; i < n; i++) {
            elements[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(elements, new Comparator<String>() {
            public int compare(String a, String b) {
                String first = a + b;
                String sec = b + a;
                return sec.compareTo(first);
            }
        });
        if (elements[0].equals("0")) {
            return "0";
        }
        String res = "";
        for (String val : elements) {
            res += val;
        }
        return res;
    }

    public static void main(String[] args) {
        // Example usage
        int[] nums = {3, 30, 34, 5, 9};
        Some some = new Some();
        String largestNum = some.largestNumber(nums);
        System.out.println("The largest number is: " + largestNum);
    }
}
