package Arrays;

import java.math.BigDecimal;
import java.math.BigInteger;

public class MultiplyString {
//    public String multiply(String num1, String num2) {
//        BigInteger number1 = new BigInteger(num1);
//        BigInteger number2 = new BigInteger(num2);
//        BigInteger result = number1.multiply(number2);
////        return result.toString();
//        return (new BigInteger(num1).multiply(new BigInteger(num2))).toString();
//
//    }

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int m = num1.length(), n = num2.length();
        int[] result = new int[m + n];

        // Multiply each digit of num1 and num2
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = product + result[i + j + 1];

                result[i + j + 1] = sum % 10; // Place the remainder in the current position
                result[i + j] += sum / 10;   // Add the carry to the next position
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            if (!(sb.length() == 0 && num == 0)) { // Skip leading zeros
                sb.append(num);
            }
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        MultiplyString ms = new MultiplyString();
        System.out.println(ms.multiply("2","3"));
        System.out.println(ms.multiply("123","456"));
        System.out.println(ms.multiply("498828660196","840477629533"));
    }
}
