package dp;

/**
 * 下降路径最小和 II
 */
public class MinFallingPathSum_1289 {
    public int minFallingPathSum(int[][] grid) {
        int length = grid.length;
        if (length == 1){
            return grid[0][0];
        }
        int[][] dp = new int[length][length];
        for (int i = 0;i<length;i++){
            dp[0][i] = grid[0][i];
        }
        for (int i = 1;i<length;i++){
            for (int j = 0;j<length;j++){
                dp[i][j] = Integer.MAX_VALUE;
                for (int p = 0;p<length;p++){
                    if (j != p){
                        dp[i][j] = Math.min(dp[i][j],dp[i-1][p]+grid[i][j]);
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0;i<length;i++){
            min = Math.min(min,dp[length-1][i]);
        }
        System.out.println(min);
        return min;
    }

    public static void main(String[] args) {
        int[][] arr = {{-37,51,-36,34,-22}
                ,{82,4,30,14,38}
                ,{-68,-52,-92,65,-85}
                ,{-49,-3,-77,8,-19}
                ,{-60,-71,-21,-62,-73}};
        new MinFallingPathSum_1289().minFallingPathSum(arr);
    }
}
