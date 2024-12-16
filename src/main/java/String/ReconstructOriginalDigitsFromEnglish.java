package String;

import java.util.HashMap;
import java.util.Map;

public class ReconstructOriginalDigitsFromEnglish {

//    public String originalDigits(String s) {
//        Map<Character, Integer> frequency = new HashMap<>();
//        for(int i=0; i<s.length(); i++){
//            frequency.put(s.charAt(i), frequency.getOrDefault(s.charAt(i),0)+1);
//        }
//        return "";
//    }

    public String originalDigits(String s) {
        // Frequency map for letters
        int[] letterCount = new int[26];
        for (char c : s.toCharArray()) {
            letterCount[c - 'a']++;
        }

        // Array to store the count of each digit
        int[] digitCount = new int[10];

        // Identify digits using unique letters
        digitCount[0] = letterCount['z' - 'a']; // 'z' is unique to "zero"
        digitCount[2] = letterCount['w' - 'a']; // 'w' is unique to "two"
        digitCount[4] = letterCount['u' - 'a']; // 'u' is unique to "four"
        digitCount[6] = letterCount['x' - 'a']; // 'x' is unique to "six"
        digitCount[8] = letterCount['g' - 'a']; // 'g' is unique to "eight"

        // Identify remaining digits
        digitCount[1] = letterCount['o' - 'a'] - digitCount[0] - digitCount[2] - digitCount[4];
        digitCount[3] = letterCount['h' - 'a'] - digitCount[8];
        digitCount[5] = letterCount['f' - 'a'] - digitCount[4];
        digitCount[7] = letterCount['s' - 'a'] - digitCount[6];
        digitCount[9] = letterCount['i' - 'a'] - digitCount[5] - digitCount[6] - digitCount[8];

        // Build the result string
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < digitCount[i]; j++) {
                result.append(i);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        ReconstructOriginalDigitsFromEnglish re = new ReconstructOriginalDigitsFromEnglish();
        System.out.println(re.originalDigits("owoztneoer"));
        System.out.println(re.originalDigits("fviefuro"));

    }
}
