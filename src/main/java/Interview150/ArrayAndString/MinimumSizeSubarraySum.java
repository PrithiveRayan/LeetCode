package Interview150.ArrayAndString;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
//      int min = Integer.MAX_VALUE;
//        for(int start =0; start<nums.length; start++){
//            for(int end = start; end<nums.length; end++){
//
//                int count = 0;
//                int sum = 0;
//                for(int k=start; k<=end; k++){
//                    sum += nums[k];
//                    count++;
//                }
//                if(sum == target && count<min){
//                    min = count;
//                }
//            }
//        }
//
//        return min == Integer.MAX_VALUE ? 0 : min;
        int minLength = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            // Shrink the window from the left as long as sum >= target
            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }


    public static void main(String[] args) {
        MinimumSizeSubarraySum ms = new MinimumSizeSubarraySum();
        System.out.println(ms.minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
        System.out.println(ms.minSubArrayLen(4, new int[]{1,4,4}));
        System.out.println(ms.minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1}));

    }
}
