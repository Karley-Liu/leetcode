package dp;

import java.util.Arrays;

public class CoinChange_322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        int  max = amount+1;
        Arrays.fill(dp,max);
        //base case
        dp[0] = 0;
        for (int i =0;i<dp.length;i++){
            for (int coin: coins){
                if (i-coin<0) continue;
                dp[i] = Math.min(dp[i], dp[i-coin] + 1);
            }
        }
//        System.out.println((dp[amount] == amount+1)?-1:dp[amount]);
        return (dp[amount] == amount+1)?-1:dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
        new CoinChange_322().coinChange(coins,amount);
    }
}
