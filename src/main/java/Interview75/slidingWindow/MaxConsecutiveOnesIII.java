package Interview75.slidingWindow;

public class MaxConsecutiveOnesIII {

    public int longestOnes(int[] nums, int k) {
//        int maxConsecutive = 0;
//        int currentConsecutive = 0;
//        int count = k;
//        for (int num : nums) {
//            if (num == 1 || count != 0) {
//                currentConsecutive++;// Expand the window for consecutive 1s
//                if (num == 0) {
//                    count--;
//                }
//            } else {
//                if (count == 0)
//                    count = k;
//                maxConsecutive = Math.max(maxConsecutive, currentConsecutive); // Update max if needed
//                currentConsecutive = 0; // Reset for a new sequence
//            }
//        }
//        return Math.max(maxConsecutive, currentConsecutive);

        int maxConsecutive = 0;
        int left = 0;
        int zeroCount = 0;
        for (int right = 0; right < nums.length; right++) {
            // Expand the window by moving `right`, count `0`s as we go
            if (nums[right] == 0) {
                zeroCount++;
            }

            // If we have more than `k` `0`s, move `left` to shrink the window
            if (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--; // Adjust zeroCount since we're moving past a `0`
                }
                left++; // Move the window forward
            }

            // Calculate the maximum window size
            maxConsecutive = Math.max(maxConsecutive, right - left + 1);
        }

        return maxConsecutive;

    }


    public static void main(String[] args) {
        MaxConsecutiveOnesIII mc = new MaxConsecutiveOnesIII();

//        System.out.println(mc.longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
//        System.out.println(mc.longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));

        System.out.println(mc.longestOnes(new int[]{0,0,1,1,0,0,1,0,1,1}, 1));
    }
}
