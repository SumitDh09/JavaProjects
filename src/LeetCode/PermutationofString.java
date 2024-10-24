package LeetcodeProblems;

//two map comparison
class PermutationofString {
    public static void main(String[] args) {
        PermutationofString solution = new PermutationofString();
        String s1 = "ab";
        String s2 = "eidbaooo";
        boolean result = solution.checkInclusion(s1, s2);
        System.out.println("Does s2 contain a permutation of s1? " + result);
    }

    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if (m < n) return false;
        int map1[] = new int[26];   //0

        for (int i = 0; i < n; i++) {
            map1[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i <= m - n; i++) {
            int map2[] = new int[26];
            for (int j = 0; j < n; j++) {
                map2[s2.charAt(i + j) - 'a']++;
            }
            if (isMatched(map1, map2)) {
                return true;
            }
        }
        return false;
    }

    private boolean isMatched(int map1[], int map2[]) {
        for (int i = 0; i < 26; i++) {
            if (map1[i] != map2[i]) return false;
        }
        return true;
    }
}
