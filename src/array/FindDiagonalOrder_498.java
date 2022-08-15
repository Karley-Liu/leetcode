package array;

public class FindDiagonalOrder_498 {

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0){
            return new int[0];
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        //存放数组
        int[] ans = new int[rows * columns];
        //对角线方向次数
        int count = rows + columns - 1;
        //定义初始化，行标记，列标记，存放数组索引
        int row = 0,col = 0,index = 0;
        //对角线循环
        for (int i = 0;i<count;i++){
            //判断对角线方向（题目初始从右上（i=0)开始）：偶数右上，奇数左下
            if (i % 2 == 0){
                //右上操作
                while (row >= 0 && col < columns){
                    //将矩阵存入存放数组
                    ans[index] = matrix[row][col];
                    //索引后移
                    index++;
                    //右上规律：行-1，列+1
                    row--;
                    col++;
                }
                //判断是否为越界情况，不越界正常+1，越界行+2，列-1
                if (col < columns){
                    row++;
                }else {
                    row += 2;
                    col--;
                }
                //左下操作：规律与右上相反
            }else {
                while (row < rows && col >= 0){
                    ans[index] = matrix[row][col];
                    index++;
                    row++;
                    col--;
                }
                if (row < rows){
                    col++;
                }else {
                    row--;
                    col += 2;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        new FindDiagonalOrder_498().findDiagonalOrder(matrix);
    }
}
