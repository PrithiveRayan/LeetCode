package Stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperature {

//    public int[] dailyTemperatures(int[] temperatures) {
//        int[] warmer = new int[temperatures.length];
//        warmer[temperatures.length-1] = 0;
//        for(int i=0; i<temperatures.length-1; i++){
//            int current = temperatures[i];
//            int count = 1;
//            for(int j = i+1; j<temperatures.length; j++){
//                if(current < temperatures[j]){
//                    warmer[i] = count;
//                    break;
//                }
//                count++;
//            }
//        }
//        return warmer;
//    }

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>(); // Monotonic decreasing stack

        for (int i = n - 1; i >= 0; i--) {
            // Remove elements from the stack that are less than or equal to the current temperature
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }

            // If the stack is not empty, calculate the difference of indices
            if (!stack.isEmpty()) {
                answer[i] = stack.peek() - i;
            } else {
                answer[i] = 0; // No warmer day
            }

            // Push the current day index onto the stack
            stack.push(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        DailyTemperature dt = new DailyTemperature();
        System.out.println(Arrays.toString(dt.dailyTemperatures(new int[]{73,74,75,71,69,72,76,73})));
        System.out.println(Arrays.toString(dt.dailyTemperatures(new int[]{30,40,50,60})));
        System.out.println(Arrays.toString(dt.dailyTemperatures(new int[]{30,60,90})));

    }
}
