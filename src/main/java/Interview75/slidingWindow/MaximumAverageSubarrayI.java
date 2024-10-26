package Interview75.slidingWindow;

import Interview75.TwoPointers.MaxNumberOfKSumPairs;

public class MaximumAverageSubarrayI {

    public double findMaxAverage(int[] nums, int k) {

        // doesn't pass all testcase also not efficient
//        double result = 0;
//
//        for(int start=0; start<nums.length; start++){
//            for(int end = start; end<nums.length; end++){
//                double sum = 0;
//                double count = 0;
//                for(int x = start; x<=end; x++){
//                    sum += nums[x];
//                    count++;
//                }
//                double avg = sum/count;
//                if(avg > result && count == k)
//                    result = avg;
//            }
//        }
//        return result;

        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        double maxAvg = sum / k;
        for (int i = k; i < nums.length; i++) {
            sum = sum - nums[i - k] + nums[i];
            maxAvg = Math.max(maxAvg, sum / k);
        }
        return maxAvg;
    }

    public static void main(String[] args) {

        MaximumAverageSubarrayI ms = new MaximumAverageSubarrayI();
        System.out.println(ms.findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4));

    }
}
