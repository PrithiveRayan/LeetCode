package Interview75.stack;

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
//        String result = "";
//
//        int size = 1;
//        StringBuilder temp = new StringBuilder();
//        for(int i=0;i<s.length();i++){
//
//            if(Character.isDigit(s.charAt(i))){
//                size = s.charAt(i) - '0';
//                continue;
//            }
//            if(s.charAt(i) == '['){
//                continue;
//            }
//            if(s.charAt(i) == ']'){
//                int del = size;
//                while(size > 0){
//                    result += temp;
//                    size--;
//                }
//                temp.delete(0, del);
//                continue;
//            }
//            temp.append(s.charAt(i));
//        }
//
//        return result;

        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                // Build the full number k (could be multiple digits)
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                // Push the current number and current string to their stacks
                countStack.push(k);
                stringStack.push(currentString);
                // Reset current string and k for new segment
                currentString = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                // Pop the repeat count and previous string segment
                int repeatCount = countStack.pop();
                StringBuilder decodedSegment = stringStack.pop();
                // Append the repeated current segment to the previous segment
                for (int i = 0; i < repeatCount; i++) {
                    decodedSegment.append(currentString);
                }
                // Set currentString to the combined decoded segment
                currentString = decodedSegment;
            } else {
                // Regular characters are appended to the current string
                currentString.append(ch);
            }
        }

        return currentString.toString();
    }

    public static void main(String[] args) {
        DecodeString ds = new DecodeString();
//        System.out.println(ds.decodeString("3[a]2[bc]"));
        System.out.println(ds.decodeString("3[a2[c]]"));
        System.out.println(ds.decodeString("2[abc]3[cd]ef"));
    }
}
