package Stack;

public class ShortestUnsortedContinuousSubarray {

//    public int findUnsortedSubarray(int[] nums) {
//        if(nums[0] > nums[nums.length-1]){
//            return nums.length;
//        }
//        int leftIndex = 0, rightIndex = nums.length-1;
//        int left = 0, right = nums.length-1;
//        boolean leftFound = false;
//        boolean rightFound = false;
//        int length = nums.length;
//        while(!leftFound || !rightFound){
//            if(nums[left] < nums[leftIndex] && !leftFound){
////                leftIndex = left-1;
//                leftFound = true;
//            }else if(!leftFound){
//                leftIndex = left;
//                length--;
//                left++;
//            }
//            if(nums[right] > nums[rightIndex] && !rightFound){
////                rightIndex = right+1;
//                rightFound = true;
//            }
//            else if(!rightFound){
//                rightIndex = right;
//                length--;
//                right--;
//            }
//            if(length <= 0){
//                break;
//            }
//        }
//        if(!leftFound && !rightFound){
//            return 0;
//        }
//
//        return rightIndex-leftIndex+1;
//    }

    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;

        // Find the initial left boundary
        while (left < n - 1 && nums[left] <= nums[left + 1]) {
            left++;
        }

        // If the array is already sorted
        if (left == n - 1) {
            return 0;
        }

        // Find the initial right boundary
        while (right > 0 && nums[right] >= nums[right - 1]) {
            right--;
        }

        // Find the min and max in the unsorted subarray
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        // Expand the left boundary
        while (left > 0 && nums[left - 1] > min) {
            left--;
        }

        // Expand the right boundary
        while (right < n - 1 && nums[right + 1] < max) {
            right++;
        }

        // Return the length of the subarray
        return right - left + 1;
    }

    public static void main(String[] args) {
        ShortestUnsortedContinuousSubarray ss = new ShortestUnsortedContinuousSubarray();
        System.out.println(ss.findUnsortedSubarray(new int[]{5,3,3,3}));
        System.out.println(ss.findUnsortedSubarray(new int[]{2,6,4,8,10,9,15}));
//        System.out.println(ss.findUnsortedSubarray(new int[]{1,2,3,4}));
//        System.out.println(ss.findUnsortedSubarray(new int[]{1}));
//        System.out.println(ss.findUnsortedSubarray(new int[]{1,2,3,4,3,5,6,5,3,6,7,3,6,7,8}));
        System.out.println(ss.findUnsortedSubarray(new int[]{2,1}));

    }
}
