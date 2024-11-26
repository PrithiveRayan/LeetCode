package Arrays;

public class MaximumProductSubArray {

    public int maxProduct(int[] nums) {
        int max = 0;
        boolean changed = false;
        for(int left=0; left<nums.length; left++){
            for(int right=left; right<nums.length; right++){
                int product = 1;
                for(int k=left; k<=right; k++){
                    product = product * nums[k];
                }
                if(product > max){
                    max = product;
                }
            }
        }
        return max;
    }

//    private boolean isMaximum(int product){
//
//    }

    public static void main(String[] args) {

        MaximumProductSubArray ms = new MaximumProductSubArray();
        System.out.println(ms.maxProduct(new int[]{2,3,-2,4}));
        System.out.println(ms.maxProduct(new int[]{-2,0,-1}));

    }
}
