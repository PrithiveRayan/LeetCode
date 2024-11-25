package Arrays;

import java.util.*;

public class WordBreak {

//    public boolean wordBreak(String s, List<String> wordDict) {
//        int checkpoint = 0;
//        for(int i=0; i<s.length(); i++){
//            if(wordDict.contains(s.substring(checkpoint, i+1))){
//                if(i == s.length()-1){
//                    return true;
//                }
//                checkpoint = i+1;
//            }
//        }
//        return false;
//    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict); // Convert list to a set for O(1) lookups
        int n = s.length();
        boolean[] dp = new boolean[n + 1];

        dp[0] = true; // Base case: Empty string

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                // If s[0:j] can be segmented and s[j:i] is in the dictionary
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // No need to check further
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {

        WordBreak wb = new WordBreak();
//        System.out.println(wb.wordBreak("leetcode",new ArrayList<>(Arrays.asList("leet","code"))));
//        System.out.println(wb.wordBreak("applepenapple",new ArrayList<>(Arrays.asList("apple","pen"))));
//        System.out.println(wb.wordBreak("catsandog",new ArrayList<>(Arrays.asList("cats","dog","sand","and","cat"))));
        System.out.println(wb.wordBreak("aaaaaaa",new ArrayList<>(Arrays.asList("aaaa","aaa"))));
    }
}
