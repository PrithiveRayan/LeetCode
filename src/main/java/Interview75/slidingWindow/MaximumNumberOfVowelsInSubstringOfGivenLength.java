package Interview75.slidingWindow;

import java.util.Set;

public class MaximumNumberOfVowelsInSubstringOfGivenLength {
    public int maxVowels(String s, int k) {


        // O(n^3)
//        int max = 0;
//        Set<Character> vowels = Set.of('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u');
//        for(int start=0; start<s.length(); start++){
//            for(int end = start; end<s.length(); end++){
//                int count = 0;
//                int size = 0;
//                for(int x = start; x<=end; x++){
//                    if(vowels.contains(s.charAt(x))){
//                        count ++;
//                    }
//                    size++;
//                }
//                if(count > max && size == k)
//                    max = count;
//            }
//        }
//        return max;

        int maxVowels=0;
        int currentVowels =0;
        Set<Character> vowels = Set.of('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u');
        for (int i = 0; i < k; i++) {
           if(vowels.contains(s.charAt(i))){
               currentVowels++;
           }
        }
        maxVowels = currentVowels;

        for (int i = k; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i - k))) {
                currentVowels--;
            }
            if (vowels.contains(s.charAt(i))) {
                currentVowels++;
            }
            maxVowels = Math.max(maxVowels, currentVowels);
        }
        return maxVowels;


    }


    public static void main(String[] args) {
        MaximumNumberOfVowelsInSubstringOfGivenLength ml = new MaximumNumberOfVowelsInSubstringOfGivenLength();
        System.out.println(ml.maxVowels("abciiidef",3));
        System.out.println(ml.maxVowels("aeiou",2));
        System.out.println(ml.maxVowels("leetcode",3));


    }
}
