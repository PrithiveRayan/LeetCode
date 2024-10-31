package Interview150.ArrayAndString;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int max = 0;
        while(left<right){
            if(height[left]<height[right]){
                max = Math.max(max, (right-left)*height[left]);
                left++;
            }
            else{
                max = Math.max(max, (right-left)*height[right]);
                right--;
            }
        }
        return max;
    }


    public static void main(String[] args) {

        ContainerWithMostWater cw = new ContainerWithMostWater();
        System.out.println(cw.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(cw.maxArea(new int[]{1,1}));
    }
}
