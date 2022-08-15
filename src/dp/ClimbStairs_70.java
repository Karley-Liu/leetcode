package dp;

public class ClimbStairs_70 {

    public int climbStairs(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        if (n <= 1){
            return dp[n-1];
        }
        dp[1] = 2;
        for (int i = 2;i<n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        System.out.println(dp[n-1]);
        return dp[n-1];
    }

    public static void main(String[] args) {
        int n = 1;
        new ClimbStairs_70().climbStairs(n);
    }
}
