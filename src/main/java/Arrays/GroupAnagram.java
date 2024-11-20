package Arrays;

import java.util.*;

public class GroupAnagram {

    public List<List<String>> groupAnagrams(String[] strs) {
//        List<List<String>> result = new ArrayList<>();
//        HashMap<String, List<Integer>> groups = new HashMap<>();
//        for(int i=0; i<strs.length; i++){
//            String temp = sort(strs[i]);
//            if(groups.containsKey(temp)){
//                List<Integer> list = groups.get(temp);
//                list.add(i);
//                groups.put(temp,list);
//            }
//            else{
//                groups.put(temp,new ArrayList<>(Arrays.asList(i)));
//            }
//        }
//
//        for(List<Integer> group: groups.values()){
//            List<String> temp = new ArrayList<>();
//            for(Integer ind : group){
//                temp.add(strs[ind]);
//            }
//            result.add(temp);
//        }
//        return result;

        if (strs == null || strs.length == 0) return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedKey = new String(charArray);

            map.computeIfAbsent(sortedKey, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());

    }

    private String sort(String s){
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }



    public static void main(String[] args) {

        GroupAnagram ga = new GroupAnagram();
//        System.out.println(ga.groupAnagrams(new String[]{"a"}));
        System.out.println(ga.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
        System.out.println(new String[]{""});

    }
}
