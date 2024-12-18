package Stack;

import java.util.Stack;

public class DecodedStringAtIndex {

//    public String decodeAtIndex(String s, int k) {
//        int index = k;
//        Stack<String> stack = new Stack<>();
//        String result = "";
//        for(int i=0; i<s.length(); i++){
//            if(Character.isDigit(s.charAt(i))){
//                String temp = "";
//                if(!stack.isEmpty()){
//                    temp = stack.pop();
//                }
//                temp += result;
//                String toPush = "";
//                int increment = Integer.parseInt(String.valueOf(s.charAt(i)));
//                for(int j=0; j<increment; j++){
//                    toPush += temp;
//                }
//                if(toPush.length() > k){
//                    return String.valueOf(toPush.charAt(k-1));
//                }
//                stack.push(toPush);
//                result = "";
//                continue;
//            }
//            result += s.charAt(i);
//        }
//
//        String toFind = (!stack.isEmpty()) ? stack.pop() : s;
//        return String.valueOf(toFind.charAt(k-1));
//
//    }

    public char decodeAtIndex(String s, int k) {
        long decodedLength = 0;

        // Calculate the length of the decoded string
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                decodedLength *= (c - '0'); // Expand the length
            } else {
                decodedLength++; // Add 1 for a letter
            }
        }

        // Work backwards to find the k-th character
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int multiplier = c - '0';
                decodedLength /= multiplier; // Reverse the expansion
                k %= decodedLength; // Adjust k to stay within bounds
            } else {
                if (k == 0 || k == decodedLength) {
                    return c;
                }
                decodedLength--; // Reduce the length
            }
        }

        throw new IllegalArgumentException("Invalid input or k");
    }


    public static void main(String[] args) {

        DecodedStringAtIndex ds = new DecodedStringAtIndex();
//        System.out.println(ds.decodeAtIndex("leet2code3", 10));
//        System.out.println(ds.decodeAtIndex("ha22", 5));
//        System.out.println(ds.decodeAtIndex("a2345678999999999999999", 1));
        System.out.println(ds.decodeAtIndex("y959q969u3hb22odq595", 222280369));
//        System.out.println(ds.decodeAtIndex("abc", 1));
//        System.out.println(ds.decodeAtIndex("leet2code3", 10));

    }
}
