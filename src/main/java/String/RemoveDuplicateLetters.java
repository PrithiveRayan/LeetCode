package String;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {
//        if(s.length() < 2){
//            return s;
//        }
//        boolean[] seen = new boolean[26];
//        int[] frequency = new int[26];
//
//        for(int i=0; i<s.length(); i++){
//            frequency[s.charAt(i) - 'a']++;
//        }
//        Stack<Character> stack = new Stack<>();
//        stack.push(s.charAt(0));
//        seen[s.charAt(0) - 'a'] = true;
//        for(int i=1; i<s.length(); i++){
//            if(s.charAt(i) > s.charAt(i-1) && !seen[s.charAt(i) - 'a']){
//                stack.push(s.charAt(i));
//            }
//            else{
//                while(!stack.isEmpty()){
//                    if(s.charAt(i) > s.charAt(i-1))
//                }
//
//            }
//
//        }

        // Store the last occurrence of each character
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        Stack<Character> stack = new Stack<>();
        boolean[] used = new boolean[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (used[c - 'a']) continue;

            // Remove characters from the stack that are lexicographically greater
            // and have a later occurrence in the string
            while (!stack.isEmpty() && stack.peek() > c && lastIndex[stack.peek() - 'a'] > i) {
                used[stack.pop() - 'a'] = false;
            }
            stack.push(c);
            used[c - 'a'] = true;
        }

        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }
        return result.toString();


    }

    public static void main(String[] args) {

        RemoveDuplicateLetters rl = new RemoveDuplicateLetters();
//        System.out.println(rl.removeDuplicateLetters("bcabc"));
        System.out.println(rl.removeDuplicateLetters("cbacdcbc"));

    }
}
