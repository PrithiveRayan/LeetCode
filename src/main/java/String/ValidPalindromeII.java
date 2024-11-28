package String;

public class ValidPalindromeII {

    // Time exceeds
//    public boolean validPalindrome(String s) {
//        for(int i=0; i<s.length(); i++){
//            if(i == 0 && isPalindrome(s)){
//                return true;
//            }
//            else if(isPalindrome(s.substring(0,i)+s.substring(i+1))){
//                return true;
//            }
//        }
//        return false;
//    }
//
//    private boolean isPalindrome(String s){
//        int left =0, right = s.length()-1;
//        while(left<=right){
//            if(s.charAt(left) != s.charAt(right)){
//                return false;
//            }
//            right--;
//            left++;
//        }
//        return true;
//    }

    public static boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
            left++;
            right--;
        }

        return true; // If no mismatches found, it's already a palindrome
    }

    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindromeII vp = new ValidPalindromeII();
//        System.out.println(vp.validPalindrome("aba"));
//        System.out.println(vp.validPalindrome("abca"));
//        System.out.println(vp.validPalindrome("abc"));
        System.out.println(vp.validPalindrome("abcacdba"));
    }
}
