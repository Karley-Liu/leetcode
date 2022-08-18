package array;

public class NumMatrix_304 {

    //preSum[i][j]记录的是matrix中子矩阵的[0,0,i-1,j-1]的元素和
    private int[][] preSum;

    public NumMatrix_304(int[][] matrix) {
        int m = matrix.length, n=matrix[0].length;
        if (m == 0 || n == 0) return;
        preSum = new int[m+1][n+1];
        for (int i = 1;i<m+1;i++){
            for (int j = 1;j < n+1;j++){
                //计算每个矩阵的元素和
                preSum[i][j] = preSum[i-1][j] + preSum[i][j-1]
                        + matrix[i-1][j-1] - preSum[i-1][j-1];
            }
        }
    }

    //计算子矩阵[x1,x2,y1,y2]的元素和
    public int sumRegion(int row1, int col1, int row2, int col2) {
        //目标矩阵之和由四个相邻矩阵运算获得
        return preSum[row2+1][col2+1]-preSum[row1][col2+1]
                -preSum[row2+1][col1]+preSum[row1][col1];
    }
}
