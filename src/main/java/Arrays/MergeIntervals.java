package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

//    public int[][] merge(int[][] intervals) {
//        int[][] merged = new int[intervals.length][intervals[0].length];
//        List<Integer[][]> result = new ArrayList<>();
//        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
//
//        int[] temp = intervals[0];
//        int[] store = new int[2];
//        int counter = 0;
//        for(int i=1; i<intervals.length; i++){
//            if(intervals[i][0] <= temp[1]){
//                store[0] = temp[0];
//                store[1] = intervals[i][1];
//            }
//            else{
//                merged[counter][0] = store[0];
//                merged[counter][1] = store[1];
//                temp[0] =  store[0];
//                temp[1] = store[1];
//                counter++;
//            }
//        }
//        return merged;
//    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();
        int[] currentInterval = intervals[0];
        merged.add(currentInterval);
        for (int[] interval : intervals) {
            int currentStart = currentInterval[0];
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if (nextStart <= currentEnd) {
                // Overlapping intervals, merge them
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                // Non-overlapping interval, add it to the list
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }



    public static void main(String[] args) {
        MergeIntervals mi = new MergeIntervals();
        System.out.println(Arrays.deepToString(mi.merge(new int[][]{{1,3},{2,6},{8,10},{15,18}})));
        System.out.println(Arrays.deepToString(mi.merge(new int[][]{{1,4},{4,5}})));
    }
}
