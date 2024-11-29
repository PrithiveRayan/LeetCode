package String;

import java.util.*;

public class LetterCombinationsOfPhoneNumber {

//    public List<String> letterCombinations(String digits) {
//        List<String> combinations = new ArrayList<>();
//        HashMap<Character, List<String>> letters = new HashMap<>();
//        letters.put('2', Arrays.asList("a","b","c"));
//        letters.put('3', Arrays.asList("d","e","f"));
//        letters.put('4', Arrays.asList("g","h","i"));
//        letters.put('5', Arrays.asList("j","k","l"));
//        letters.put('6', Arrays.asList("m","n","o"));
//        letters.put('7', Arrays.asList("p","q","r","s"));
//        letters.put('8', Arrays.asList("t","u","v"));
//        letters.put('9', Arrays.asList("w","x","y","z"));
//
//        if(digits.length() == 1){
//            return letters.get(digits.charAt(0));
//        }
//
//        int length = 1;
//        for(int i=0; i<digits.length(); i++){
//            int size = letters.get(digits.charAt(i)).size();
//            length = length * size;
//        }
//        if(length == 1){
//            return combinations;
//        }
//
//        int left = 0, right = digits.length()-1;
//        while(left<right){
//            int size = letters.get(digits.charAt(left)).size();
//            for(int i=left; i<size; i++){
//
//            }
//
//        }
//
//
//
//        for(int i=0; i<digits.length(); i++){
//
//
//
//        }
//
//        return combinations;
//
//    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        String[] keypad = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs","tuv", "wxyz"};
        // Initialize a queue
        Queue<String> queue = new LinkedList<>();
        queue.offer(""); // Start with an empty combination


        for (char digit : digits.toCharArray()) {
            String letters = keypad[digit - '0'];
            int size = queue.size();

            // Expand existing combinations in the queue
            for (int i = 0; i < size; i++) {
                String combination = queue.poll();
                for (char letter : letters.toCharArray()) {
                    queue.offer(combination + letter);
                }
            }
        }
        return new ArrayList<>(queue);
    }


    public static void main(String[] args) {
        LetterCombinationsOfPhoneNumber lc = new LetterCombinationsOfPhoneNumber();
        System.out.println(lc.letterCombinations("23"));
//        System.out.println(lc.letterCombinations(""));
//        System.out.println(lc.letterCombinations("2"));
        System.out.println(lc.letterCombinations("234"));

    }
}
