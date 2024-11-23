package Arrays;

import java.util.*;

public class SubsetsII {

    public List<List<Integer>> generateSubsetsBitManipulation(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        int n = nums.length;
        int totalSubsets = 1 << n; // 2^n subsets
        for (int i = 0; i < totalSubsets; i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                // Check if the j-th bit in i is set
                if ((i & (1 << j)) != 0) {
                    subset.add(nums[j]);
                }
            }
            subsets.add(subset);
        }

        return subsets;
    }

    public static List<List<Integer>> subsetsManipulationWithDistinct(int[] nums) {
        // Sort the input array to group duplicates
        Arrays.sort(nums);

        Set<List<Integer>> uniqueSubsets = new HashSet<>();
        int n = nums.length;
        int totalSubsets = (1 << n);
        for (int i = 0; i < totalSubsets; i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(nums[j]);
                }
            }
            uniqueSubsets.add(subset);
        }
        return new ArrayList<>(uniqueSubsets);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());

        for (int num : nums) {
            int size = subsets.size();
            for (int i = 0; i < size; i++) {
                // Create a new subset by adding the current element to an existing subset
                List<Integer> newSubset = new ArrayList<>(subsets.get(i));
                newSubset.add(num);
                subsets.add(newSubset);
            }
        }
        return subsets;

    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort the array to group duplicates
        result.add(new ArrayList<>()); // Start with the empty subset

        int startIndex = 0, endIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            startIndex = 0;

            // If the current element is a duplicate, only extend subsets from the previous step
            if (i > 0 && nums[i] == nums[i - 1]) {
                startIndex = endIndex + 1;
            }

            endIndex = result.size() - 1;

            for (int j = startIndex; j <= endIndex; j++) {
                List<Integer> subset = new ArrayList<>(result.get(j));
                subset.add(nums[i]);
                result.add(subset);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        SubsetsII ss = new SubsetsII();
//        System.out.println(ss.subsetsWithDup(new int[]{1,2,2}));
//        System.out.println(ss.subsetsWithDup(new int[]{0}));
        System.out.println(ss.generateSubsetsBitManipulation(new int[]{1,2,2}));
        System.out.println(ss.generateSubsetsBitManipulation(new int[]{0}));

    }
}
