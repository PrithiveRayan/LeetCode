package BinarySearch;

public class SearchIn2DMatrixII {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0, col = n - 1; // Start at the top-right corner
        while (row < m && col >= 0) {
            if (matrix[row][col] == target) {
                return true; // Target found
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SearchIn2DMatrixII sm = new SearchIn2DMatrixII();
        System.out.println(sm.searchMatrix(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}},5));
        System.out.println(sm.searchMatrix(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}},20));

    }
}
