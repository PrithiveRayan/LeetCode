package Interview75.ArrayAndString;

public class ReverseVowelsOfAString {

    public String reverseVowels(String s) {
        int i = 0;
        int j = s.length()-1;
        char[] str1 = s.toCharArray();
        while (i < j)
        {
            if (!isVowel(str1[i]))
            {
                i++;
                continue;
            }
            if (!isVowel(str1[j]))
            {
                j--;
                continue;
            }

            // swapping
            char t = str1[i];
            str1[i]= str1[j];
            str1[j]= t;


            i++;
            j--;
        }
        String str2 = String.copyValueOf(str1);
        return str2;
    }
    boolean isVowel(char c) {
        return (c == 'a' || c == 'A' || c == 'e'
                || c == 'E' || c == 'i' || c == 'I'
                || c == 'o' || c == 'O' || c == 'u'
                || c == 'U');
    }

    public static void main(String[] args) {
        ReverseVowelsOfAString rs = new ReverseVowelsOfAString();
        String str1 = "IceCreAm";
        String str2 = "leetcode";

        System.out.println(rs.reverseVowels(str1));
        System.out.println(rs.reverseVowels(str2));

    }
}
