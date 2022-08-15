package dp;

/**
 * 最小路径和
 */
public class MinPathSum_64 {

    public int minPathSum(int[][] grid){
        int rows = grid.length; //行数
        int columns = grid[0].length;   //列数
        if (rows == 1 && columns == 1){
            return grid[0][0];
        }
        int[][] dp = new int[rows][columns];
        dp[0][0]=grid[0][0];
        for (int i = 0;i<rows;i++){
            for (int j = 0;j<columns;j++){
                if (i>0 && j>0){
                    dp[i][j] = Math.min(dp[i-1][j] + grid[i][j],dp[i][j-1] + grid[i][j]);
                }else if (i>0){
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                }else if (j>0){
                    dp[i][j] = dp[i][j-1] + grid[i][j];
                }
            }
        }
        System.out.println(dp[rows-1][columns-1]);
        return dp[rows-1][columns-1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        new MinPathSum_64().minPathSum(grid);
    }
}
