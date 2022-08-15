package array;

public class SearchMatrix_240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        //行
        int row = matrix.length;
        //列
        int col = matrix[0].length;
        //行指针,列指针
        int rowPoint = 0,colPoint = col-1;
        while (rowPoint < row && colPoint >= 0){
            if (matrix[rowPoint][colPoint] == target){
                return true;
            }else if (matrix[rowPoint][colPoint] < target){
                rowPoint++;
            }else if (matrix[rowPoint][colPoint] > target){
                colPoint--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        new SearchMatrix_240().searchMatrix(matrix,5);
    }
}
