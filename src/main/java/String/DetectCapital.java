package String;

import java.util.HashSet;
import java.util.Set;

public class DetectCapital {

    public boolean detectCapitalUse(String word) {
        if(word.equals(word.toLowerCase())){
            return true;
        }
        else if(word.equals(word.toUpperCase())){
            return true;
        }
        else if(Character.isUpperCase(word.charAt(0)) && word.substring(1).equals(word.substring(1).toLowerCase())){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        DetectCapital dc = new DetectCapital();
//        System.out.println(dc.detectCapitalUse("USA"));
//        System.out.println(dc.detectCapitalUse("FlaG"));
//        System.out.println(dc.detectCapitalUse("leetcode"));
        System.out.println(dc.detectCapitalUse("Leetcode"));

    }
}
