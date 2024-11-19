package String;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
//        String longest = "";
//
//        String first = strs[0];
//        int max = Integer.MAX_VALUE;
//        for(int i=1; i<strs.length; i++){
//            String temp = strs[i];
//            int count = 0;
//            for(int j=0; j<temp.length(); j++){
//
//                if(i<=first.length() && j<=temp.length() && longest.length() <= max && temp.charAt(j) == first.charAt(j)){
//                    longest = longest+temp.charAt(j);
//                    count++;
//                }
//                else if(count < max){
//                    max = count;
//                    break;
//                }
//                else{
//                    break;
//                }
//            }
//            first = longest;
//            longest = "";
//
//        }
//        return first;

        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];


        for (String str : strs) {

            while (!str.startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }

        }

        return prefix;


    }


    public static void main(String[] args) {
        LongestCommonPrefix lp = new LongestCommonPrefix();
        System.out.println(lp.longestCommonPrefix(new String[]{"c","c","c"}));
        System.out.println(lp.longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(lp.longestCommonPrefix(new String[]{"dog","racecar","car"}));

    }
}
