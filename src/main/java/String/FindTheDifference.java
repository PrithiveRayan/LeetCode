package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class FindTheDifference {

    public char findTheDifference(String s, String t) {

        List<Character> hashing = new ArrayList<>();
        for(int i=0; i<t.length(); i++){
            hashing.add(t.charAt(i));
        }

        for(int i=0; i<s.length(); i++){
            if(hashing.contains(s.charAt(i))){
                hashing.remove(Character.valueOf(s.charAt(i)));
            }
        }

        return hashing.get(0);

    }


    public static void main(String[] args) {
        FindTheDifference fd = new FindTheDifference();
        System.out.println(fd.findTheDifference("abcd","abcde"));
        System.out.println(fd.findTheDifference("","y"));

    }
}
