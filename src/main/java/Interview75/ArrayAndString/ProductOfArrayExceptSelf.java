package Interview75.ArrayAndString;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] product = new int[nums.length];
        //for positive integer
//        int sum = 1;
//        int incrementer = 0;
//        for(int i: nums){
//            sum *= i;
//        }
//        for(int i: nums){
//            product[incrementer++] = sum/i;
//        }

        // O(n^2)
//        for(int i=0; i<nums.length; i++){
//            int sum = 1;
//            for(int j=0; j<nums.length; j++){
//                if(i==j){
//                    continue;
//                }
//                sum *= nums[j];
//            }
//            product[i] = sum;
//        }


        return calculateProductWithoutDivision(nums);
    }

    public int[] calculateProductWithoutDivision(int[] nums) {
        int n = nums.length;
        int[] product = new int[n];
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        // Calculate prefix products
        prefix[0] = 1; // No elements to the left
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        // Calculate suffix products
        suffix[n - 1] = 1; // No elements to the right
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }

        // Calculate product array
        for (int i = 0; i < n; i++) {
            product[i] = prefix[i] * suffix[i];
        }

        return product;
    }

    int[] productExceptSelf(int[] nums, int n) {
        int c = 0;
        int prod = 1;
        int[] res = new int[n];
        Arrays.fill(res, 0);

        // Calculate product of all non-zero elements and count zeros
        for (int num : nums) {
            if (num == 0)
                c++;
            else
                prod *= num;
        }

        // Generate the result array
        for (int i = 0; i < n; i++) {
            if (c > 1)
                res[i] = 0;
            else if (c == 1) {
                if (nums[i] == 0)
                    res[i] = prod;
                else
                    res[i] = 0;
            } else {
                res[i] = prod / nums[i];
            }
        }

        return res;
    }



    public static void main(String[] args) {
        ProductOfArrayExceptSelf pa = new ProductOfArrayExceptSelf();
//        System.out.println(Arrays.toString(pa.productExceptSelf(pa.productExceptSelf(new int[]{1,2,3,4}))));
        System.out.println(Arrays.toString(pa.productExceptSelf(pa.productExceptSelf(new int[]{-1,1,0,-3,3}))));

    }
}
