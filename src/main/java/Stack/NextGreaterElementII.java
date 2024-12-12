package Stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {

//    public int[] nextGreaterElements(int[] nums) {
//        int[] result = new int[nums.length];
//        for(int i=0; i<nums.length; i++){
//            result[i] = nextGreater(nums,i);
//        }
//        return result;
//    }
//
//    private int nextGreater(int[] nums, int index){
//        boolean isCompleted = false;
//        int counter = index+1;
//        int max = 0;
//        while(!isCompleted){
//            if(counter >= nums.length){
//                counter = 0;
//            }
//            if(counter == index){
//                isCompleted = true;
//                break;
//            }
//            if(nums[counter] > nums[index]){
//                return nums[counter];
//            }
//            counter++;
//        }
//
//        return (max == 0) ? -1 : max;
//    }

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1); // Initialize all values to -1
        Stack<Integer> stack = new Stack<>(); // Stack to store indices

        // Traverse the array twice
        for (int i = 0; i < 2 * n; i++) {
            int currentIndex = i % n; // Wrap around using modulo
            while (!stack.isEmpty() && nums[stack.peek()] < nums[currentIndex]) {
                int topIndex = stack.pop();
                result[topIndex] = nums[currentIndex]; // Update the result
            }
            if (i < n) {
                stack.push(currentIndex); // Push index only in the first pass
            }
        }

        return result;
    }

    public static void main(String[] args) {
        NextGreaterElementII ne = new NextGreaterElementII();
        System.out.println(Arrays.toString(ne.nextGreaterElements(new int[]{-1,0})));
        System.out.println(Arrays.toString(ne.nextGreaterElements(new int[]{1,2,1})));
        System.out.println(Arrays.toString(ne.nextGreaterElements(new int[]{1,2,3,4,3})));

    }
}
