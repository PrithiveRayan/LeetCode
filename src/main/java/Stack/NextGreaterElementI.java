package Stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElementI {

//    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//        for(int i=0; i<nums1.length; i++){
//            nums1[i] = nextGreater(nums1[i], nums2);
//        }
//        return nums1;
//    }
//
//    private int nextGreater(int k, int[] nums){
//        boolean search = false;
//        for(int i=0; i<nums.length; i++){
//            if(nums[i] == k){
//                search = true;
//                continue;
//            }
//            if(search && nums[i] > k){
//                return nums[i];
//            }
//        }
//        return -1;
//    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Map to store the next greater element for each element in nums2
        HashMap<Integer, Integer> nextGreaterMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        // Preprocess nums2 to find the next greater element for each element
        for (int num : nums2) {
            // While the stack is not empty and the current num is greater than the element at the top of the stack
            while (!stack.isEmpty() && stack.peek() < num) {
                nextGreaterMap.put(stack.pop(), num);  // Pop elements and store their next greater element
            }
            stack.push(num);  // Push the current element onto the stack
        }

        // For the remaining elements in stack, there is no next greater element, so we map them to -1
        while (!stack.isEmpty()) {
            nextGreaterMap.put(stack.pop(), -1);
        }

        // Now, create the result array for nums1 based on the nextGreaterMap
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = nextGreaterMap.get(nums1[i]);  // Get the next greater element for each element in nums1
        }

        return result;
    }

    public static void main(String[] args) {
        NextGreaterElementI ne = new NextGreaterElementI();
        System.out.println(Arrays.toString(ne.nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2})));
        System.out.println(Arrays.toString(ne.nextGreaterElement(new int[]{2,4}, new int[]{1,2,3,4})));
    }
}
