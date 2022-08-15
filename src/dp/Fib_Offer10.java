package dp;

import java.util.Vector;

public class Fib_Offer10 {

    //暴力递归
    public int fib(int n){
        if (n == 0) return 0;
        if (n == 1 || n==2) return 1;
        return fib(n-1) + fib(n-2);
    }

    //带备忘录的递归算法
    public int fib2(int n) {
        if ( n== 0) return 0;
        //将备忘录全部初始化为0
        Vector<Integer> memo = new Vector<>(n + 1, 0);
        return helper(memo,n);
    }

    int helper(Vector<Integer> memo,int n){
        //base case
        if (n == 1 || n==2){
            return 1;
        }
        //已经计算过
        if (memo.elementAt(n) != 0){
            return memo.elementAt(n);
        }
        memo.set(n,helper(memo,n-1) + helper(memo,n-2));
        return memo.elementAt(n);
    }

    public int fib3(int n){
        if (n == 0){
            return 0;
        }
        if (n == 1 || n == 2){
            return 1;
        }
        final int MOD = 1000000007;
        int[] dp = new int[n+1];
        //base case
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3;i <= n;i++){
            dp[i] = (dp[i-1] + dp[i-2]) % MOD;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        new Fib_Offer10().fib3(n);
    }
}
