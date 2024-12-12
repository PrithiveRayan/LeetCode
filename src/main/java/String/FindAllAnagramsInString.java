package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInString {

    public List<Integer> findAnagrams(String s, String p) {
        p = sort(p);
        List<Integer> index = new ArrayList<>();
        for(int i=0; i+p.length()-1<s.length(); i++){
            if(p.equals(sort(s.substring(i,i+p.length())))){
                index.add(i);
            }
        }
        return index;
    }

    private String sort(String str){
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static void main(String[] args) {
        FindAllAnagramsInString fa = new FindAllAnagramsInString();
        System.out.println(fa.findAnagrams("cbaebabacd","bac"));
        System.out.println(fa.findAnagrams("abab","ab"));

    }
}
