package Interview75.ArrayAndString;

public class ReverseWordsInAString {

    public String reverseWords(String s) {
        String str = "";
        String[] splitted = s.trim().split(" ");
        for(int i=splitted.length-1; i>=0; i--){
            if(splitted[i].equals(""))
                continue;
            if(i-1>=0){
                str += splitted[i];
                str += " ";
            }
            else{
                str += splitted[i];
            }
        }
        return str;

    }



    public static void main(String[] args) {
        ReverseWordsInAString rs = new ReverseWordsInAString();
        String rev1 = rs.reverseWords("the sky is blue");
        String rev2 = rs.reverseWords("  hello world  ");
        String rev3 = rs.reverseWords("a good   example");
        System.out.println(rev1);
        System.out.println(rev2);
        System.out.println(rev3);

    }
}
