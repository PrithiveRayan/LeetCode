package String;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

    public boolean wordPattern(String pattern, String s) {

        String trimmed = s.trim();
        String[] arr = trimmed.split(" ");
        if(pattern.length() != arr.length)
            return false;
        Map<Character, String> hash = new HashMap<>();
        for(int i=0; i<pattern.length(); i++){
            if(!hash.containsKey(pattern.charAt(i)) && hash.containsValue(arr[i]) ){
                return false;
            }
            if(hash.containsKey(pattern.charAt(i)) && !(hash.get(pattern.charAt(i)).equals(arr[i])) ){
                return false;
            }
            hash.put(pattern.charAt(i), arr[i]);
        }





        return true;
    }


    public static void main(String[] args) {
        WordPattern wp = new WordPattern();
//        System.out.println(wp.wordPattern("abba","dog cat cat dog"));
//        System.out.println(wp.wordPattern("abba","dog cat cat fish"));
//        System.out.println(wp.wordPattern("aaaa","dog cat cat dog"));
//        System.out.println(wp.wordPattern("abba","dog dog dog dog"));
        System.out.println(wp.wordPattern("aaa","dog dog dog dog"));

    }
}
