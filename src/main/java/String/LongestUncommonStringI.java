package String;

public class LongestUncommonStringI {

    public int findLUSlength(String a, String b) {
        if(a.equals(b)){
            return -1;
        }
        return Math.max(a.length(), b.length());

    }

    public static void main(String[] args) {
        LongestUncommonStringI ls = new LongestUncommonStringI();
        System.out.println(ls.findLUSlength("aba","cdc"));
        System.out.println(ls.findLUSlength("aaa","bbb"));
        System.out.println(ls.findLUSlength("aaa","aaa"));

    }
}
