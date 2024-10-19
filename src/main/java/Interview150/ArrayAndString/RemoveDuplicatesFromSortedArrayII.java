package Interview150.ArrayAndString;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {

        int index = 0;
        for (int num : nums) {
            if (index < 2 || num != nums[index - 2]) {
                nums[index] = num; // Place the current element at the 'index' position and increment 'index'
                index++;
            }
        }
        return index;
    }

    public static void main(String[] args) {

        RemoveDuplicatesFromSortedArrayII rm = new RemoveDuplicatesFromSortedArrayII();
        int[] arr = {0,0,1,1,1,1,2,3,3};
        rm.removeDuplicates(arr);
        System.out.println(Arrays.toString(arr));


    }
}
