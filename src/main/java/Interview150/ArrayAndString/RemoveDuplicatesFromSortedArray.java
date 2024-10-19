package Interview150.ArrayAndString;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {

        int n = nums.length;
        if (n <= 1)
            return n;

        int idx = 1; // Start from the second element
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[idx++] = nums[i];
            }
        }
        return idx;

    }

    public static void main(String[] args) {

        RemoveDuplicatesFromSortedArray rm = new RemoveDuplicatesFromSortedArray();
        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        rm.removeDuplicates(arr);
        System.out.println(Arrays.toString(arr));

    }
}
