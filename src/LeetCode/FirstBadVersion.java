 package LeetcodeProblems;

// Simulating the VersionControl class

 //LeetCode 278
class VersionControl {
    private int badVersion;

    public VersionControl(int badVersion) {
        this.badVersion = badVersion;
    }

    boolean isBadVersion(int version) {
        return version >= badVersion;
    }
}

public class FirstBadVersion extends VersionControl {
    public FirstBadVersion(int badVersion) {
        super(badVersion);
    }

    public static void main(String[] args) {
        // TestCase 1
        int n1 = 5;
        int bad1 = 4;
        FirstBadVersion solution1 = new FirstBadVersion(bad1);
        int result1 = solution1.firstBadVersion(n1);
        System.out.println("Test case 1:");
        System.out.println("n = " + n1 + ", bad version = " + bad1);
        System.out.println("First bad version: " + result1);

        // TestCase 2
        int n2 = 1;
        int bad2 = 1;
        FirstBadVersion solution2 = new FirstBadVersion(bad2);
        int result2 = solution2.firstBadVersion(n2);
        System.out.println("\nTest case 2:");
        System.out.println("n = " + n2 + ", bad version = " + bad2);
        System.out.println("First bad version: " + result2);

        // TestCase 3
        int n3 = 10;
        int bad3 = 7;
        FirstBadVersion solution3 = new FirstBadVersion(bad3);
        int result3 = solution3.firstBadVersion(n3);
        System.out.println("\nTest case 3:");
        System.out.println("n = " + n3 + ", bad version = " + bad3);
        System.out.println("First bad version: " + result3);
    }

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}