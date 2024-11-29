package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MajorityElementII {
//    public List<Integer> majorityElement(int[] nums) {
//        if (nums.length == 1)
//            return Arrays.asList(nums[0]);
//        if(nums.length == 2){
//            if(nums[0] != nums[1]){
//                return Arrays.asList(nums[0], nums[1]);
//            }
//            else{
//                return Arrays.asList(nums[0]);
//            }
//        }
//
//        Arrays.sort(nums);
//        List<Integer> result = new ArrayList<>();
//        int count = 1;
//        for(int i=1; i<nums.length; i++){
//            if(nums[i-1] == nums[i]){
//                count++;
//            }
//            if(count > (nums.length/3)){
//                result.add(nums[i]);
//                count = 1;
//            }
//
//        }
//        return result;
//    }

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;

        // Step 1: Identify candidates using Boyer-Moore Voting Algorithm
        int candidate1 = 0, candidate2 = 0, count1 = 0, count2 = 0;
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // Step 2: Verify the candidates
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == candidate1) count1++;
            else if (num == candidate2) count2++;
        }

        int n = nums.length;
        if (count1 > n / 3) result.add(candidate1);
        if (count2 > n / 3) result.add(candidate2);

        return result;
    }

    public static void main(String[] args) {
        MajorityElementII me = new MajorityElementII();
//        System.out.println(me.majorityElement(new int[]{3,2,3}));
//        System.out.println(me.majorityElement(new int[]{1}));
//        System.out.println(me.majorityElement(new int[]{1,2}));
//        System.out.println(me.majorityElement(new int[]{0,0,0}));
        System.out.println(me.majorityElement(new int[]{2,3,2,3,2,4,3,2,3}));

    }
}
