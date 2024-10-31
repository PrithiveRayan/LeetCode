package Interview75.HashMap_Set;

import java.util.*;

public class DetermineTwoStringsAreClose {

    public boolean closeStrings(String word1, String word2) {

//        if(word1.length() != word2.length())
//            return false;
//        Set<Character> occurrence1 = new TreeSet<>();
//        Set<Character> occurrence2 = new TreeSet<>();
//        for(int i=0; i<word1.length(); i++){
//            occurrence1.add(word1.charAt(i));
//            occurrence2.add(word2.charAt(i));
//        }
//        if(occurrence1.size() != occurrence2.size())
//            return false;
//        else if(!occurrence1.equals(occurrence2))
//            return false;
//        return true;

        if (word1.length() != word2.length()) {
            return false;
        }
        int[] count1 = new int[26]; // For 'a' to 'z'
        int[] count2 = new int[26];

        for (char c : word1.toCharArray()) {
            count1[c - 'a']++; // Increment count for each character in word1
        }
        for (char c : word2.toCharArray()) {
            count2[c - 'a']++; // Increment count for each character in word2
        }
        for (int i = 0; i < 26; i++) {
            if ((count1[i] > 0 && count2[i] == 0) || (count1[i] == 0 && count2[i] > 0)) {
                return false; // Different characters in the two strings
            }
        }

        // Step 4: Check if the frequencies can match
        Arrays.sort(count1);
        Arrays.sort(count2);

        return Arrays.equals(count1, count2);
    }


    public static void main(String[] args) {
        DetermineTwoStringsAreClose ds = new DetermineTwoStringsAreClose();
//        System.out.println(ds.closeStrings("abc","bca"));
//        System.out.println(ds.closeStrings("a","aa"));
//        System.out.println(ds.closeStrings("cabbba","abbccc"));
        System.out.println(ds.closeStrings("abbzzca","babzzcz"));

    }
}
