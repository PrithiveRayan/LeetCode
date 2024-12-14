package String;

import java.util.HashMap;

public class FractionToRecurringDecimal {
//    public String fractionToDecimal(int numerator, int denominator) {
//        String result = "";
//        double value = (double) numerator/denominator;
//        String converted = String.valueOf(value);
//        if(converted.contains(".")){
//            String[] splited = converted.split("\\.");
//            if(splited[1].equals("0")){
//                return splited[0];
//            }
//            result = splited[0]+"."+formatRepeatingString(splited[1]);
//            return result;
//        }
//        else{
//            return converted;
//        }
//    }
//
//    public static String formatRepeatingString(String str) {
//        int n = str.length();
//
//        // Special case: Handle the case where there's no repetition
//        if (n == 0) {
//            return str;
//        }
//
//        // Try to find the smallest repeating unit
//        for (int len = 1; len <= n / 2; len++) {
//            if (n % len == 0) {
//                String pattern = str.substring(0, len);
//                StringBuilder repeatedString = new StringBuilder();
//
//                // Construct the string by repeating the pattern
//                for (int i = 0; i < n / len; i++) {
//                    repeatedString.append(pattern);
//                }
//
//                // Check if repeating the pattern covers the entire string
//                if (repeatedString.toString().equals(str)) {
//                    // Return the result with the repeating part in parentheses
//                    return str.substring(0, 1) + "(" + pattern + ")";
//                }
//            }
//        }
//
//        // If no repeating pattern is found, return the string as-is
//        return str;
//    }

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }

        StringBuilder result = new StringBuilder();

        // Handle the sign of the result
        if ((numerator < 0) ^ (denominator < 0)) {
            result.append("-");
        }

        // Work with absolute values
        long num = Math.abs((long) numerator);
        long denom = Math.abs((long) denominator);

        // Get the integer part of the result
        result.append(num / denom);

        // Get the remainder
        long remainder = num % denom;

        // If there is no remainder, return the result
        if (remainder == 0) {
            return result.toString();
        }

        // Otherwise, we have a fractional part
        result.append(".");

        // Map to store remainder positions
        HashMap<Long, Integer> remainderMap = new HashMap<>();

        // Loop to process the decimal part
        while (remainder != 0) {
            // If we've seen this remainder before, a repeat is found
            if (remainderMap.containsKey(remainder)) {
                int repeatIndex = remainderMap.get(remainder);
                result.insert(repeatIndex, "("); // Insert '(' before the repeating part
                result.append(")"); // Insert ')' after the repeating part
                return result.toString();
            }

            // Store the current remainder and its position
            remainderMap.put(remainder, result.length());

            // Multiply remainder by 10 and get the next digit
            remainder *= 10;
            result.append(remainder / denom);

            // Update the remainder
            remainder %= denom;
        }

        return result.toString();
    }

    public static void main(String[] args) {

        FractionToRecurringDecimal fd = new FractionToRecurringDecimal();
//        System.out.println(fd.fractionToDecimal(1,2));
//        System.out.println(fd.fractionToDecimal(2,1));
//        System.out.println(fd.fractionToDecimal(4,333));
        System.out.println(fd.fractionToDecimal(1,6));

    }
}
