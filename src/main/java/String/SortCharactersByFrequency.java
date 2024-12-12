package String;

import java.util.*;

public class SortCharactersByFrequency {

    public String frequencySort(String s) {

        // Step 1: Count frequency of each character
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Create a list of characters sorted by frequency
        List<Map.Entry<Character, Integer>> sortedList = new ArrayList<>(frequencyMap.entrySet());
        sortedList.sort((entry1, entry2) -> entry2.getValue() - entry1.getValue());  // Sort by frequency in descending order

        // Step 3: Build the result string
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : sortedList) {
            char c = entry.getKey();
            int freq = entry.getValue();
            for (int i = 0; i < freq; i++) {
                result.append(c);  // Append the character 'freq' times
            }
        }

        return result.toString();



    }

    public static void main(String[] args) {
        SortCharactersByFrequency sc = new SortCharactersByFrequency();
//        System.out.println(sc.frequencySort("tree"));
//        System.out.println(sc.frequencySort("cccaaa"));
//        System.out.println(sc.frequencySort("Aabb"));
        System.out.println(sc.frequencySort("cbbzzzaddxxxx"));

    }
}
