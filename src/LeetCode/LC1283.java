package LeetcodeProblems;

class SmallestDivisor {

    public boolean isLess(int d, int[] arr, int t) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % d == 0) sum += arr[i] / d;
            else sum += arr[i] / d + 1;
        }
        return sum <= t;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int mx = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            mx = Math.max(mx, nums[i]);
        }
        int lo = 1, hi = mx;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (isLess(mid, nums, threshold)) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        SmallestDivisor sd = new SmallestDivisor();
        int[] nums = {1, 2, 5, 9};
        int threshold = 6;
        System.out.println("Smallest Divisor: " + sd.smallestDivisor(nums, threshold));
    }
}
