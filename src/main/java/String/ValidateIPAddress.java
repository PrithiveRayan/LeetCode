package String;

import java.util.Arrays;
import java.util.List;

public class ValidateIPAddress {

//    public String validIPAddress(String queryIP) {
//        if(queryIP.contains(".")){
//            return isIPv4(queryIP);
//        }
//        else{
//            return isIPv6(queryIP);
//        }
//    }
//
//    private String isIPv4(String queryIP){
//        if(queryIP.charAt(0) == '.' || queryIP.charAt(queryIP.length()-1) == '.')
//            return "Neither";
//        String[] ips = queryIP.split("\\.");
//        if(ips.length != 4){
//            return "Neither";
//        }
//        for(String ip : ips){
//            if((ip.length() > 3) || (ip.charAt(0) == '0' && ip.length() > 1)){
//                return "Neither";
//            }
//            for(int i=0; i<ip.length(); i++){
//                if(!Character.isDigit(ip.charAt(i))){
//                    return "Neither";
//                }
//            }
//            int temp = Integer.parseInt(ip);
//            if(temp > 255){
//                return "Neither";
//            }
//        }
//        return "IPv4";
//    }
//
//    private String isIPv6(String queryIP){
//        if(queryIP.charAt(0) == ':' || queryIP.charAt(queryIP.length()-1) == ':')
//            return "Neither";
//        String[] ips = queryIP.split(":");
//        List<Character> alphabet = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'A', 'B', 'C', 'D', 'F');
//        if(ips.length != 8){
//            return "Neither";
//        }
//        for(String ip : ips){
//            if((ip.length() > 4)){
//                return "Neither";
//            }
//            for(int i=0; i<ip.length(); i++){
//                if(Character.isDigit(ip.charAt(i)))
//                    continue;
//
//                if(!alphabet.contains(ip.charAt(i))){
//                    return "Neither";
//                }
//            }
//        }
//        return "IPv6";
//    }

    public String validIPAddress(String queryIP) {
        if (queryIP.contains(".")) {
            return validateIPv4(queryIP) ? "IPv4" : "Neither";
        } else if (queryIP.contains(":")) {
            return validateIPv6(queryIP) ? "IPv6" : "Neither";
        } else {
            return "Neither";
        }
    }

    private boolean validateIPv4(String ip) {
        String[] parts = ip.split("\\.", -1);
        if (parts.length != 4) return false;
        for (String part : parts) {
            if (part.isEmpty() || part.length() > 3) return false;
            // Check if it's a valid number
            for (char ch : part.toCharArray()) {
                if (!Character.isDigit(ch)) return false;
            }
            int num = Integer.parseInt(part);
            if (num < 0 || num > 255) return false;
            // No leading zeros
            if (part.startsWith("0") && part.length() > 1) return false;
        }
        return true;
    }

    private boolean validateIPv6(String ip) {
        String[] parts = ip.split(":", -1);
        if (parts.length != 8) return false;
        for (String part : parts) {
            if (part.isEmpty() || part.length() > 4) return false;
            for (char ch : part.toCharArray()) {
                if (!isValidHexChar(ch)) return false;
            }
        }
        return true;
    }

    private boolean isValidHexChar(char ch) {
        return Character.isDigit(ch) ||
                (ch >= 'a' && ch <= 'f') ||
                (ch >= 'A' && ch <= 'F');
    }

    public static void main(String[] args) {
        ValidateIPAddress vp = new ValidateIPAddress();
//        System.out.println(vp.validIPAddress("172.16.254.1"));
//        System.out.println(vp.validIPAddress("256.256.256.256"));
//        System.out.println(vp.validIPAddress("192.168@1.1"));
//        System.out.println(vp.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
//        System.out.println(vp.validIPAddress("2001:0db8:85a3::8A2E:037j:7334"));
//        System.out.println(vp.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
        System.out.println(vp.validIPAddress("20EE:Fb8:85a3:0:0:8A2E:0370:7334"));


    }
}
