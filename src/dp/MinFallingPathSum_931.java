package dp;

/**
 * 下降路径最小和
 */
public class MinFallingPathSum_931 {

    public int minFallingPathSum(int[][] matrix){
        int length = matrix.length;
        if (length == 1){
            return matrix[0][0];
        }
        int[][] dp = new int[length][length];
        int min = Integer.MAX_VALUE;
        for (int i = 0;i<length;i++){
            for (int j = 0;j<length;j++){
                if (i == 0){
                    dp[i][j] = matrix[i][j];
                }else{
                    if (j == 0){
                        dp[i][j] = matrix[i][j]+Math.min(dp[i-1][j],dp[i-1][j+1]);
                    }else if (j == length-1){
                        dp[i][j] = matrix[i][j]+Math.min(dp[i-1][j],dp[i-1][j-1]);
                    }else {
                        int tempMin = Math.min(dp[i-1][j - 1], dp[i-1][j]);
                        tempMin = Math.min(tempMin,dp[i-1][j+1]);
                        dp[i][j] = tempMin+matrix[i][j];
                    }
                }
                min = Math.min(min,dp[i][j]);
            }
        }
        System.out.println(min);
        return min;
    }

    public static void main(String[] args) {
        int[][] matrix = {{-19,57},{-40,-5}};
        new MinFallingPathSum_931().minFallingPathSum(matrix);
    }
}
