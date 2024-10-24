package LeetcodeProblems;

public class ProductExceptSelf {
    public static void main(String[] args) {
        ProductExceptSelf solution = new ProductExceptSelf();
        int[] arc = {1, 2, 3, 4};
        int[] result = solution.productExceptSelf(arc);

        System.out.println(" Product of array except self :- ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    public int[] productExceptSelf(int[] arc) {
        int n = arc.length;
        int[] answer = new int[n];
        //nums.length --> arc.length
        // First pass: compute prefix products
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i-1] * arc[i-1];
        }

        // Second pass: compute suffix products and final result
        int suffixProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= suffixProduct;
            suffixProduct *= arc[i];
        }

        return answer;
    }
}

