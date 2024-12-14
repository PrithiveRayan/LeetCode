package Stack;

import java.util.Stack;

public class ValidParanthesisString {

//    public boolean checkValidString(String s) {
////        if(s.length() == 1){
////            return false;
////        }
//        Stack<Character> stack = new Stack<>();
//        for(int i=0; i<s.length(); i++){
//            if (s.charAt(i) != ')') {
//                stack.push(s.charAt(i));
//            }
//            else{
//                if(stack.isEmpty()){
//                    return false;
//                }
//                char temp = stack.pop();
//                if(temp != '*' && temp != '('){
//                    return false;
//                }
//            }
//        }
//        if(!stack.isEmpty()){
//            char temp = stack.pop();
//            if(temp != '*'){
//                return false;
//            }
//        }
//        return true;
//    }

    public boolean checkValidString(String s) {
        int low = 0, high = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                low++;
                high++;
            } else if (c == ')') {
                low = Math.max(0, low - 1);
                high--;
            } else if (c == '*') {
                low = Math.max(0, low - 1); // Treat '*' as ')'
                high++; // Treat '*' as '('
            }

            if (high < 0) {
                // More ')' than '(' at any point
                return false;
            }
        }

        // Ensure all open parentheses are closed
        return low == 0;
    }

    public static void main(String[] args) {
        ValidParanthesisString vp = new ValidParanthesisString();
//        System.out.println(vp.checkValidString("("));
//        System.out.println(vp.checkValidString("(((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((("));
        System.out.println(vp.checkValidString("(((*)))"));
        System.out.println(vp.checkValidString("()"));
        System.out.println(vp.checkValidString("(*)"));
        System.out.println(vp.checkValidString("(*))"));

    }
}
