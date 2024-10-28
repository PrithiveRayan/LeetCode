package Problems.TwoPointers;

public class FindTheIndexOfTheFirstOccurrenceInString {

    public int strStr(String haystack, String needle) {
//        int index = -1;
//        int start = 0;
//        for(int i=0; i<haystack.length(); i++){
//            if(haystack.charAt(i) == needle.charAt(start)){
//                if(start == 0){
//                    index = i;
//                }
//                start++;
//                if(start == needle.length()){
//                    break;
//                }
//            }
//            else{
//                start = 0;
//                index = -1;
//            }
//        }
//        return index;

        if ("".equals(needle)) {
            return 0;
        }

        int len1 = haystack.length();
        int len2 = needle.length();
        int p = 0;
        int q = 0;
        while (p < len1) {
            if (haystack.charAt(p) == needle.charAt(q)) {
                if (len2 == 1) {
                    return p;
                }
                ++p;
                ++q;
            } else {
                p -= q - 1;
                q = 0;
            }

            if (q == len2) {
                return p - q;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindTheIndexOfTheFirstOccurrenceInString fs = new FindTheIndexOfTheFirstOccurrenceInString();
//        System.out.println(fs.strStr("sadbutsad","sad"));
//        System.out.println(fs.strStr("leetcode","leeto"));
        System.out.println(fs.strStr("aaa","aaaa"));

    }




}
