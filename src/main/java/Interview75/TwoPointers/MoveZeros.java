package Interview75.TwoPointers;

import java.util.Arrays;

public class MoveZeros {

    public void moveZeroes(int[] nums) {
//        int zero = 0;
//        int nonZero = 0;
//        for(int i=0; i<nums.length; i++){
//            if(nums[i]!=0){
//                nums[nonZero++] = nums[i];
//            }
//            else{
//                zero++;
//            }
//        }
//        for(int i=nums.length-zero; i<nums.length; i++){
//            nums[i] = 0;
//        }

        int i = -1, n = nums.length;
        for (int j = 0; j < n; ++j) {
            if (nums[j] != 0) {
                int t = nums[++i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }
    }

    public static void main(String[] args) {
        MoveZeros mz = new MoveZeros();
        int[] arr = {0,1,0,3,12};
        int[] arr2 = {0};

        mz.moveZeroes(arr);
        mz.moveZeroes(arr2);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));

    }
}
