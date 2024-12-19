package String;

public class ComplexNumberMultiplication {

    public String complexNumberMultiply(String num1, String num2) {
//        String[] str1 = num1.split("\\+");
//        String[] str2 = num2.split("\\+");
//        String sa=str1[0], sb=str1[1], sc=str2[0], sd=str2[1];
//        int a = sa.charAt(0) == '-' ? -(Integer.parseInt(sa.substring(1,sa.length()))) : Integer.parseInt(sa);
//        int b = sb.charAt(0) == '-' ? -(Integer.parseInt(sb.substring(1,sb.length()-1))) : Integer.parseInt(sb.substring(0, sb.length()-1));
//        int c = sc.charAt(0) == '-' ? -(Integer.parseInt(sc.substring(1,sc.length()))) : Integer.parseInt(sc);
//        int d = sd.charAt(0) == '-' ? -(Integer.parseInt(sd.substring(1,sd.length()-1))) : Integer.parseInt(sd.substring(0, sd.length()-1));
//
//        int real = (a*c)-(b*d);
//        int imaginary = (a*d)+(b*c);
//
//        return String.valueOf(real)+"+"+String.valueOf(imaginary)+"i";

        // Parse num1
        String[] parts1 = num1.split("\\+");
        int real1 = Integer.parseInt(parts1[0]);
        int imaginary1 = Integer.parseInt(parts1[1].replace("i", ""));

        // Parse num2
        String[] parts2 = num2.split("\\+");
        int real2 = Integer.parseInt(parts2[0]);
        int imaginary2 = Integer.parseInt(parts2[1].replace("i", ""));

        // Apply the multiplication formula
        int realPart = real1 * real2 - imaginary1 * imaginary2;
        int imaginaryPart = real1 * imaginary2 + imaginary1 * real2;

        // Format the result
        return realPart + "+" + imaginaryPart + "i";

    }

    public static void main(String[] args) {
        ComplexNumberMultiplication cm = new ComplexNumberMultiplication();
        System.out.println(cm.complexNumberMultiply("1+1i", "1+1i"));
        System.out.println(cm.complexNumberMultiply("1+-1i", "1+-1i"));

    }
}
