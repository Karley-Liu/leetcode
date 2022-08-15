package array;

public class SetZeroes_73 {

    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        boolean[] rows_bool = new boolean[rows];
        boolean[] columns_bool = new boolean[columns];
        for (int i = 0;i<rows;i++){
            for (int j = 0;j<columns;j++){
                if (matrix[i][j] == 0){
                    rows_bool[i] = true;
                    columns_bool[j] = true;
                }
            }
        }
        for (int i = 0;i<rows;i++){
            for (int j = 0;j<columns;j++){
                if (rows_bool[i]||columns_bool[j]){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        new SetZeroes_73().setZeroes(matrix);
    }
}
