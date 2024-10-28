package Problems.TwoPointers;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        // for some of the testcases time exceeds
//        String str1 = "";
//        String str2 = "";
//        for(int i=0; i<s.length(); i++){
//            if(!Character.isLetterOrDigit(s.charAt(i)))
//                continue;
//            str1 += s.toLowerCase().charAt(i);
//        }
//        for(int i=s.length()-1; i>=0; i--){
//            if(!Character.isLetterOrDigit(s.charAt(i)))
//                continue;
//            str2 += s.toLowerCase().charAt(i);
//        }
//        return str1.equals(str2);

//        int start = 0;
//        int end = s.length()-1;
//        while(start < end){
//            if(!Character.isLetterOrDigit(s.charAt(start))){
//                start++;
//                continue;
//            }
//            if(!Character.isLetterOrDigit(s.charAt(end))){
//                end--;
//                continue;
//            }
//            if(s.toLowerCase().charAt(start) != s.toLowerCase().charAt(end))
//                return false;
//            start++;
//            end--;
//        }
//        return true;
//        int start = 0;
//        int end = s.length()-1;
//        for(int i=0; i<s.length(); i++){
//            if(!Character.isLetterOrDigit(s.charAt(start))){
//                start++;
//                continue;
//            }
//            if(!Character.isLetterOrDigit(s.charAt(end))){
//                end--;
//                continue;
//            }
//            if(s.toLowerCase().charAt(start) != s.toLowerCase().charAt(end))
//                return false;
//            start++;
//            end--;
//        }
//        return true;
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (!Character.isLetterOrDigit(s.charAt(i))) {
                ++i;
            } else if (!Character.isLetterOrDigit(s.charAt(j))) {
                --j;
            } else if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            } else {
                ++i;
                --j;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome vp = new ValidPalindrome();
        System.out.println(vp.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(vp.isPalindrome("race a car"));
        System.out.println(vp.isPalindrome(" "));

    }
}
