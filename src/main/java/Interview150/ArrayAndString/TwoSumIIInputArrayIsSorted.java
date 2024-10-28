package Interview150.ArrayAndString;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumIIInputArrayIsSorted {

    public int[] twoSum(int[] numbers, int target) {
        // O(n^2)
//        for(int i=0; i<numbers.length; i++){
//            for(int j=i; j<numbers.length; j++){
//                if(i == j)
//                    continue;
//                if(numbers[i]+numbers[j] == target)
//                    return new int[]{i+1,j+1};
//            }
//        }
//        return null;

        //time - O(n), space - O(n)
//        Map<Integer, Integer> map = new HashMap<>();
//
//        for (int i = 0; i < numbers.length; i++) {
//            int complement = target - numbers[i];
//
//            // Check if the complement is already in the map
//            if (map.containsKey(complement)) {
//                return new int[] { map.get(complement) + 1, i + 1 }; // +1 to match 1-based index
//            }
//
//            // Add the current number and its index to the map
//            map.put(numbers[i], i);
//        }
//        return null; // Return null if no two numbers sum up to the target

        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[] { left + 1, right + 1 }; // +1 to match 1-based index
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return null;

    }

    public static void main(String[] args) {
        TwoSumIIInputArrayIsSorted ts = new TwoSumIIInputArrayIsSorted();

        int[] result = ts.twoSum(new int[]{2,7,11,15}, 9);
        int[] result2 = ts.twoSum(new int[]{2,3,4}, 6);
        int[] result3 = ts.twoSum(new int[]{-1,0}, -1);

        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(result2));
        System.out.println(Arrays.toString(result3));
    }
}
