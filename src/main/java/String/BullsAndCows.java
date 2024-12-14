package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BullsAndCows {

//    public String getHint(String secret, String guess) {
//        int bulls = 0;
//        int cows = 0;
////        Map<Character, Integer> secretCount = new HashMap<>();
////        Map<Character, Integer> guessCount = new HashMap<>();
//        List<Character> guessChars = new ArrayList<>();
//        List<Character> secretChars = new ArrayList<>();
//        for (int i = 0; i < secret.length(); i++) {
//            if (secret.charAt(i) == guess.charAt(i)) {
//                bulls++;
//                continue;
//            }
//            secretChars.add(secret.charAt(i));
//            guessChars.add(guess.charAt(i));
////            secretCount.put(secret.charAt(i), secretCount.getOrDefault(secret.charAt(i), 0) + 1);
////            guessCount.put(guess.charAt(i), guessCount.getOrDefault(guess.charAt(i), 0) + 1);
//        }
//        for(int i=0 ; i<secretChars.size(); i++){
//            if(guessChars.contains(secretChars.get(i))){
//                cows++;
//                guessChars.remove(Character.valueOf(secretChars.get(i)));
//            }
//        }
//
//        return bulls + "A" + cows + "B";
//    }

    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;

        // Map to store unmatched characters from secret
        Map<Character, Integer> secretMap = new HashMap<>();

        // First pass to count bulls
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++; // Correct position (bull)
            } else {
                // Increment the count for unmatched secret characters
                secretMap.put(secret.charAt(i), secretMap.getOrDefault(secret.charAt(i), 0) + 1);
            }
        }

        // Second pass to count cows
        for (int i = 0; i < guess.length(); i++) {
            if (secret.charAt(i) != guess.charAt(i)) { // Process only unmatched characters
                char guessChar = guess.charAt(i);
                if (secretMap.containsKey(guessChar) && secretMap.get(guessChar) > 0) {
                    cows++; // A matching character (cow) in the wrong position
                    secretMap.put(guessChar, secretMap.get(guessChar) - 1); // Decrement count
                }
            }
        }

        // Return the result as xAyB
        return bulls + "A" + cows + "B";
    }

    public static void main(String[] args) {
        BullsAndCows bc = new BullsAndCows();
        System.out.println(bc.getHint("1807","7810"));
        System.out.println(bc.getHint("1123","0111"));

    }
}
