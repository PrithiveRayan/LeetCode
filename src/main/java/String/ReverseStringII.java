package String;

public class ReverseStringII {

    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        for (int i = 0; i < n; i += 2 * k) {
            int start = i;
            int end = Math.min(i + k - 1, n - 1);
            reverse(chars, start, end);
        }

        return new String(chars);
    }

    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        ReverseStringII rs = new ReverseStringII();
//        System.out.println(rs.reverseStr("abcdefg",2));
//        System.out.println(rs.reverseStr("abcd",2));
        System.out.println(rs.reverseStr("abcdefghijklmnopqrstuvwxyz",4));

    }
}
