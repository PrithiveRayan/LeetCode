package String;

import java.util.HashMap;
import java.util.Map;

public class RepeatedSubstringPattern {

//    public boolean repeatedSubstringPattern(String s) {
//
//        if(s.length() ==0 || s.length() == 1)
//            return true;
//        Map<Character, Integer> hashing = new HashMap<>();
//        for(int i=0; i<s.length(); i++){
//            hashing.put(s.charAt(i), hashing.getOrDefault(s.charAt(i), 0)+1);
//        }
//        int first = 0;
//        for(int count : hashing.values()){
//            if(first == 0){
//                first = count;
//                continue;
//            }
//            else if(count != first){
//                return false;
//            }
//        }
//        return true;
//    }

    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() <= 1) {
            return false;
        }
        String doubled = s + s;
        String modified = doubled.substring(1, doubled.length() - 1);
        return modified.contains(s);
    }

    public static void main(String[] args) {
        RepeatedSubstringPattern rp = new RepeatedSubstringPattern();
        System.out.println(rp.repeatedSubstringPattern("abab"));
        System.out.println(rp.repeatedSubstringPattern("aba"));
        System.out.println(rp.repeatedSubstringPattern("abcabcabcabc"));

    }
}
