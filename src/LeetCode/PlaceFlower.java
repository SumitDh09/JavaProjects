package LeetcodeProblems;

class PlaceFlower {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int size = flowerbed.length;

        for (int i = 0; i < size; i++) {
            if (flowerbed[i] == 0) {
                boolean emptyLeft = (i == 0) || (flowerbed[i - 1] == 0);
                boolean emptyRight = (i == size - 1) || (flowerbed[i + 1] == 0);

                if (emptyLeft && emptyRight) {
                    flowerbed[i] = 1;
                    count++;
                    if (count >= n) {
                        return true;
                    }
                }
            }
        }

        return count >= n;
    }

    public static void main(String[] args) {
        // Test cases
        int[] flowerbed1 = {1, 0, 0, 0, 1};
        int n1 = 1;
        System.out.println("Test case 1: " + canPlaceFlowers(flowerbed1, n1)); // Should return true

        int[] flowerbed2 = {1, 0, 0, 0, 1};
        int n2 = 2;
        System.out.println("Test case 2: " + canPlaceFlowers(flowerbed2, n2)); // Should return false

        int[] flowerbed3 = {1, 0, 0, 0, 0, 1};
        int n3 = 2;
        System.out.println("Test case 3: " + canPlaceFlowers(flowerbed3, n3)); // Should return false

        int[] flowerbed4 = {0, 0, 1, 0, 1};
        int n4 = 1;
        System.out.println("Test case 4: " + canPlaceFlowers(flowerbed4, n4)); // Should return true

        int[] flowerbed5 = {0, 0, 0, 0, 0};
        int n5 = 3;
        System.out.println("Test case 5: " + canPlaceFlowers(flowerbed5, n5)); // Should return true
    }
}


