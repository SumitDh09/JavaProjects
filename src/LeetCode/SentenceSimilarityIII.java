package LeetcodeProblems;

class SentenceSimilarityIII {
    public static void main(String[] args) {
        SentenceSimilarityIII solution = new SentenceSimilarityIII();

        // Test cases
        String[][] testCases = {
                {"My name is Haley", "My Haley"},
                {"of", "A lot of people"},
                {"Eating right now", "Eating"},
                {"Luky", "Lucccky"},
                {"Hello World", "Hello World"},
                {"A B C D", "A X B Y C Z D"},
                {"A B", "A C B"},
                {"A", "A"},
                {"A", "B"}
        };

        for (String[] testCase : testCases) {
            boolean result = solution.areSentencesSimilar(testCase[0], testCase[1]);
            System.out.println("Sentence 1: \"" + testCase[0] + "\"");
            System.out.println("Sentence 2: \"" + testCase[1] + "\"");
            System.out.println("Are they similar? " + result);
            System.out.println();
        }
    }

    //tc N+M + Min(n,m)
    //sc n+m
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if(sentence1.length() > sentence2.length()){
            return areSentencesSimilar(sentence2, sentence1);
        }
        String smallerWords[] = sentence1.split(" ");
        String largerWords[] = sentence2.split(" ");
        int start = 0;
        int end1 = smallerWords.length - 1;
        int end2 = largerWords.length - 1;
        //find prefix words
        while(start <= end1 && smallerWords[start].equals(largerWords[start])){
            start++;
        }
        //find suffix words
        while(start <= end1 && smallerWords[end1].equals(largerWords[end2])){
            end1--;
            end2--;
        }
        return (start > end1);
    }
}