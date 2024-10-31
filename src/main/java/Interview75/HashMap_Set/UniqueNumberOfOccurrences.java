package Interview75.HashMap_Set;

import java.util.*;
import java.util.stream.Collectors;

public class UniqueNumberOfOccurrences {

    public boolean uniqueOccurrences(int[] arr) {
//        HashMap<Integer, Integer> occurrence = new HashMap<>();
//        for(int i=0; i<arr.length; i++){
//            occurrence.put(arr[i], occurrence.getOrDefault(arr[i],0)+1);
//        }
//
//        List<Integer> list = occurrence.values().stream().sorted().collect(Collectors.toList());
//        for(int i=0; i<list.size(); i++){
//            if(i+1 < list.size() && list.get(i) == list.get(i+1))
//                return false;
//        }
//        return true;

        // Create a hash map to count occurrences of each number
        Map<Integer, Integer> occurrences = new HashMap<>();

        // Count occurrences of each number in the array
        for (int num : arr) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        // Create a set to track unique counts
        Set<Integer> uniqueCounts = new HashSet<>();

        // Check if counts are unique
        for (int count : occurrences.values()) {
            if (!uniqueCounts.add(count)) {
                return false; // Not unique
            }
        }

        return true; // All counts are unique
    }
    public static void main(String[] args) {
        UniqueNumberOfOccurrences un = new UniqueNumberOfOccurrences();

        System.out.println(un.uniqueOccurrences(new int[]{1,2,2,1,1,3}));
        System.out.println(un.uniqueOccurrences(new int[]{1,2}));
        System.out.println(un.uniqueOccurrences(new int[]{-3,0,1,-3,1,1,1,-3,10,0}));

    }
}
