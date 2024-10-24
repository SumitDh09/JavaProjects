package LeetcodeProblems;

public class LC443 {
    public static void main(String[] args) {
        // Example usage:
        char[] inputArray = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        LC443 compressor = new LC443();
        int compressedLength = compressor.compress(inputArray);

        System.out.print("Compressed array: ");
        for (int i = 0; i < compressedLength; i++) {
            System.out.print(inputArray[i]);
        }
        System.out.println();
        System.out.println("Length of compressed array: " + compressedLength);
    }

    public int compress(char[] arr) {
        StringBuilder ans = new StringBuilder("");
        int i = 0;
        int j = 0;
        while (j < arr.length) {
            if (arr[j] == arr[i])
                j++;
            else {
                ans.append(arr[i]);
                int len = j - i;
                if (len > 1)
                    ans.append(len);
                i = j;
            }
        }
        ans.append(arr[i]);
        int len = j - i;
        if (len > 1)
            ans.append(len);
        for (i = 0; i < ans.length(); i++) {
            arr[i] = ans.charAt(i);
        }
        return ans.length();
    }
}
