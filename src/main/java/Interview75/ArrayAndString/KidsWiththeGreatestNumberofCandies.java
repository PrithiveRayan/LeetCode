package Interview75.ArrayAndString;

import java.util.LinkedList;
import java.util.List;

public class KidsWiththeGreatestNumberofCandies {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new LinkedList<>();
        int max = 0;
        for(int i : candies){
            if(max < i)
                max = i;
        }
        for(int i=0; i<candies.length; i++){
            if(candies[i]+extraCandies >= max)
                result.add(true);
            else
                result.add(false);
        }
        return result;
    }


    public static void main(String[] args) {
        KidsWiththeGreatestNumberofCandies kc = new KidsWiththeGreatestNumberofCandies();
        int[] arr1 = {2,3,5,1,3};
        int[] arr2 = {4,2,1,1,2};
        int[] arr3 = {12,1,12};
        System.out.println(kc.kidsWithCandies(arr1, 3));
        System.out.println(kc.kidsWithCandies(arr2, 1));
        System.out.println(kc.kidsWithCandies(arr3, 10));
    }
}
