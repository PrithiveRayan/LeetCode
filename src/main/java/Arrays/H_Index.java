package Arrays;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class H_Index {

//    public int hIndex(int[] citations) {
//
//        List<Integer> list = Arrays.stream(citations).boxed().sorted((a, b) -> b - a).collect(Collectors.toList());
//        int index = 0;
//        for(int i=0; i<list.size(); i++){
//            if(list.get(i) < i+1){
//                return index;
//            }
//           index = i+1;
//        }
//        return index;
//    }

    public static int hIndex(int[] citations) {
        int n = citations.length;
        int[] buckets = new int[n + 1]; // Buckets to count papers with citation counts

        // Fill the buckets
        for (int c : citations) {
            if (c >= n) {
                buckets[n]++; // All citations >= n are grouped in the last bucket
            } else {
                buckets[c]++;
            }
        }

        // Find the h-index
        int total = 0;
        for (int i = n; i >= 0; i--) {
            total += buckets[i]; // Accumulate the total number of papers
            if (total >= i) {
                return i; // h-index found
            }
        }
        return 0; // No valid h-index
    }

    public static void main(String[] args) {
        H_Index hi = new H_Index();
        System.out.println(hi.hIndex(new int[]{3,0,6,1,5}));
        System.out.println(hi.hIndex(new int[]{1,3,1}));

    }
}
