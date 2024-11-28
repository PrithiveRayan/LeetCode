package String;

import java.util.*;

public class MinimumSumIndexOfTwoLists {

//    public String[] findRestaurant(String[] list1, String[] list2) {
//
//        Map<Integer, List<String>> map = new TreeMap<>();
//        int min = 0;
//        for(int i=0; i<list1.length; i++){
//            for(int j=0; j< list2.length; j++){
//                if(list1[i].equals(list2[j])){
//                    map.putIfAbsent(i + j, new ArrayList<>());
//                    map.get(i + j).add(list1[i]);
//                }
//
//            }
//        }
//
//        List<String> firstList = map.values().iterator().next();
//
//        return firstList.toArray(new String[0]);
//    }

    public static String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map1 = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map1.put(list1[i], i);
        }

        int minSum = Integer.MAX_VALUE;
        List<String> result = new ArrayList<>();
        for (int j = 0; j < list2.length; j++) {
            if (map1.containsKey(list2[j])) {
                int sum = map1.get(list2[j]) + j;

                if (sum < minSum) {
                    minSum = sum;
                    result.clear();
                    result.add(list2[j]);
                }
                else if (sum == minSum) {
                    result.add(list2[j]);
                }
            }
        }

        return result.toArray(new String[0]);
    }

    public static void main(String[] args) {

        MinimumSumIndexOfTwoLists ml = new MinimumSumIndexOfTwoLists();
        System.out.println(Arrays.toString(ml.findRestaurant(new String[]{"Shogun","Tapioca Express","Burger King","KFC"},
                new String[]{"Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"})));
        System.out.println(Arrays.toString(ml.findRestaurant(new String[]{"Shogun","Tapioca Express","Burger King","KFC"},
                new String[]{"KFC","Shogun","Burger King"})));
        System.out.println(Arrays.toString(ml.findRestaurant(new String[]{"happy","sad","good"},
                new String[]{"sad","happy","good"})));

    }
}
