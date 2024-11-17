package Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> duplicate = new HashSet<>();
        for(int num:nums){
            if(duplicate.contains(num))
                return true;
            duplicate.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate cd = new ContainsDuplicate();
        System.out.println(cd.containsDuplicate(new int[]{1,2,3,1}));
        System.out.println(cd.containsDuplicate(new int[]{1,2,3,4}));
    }
}
