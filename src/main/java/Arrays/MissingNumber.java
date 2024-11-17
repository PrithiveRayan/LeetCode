package Arrays;

public class MissingNumber {

    public int missingNumber(int[] nums) {

        int sum = nums.length*(nums.length+1)/2;
        for(int i=0; i<nums.length; i++){
            sum = sum - nums[i];
        }
        return sum;
    }


    public static void main(String[] args) {
        MissingNumber mn = new MissingNumber();
        System.out.println(mn.missingNumber(new int[]{3,0,1}));
        System.out.println(mn.missingNumber(new int[]{0,1}));
        System.out.println(mn.missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));

    }
}
