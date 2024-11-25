package Arrays;

import java.util.Stack;

public class ReversePolishNotation {
//    public int evalRPN(String[] tokens) {
//        int sum = 0;
//        boolean started = false;
//        Stack<Integer> stack = new Stack<>();
//        for(String token : tokens){
//            if(Character.isDigit(token.charAt(0))){
//                stack.push(token.charAt(0) - '0');
//            }
//            else if(token.charAt(0) == '+'){
//                if(started){
//                    sum = stack.pop() + sum;
//                }
//                else{
//                    started =true;
//                    int first = stack.pop();
//                    int second = stack.pop();
//                    sum = second + first;
//                }
//            }
//            else if(token.charAt(0) == '-'){
//                if(started){
//                    sum = stack.pop() - sum;
//                }
//                else{
//                    started = true;
//                    int first = stack.pop();
//                    int second = stack.pop();
//                    sum = second - first;
//                }
//
//            }
//            else if(token.charAt(0) == '/'){
//                if(started){
//                    sum = stack.pop() + sum;
//                }
//                else{
//                    started = true;
//                    int first = stack.pop();
//                    int second = stack.pop();
//                    sum = second + first;
//                }
//
//            }
//            else{
//                if(started){
//                    sum = stack.pop() * sum;
//                }
//                else{
//                    started = true;
//                    int first = stack.pop();
//                    int second = stack.pop();
//                    sum = second * first;
//                }
//
//            }
//        }
//        return sum;
//    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (isOperator(token)) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                int result = applyOperation(num1, num2, token);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private int applyOperation(int num1, int num2, String operator) {
        switch (operator) {
            case "+": return num1 + num2;
            case "-": return num1 - num2;
            case "*": return num1 * num2;
            case "/": return num1 / num2; // Integer division truncates toward zero
            default: throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    public static void main(String[] args) {
        ReversePolishNotation rn = new ReversePolishNotation();
        System.out.println(rn.evalRPN(new String[]{"2","1","+","3","*"}));
        System.out.println(rn.evalRPN(new String[]{"4","13","5","/","+"}));
        System.out.println(rn.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
}
