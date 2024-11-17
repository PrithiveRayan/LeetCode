package Arrays;

import java.util.Arrays;
import java.util.Stack;

public class NumberPlusOne {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // Iterate from the last digit backwards
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits; // Return as no further carry needed
            }
            // Set the current digit to 0 and continue to handle carry
            digits[i] = 0;
        }

        // If the loop completes, all digits were 9; need an extra digit
        int[] result = new int[n + 1];
        result[0] = 1; // The most significant digit
        return result;
    }

    public static void main(String[] args) {
        NumberPlusOne npo = new NumberPlusOne();
        System.out.println(Arrays.toString(npo.plusOne(new int[]{9,5,9})));
    }


}
