package Interview150.ArrayAndString;

import java.util.*;

public class _3sum {
    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> result = new ArrayList<>();
//        Arrays.sort(nums); // Sort the array
//
//        for (int i = 0; i < nums.length - 2; i++) {
//            // Avoid duplicates for the first element
//            if (i > 0 && nums[i] == nums[i - 1]) continue;
//
//            int left = i + 1;
//            int right = nums.length - 1;
//
//            while (left < right) {
//                int sum = nums[i] + nums[left] + nums[right];
//
//                if (sum == 0) {
//                    // Add the triplet to the result
//                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
//
//                    // Move left and right pointers to the next different numbers to avoid duplicates
//                    while (left < right && nums[left] == nums[left + 1]) left++;
//                    while (left < right && nums[right] == nums[right - 1]) right--;
//
//                    // Move pointers to look for new pairs
//                    left++;
//                    right--;
//                } else if (sum < 0) {
//                    left++; // Increase sum by moving left pointer to the right
//                } else {
//                    right--; // Decrease sum by moving right pointer to the left
//                }
//            }
//        }
//
//        return result;

        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> uniqueTriplets = new HashSet<>();
        Arrays.sort(nums); // Sort to handle duplicates

        for (int i = 0; i < nums.length - 2; i++) {
            int target = -nums[i];
            Set<Integer> seen = new HashSet<>();

            for (int j = i + 1; j < nums.length; j++) {
                int complement = target - nums[j];

                if (seen.contains(complement)) {
                    // Found a triplet
                    List<Integer> triplet = Arrays.asList(nums[i], complement, nums[j]);

                    // Sort triplet to handle duplicates, since `Set` relies on order
                    if (uniqueTriplets.add(triplet)) {
                        result.add(triplet);
                    }
                }
                seen.add(nums[j]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        _3sum ts = new _3sum();
        List<List<Integer>> result = ts.threeSum(new int[]{-1,0,1,2,-1,-4});
        List<List<Integer>> result2 = ts.threeSum(new int[]{-0,1,1});
        List<List<Integer>> result3 = ts.threeSum(new int[]{0,0,0});

        System.out.println(result);
        System.out.println(result2);
        System.out.println(result3);


    }
}
