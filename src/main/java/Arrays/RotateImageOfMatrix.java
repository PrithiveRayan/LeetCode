package Arrays;

import java.util.Arrays;

public class RotateImageOfMatrix {

    public void rotate(int[][] matrix) {

//        int len = matrix.length;
//        for(int i=0; i<matrix.length; i++){
//            for(int j=0; j<matrix[i].length; j++){
//                matrix[i][j] = matrix[len-1][j];
//            }
//        }

        int n = matrix.length;

        // Step 1: Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Swap matrix[i][j] with matrix[j][i]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                // Swap elements in the row
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }

    }


    public static void main(String[] args) {
        RotateImageOfMatrix rm = new RotateImageOfMatrix();
        int [][] three = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        rm.rotate(three);
        System.out.println(Arrays.deepToString(three));

    }
}
