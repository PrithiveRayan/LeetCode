package Interview75.HashMap_Set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDifferenceOfTwoArrays {

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> list = new ArrayList<>();

        Set<Integer> num1Set = new HashSet<>();
        Set<Integer> num2Set = new HashSet<>();
        for(int num: nums1){
            num1Set.add(num);
        }

        for(int num: nums2){
            num2Set.add(num);
        }
        List<Integer> list1 = new ArrayList<>();

        for(int num: nums1){
            if((!num2Set.contains(num) && !(list1.contains(num)))){
                list1.add(num);
            }
        }
        list.add(list1);
        List<Integer> list2 = new ArrayList<>();
        for(int num: nums2){
            if((!num1Set.contains(num) && !(list2.contains(num)))){
                list2.add(num);
            }
        }
        list.add(list2);

        return list;
    }



    public static void main(String[] args) {
        FindDifferenceOfTwoArrays da = new FindDifferenceOfTwoArrays();
        System.out.println(da.findDifference(new int[]{1,2,3},new int[]{2,4,6}));
        System.out.println(da.findDifference(new int[]{1,2,3,3},new int[]{1,1,2,2}));

    }
}
