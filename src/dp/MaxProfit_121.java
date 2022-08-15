package dp;

public class MaxProfit_121 {
    public int maxProfit(int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        int length = prices.length;
        int[][] dp = new int[length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1;i<length;i++){
            /**
             * 第i+1天没买也没卖,最大利润就是dp[i-1][0]
             * 第i+1天卖了一支股票,最大利润就是第i天持有股票最大利润+第i+1天卖出股票最大利润
             */
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],-prices[i]);
        }
        System.out.println(dp[length-1][0]);
        return dp[length-1][0];
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        new MaxProfit_121().maxProfit(prices);
    }
}
