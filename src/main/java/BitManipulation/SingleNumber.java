package BitManipulation;

import java.util.Arrays;

public class SingleNumber {

    public int singleNumber(int[] nums) {
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum = sum ^ nums[i];
        }

        return sum;

    }

    public static void main(String[] args) {
        SingleNumber sn = new SingleNumber();
        System.out.println(sn.singleNumber(new int[]{1}));
        System.out.println(sn.singleNumber(new int[]{2,2,1}));
        System.out.println(sn.singleNumber(new int[]{4,1,2,1,2}));
    }
}
