package LeetcodeProblems;

class FindTheHighestAltitude {
    public static void main(String[] args) {
        FindTheHighestAltitude solution = new FindTheHighestAltitude();

        // Example test case
        int[] gain = {-5, 1, 5, 0, -7};
        System.out.println("Highest Altitude: " + solution.largestAltitude(gain)); // Output: 1

        // Additional test case
        int[] gain2 = {-4, -3, -2, -1, 4, 3, 2};
        System.out.println("Highest Altitude: " + solution.largestAltitude(gain2)); // Output: 0
    }

    public int largestAltitude(int[] gain) {
        int ans = 0;
        int currAltitude = 0;
        for (final int g : gain) {
            currAltitude += g;
            ans = Math.max(ans, currAltitude);
        }
        return ans;
    }
}
