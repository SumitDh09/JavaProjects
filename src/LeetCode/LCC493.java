package LeetcodeProblems;

import java.util.Arrays;

public class LCC493 {
    public int mergeSort(int[] A, int left, int mid, int right) {
        int count = 0;
        int i = left, j = mid + 1, k = 0;
        int[] C = new int[right - left + 1];

        // Count pairs
        while (i <= mid && j <= right) {
            if ((long) A[i] > 2 * (long) A[j]) {
                count += (mid - i + 1);
                j++;
            } else {
                i++;
            }
        }

        // Reset pointers
        i = left;
        j = mid + 1;

        // Merge the two halves
        while (i <= mid && j <= right) {
            if (A[i] <= A[j]) {
                C[k++] = A[i++];
            } else {
                C[k++] = A[j++];
            }
        }

        // Copy remaining elements of left half
        while (i <= mid) {
            C[k++] = A[i++];
        }

        // Copy remaining elements of right half
        while (j <= right) {
            C[k++] = A[j++];
        }

        // Copy back the merged elements to original array
        for (int z = 0; z < C.length; z++) {
            A[left + z] = C[z];
        }

        return count;
    }

    public static void main(String[] args) {
        // Example usage
        int[] A = {1, 3, 2, 3, 1};
        LCC493 obj = new LCC493();
        int count = obj.mergeSort(A, 0, (A.length - 1) / 2, A.length - 1);
        System.out.println("Count of important reverse pairs: " + count);
        System.out.println("Sorted array: " + Arrays.toString(A));
    }
}
