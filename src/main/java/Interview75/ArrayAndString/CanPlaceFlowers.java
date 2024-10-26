package Interview75.ArrayAndString;

public class CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {

//        for(int i=0; i<flowerbed.length; i++){
//
//            if(flowerbed[i] == 1)
//                continue;
//
////            if((i-1 > -1 && flowerbed[i-1] != 1) &&(i+1 < flowerbed.length || flowerbed[i-1] != 1 )){
//            if(((i == 0 && flowerbed[i+1] != 1) || (i-1 > -1 && flowerbed[i-1] != 1)) &&((i+1 < flowerbed.length && flowerbed[i+1] !=1) || (i+1 == flowerbed.length))){
//                flowerbed[i] = 1;
//                n--;
//            }
//        }
//
//        return n > 0 ? false:true;


        int m = flowerbed.length;
        for (int i = 0; i < m; ++i) {
            int l = i == 0 ? 0 : flowerbed[i - 1];
            int r = i == m - 1 ? 0 : flowerbed[i + 1];
            if (l + flowerbed[i] + r == 0) {
                flowerbed[i] = 1;
                --n;
            }
        }
        return n <= 0;
    }

    public static void main(String[] args) {
        CanPlaceFlowers cf = new CanPlaceFlowers();
//        System.out.println(cf.canPlaceFlowers(new int[]{1,0,0,0,1},1));
//        System.out.println(cf.canPlaceFlowers(new int[]{1,0,0,0,1},2));
//        System.out.println(cf.canPlaceFlowers(new int[]{1,0,0,0,0,1},2));
//        System.out.println(cf.canPlaceFlowers(new int[]{0,0,1,0,1},1));
        System.out.println(cf.canPlaceFlowers(new int[]{1,0,0,0,1,0,0},2));

    }
}
