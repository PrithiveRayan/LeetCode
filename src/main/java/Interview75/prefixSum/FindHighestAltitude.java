package Interview75.prefixSum;

public class FindHighestAltitude {

    public int largestAltitude(int[] gain) {
        // O(n)
        int largest = 0;
        int currentAlt = 0;
        for(int i=0; i<gain.length; i++){
            currentAlt = currentAlt+gain[i];
            largest = Math.max(currentAlt, largest);
        }
        return largest;
    }


    public static void main(String[] args) {
        FindHighestAltitude fha = new FindHighestAltitude();
        System.out.println(fha.largestAltitude(new int[]{-5,1,5,0,-7}));
        System.out.println(fha.largestAltitude(new int[]{-4,-3,-2,-1,4,3,2}));
    }
}
