package Arrays;

public class SortColorsUsingDutchFlagAlgorithm {

    public void sortColors(int[] nums) {

        int low = 0, mid = 0, high = nums.length - 1;
            while (mid <= high) {
                if (nums[mid] == 0) {
                    swap(nums, low, mid);
                    low++;
                    mid++;
                } else if (nums[mid] == 1) {
                    mid++;
                } else {
                    swap(nums, mid, high);
                    high--;
                }
            }

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        SortColorsUsingDutchFlagAlgorithm sc = new SortColorsUsingDutchFlagAlgorithm();
        int[] arr1 = {2,0,2,1,1,0};
        int[] arr2 = {1,2,0,2,1,2,0,0,1};
//        sc.sortColors(arr1);
        sc.sortColors(arr2);

    }
}
