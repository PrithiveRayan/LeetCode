package Interview75.stack;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
//        Stack<Integer> stack = new Stack<>();
//        for(int i=0; i<asteroids.length; i++){
//            while(asteroids[i] < 0 && stack.peek() < asteroids[i]){
//                stack.pop();
//            }
//            stack.push(asteroids[i]);
//        }
//        int[] result = new int[stack.size()];
//        return result;


        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            // Process the current asteroid
            boolean exploded = false;

            // Handle collisions only if current asteroid is moving left (negative)
            while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                if (Math.abs(asteroid) > stack.peek()) {
                    stack.pop(); // Right-moving asteroid explodes
                } else if (Math.abs(asteroid) == stack.peek()) {
                    stack.pop(); // Both explode
                    exploded = true;
                    break;
                } else {
                    exploded = true;
                    break; // Left-moving asteroid explodes
                }
            }

            // Push the asteroid if it hasn't exploded
            if (!exploded) {
                stack.push(asteroid);
            }
        }

        // Convert stack to array
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;

    }

    public static void main(String[] args) {
        AsteroidCollision ac = new AsteroidCollision();
        System.out.println(Arrays.toString(ac.asteroidCollision(new int[]{5,10,-5})));
        System.out.println(Arrays.toString(ac.asteroidCollision(new int[]{8,-8})));
        System.out.println(Arrays.toString(ac.asteroidCollision(new int[]{10,2,-5})));
        System.out.println(Arrays.toString(ac.asteroidCollision(new int[]{-10,2,-5})));

    }
}
