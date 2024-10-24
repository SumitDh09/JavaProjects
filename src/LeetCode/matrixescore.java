package LeetcodeProblems;

public class matrixescore {
    
    public int matrixScore(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        
        // Step 1: Ensure all rows have their first element as 1
        for (int i = 0; i < m; i++) {
            if (arr[i][0] == 0) {
                // Flip the row
                for (int j = 0; j < n; j++) {
                    arr[i][j] = 1 - arr[i][j];
                }
            }
        }
        
        // Step 2: Ensure each column has more 1s than 0s
        for (int j = 1; j < n; j++) {
            int noOfZeroes = 0;
            int noOfOnes = 0;
            for (int i = 0; i < m; i++) {
                if (arr[i][j] == 0) {
                    noOfZeroes++;
                } else {
                    noOfOnes++;
                }
            }
            
            if (noOfZeroes > noOfOnes) {
                // Flip the column
                for (int i = 0; i < m; i++) {
                    arr[i][j] = 1 - arr[i][j];
                }
            }
        }
        
        // Step 3: Calculate the score
        int score = 0;
        int x = 1;
        for (int j = n - 1; j >= 0; j--) {
            for (int i = 0; i < m; i++) {
                score += (arr[i][j] * x);
            }
            x *= 2;
        }
        
        return score;
    }

    public static void main(String[] args) {
        // Example usage
        int[][] matrix = {
            {0, 0, 1, 1},
            {1, 0, 1, 0},
            {0, 1, 1, 0}
        };
        
        matrixescore solution = new matrixescore();
        int result = solution.matrixScore(matrix);
        System.out.println("Score: " + result);
    }
}
