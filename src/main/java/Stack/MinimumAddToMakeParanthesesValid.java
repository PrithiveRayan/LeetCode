package Stack;

import java.util.Stack;

public class MinimumAddToMakeParanthesesValid {

//    public int minAddToMakeValid(String s) {
//        int moves = 0;
//        Stack<Character> stack = new Stack<>();
//        for(int i=0 ;i<s.length(); i++){
//            if(s.charAt(i) == ')' && !stack.isEmpty()){
//                stack.pop();
//            }
//            else if(s.charAt(i) == ')'){
//                moves++;
//            }
//            else{
//                stack.push(s.charAt(i));
//            }
//        }
//
//        if(!stack.isEmpty()){
//            moves += stack.size();
//        }
//        return moves;
//    }

    public int minAddToMakeValid(String s) {
        int moves = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    moves++;
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        moves += stack.size();
        return moves;
    }

    public static void main(String[] args) {
        MinimumAddToMakeParanthesesValid ma = new MinimumAddToMakeParanthesesValid();
        System.out.println(ma.minAddToMakeValid("))"));
        System.out.println(ma.minAddToMakeValid("())"));
        System.out.println(ma.minAddToMakeValid("((("));
    }
}
