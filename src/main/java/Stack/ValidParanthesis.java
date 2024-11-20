package Stack;

import java.util.Stack;

public class ValidParanthesis {

    public boolean isValid(String s) {

        if(s.length() < 2){
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{'){
                stack.push(s.charAt(i));
                continue;
            }
            if(stack.isEmpty()){
                return false;
            }
            char temp = stack.pop();
            if((temp != '(' && c == ')') || (temp != '[' && c == ']') || (temp != '{' && c == '}')){
                return false;
            }
        }
        if(!stack.isEmpty()){
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        ValidParanthesis vp = new ValidParanthesis();
//        System.out.println(vp.isValid("()[]{}"));
        System.out.println(vp.isValid("["));
        System.out.println(vp.isValid("([])"));
    }
}
