package Arrays;

import java.util.*;

public class TopKFrequentElements {

//    public int[] topKFrequent(int[] nums, int k) {
//        Map<Integer, Integer> frequent = new HashMap<>();
//
//        for(int num : nums){
//            frequent.put(num, frequent.getOrDefault(num,0)+1);
//        }
//
//        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(frequent.entrySet());
//
//        entryList.sort((entry1, entry2) -> entry2.getValue() - entry1.getValue());
//
//        Map<Integer, Integer> sortedMap = new LinkedHashMap<>();
//        for (Map.Entry<Integer, Integer> entry : entryList) {
//            sortedMap.put(entry.getKey(), entry.getValue());
//        }
//
//        int[] frequentElements = new int[k];
//        int increment = 0;
//        for(int freq : sortedMap.keySet()){
//            frequentElements[increment] = freq;
//            increment++;
//            if(increment == k){
//                break;
//            }
//        }
//        return frequentElements;
//    }

    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequencies of elements
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create a list of lists for bucket sort
        List<Integer>[] bucket = new List[nums.length + 1]; // Frequency ranges from 0 to nums.length
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<>();
        }

        // Step 3: Group numbers by their frequencies
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int freq = entry.getValue();
            bucket[freq].add(entry.getKey());
        }

        // Step 4: Collect the top k frequent elements
        List<Integer> result = new ArrayList<>();
        for (int i = bucket.length - 1; i >= 0 && result.size() < k; i--) {
            for (int num : bucket[i]) {
                result.add(num);
                if (result.size() == k) {
                    break;
                }
            }
        }

        // Convert result list to an array and return
        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        TopKFrequentElements te = new TopKFrequentElements();
        System.out.println(Arrays.toString(te.topKFrequent(new int[]{1,1,1,2,2,3},2)));
        System.out.println(Arrays.toString(te.topKFrequent(new int[]{1},1)));
    }
}
