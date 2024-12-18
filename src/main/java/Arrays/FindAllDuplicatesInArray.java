package Arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllDuplicatesInArray {

//    public List<Integer> findDuplicates(int[] nums) {
//        List<Integer> result = new ArrayList<>();
//        Set<Integer> hashing = new HashSet<>();
//        for(int num : nums){
//            if(hashing.contains(num)){
//                result.add(num);
//            }
//            hashing.add(num);
//        }
//        return result;
//    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int num : nums) {
            // Use the absolute value of num to determine the index
            int index = Math.abs(num) - 1;

            // Check if the number at the index is already negative
            if (nums[index] < 0) {
                result.add(index + 1); // The number is a duplicate
            } else {
                // Mark the number as visited by negating it
                nums[index] = -nums[index];
            }
        }

        // Return the result
        return result;
    }

    public static void main(String[] args) {

        FindAllDuplicatesInArray fd = new FindAllDuplicatesInArray();
        System.out.println(fd.findDuplicates(new int[]{4,3,2,7,8,2,3,1}));
        System.out.println(fd.findDuplicates(new int[]{1,1,2}));
        System.out.println(fd.findDuplicates(new int[]{1}));

    }
}
