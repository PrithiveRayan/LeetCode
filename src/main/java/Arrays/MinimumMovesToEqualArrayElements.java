package Arrays;

public class MinimumMovesToEqualArrayElements {
    public int minMoves(int[] nums) {
        int sum = 0;
        int minVal = Integer.MAX_VALUE;
        // Calculate the sum and find the minimum value
        for (int num : nums) {
            sum += num;
            minVal = Math.min(minVal, num);
        }
        // Compute the total moves
        return sum - nums.length * minVal;
    }

//    public int minMoves(int[] nums) {
//        int min = Integer.MAX_VALUE;
//        long sum = 0;
//        for(int num : nums){
//            if(min > num){
//                min = num;
//            }
//            sum += num;
//        }
////        return (int) ((max*nums.length) - sum);
//        int minMoves = 0;
//        for(int num : nums){
//            if(num != min){
//                minMoves += num-min;
//            }
//        }
//        return minMoves;
//    }

    public static void main(String[] args) {
        MinimumMovesToEqualArrayElements me = new MinimumMovesToEqualArrayElements();
        System.out.println(me.minMoves(new int[]{1,2,3}));
        System.out.println(me.minMoves(new int[]{1,1,1}));
        System.out.println(me.minMoves(new int[]{1,1,1000000000}));

    }
}
