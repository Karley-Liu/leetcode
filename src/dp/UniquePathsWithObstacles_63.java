package dp;

/**
 * 不同路径 II
 */
public class UniquePathsWithObstacles_63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid){
        if (obstacleGrid[0][0] == 1){
            return 0;
        }
        int rows = obstacleGrid.length; //行数
        int columns = obstacleGrid[0].length;   //列数
        int[][] dp = new int[rows][columns];
        dp[0][0]=1;
        for (int i = 0;i<rows;i++){
            for (int j = 0;j<columns;j++){
                if (obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }else {
                    if (i>0 && j>0){
                        dp[i][j] = dp[i-1][j] + dp[i][j-1];
                    }else if (i>0){
                        dp[i][j] = dp[i-1][j];

                    }else if (j>0){
                        dp[i][j] = dp[i][j-1];
                    }
                }
            }
        }
        System.out.println(dp[rows-1][columns-1]);
        return dp[rows-1][columns-1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = {{0,1},{0,0}};
        new UniquePathsWithObstacles_63().uniquePathsWithObstacles(obstacleGrid);
    }
}
