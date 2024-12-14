package BinarySearch;

public class H_Index_II {

    public int hIndex(int[] citations) {

        int n = citations.length;
        int left = 0, right = n-1;
        int max = 0;
        while (left<=right){
            int mid = left+(right-left)/2;
            if(citations[mid] >= (n-mid)){
                right = mid-1;
                max = n-mid;
            }
            else{
                left = mid+1;
            }
        }
        return max;

    }

    public static void main(String[] args) {
        H_Index_II hi = new H_Index_II();
        System.out.println(hi.hIndex(new int[]{0,1,3,5,6}));
        System.out.println(hi.hIndex(new int[]{1,2,100}));
        System.out.println(hi.hIndex(new int[]{4,5,4,5}));
    }
}
