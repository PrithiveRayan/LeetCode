package String;

public class AddBinary {

    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int aLen = a.length()-1;
        int bLen = b.length()-1;
        while(aLen >= 0 || bLen >= 0 || carry != 1){
            int aBit = aLen >= 0 ? a.charAt(aLen) - '0' : 0;
            int bBit = bLen >= 0 ? b.charAt(bLen) - '0' : 0;

            int sum = aBit + bBit + carry;
            carry = sum/2;
            result.append(sum%2);
            aLen--;
            bLen--;
        }

        return result.reverse().toString();

    }

    public static void main(String[] args) {

        AddBinary ab = new AddBinary();
        System.out.println(ab.addBinary("11","1"));
        System.out.println(ab.addBinary("1010","1011"));

    }
}
