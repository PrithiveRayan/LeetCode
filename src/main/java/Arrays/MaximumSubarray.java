package Arrays;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1)
            return nums[0];

        int max = Integer.MIN_VALUE;

//        for(int i=0; i<nums.length; i++){
//            for(int j=i; j<nums.length; j++){
//                int sum = 0;
//                for(int k=i; k<=j; k++){
//                    sum = sum+nums[k];
//                }
//                if(sum > max){
//                    max = sum;
//                }
//            }
//        }
//        return max;

        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;



    }

    public static void main(String[] args) {
        MaximumSubarray ms = new MaximumSubarray();
        System.out.println(ms.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(ms.maxSubArray(new int[]{2}));
        System.out.println(ms.maxSubArray(new int[]{5,4,-1,7,8}));

    }
}
