package String;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {

    public int longestPalindrome(String s) {
        int max = 0;
        Map<Character, Integer> counts = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            counts.put(s.charAt(i),counts.getOrDefault(s.charAt(i),0)+1);
        }
        boolean oddAdded = false;
        for(Integer count : counts.values()){
            if(count == 1 && oddAdded){
                continue;
            }
            if(count == 1 && !oddAdded){
                oddAdded = true;
                max++;
            }
            else{
                if(count % 2 == 1){
                    if(!oddAdded){
                        max++;
                        oddAdded = true;
                    }
                  max = max + (count-1);
                }
                else{
                    max = max+count;
                }
            }
        }

        return max;

    }

    public static void main(String[] args) {

        LongestPalindrome lp = new LongestPalindrome();
//        System.out.println(lp.longestPalindrome("abccccdd"));
//        System.out.println(lp.longestPalindrome("a"));
        System.out.println(lp.longestPalindrome("bananas"));

    }
}
