package array;

public class Rotate_48 {

    /**
     * 使用辅助数组
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        int[][] newMatrix = new int[length][length];
        for (int i = 0;i<length;++i){
            for (int j = 0;j<length;++j){
                newMatrix[j][length-i-1] = matrix[i][j];
            }
        }
        for (int i = 0;i<length;++i) {
            for (int j = 0; j < length; ++j) {
                matrix[i][j] = newMatrix[i][j];
            }
        }
    }

    /**
     * 原地旋转
     * @param matrix
     */
    public void rotate2(int[][] matrix){
        int length = matrix.length;
        for (int i = 0;i<length/2;++i){
            for (int j = 0;j<(length+1)/2;++j){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[length-j-1][i];
                matrix[length-j-1][i] = matrix[j][length-i-1];
                matrix[j][length-i-1] = temp;
            }
        }
    }

    /**
     * 反转代替旋转
     * @param matrix
     */
    public void rotate3(int[][] matrix){
        int length = matrix.length;
        //水平翻转
        for (int i = 0;i<length/2;++i){
            for (int j = 0;j<length;++j){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[length-i-1][j];
                matrix[length-i-1][j] = temp;
            }
        }
        //主对角线反转
        for (int i = 0;i<length;++i){
            for (int j = 0;j<i;++j){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        new Rotate_48().rotate(matrix);
    }
}
