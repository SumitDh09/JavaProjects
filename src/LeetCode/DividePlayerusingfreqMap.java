package LeetcodeProblems;
import java.util.HashMap;

class DividePlayersusingFreqMap {

//    leetcode 2491

    public static void main(String[] args) {
        DividePlayersusingFreqMap solution = new DividePlayersusingFreqMap();
        int[] skill = {3, 2, 5, 1, 3, 4};
        long result = solution.dividePlayers(skill);
        System.out.println("Result: " + result);
    }

    public long dividePlayers(int[] skill) {
        int n = skill.length;
        int teams = n / 2;
        int totalSum = 0;
        // input skill = [3,2,5,1,3,4]
        // output :- 22
        // Sum of all teams 3(x)
        // x=6 , no negative number
        // Frequency Map
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int element : skill) {
            freqMap.put(element, freqMap.getOrDefault(element, 0) + 1);
            totalSum += element;
        }
        if (totalSum % teams != 0) {
            return -1;
        }
        int targetPoints = totalSum / teams;
        long res = 0;
        for (int element : skill) {
            if (freqMap.get(element) == 0) {
                continue;
            }
            freqMap.put(element, freqMap.get(element) - 1);
            int partner = targetPoints - element;
            if (!freqMap.containsKey(partner) || freqMap.get(partner) == 0) {
                return -1;
            }
            freqMap.put(partner, freqMap.get(partner) - 1);
            res = res + ((long) element * (long) partner);
        }
        return res;
    }
}


