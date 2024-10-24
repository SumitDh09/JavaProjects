package LeetcodeProblems;

public class DividePlayerusingFreqArray {
    public static void main(String[] args) {
        DividePlayerusingFreqArray solution = new DividePlayerusingFreqArray();
        int[] skill = {3, 2, 5, 1, 3, 4};
        long result = solution.dividePlayers(skill);
        System.out.println("Result: " + result);
    }

//    Leetcode 2491
    public long dividePlayers(int[] skill) {

        // input skill = [3,2,5,1,3,4]
        // output :- 22
        // Sum of all teams 3(x)
        // x=6 , no negative number
        // Frequency Array
        int n = skill.length;
        int teams = n / 2;
        int totalSum = 0;
        int freqMap[] = new int[1001];
        for (int element : skill) {
            freqMap[element]++;
            totalSum += element;
        }
        if (totalSum % teams != 0) {
            return -1;
        }
        int targetPoints = totalSum / teams;
        long res = 0;
        for (int element : skill) {
            if (freqMap[element] == 0) {
                continue;
            }
            freqMap[element]--;
            int partner = targetPoints - element;
            if (freqMap[partner] == 0) {
                return -1;
            }
            freqMap[partner]--;
            res = res + ((long) element * (long) partner);
        }
        return res;
    }
}
