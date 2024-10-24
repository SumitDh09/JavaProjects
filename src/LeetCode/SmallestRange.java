package LeetcodeProblems;

import java.util.*;

class SmallestRange {
    // Main method for testing
    public static void main(String[] args) {
        SmallestRange solution = new SmallestRange();

        List<List<Integer>> nums = Arrays.asList(
                Arrays.asList(4, 10, 15, 24, 26),
                Arrays.asList(0, 9, 12, 20),
                Arrays.asList(5, 18, 22, 30)
        );

        int[] result = solution.smallestRange(nums);
        System.out.println("Smallest Range: [" + result[0] + ", " + result[1] + "]");
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Element> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        int max = Integer.MIN_VALUE;
        int rangeStart = 0, rangeEnd = Integer.MAX_VALUE;
        int rangeSize = rangeEnd - rangeStart;

        // Initialize the heap with the first element from each list
        for (int i = 0; i < nums.size(); i++) {
            if (!nums.get(i).isEmpty()) {
                int val = nums.get(i).get(0);
                pq.offer(new Element(val, i, 0));
                max = Math.max(max, val);
            }
        }

        // Process elements until one of the lists is exhausted
        while (pq.size() == nums.size()) {
            Element curr = pq.poll();
            int currRangeSize = max - curr.val;

            if (currRangeSize < rangeSize) {
                rangeStart = curr.val;
                rangeEnd = max;
                rangeSize = currRangeSize;
            }

            // Move to the next element in the list
            if (curr.index + 1 < nums.get(curr.list).size()) {
                int nextVal = nums.get(curr.list).get(curr.index + 1);
                pq.offer(new Element(nextVal, curr.list, curr.index + 1));
                max = Math.max(max, nextVal);
            }
        }

        return new int[]{rangeStart, rangeEnd};
    }

    // Helper class to store element information
    private static class Element {
        int val;
        int list;
        int index;

        Element(int val, int list, int index) {
            this.val = val;
            this.list = list;
            this.index = index;
        }
    }
}
