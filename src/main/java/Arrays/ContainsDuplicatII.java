package Arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicatII {


    /*
    return true if there are two distinct indices i and j in the array
    such that nums[i] == nums[j] and abs(i - j) <= k.
    */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> duplicate = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(duplicate.containsKey(nums[i]) && Math.abs(duplicate.get(nums[i])-i) <= k){
                return true;
            }
            duplicate.put(nums[i], i);
        }
        return false;
    }


    public static void main(String[] args) {
        ContainsDuplicatII cd = new ContainsDuplicatII();
        System.out.println(cd.containsNearbyDuplicate(new int[]{1,2,3,1},3));
        System.out.println(cd.containsNearbyDuplicate(new int[]{1,0,1,1},1));
        System.out.println(cd.containsNearbyDuplicate(new int[]{1,2,3,1,2,3},2));
    }
}
