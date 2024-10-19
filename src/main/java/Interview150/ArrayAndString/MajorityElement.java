package Interview150.ArrayAndString;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MajorityElement {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(count.containsKey(nums[i])){
                int temp = count.get(nums[i]);
                count.put(nums[i],count.get(nums[i])+1);
            }
            else{
                count.put(nums[i],1);
            }
        }
        int maxValue = Integer.MIN_VALUE;
        int keyOfMaxValue = -1;
        for (var entry : count.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                keyOfMaxValue = entry.getKey();
            }
        }

        return keyOfMaxValue;

    }

    public static void main(String[] args) {
        MajorityElement me = new MajorityElement();
        System.out.println(me.majorityElement(new int[]{2,2,1,1,1,2,2}));

    }
}
