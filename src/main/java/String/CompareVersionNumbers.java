package String;

public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int maxLength = Math.max(v1.length, v2.length);

        for (int i = 0; i < maxLength; i++) {
            int rev1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int rev2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;

            if (rev1 > rev2) return 1;
            if (rev1 < rev2) return -1;
        }

        return 0; // All revisions are equal
    }

    public static void main(String[] args) {
        CompareVersionNumbers comparator = new CompareVersionNumbers();

        System.out.println(comparator.compareVersion("1.0.3.005.10", "1.0.3.5.9.0"));

        System.out.println(comparator.compareVersion("1.01", "1.001")); // Output: 0
        System.out.println(comparator.compareVersion("1.0", "1.0.0")); // Output: 0
        System.out.println(comparator.compareVersion("1.2", "1.10")); // Output: -1
        System.out.println(comparator.compareVersion("2.1", "1.9.9")); // Output: 1
    }
}
