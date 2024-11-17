package Arrays;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
//        for(int i=0; i<board.length; i++){
//            Set<Character> isRowValid = new HashSet<>();
//            for(int j=0; j<board[i].length; j++){
//                if(board[i][j] != '.' && isRowValid.contains(board[i][j])){
//                    return false;
//                }
//                isRowValid.add(board[i][j]);
//
//            }
//        }
//        int rows = board.length;
//        int cols = board[0].length;
//        for (int col = 0; col < cols; col++) {
//            Set<Character> isRowValid = new HashSet<>();
//            for (int row = 0; row < rows; row++) {
//
//                if(board[row][col] != '.' && isRowValid.contains(board[row][col])){
//                    return false;
//                }
//                isRowValid.add(board[row][col]);
//            }
//        }
//        return true;


        // Create arrays of hash sets for rows, columns, and sub-boxes
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }
        // Iterate through the board
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char current = board[r][c];

                // Skip empty cells
                if (current == '.') {
                    continue;
                }

                // Check the row
                if (rows[r].contains(current)) {
                    return false; // Duplicate in row
                }
                rows[r].add(current);

                // Check the column
                if (cols[c].contains(current)) {
                    return false; // Duplicate in column
                }
                cols[c].add(current);

                // Check the sub-box
                int boxIndex = (r / 3) * 3 + c / 3; // Map (r, c) to box index
                if (boxes[boxIndex].contains(current)) {
                    return false; // Duplicate in sub-box
                }
                boxes[boxIndex].add(current);
            }
        }
        return true; // No duplicates found
    }


    public static void main(String[] args) {
        ValidSudoku vs = new ValidSudoku();
        char[][] sudoku = {{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        char[][] sudoku2 = {{'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};

        System.out.println(vs.isValidSudoku(sudoku));
        System.out.println(vs.isValidSudoku(sudoku2));

    }
}
