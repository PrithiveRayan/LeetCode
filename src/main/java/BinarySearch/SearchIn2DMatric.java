package BinarySearch;

public class SearchIn2DMatric {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;       // Number of rows
        int n = matrix[0].length;    // Number of columns
        int left = 0, right = m * n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / n;
            int col = mid % n;
            int midValue = matrix[row][col];

            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    public boolean searchMatrixBetter(int[][] matrix, int target) {
        for(int i=0; i<matrix.length; i++){
            if(matrix[i][matrix[0].length-1] >= target){
                if(isAvailable(matrix[i],target))
                    return true;
                else
                    return false;
            }
            else {
                continue;
            }
        }
        return false;
    }

    private boolean isAvailable(int[] arr, int target){
        int left = 0, right = arr.length-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(arr[mid] == target){
                return true;
            }
            if(arr[mid] > target){
                right = mid-1;
            }
            else {
                left = mid+1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SearchIn2DMatric sm = new SearchIn2DMatric();
        System.out.println(sm.searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}},3));
        System.out.println(sm.searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}},31));
    }
}
