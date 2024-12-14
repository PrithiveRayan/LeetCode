package Arrays;

public class H_Index_II {

    public int hIndex(int[] citations) {
        int n = citations.length;
        int h = 0;
        for (int i = 0; i < n; i++) {
            int currentCitations = citations[i];

            // Count how many papers have at least 'h' citations
            if (currentCitations >= (n - i)) {
                h = n - i;
                break;
            }
        }

        return h;
    }


    public static void main(String[] args) {
        H_Index_II hi = new H_Index_II();
        System.out.println(hi.hIndex(new int[]{0,1,3,5,6}));
        System.out.println(hi.hIndex(new int[]{1,2,100}));

    }
}
