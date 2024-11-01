package Interview75.queue;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfRecentCalls {

    private Queue<Integer> queue;

    // Constructor to initialize the RecentCounter
    public NumberOfRecentCalls() {
        queue = new LinkedList<>();
    }

    // Method to handle the ping request
    public int ping(int t) {
        // Add the new request time to the queue
        queue.add(t);

        // Remove requests that are outside the 3000 ms time frame
        while (!queue.isEmpty() && queue.peek() < t - 3000) {
            queue.poll();
        }

        // The size of the queue represents the number of requests in the last 3000 ms
        return queue.size();
    }


    public static void main(String[] args) {
        NumberOfRecentCalls counter = new NumberOfRecentCalls();
        System.out.println(counter.ping(1));    // Output: 1
        System.out.println(counter.ping(100));  // Output: 2
        System.out.println(counter.ping(3001)); // Output: 3
        System.out.println(counter.ping(3002)); // Output: 3

    }
}
