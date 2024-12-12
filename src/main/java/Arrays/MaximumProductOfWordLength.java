package Arrays;

public class MaximumProductOfWordLength {

    public int maxProduct(String[] words) {
        int n = words.length;
        int[] bitmasks = new int[n];
        int[] lengths = new int[n];

        for (int i = 0; i < n; i++) {
            int bitmask = 0;
            for (char c : words[i].toCharArray()) {
                bitmask |= 1 << (c - 'a'); // Set the bit corresponding to the character
            }
            bitmasks[i] = bitmask;
            lengths[i] = words[i].length();
        }

        // Compute the maximum product of lengths of two words with no common letters
        int maxProduct = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((bitmasks[i] & bitmasks[j]) == 0) { // No common letters
                    maxProduct = Math.max(maxProduct, lengths[i] * lengths[j]);
                }
            }
        }

        return maxProduct;
    }

    public static void main(String[] args) {
        MaximumProductOfWordLength ml = new MaximumProductOfWordLength();
        System.out.println(ml.maxProduct(new String[]{"abcw","baz","foo","bar","xtfn","abcdef"}));
        System.out.println(ml.maxProduct(new String[]{"a","ab","abc","d","cd","bcd","abcd"}));
        System.out.println(ml.maxProduct(new String[]{"a","aa","aaa","aaaa"}));
    }
}
