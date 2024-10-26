package Interview75.ArrayAndString;


public class MergeStringsAlternately {

    public String mergeAlternately(String word1, String word2) {
        String merged = "";
//        int l2 = word2.length();
//        for(int i=0; i<word1.length(); i++){
//            merged += word1.charAt(i);
//            if(i < word2.length()){
//                merged += word2.charAt(i);
//                l2--;
//            }
//        }
//        if(merged.length() != word1.length()+word2.length()){
//            for(int i=l2; i<word2.length(); i++){
//                merged += word2.charAt(i);
//            }
//        }

        for(int i=0; i<word1.length() || i<word2.length(); i++){
            if(i<word1.length())
                merged += word1.charAt(i);
            if(i < word2.length())
                merged += word2.charAt(i);

        }
        return merged;
    }

    public static void main(String[] args) {

        MergeStringsAlternately ms = new MergeStringsAlternately();
        System.out.println(ms.mergeAlternately("abc","pqr"));
        System.out.println(ms.mergeAlternately("ab","pqrs"));
        System.out.println(ms.mergeAlternately("abcd","pq"));

    }
}
