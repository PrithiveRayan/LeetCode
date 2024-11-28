package Arrays;

import java.util.*;

public class LargestNumber {

//    public String largestNumber(int[] nums) {
//
//        TreeMap<Integer, List<Integer>> group = new TreeMap<>(Comparator.reverseOrder());
//        for(int num : nums){
//            String temp = String.valueOf(num);
//            Integer first = Character.getNumericValue(temp.charAt(0));
////            treeMap.put(first,new ArrayList<>(Arrays.asList(num)));
//            group.computeIfAbsent(first, k -> new ArrayList<>()).add(num);
//        }
//        String largest = "";
//        for(List<Integer> list : group.values()){
//            list.sort(Comparator.reverseOrder());
//            for(int i : list){
//                largest = largest+String.valueOf(i);
//            }
//        }
//
//        return largest;
//    }

    public static String largestNumber(int[] nums) {
        String[] numStrs = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        Arrays.sort(numStrs, (a, b) -> (b + a).compareTo(a + b));

        // Handle the case where the largest number is "0" (e.g., [0, 0])
        if (numStrs[0].equals("0")) {
            return "0";
        }

        return String.join("", numStrs);
    }


    public static void main(String[] args) {
        LargestNumber ln = new LargestNumber();
        System.out.println(ln.largestNumber(new int[]{10,2}));
        System.out.println(ln.largestNumber(new int[]{3,30,34,5,9}));

    }
}
