package Interview75.slidingWindow;

public class LongestSubarrayAfterDeletingOneElement {
    public int longestSubarray(int[] nums) {
        int maxConsecutive = 0;
        int left = 0;
        int zeroCount = 0;
        for(int right = 0; right < nums.length; right++){
            if (nums[right] == 0) {
                zeroCount++;
            }
            if(zeroCount > 1){
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            maxConsecutive = Math.max(maxConsecutive, right - left + 1);

        }
        return maxConsecutive-1;
    }



    public static void main(String[] args) {
        LongestSubarrayAfterDeletingOneElement le = new LongestSubarrayAfterDeletingOneElement();
        System.out.println(le.longestSubarray(new int[]{1,1,0,1}));
        System.out.println(le.longestSubarray(new int[]{0,1,1,1,0,1,1,0,1}));
        System.out.println(le.longestSubarray(new int[]{1,1,1}));

    }
}
