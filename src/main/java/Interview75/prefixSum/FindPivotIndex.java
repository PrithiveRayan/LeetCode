package Interview75.prefixSum;

public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
//        int index = -1;
//        int[] leftSum = new int[nums.length];
//        int sumLeft = 0;
//        int[] rightSum = new int[nums.length];
//        int sumRight = 0;
//        for(int i=0; i<nums.length; i++){
//            sumLeft = sumLeft+nums[i];
//            leftSum[i] = sumLeft;
//        }
//        for(int i= nums.length-1; i>=0; i--){
//            sumRight = sumRight+nums[i];
//            rightSum[i] = sumRight;
//        }
//
//        for(int i=0; i<nums.length; i++){
//            if(leftSum[i] == rightSum[i]){
//                index = i;
//                break;
//            }
//        }
//        return index;

        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == totalSum - leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;


    }


    public static void main(String[] args) {
        FindPivotIndex pi = new FindPivotIndex();
        System.out.println(pi.pivotIndex(new int[]{1,7,3,6,5,6}));
        System.out.println(pi.pivotIndex(new int[]{1,2,3}));
        System.out.println(pi.pivotIndex(new int[]{2,1,-1}));
    }
}
