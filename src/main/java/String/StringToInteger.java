package String;

public class StringToInteger {
//    public int myAtoi(String s) {
//        s = s.trim();
//        boolean isNegative = false;
//        boolean isStarted = false;
//        String number = "";
//        for(int i=0; i<s.length(); i++){
//
//            if(i == 0 && s.charAt(i) == '-'){
//                isNegative = true;
//                continue;
//            }
//            if(Character.isDigit(s.charAt(i))){
//                number = number+s.charAt(i);
//            }else{
//                break;
//            }
//        }
//        if(isNegative && number.length()>1)
//            return Integer.parseInt("-"+number);
//        else if(number.length()<1)
//            return 0;
//        else
//            return Integer.parseInt(number);
//    }

    public static int myAtoi(String s) {
        s = s.trim();
        if (s.isEmpty()) return 0;
        int sign = 1;
        int index = 0;
        if (s.charAt(0) == '-') {
            sign = -1;
            index++;
        } else if (s.charAt(0) == '+') {
            index++;
        }
        long result = 0;
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            result = result * 10 + (s.charAt(index) - '0');
            if (result * sign < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            if (result * sign > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            index++;
        }
        return (int) (result * sign);
    }

    public static void main(String[] args) {
        StringToInteger si = new StringToInteger();

        System.out.println(si.myAtoi("-91283472332"));
        System.out.println(si.myAtoi(" -042"));
        System.out.println(si.myAtoi("1337c0d3"));
        System.out.println(si.myAtoi("0-1"));
        System.out.println(si.myAtoi("words and 987"));

    }
}
