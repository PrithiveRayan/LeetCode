package Interview75.TwoPointers;

public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
//        int count = s.length();
//        int start = 0;
//        if(s.length() == 0 && t.length()>0)
//            return true;
//        for(int i=0; i<t.length(); i++){
//            if(s.charAt(start) == t.charAt(i)){
//                count--;
//                start++;
//            }
//            if(count == 0)
//                return true;
//
//        }
//        return false;


        if (s.length() == 0) {
            return true;
        }
        int start = 0;
        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(start) == t.charAt(i)) {
                start++;
                if (start == s.length()) {
                    return true; // All characters in s were found in sequence
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        IsSubsequence is = new IsSubsequence();
//        System.out.println(is.isSubsequence("abc","ahbgdc"));
//        System.out.println(is.isSubsequence("axc","ahbgdc"));
        System.out.println(is.isSubsequence("","ahbgdc"));

    }
}
