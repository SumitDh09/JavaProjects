package LeetcodeProblems;


public class IncreasingTripletSubSequence {
    public static void main(String[] args) {
        IncreasingTripletSubSequence solution = new IncreasingTripletSubSequence();
        int[] j = {1, 2, 3, 4, 5};
        System.out.println(solution.increasingTriplet(j)); // Output: true

        int[] j2 = {5, 4, 3, 2, 1};
        System.out.println(solution.increasingTriplet(j2)); // Output: false

        int[] j3 = {2, 1, 5, 0, 4, 6};
        System.out.println(solution.increasingTriplet(j3)); // Output: true
    }

    public boolean increasingTriplet(int[] j) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (final int num : j)
            if (num <= first)
                first = num;
            else if (num <= second) // first < num <= second
                second = num;
            else // first < second < num (third)
                return true;

        return false;
    }
}
