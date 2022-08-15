package array;

public class SearchMatrix_74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        for (int i = 0;i < rows;i++){
            if (matrix[i][columns-1] > target){
                for (int j = 0;j < columns;j++){
                    if (matrix[i][j] == target){
                        return true;
                    }
                }
            }else if (matrix[i][columns-1] == target){
                return true;
            }
        }
        return false;
    }

    public boolean searchMatrix2(int[][] matrix,int target){
        int m = matrix.length;
        int n = matrix[0].length;
        //二位数组映射到一维
        int left = 0,right = m*n-1;
        while (left <= right){
            int mid = (left+right)/2;
            if (get(matrix,mid) == target){
                return true;
            }else if (get(matrix,mid) < target){
                left = mid + 1;
            }else if (get(matrix,mid) > target){
                right = mid - 1;
            }
        }
        return false;
    }

    //通过一维坐标访问二位数组中的元素
    int get(int[][] matrix,int index){
        int m = matrix.length,n=matrix[0].length;
        int i = index / n,j = index % n;
        return matrix[i][j];
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 13;
        new SearchMatrix_74().searchMatrix(matrix,target);
    }
}
