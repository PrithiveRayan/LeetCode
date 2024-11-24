package Arrays;

public class SingleNumberII {

    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int num : nums) {
            ones = (ones ^ num) & ~twos; // Add num to ones if not in twos
            twos = (twos ^ num) & ~ones; // Add num to twos if not in ones
        }
        return ones;
    }

    public static void main(String[] args) {
        SingleNumberII sn = new SingleNumberII();
        System.out.println(sn.singleNumber(new int[]{2,2,3,2}));
        System.out.println(sn.singleNumber(new int[]{0,1,0,1,0,1,99}));
    }
}
