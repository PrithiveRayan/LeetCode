package String;

import java.util.*;

public class FirstUniqueCharacterInString {

    public int firstUniqChar(String s) {

        Map<Character, Integer> hashing = new LinkedHashMap<>();
        for(int i=0; i<s.length(); i++){
            if(hashing.containsKey(s.charAt(i))){
                hashing.put(s.charAt(i), -1);
            }
            else{
                hashing.put(s.charAt(i), i);
            }
        }

        for(Integer index : hashing.values()){
            if(index > -1){
                return index;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        FirstUniqueCharacterInString fc = new FirstUniqueCharacterInString();
        System.out.println(fc.firstUniqChar("leetcode"));
        System.out.println(fc.firstUniqChar("loveleetcode"));
        System.out.println(fc.firstUniqChar("aabb"));

    }
}
