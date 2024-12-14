package Stack;

import java.util.Stack;

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        if (k >= num.length()) return "0";
        Stack<Character> stack = new Stack<>();
        for (char digit : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > digit) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }

        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        StringBuilder result = new StringBuilder();
        for (char digit : stack) {
            result.append(digit);
        }

        while (result.length() > 0 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }

        return result.length() == 0 ? "0" : result.toString();

    }

    public static void main(String[] args) {
        RemoveKDigits rk = new RemoveKDigits();
//        System.out.println(rk.removeKdigits("1432219", 3));
        System.out.println(rk.removeKdigits("100200", 1));
        System.out.println(rk.removeKdigits("12345", 2));
        System.out.println(rk.removeKdigits("10", 2));

    }
}
