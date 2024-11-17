package BinarySearch;

import java.util.Arrays;

public class FirstAndLastPosition {
    public int[] searchRange(int[] nums, int target) {
//        int left = 0, right = nums.length-1;
//        while(left <= right){
//            int mid = left+(right-left)/2;
//            if(nums[mid] == target){
//                if(mid-1 >=0 && nums[mid-1] == target){
//                    return new int[]{mid-1,mid};
//                }
//                else{
//                    return new int[]{mid,mid+1};
//                }
//
//            }
//            if(nums[mid] < target){
//                left = mid+1;
//            }
//            else {
//                right = mid-1;
//            }
//        }
//        return new int[]{-1,-1};
        int first = findFirst(nums, target);
        if(first == -1) return new int[]{-1,-1};
        int last = findLast(nums, target);
        return new int[] {first, last};

    }

    private int findFirst(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                result = mid; // Record the potential result
                right = mid - 1; // Narrow search to left half
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    private int findLast(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                result = mid; // Record the potential result
                left = mid + 1; // Narrow search to right half
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FirstAndLastPosition fp = new FirstAndLastPosition();
        System.out.println(Arrays.toString(fp.searchRange(new int[]{5,7,7,8,8,10},8)));
        System.out.println(Arrays.toString(fp.searchRange(new int[]{5,7,7,8,8,10},6)));
        System.out.println(Arrays.toString(fp.searchRange(new int[]{1},1)));
    }
}
