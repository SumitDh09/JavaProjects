package LeetcodeProblems;

public class KthLargestElement {
    static int ans;

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int partition(int[] arr, int lo, int hi) {
        int pivot = arr[lo];
        int pivotidx = lo;
        int smallercount = 0;
        for (int i = lo + 1; i <= hi; i++) {
            if (arr[i] <= pivot)
                smallercount++;
        }
        int correctidx = pivotidx + smallercount;
        swap(arr, pivotidx, correctidx);
        int i = lo;
        int j = hi;
        while (i < correctidx && j > correctidx) {
            while (i < correctidx && arr[i] <= pivot) i++;
            while (j > correctidx && arr[j] > pivot) j--;
            if (i < correctidx && j > correctidx) {
                swap(arr, i, j);
            }
        }
        return correctidx;
    }

    public void quickSelect(int[] arr, int lo, int hi, int k) {
        if (lo >= hi) {
            if (lo == k - 1) ans = arr[lo];
            return;
        }
        int idx = partition(arr, lo, hi);
        if (k - 1 == idx) {
            ans = arr[idx];
            return;
        }
        if (k - 1 < idx) quickSelect(arr, lo, idx - 1, k);
        else quickSelect(arr, idx + 1, hi, k);
    }

    public int findKthLargest(int[] nums, int k) {
        ans = -1;
        int n = nums.length;
        quickSelect(nums, 0, n - 1, n - k + 1);
        return ans;
    }


    // ... (rest of the class remains the same)

    public static void main(String[] args) {
        KthLargestElement solution = new KthLargestElement();
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int result = solution.findKthLargest(nums, k);
        System.out.println("The " + k + "th largest element is: " + result);
    }

}

