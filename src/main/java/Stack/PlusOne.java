package Stack;

import java.util.Stack;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        Stack<Integer> stack = new Stack<>();
        int carry = 0;
        for(int i=digits.length-1; i>=0; i--){
            int sum = i == digits.length-1 ? digits[i] + 1 + carry : digits[i] + carry;
            if(sum > 9){
                carry = 1;
                stack.push(0);
            }
            else {
                carry = 0;
                stack.push(sum);
            }
        }
        if(carry == 1)
            stack.push(1);

        int[] result = new int[stack.size()];
        int counter = 0;
        while(!stack.isEmpty()){
            result[counter++] = stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        PlusOne po = new PlusOne();
        po.plusOne(new int[]{9,7});
        po.plusOne(new int[]{9,9,9});

    }
}
