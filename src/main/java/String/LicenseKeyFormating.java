package String;

public class LicenseKeyFormating {

    public String licenseKeyFormatting(String s, int k) {

        s = s.replace("-", "").toUpperCase();
        StringBuilder result = new StringBuilder();
        int firstGroupSize = s.length() % k;
        if (firstGroupSize > 0) {
            result.append(s.substring(0, firstGroupSize));
        }
        for (int i = firstGroupSize; i < s.length(); i += k) {
            if (result.length() > 0) {
                result.append("-");
            }
            result.append(s.substring(i, i + k));
        }
        return result.toString();

    }

    public static void main(String[] args) {

        LicenseKeyFormating lf = new LicenseKeyFormating();
        System.out.println(lf.licenseKeyFormatting("5F3Z-2e-9-w", 4));
        System.out.println(lf.licenseKeyFormatting("2-5g-3-J", 2));

    }
}
