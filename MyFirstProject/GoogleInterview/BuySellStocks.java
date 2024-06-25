package GoogleInterview;

public class BuySellStocks {
    private int maxProfit(int[] prices) {
        int buy = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > buy)
                profit = Math.max(profit, prices[i] - buy);
            else
                buy = prices[i];
        }
        return profit;
    }

    public static void main(String[] args) {
        BuySellStocks buySellStocks = new BuySellStocks();
        System.out.println(buySellStocks.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
