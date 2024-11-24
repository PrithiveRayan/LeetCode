package String;

import java.util.*;

public class KeyboardRow {
    public String[] findWords(String[] words) {
        Set<Character> first = new HashSet<>(Arrays.asList('Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'));
        Set<Character> second = new HashSet<>(Arrays.asList('A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'));
        Set<Character> third = new HashSet<>(Arrays.asList('Z', 'X', 'C', 'V', 'B', 'N', 'M', 'z', 'x', 'c', 'v', 'b', 'n', 'm'));
        List<String> result = new LinkedList<>();

        for(String str : words){
            if(first.contains(str.charAt(0)) && isSameRow(str, first)){
                result.add(str);
            }
            else if(second.contains(str.charAt(0)) && isSameRow(str, second)){
                result.add(str);
            }
            else if(isSameRow(str, third)){
                result.add(str);
            }

        }
        return result.toArray(new String[0]);
    }

    private boolean isSameRow(String str, Set<Character> row){
        for(int i=0; i<str.length(); i++){
            if(!row.contains(str.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        KeyboardRow kr = new KeyboardRow();

        System.out.println(Arrays.toString(kr.findWords(new String[]{"Hello","Alaska","Dad","Peace"})));
        System.out.println(Arrays.toString(kr.findWords(new String[]{"omk"})));
        System.out.println(Arrays.toString(kr.findWords(new String[]{"adsdf","sfd"})));
    }
}
