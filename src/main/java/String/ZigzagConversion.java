package String;

public class ZigzagConversion {

    public String convert(String s, int numRows) {

        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        // Simulate the zigzag traversal
        int currentRow = 0;
        int direction = 1; // 1 for moving down, -1 for moving up

        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);

            // Change direction at the top or bottom row
            if (currentRow == 0) {
                direction = 1; // Start moving down
            } else if (currentRow == numRows - 1) {
                direction = -1; // Start moving up
            }

            // Move to the next row
            currentRow += direction;
        }

        // Concatenate all rows
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        ZigzagConversion zc =new ZigzagConversion();
//        System.out.println(zc.convert("PAYPALISHIRING",3));
        System.out.println(zc.convert("PAYPALISHIRING",4));
        System.out.println(zc.convert("A",1));

    }
}
