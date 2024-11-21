package Arrays;

public class SearchInRotatedSortedArrayII {

    public boolean search(int[] nums, int target) {

        int left = 0;
        int right = nums.length-1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }

            // Handle duplicates: Skip equal elements at the boundaries
//            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
//                left++;
//                right--;
//                continue;
//            }

            // Left part is sorted
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // Target is in the left part
                } else {
                    left = mid + 1; // Target is in the right part
                }
            }
            // Right part is sorted
            else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1; // Target is in the right part
                } else {
                    right = mid - 1; // Target is in the left part
                }
            }

        }


        return false;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArrayII sr = new SearchInRotatedSortedArrayII();
        System.out.println(sr.search(new int[]{2,5,6,0,0,1,2},0));
        System.out.println(sr.search(new int[]{2,5,6,0,0,1,2},3));

    }

}
