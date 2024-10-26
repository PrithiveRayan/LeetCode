package Interview75.ArrayAndString;

public class StringCompression {

//    public int compress(char[] chars) {
//
//        Map<Character, Integer> countChar = new LinkedHashMap<>();
//
//        for(Character i : chars){
//            countChar.put(i, countChar.getOrDefault(i,0)+1);
//        }
//
//        char[] charArray = new char[countChar.size()*2];
//
//        int count = 0;
//        for(Map.Entry<Character, Integer> entry : countChar.entrySet()){
//            if(countChar.size() == 1){
//                charArray[0] = entry.getKey();
//                break;
//            }
//            charArray[count++] = entry.getKey();
//            char temp = Integer.toString(entry.getValue()).charAt(0);
//            charArray[count++] = temp;
//        }
//
//
//        return countChar.size() == 1 ? 1 : countChar.size() *2;
//    }

    public int compress(char[] chars) {
        int index = 0; // Points to where we write in the array
        int i = 0;     // Points to the current character in the input

        while (i < chars.length) {
            char currentChar = chars[i];
            int count = 0;

            // Count the number of occurrences of the current character
            while (i < chars.length && chars[i] == currentChar) {
                i++;
                count++;
            }

            // Write the character to the array
            chars[index++] = currentChar;

            // If count is more than 1, convert it to a string and write each digit
            if (count > 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[index++] = c;
                }
            }
        }

        return index; // The new length of the compressed array
    }

    public static void main(String[] args) {

        StringCompression sc = new StringCompression();
        int result = sc.compress(new char[]{'a','a','b','b','c','c','c'});
        int result2 = sc.compress(new char[]{'a'});
        int result3 = sc.compress(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'});

        System.out.println(result);
        System.out.println(result2);
        System.out.println(result3);
    }
}
