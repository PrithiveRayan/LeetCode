package Interview150.ArrayAndString;

import java.util.Arrays;

public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        for(int i = 0; i<n; i++){
//            nums1[m++] = nums2[i];
//        }
//        Arrays.sort(nums1);

        int i = m - 1;     // nums1's index (the actual nums)
        int j = n - 1;     // nums2's index
        int k = m + n - 1; // nums1's index (the next filled position)

        while (j >= 0)
            if (i >= 0 && nums1[i] > nums2[j])
                nums1[k--] = nums1[i--];
            else
                nums1[k--] = nums2[j--];

    }

    public static void main(String[] args) {
        MergeSortedArray ms = new MergeSortedArray();
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};

        ms.merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
