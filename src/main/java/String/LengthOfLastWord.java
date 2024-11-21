package String;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {

        String trimmed = s.trim();
        int count = 0;
        for (int i = trimmed.length() - 1; i >= 0; i--) {
            if (trimmed.charAt(i) == ' ') {
                break;
            }
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        LengthOfLastWord lw = new LengthOfLastWord();
//        System.out.println(lw.lengthOfLastWord("Hello World"));
//        System.out.println(lw.lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println(lw.lengthOfLastWord("a"));
    }
}
