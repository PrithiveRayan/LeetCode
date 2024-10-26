package Interview75.ArrayAndString;

public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= first) {
                first = num; // update first if num is smaller
            } else if (num <= second) {
                second = num; // update second if num is between first and second
            } else {
                // found a number greater than both first and second
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        IncreasingTripletSubsequence its = new IncreasingTripletSubsequence();
//        System.out.println(its.increasingTriplet(new int[]{1,2,3,4,5}));
//        System.out.println(its.increasingTriplet(new int[]{5,4,3,2,1}));
//        System.out.println(its.increasingTriplet(new int[]{2,1,5,0,4,6}));
        System.out.println(its.increasingTriplet(new int[]{20,100,10,12,5,13}));

    }
}
