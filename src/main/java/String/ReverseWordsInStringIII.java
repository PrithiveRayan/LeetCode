package String;

public class ReverseWordsInStringIII {

    public String reverseWords(String s) {
        String reversed = "";
        int begin = 0;
        for(int i=0; i<s.length(); i++){
            if (s.charAt(i) == ' ') {
                reversed = reversed+reverse(s.substring(begin, i))+" ";
                begin = i+1;
            }
            if(i == s.length()-1){
                reversed = reversed+reverse(s.substring(begin,s.length()));
            }
        }
        return reversed;
    }

    private String reverse(String word){
        String temp = "";
       for(int i=word.length()-1; i>=0; i--){
           temp = temp+word.charAt(i);
       }
       return temp;
    }

    public static void main(String[] args) {
        ReverseWordsInStringIII rs = new ReverseWordsInStringIII();
        System.out.println(rs.reverseWords("Let's take LeetCode contest"));
        System.out.println(rs.reverseWords("Mr Ding"));

    }
}
