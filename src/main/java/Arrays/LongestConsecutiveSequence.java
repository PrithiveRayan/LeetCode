package Arrays;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        int longest = 1;
        if(nums.length == 0)
            return 0;

        Map<Integer, Integer> hashing = new TreeMap<>();

        for(int i=0; i<nums.length; i++){
            hashing.put(nums[i], i);
        }
        int consecutive = 1;

        Iterator<Integer> iterator = hashing.keySet().iterator();
        int previous = iterator.next();
        while(iterator.hasNext()){
            int temp = iterator.next();
            if(previous+1 == temp){
                consecutive++;
                previous++;
            }
            else if(consecutive > longest){
                longest = consecutive;
                consecutive = 1;
                previous = temp;
            }
            else{
                consecutive = 1;
                previous = temp;
            }
        }


        return consecutive > longest ? consecutive : longest;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence ls = new LongestConsecutiveSequence();
        System.out.println(ls.longestConsecutive(new int[]{100,4,200,1,3,2}));
        System.out.println(ls.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }
}
