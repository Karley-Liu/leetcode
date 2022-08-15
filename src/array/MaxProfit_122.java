package array;

/**
 * 买卖股票的最佳时机 II
 */
public class MaxProfit_122 {

    /**
     * 简易版
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices){
        if (prices.length == 0){
            return 0;
        }
        int total = 0;
        for (int i = 1;i < prices.length;i++){
            if (prices[i] > prices[i-1]){
                total += prices[i] - prices[i-1];
            }
        }
        System.out.println(total);
        return total;
    }

    /**
     * 动态规划
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices){
        if(prices.length == 0){
            return 0;
        }
        int length = prices.length;
        /**
         * dp[i][0]表示第i+1天交易完之后手里没有股票的最大利润
         * dp[i][1]表示第i+1天交易完之后手里持有股票的最大利润
         */
        int[][] dp = new int[length][2];
        //初始条件
        /**
         * 动态规划的递推公式,边界条件就是第一天
         * 如果买入:dp[0][i] = -prices[0]
         * 如果没买:dp[0][0] = 0;
         */
        dp[0][1] = -prices[0];
        dp[0][0] = 0;


        for (int i =1;i<length;i++){
            //递推公式
            /**
             * 当天交易完之后手里没有股票
             * 1.当天没有进行任何交易,当天没有股票的利润只能取前一天手里没有股票的利润
             * 2.当天手里的股票卖了,当天卖出的利润+前一天没有股票的利润
             * dp[i][0] = max(dp[i-1][0],dp[i-1][1]+prices[i]);
             */
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            /**
             * 当天交易完之后手里持有股票
             * 1.当天没有交易,手里有股票,当天持有的是前一天已经持有的
             * 2.当天买入了股票,说明前一天手里肯定没有股票,取二者最大值
             * dp[i][1] = max(dp[i-1][1],dp[i-1][0]-prices[i]);
             */
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }
        //最后一天手里肯定没股票,利润最大
        //返回dp[length-1][0]
        System.out.println(dp[length-1][0]);
        return dp[length-1][0];
    }

    /**
     * 动态规划优化
     * @param prices
     * @return
     */
    public static int maxProfit3(int[] prices){
        /**
         * 当天利润和前一天有关,只需两个变量
         * 1.记录当天交易完之后手里持有股票最大利润
         * 2.记录当天交易完之后手里没有股票最大利润
         */
        if (prices.length==0){
            return 0;
        }
        int length = prices.length;
        //初始条件
        int hold = -prices[0];
        int noHold = 0;
        for (int i = 1;i<length;i++){
            noHold=Math.max(noHold,hold+prices[i]);
            hold=Math.max(hold,noHold-prices[i]);
        }
        //最后手里没有股票才最大
        return noHold;
    }

    /**
     * 贪心算法
     * @param prices
     * @return
     */
    public static int maxProfit4(int[] prices){
    /**
     * 找到股票上涨的最大值和股票上涨的最小值,计算这段时间内股票的最大利润
     * 股票下跌不用计算,将上涨的累加就是要求的结果
     */
        if (prices.length == 0){
            return 0;
        }
        int total = 0,index = 0,length = prices.length;
        while (index < length){
            /**
             * 如果股票下跌就一直找,直到找到股票上涨为止
             */
            while (index<length-1 && prices[index] >= prices[index+1]){
                index++;
            }
            /**
             * 股票上涨开始的值,就是这段时间上涨的最小值
             */
            int min = prices[index];
            /**
             * 找到股票上涨最大值为止
             */
            while (index < length-1 && prices[index] <= prices[index+1]){
                index++;
            }
            total += prices[index++] - min;
        }
        return total;
    }
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        maxProfit2(prices);
    }
}
