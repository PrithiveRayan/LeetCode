package Interview150.ArrayAndString;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        // not so efficient O(n^3)
//        int max = 0;
//        for(int i=0; i<s.length(); i++){
//            for(int j=i; j<s.length(); j++){
//                Map<Character, Boolean> count = new HashMap<>();
//                for(int k=i; k<=j; k++){
//                    if(count.containsKey(s.charAt(k))){
//                        break;
//                    }
//                    count.put(s.charAt(k), true);
//                }
//                max = Math.max(count.size(), max);
//            }
//        }
//        return max;

        // O(n^2)
//        int max = 0;
//        for(int start =0; start<s.length(); start++){
//            Set<Character> count = new HashSet<>();
//            for(int end = start; end<s.length(); end++){
//                if(count.contains(s.charAt(end))){
//                    break;
//                }
//                count.add(s.charAt(end));
//            }
//            max = Math.max(max,count.size());
//        }
//
//        return max;

        int max = 0;
        int left = 0;
        Set<Character> window = new HashSet<>();

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            // If duplicate found, move left pointer to the right until the duplicate is removed
            while (window.contains(currentChar)) {
                window.remove(s.charAt(left));
                left++;
            }
            // Add the current character to the set and update max length
            window.add(currentChar);
            max = Math.max(max, right - left + 1);
        }

        return max;
    }


    public static void main(String[] args) {

        LongestSubstringWithoutRepeatingCharacters lc = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(lc.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lc.lengthOfLongestSubstring("bbbbb"));
        System.out.println(lc.lengthOfLongestSubstring("pwwkew"));
        System.out.println(lc.lengthOfLongestSubstring(" "));


    }
}
