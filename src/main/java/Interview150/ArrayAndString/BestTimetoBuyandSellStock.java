package Interview150.ArrayAndString;

public class BestTimetoBuyandSellStock {

    public int maxProfit(int[] prices) {
        int profit = 0;
        int minStockPrice = prices[0];
        for(int price : prices){
            profit = Math.max(profit, price-minStockPrice);
            minStockPrice = Math.min(minStockPrice,price);
        }
        return profit;
    }

    public static void main(String[] args) {

        BestTimetoBuyandSellStock bb = new BestTimetoBuyandSellStock();
        System.out.println(bb.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(bb.maxProfit(new int[]{7,6,4,3,1}));

    }
}
