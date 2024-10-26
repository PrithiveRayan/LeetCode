package Interview75.TwoPointers;

import java.util.*;

public class MaxNumberOfKSumPairs {

    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int i : nums) {
            if (map.containsKey(i) &&
                    map.get(i) > 0)
            {
                map.put(i, map.get(i) - 1);
                result++;
            }
            else
            {
                map.put(k - i,
                        map.getOrDefault(k - i, 0) + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MaxNumberOfKSumPairs mk = new MaxNumberOfKSumPairs();
        System.out.println(mk.maxOperations(new int[]{1,2,3,4},5));
        System.out.println(mk.maxOperations(new int[]{3,1,3,4,3},6));
//        System.out.println(mk.maxOperations(new int[]{2,5,4,4,1,3,4,4,1,4,4,1,2,1,2,2,3,2,4,2},3));

    }
}
