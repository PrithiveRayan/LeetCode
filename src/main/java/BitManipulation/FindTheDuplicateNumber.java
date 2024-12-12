package BitManipulation;

import java.util.HashSet;
import java.util.Set;

public class FindTheDuplicateNumber {

//    public int findDuplicate(int[] nums) {
//        Set<Integer> hashing = new HashSet<>();
//        for(int num : nums){
//            if(hashing.contains(num)){
//                return num;
//            }
//            hashing.add(num);
//        }
//        return -1;
//    }

    public static int findDuplicate(int[] nums) {
        // Step 1: Use Floyd's Tortoise and Hare to find the intersection point
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Step 2: Find the entrance to the cycle (duplicate number)
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

//    public static int findDuplicate(int[] nums) {
//        int n = nums.length - 1; // Numbers are in the range [1, n]
//        int xorAll = 0;
//        int xorNums = 0;
//
//        // XOR all numbers from 1 to n
//        for (int i = 1; i <= n; i++) {
//            xorAll ^= i;
//        }
//
//        // XOR all elements in the nums array
//        for (int num : nums) {
//            xorNums ^= num;
//        }
//
//        // XOR of xorAll and xorNums will give the duplicate number
//        return xorAll ^ xorNums;
//    }

    public static void main(String[] args) {
        FindTheDuplicateNumber fd = new FindTheDuplicateNumber();
        System.out.println(fd.findDuplicate(new int[]{1,3,4,2,2}));
        System.out.println(fd.findDuplicate(new int[]{3,1,3,4,2}));
        System.out.println(fd.findDuplicate(new int[]{3,3,3,3,3}));

    }
}
