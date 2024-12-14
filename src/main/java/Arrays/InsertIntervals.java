package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertIntervals {

//    public int[][] insert(int[][] intervals, int[] newInterval) {
//        if(intervals.length == 0){
//            return new int[][]{newInterval};
//        }
//        List<int[]> merged = new ArrayList<>();
//        int first = 0;
//        int second = 0;
//        boolean checkOverlap = false;
//        for(int i=0; i<intervals.length; i++){
//            if(intervals[i][1] > newInterval[0] && intervals[i][0] < newInterval[0]){
//                first = intervals[i][0];
//                second = newInterval[1];
//                checkOverlap = true;
//                continue;
//            }
//            if(checkOverlap){
//
//                if(intervals[i][0] <= second && intervals[i][1] >= second){
//                    checkOverlap = false;
//                    merged.add(new int[]{first,intervals[i][1]});
//                }
//                else if(intervals[i][0] > second && intervals[i][1] > second){
//                    checkOverlap = false;
//                    merged.add(new int[]{first,second});
//                    merged.add(intervals[i]);
//                }
//                continue;
//
//            }
//            merged.add(intervals[i]);
//        }
//        return merged.toArray(new int[merged.size()][]);
//    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // Add all intervals that come before the newInterval
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Merge overlapping intervals
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval); // Add the merged newInterval

        // Add all remaining intervals
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        // Convert the result list to an array
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        InsertIntervals ii = new InsertIntervals();
//        System.out.println(Arrays.deepToString(ii.insert(new int[][]{{1,3},{6,9}}, new int[]{2,5})));  // [[1,5],[6,9]]
        System.out.println(Arrays.deepToString(ii.insert(new int[][]{{1,2},{3,5},{6,7},{9,10},{12,16}}, new int[]{4,8})));  // [[1,2],[3,8],[9,10],[12,16]]
        System.out.println(Arrays.deepToString(ii.insert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[]{4,8})));  // [[1,2],[3,10],[12,16]]

    }
}
