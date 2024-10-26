package Interview75.ArrayAndString;

public class GreatestCommonDivisorOfStrings {

    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        int len = gcdIterative(str1.length(), str2.length());
        return str1.substring(0, len);
    }

    private int gcdIterative(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        GreatestCommonDivisorOfStrings gs = new GreatestCommonDivisorOfStrings();
        String result = gs.gcdOfStrings("ABCABC","ABC");
        System.out.println(result);
        String result2 = gs.gcdOfStrings("ABABAB","ABAB");
        System.out.println(result2);
        String result3 = gs.gcdOfStrings("LEET","CODE");
        System.out.println(result3);

    }
}
