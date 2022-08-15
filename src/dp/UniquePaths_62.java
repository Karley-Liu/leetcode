package dp;

/**
 * 不同路径
 */
public class UniquePaths_62 {
    /**
     * 动态规划
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m,int n){
        int[][] f = new int[m][n];
        /**
         * 边界条件,第一格为1
         */
        f[0][0] = 1;
        /**
         * 当前位置只能「往下」移动
         * 即有 f[i][j] = f[i-1][j]f[i][j]=f[i−1][j]
         *
         * 当前位置只能「往右」移动
         * 即有 f[i][j] = f[i][j-1]f[i][j]=f[i][j−1]
         *
         * 当前位置即能「往下」也能「往右」移动
         * 即有 f[i][j] = f[i][j-1] + f[i-1][j]f[i][j]=f[i][j−1]+f[i−1][j]
         */
        for (int i = 0;i<m;i++){
            for (int j = 0;j<n;j++){
                if (i>0 && j>0){
                    f[i][j] = f[i-1][j] + f[i][j-1];
                }else if (i>0){
                    f[i][j] = f[i-1][j];
                }else if (j>0){
                    f[i][j] = f[i][j-1];
                }
            }
        }
        return f[m-1][n-1];
    }

    /**
     * 递归
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths2(int m,int n){
        if (m==1 || n==1){
            return 1;
        }
        return uniquePaths2(m-1,n)+uniquePaths2(m,n-1);
    }

    public static void main(String[] args) {
        int m = 3,n=7;
        new UniquePaths_62().uniquePaths2(m,n);
    }
}
