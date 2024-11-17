package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new LinkedList<>();

        for(int i=1; i<=numRows; i++){
            List<Integer> temp = new ArrayList<>();
            for(int j=1; j<=i; j++){
                if(j == 1 || j == i){
                    temp.add(1);
                    continue;
                }
                int sum = result.get(i-2).get(j-2) + result.get(i-2).get(j-1);
                temp.add(sum);
            }
            result.add(temp);
        }



        return result;
    }

    public List<Integer> getRow(int rowIndex) {
//        List<List<Integer>> result = new LinkedList<>();
//        for(int i=1; i<=numRows+1; i++){
//            List<Integer> temp = new ArrayList<>();
//            for(int j=1; j<=i; j++){
//                if(j == 1 || j == i){
//                    temp.add(1);
//                    continue;
//                }
//                int sum = result.get(i-2).get(j-2) + result.get(i-2).get(j-1);
//                temp.add(sum);
//            }
//            result.add(temp);
//        }
//        return result.get(numRows);
        List<Integer> row = new ArrayList<>();
        long value = 1; // Initial value (1st element is always 1)
        row.add((int) value);

        for (int i = 1; i <= rowIndex; i++) {
            value = value * (rowIndex - i + 1) / i; // Compute next element
            row.add((int) value);
        }

        return row;

    }

    public static void main(String[] args) {
        PascalTriangle pt = new PascalTriangle();
        System.out.println(pt.generate(3));
        System.out.println(pt.getRow(3));
    }
}
