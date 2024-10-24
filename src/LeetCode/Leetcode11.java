package LeetcodeProblems;

public class Leetcode11 {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int width = right - left;
            int currentHeight = Math.min(height[left], height[right]);
            int currentArea = width * currentHeight;
            maxArea = Math.max(maxArea, currentArea);

            // Move the pointer pointing to the shorter line
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        Leetcode11 solution = new Leetcode11();
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int result = solution.maxArea(heights);
        System.out.println("The maximum amount of water the container can store is: " + result);
    }
}
