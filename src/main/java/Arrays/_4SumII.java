package Arrays;

import java.util.HashMap;
import java.util.Map;

public class _4SumII {

//    // Time Exceeds
//    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
//        int count = 0;
//        for(int num1: nums1){
//            for(int num2: nums2){
//                for(int num3: nums3){
//                    for(int num4: nums4){
//                        if(num1+num2+num3+num4 == 0){
//                            count++;
//                        }
//                    }
//                }
//            }
//        }
//        return count;
//    }

        public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        Map<Integer, Integer> twoSum = new HashMap<>();
        for(int num1: nums1){
            for(int num2: nums2){
                twoSum.put(num1+num2,twoSum.getOrDefault(num1+num2,0)+1);
            }
        }

            for(int num3: nums3){
                for(int num4: nums4){
                    int temp = num3+num4;
                   if(twoSum.containsKey(-temp)){
                       count += twoSum.get(-temp);
                   }
                }
            }
        return count;
    }

    public static void main(String[] args) {
        _4SumII fs = new _4SumII();
        System.out.println(fs.fourSumCount(new int[]{1,2},new int[]{-2,-1},new int[]{-1,2},new int[]{0,2}));
        System.out.println(fs.fourSumCount(new int[]{0},new int[]{0},new int[]{0},new int[]{0}));
    }
}
